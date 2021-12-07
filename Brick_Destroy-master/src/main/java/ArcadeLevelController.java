package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

import static main.java.ArcadeLevel.*;
import static main.java.ArcadeLevelModel.*;

public class ArcadeLevelController {
    public static int test=0;
    ArcadeLevelModel model = new ArcadeLevelModel();
    public void move(){
        wall.move();
    }
    public void initialize(ArcadeLevel board){
        board.setPreferredSize(new Dimension(model.getDefWidth(),550));
        board.setFocusable(true);
        board.requestFocusInWindow();
        board.addKeyListener(board);
        board.addMouseListener(board);
        board.addMouseMotionListener(board);
    }

    public void playerMoveLeft(){
        wall.player.moveLeft();
    }
    public void playerMoveRight(){
        wall.player.moveRight();
    }

    public void check(ArcadeLevel gameBoard){
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
            if(wall.hasArcadeLevel()){
                stopTime();
                gameTimer.stop();
                wall.ballReset();
                wall.wallReset();
                model.nextLevel();
                wall.nextArcadeLevel();
            }
            else{
                model.doneLevel();
                stopTime();
                gameTimer.stop();
            }
        }
        gameBoard.repaint();
    }




    public int getBrickCount(){
        return wall.getBrickCount();
    }

    public int getBallCount(){
        return wall.getBallCount();
    }


    public void findImpacts(){
        wall.findImpacts();
    }

    public int getMinutes(){
        return time.minutes;
    }

    public int getSeconds(){
        return time.seconds;
    }

    public int getElapsedTime(){
        return time.elapsed();
    }

    public void startTime(){
        time.start();
    }
    public void stopTime(){
        time.stop();
    }
    public static void resetTime(){
        time.reset();
    }
    public void keyPressed(KeyEvent keyEvent, ArcadeLevel gameBoard) {

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
                wall.player.stop();
        }
    }

    public Boolean pauseMenu(){
        return showPauseMenu;
    }

    public void mouseClicked(MouseEvent mouseEvent, ArcadeLevel gameBoard) {
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

    public void mouseMoved(MouseEvent mouseEvent, ArcadeLevel gameBoard) {
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

    public Font getMenuFont() {
        return model.getMenuFont();
    }
    public Font getStyleFont(){
        return model.getStyle();
    }

    public Wall getWall(){
        return model.getWall();
    }

    public DebugConsole setDebugConsole(JFrame frame, Wall wall, ArcadeLevel gameBoard){
        return model.setDebugConsole(frame,wall,gameBoard);
    }
    public static void setPauseMenu(){
        showPauseMenu=true;
    }





}
