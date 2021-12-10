package main.java.controller;

import main.java.debugpanel.DebugConsole;
import main.java.model.GameBoardModel;
import main.java.GraphicsMain;
import main.java.level.Wall;
import main.java.view.GameBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static main.java.model.ArcadeLevelModel.wall;
import static main.java.view.GameBoard.*;
import static main.java.model.GameBoardModel.*;

public class GameBoardController {
    public static int test=0;
    GameBoardModel model = new GameBoardModel();
    /**
     * This method is to initiate the player and the ball to move.
     */
    public void move(){
        wall.move();
    }

    /**
     * This method is to create the window created at the middle of player screen.
     * @param board is the window that need to be set
     */
    public void initialize(GameBoard board){
        board.setPreferredSize(new Dimension(model.getDefWidth(),550));
        board.setFocusable(true);
        board.requestFocusInWindow();
        board.addKeyListener(board);
        board.addMouseListener(board);
        board.addMouseMotionListener(board);
    }

    /**
     * This method is to move the player to the left.
     */
    public void playerMoveLeft(){
        Wall.player.moveLeft();
    }

    /**
     * This method is to move the player to the right.
     */
    public void playerMoveRight(){
        Wall.player.moveRight();
    }
    /**
     * This method is to check the condition of the game play.
     * This will help to check whether the wall in the game finished, the ball had lost and also the level already finished
     *
     * @param gameBoard is the game play window
     */
    public void check(GameBoard gameBoard){
        if(wall.isBallLost()){
            if(wall.ballEnd()){
                wall.wallReset();
                resetTime();
                model.gameOver();

            }
            wall.ballReset();
            gameTimer.stop();
            stopTime();
        }
        else if(wall.isDone()){
            if(wall.hasLevel()){
                stopTime();
                model.writeRecord();
                gameTimer.stop();
                wall.ballReset();
                wall.wallReset();
                model.nextLevel();
                wall.nextLevel();
            }
            else{
                model.writeRecord();
                model.doneLevel();
                model.checkHighScore();
                stopTime();
                gameTimer.stop();
            }
        }
        gameBoard.repaint();
    }



    /**
     * This is a getter method which will return the current brick count of the wall.
     *
     * @return brick count.
     */
    public int getBrickCount(){
        return wall.getBrickCount();
    }
    /**
     * This method is to get the current ball remaining.
     *
     * @return ball count.
     */
    public int getBallCount(){
        return wall.getBallCount();
    }

    /**
     * This method is to get the current high score from the high score file.
     * @return the high score
     */
    public int getHighScore(){
        return model.getHighScore();
    }
    /**
     * This method is to find impact of the ball to the brick.
     */
    public void findImpacts(){
        wall.findImpacts();
    }
    /**
     * This method is to get current timer in minutes.
     *
     * @return current timer in minutes.
     */
    public int getMinutes(){
        return time.minutes;
    }
    /**
     * This method is to get current timer in seconds.
     *
     * @return current timer in seconds.
     */
    public int getSeconds(){
        return time.seconds;
    }
    /**
     * This is a method to get the total time in seconds of the timer.
     *
     * @return total time in seconds.
     */
    public int getElapsedTime(){
        return time.elapsed();
    }
    /**
     * This method is to start the timer.
     */
    public void startTime(){
        time.start();
    }
    /**
     * This method is to stop the timer.
     */
    public void stopTime(){
        time.stop();
    }
    /**
     * This method is to reset the timer.
     */
    public static void resetTime(){
        time.reset();
    }
    /**
     * This method is to track what key that the player had pressed.
     *
     * @param keyEvent is the key that the player pressed.
     * @param gameBoard is the gameplay window,
     */
    public void keyPressed(KeyEvent keyEvent, GameBoard gameBoard) {

        switch(keyEvent.getKeyCode()){
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                playerMoveLeft();
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                playerMoveRight();
                break;
            case KeyEvent.VK_ESCAPE:
                showPauseMenu = !showPauseMenu;
                gameBoard.repaint();
                stopTime();
                gameTimer.stop();
                break;
            case KeyEvent.VK_SPACE:

                if(!showPauseMenu) {
                    if(gameTimer.isRunning()) {
                        stopTime();
                        gameTimer.stop();
                    }
                    else {
                        test=1;
                        gameTimer.start();
                        startTime();

                    }
                }

                break;

            case KeyEvent.VK_F1:
                if(keyEvent.isAltDown() && keyEvent.isShiftDown())
                    debugConsole.setVisible(true);
            default:
                Wall.player.stop();
        }
    }
    /**
     * This method is to check whether the pause menu need to show up or not
     * @return true false whether the pause menu need to show or not
     */
    public Boolean pauseMenu(){
        return showPauseMenu;
    }
    /**
     * This method is to track player's mouse activity on the pause menu.
     * @param mouseEvent is the player's mouse progress.
     * @param gameBoard is the gameplay window.
     */
    public void mouseClicked(MouseEvent mouseEvent,GameBoard gameBoard) {
        Point p = mouseEvent.getPoint();
        if (!showPauseMenu)
            return;
        if (continueButtonRect.contains(p)) {
            showPauseMenu = false;
            gameBoard.repaint();
        } else if (restartButtonRect.contains(p)) {
            model.restartLevel();
            GameBoardController.resetTime();
            wall.ballReset();
            wall.wallReset();
            showPauseMenu = false;
            gameBoard.repaint();
        } else if (exitButtonRect.contains(p)) {
            System.exit(0);
        } else if (muteButton.contains(p)) {
            if (GameBoardModel.audio == 1) {
                audio=0;
                try {
                    GraphicsMain.stopBGM();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                model.setMute();


            }else if(GameBoardModel.audio==0) {
                GraphicsMain.resumeBGM();
                model.setUnMute();
                audio=1;

            }
        }

    }
    /**
     * This method is to track the player's mouse movement.
     * @param mouseEvent is what the player's mouse doing.
     * @param gameBoard is the gameplay window.
     */
    public void mouseMoved(MouseEvent mouseEvent,GameBoard gameBoard) {
        Point p = mouseEvent.getPoint();
        if(exitButtonRect != null && showPauseMenu) {
            if (exitButtonRect.contains(p) || continueButtonRect.contains(p) || restartButtonRect.contains(p) || muteButton.contains(p))
                gameBoard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            else
                gameBoard.setCursor(Cursor.getDefaultCursor());
        }
        else{
            gameBoard.setCursor(Cursor.getDefaultCursor());
        }
    }
    /**
     * This method is to get the style of the pause menu font.
     * @return a type font for pause menu.
     */
    public Font getMenuFont() {
        return model.getMenuFont();
    }
    /**
     * This method is to get the style of the game screen font.
     * @return a type of font for word in game screen.
     */
    public Font getStyleFont(){
        return model.getStyle();
    }
    /**
     * This getter method is to get the wall object.
     * @return the object of wall
     */
    public Wall getWall(){
        return model.getWall();
    }

    /**
     * This method is to set debug console constructor.
     *
     * @param frame is the current window
     * @param wall is the wall object
     * @param gameBoard is the gameplay screen
     * @return the debug console object.
     */
    public DebugConsole setDebugConsole(JFrame frame, Wall wall, GameBoard gameBoard){
        return model.setDebugConsole(frame,wall,gameBoard);
    }
    public static void setPauseMenu(){
        showPauseMenu=true;
    }





}
