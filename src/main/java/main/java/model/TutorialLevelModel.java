package main.java.model;


import main.java.debugpanel.DebugConsole;
import main.java.scoring.Time;
import main.java.level.Wall;
import main.java.view.TutorialLevelView;

import javax.swing.*;
import java.awt.*;



public class TutorialLevelModel {
    private static final int TEXT_SIZE = 30;
    private static final int DEF_WIDTH = 600;
    private static final int DEF_HEIGHT = 550;
    public static Wall wall;
    public static boolean showPauseMenu;
    private final Font menuFont;
    public static DebugConsole debugConsole;
    public static Time time = new Time();


    int totalTime;

    Font style;

    public static int audio=1;

    /**
     * This is the constructor of Arcade Level Model
     * It initialise all the variable that we need
     */
    public TutorialLevelModel(){
        showPauseMenu = false;

        style = new Font("Noto Mono",Font.BOLD,15);
        wall = new Wall(new Rectangle(0,0,DEF_WIDTH,DEF_HEIGHT),30,3,new Point(300,430),(float)6/2);
        menuFont = new Font("Monospaced",Font.PLAIN,TEXT_SIZE);
        style = new Font("Noto Mono",Font.BOLD,15);
    }

    /**
     * This method is to create the debug console object
     *
     * @param frame is the current frame of the game screen
     * @param wall is the current wall object
     * @param gameBoard is the current game board
     * @return is the object og debug console
     */
    public DebugConsole setDebugConsole(JFrame frame, Wall wall, TutorialLevelView gameBoard){
        debugConsole = new DebugConsole(frame,wall,gameBoard);
        return debugConsole;
    }

    /**
     * This getter method is the wall object that created
     * @return wall object
     */
    public Wall getWall() {
        return wall;
    }

    /**
     * This getter method to get the width of the game board
     * @return width of game board
     */
    public int getDefWidth(){
        return DEF_WIDTH;
    }

    /**
     * This method is to set the message on the screen to Game Over
     */
    public void gameOver(){
        TutorialLevelView.message = "Game Over";
    }

    /**
     * This method is to set the message on the screen when the going to the next level
     */
    public void nextLevel(){
        totalTime+=time.elapsed()/1000;
        TutorialLevelView.message = "Go to Next Level   Time Taken in Sec: "+(time.elapsed()/1000);
    }

    /**
     * This method is the set message on the screen when wall is done.
     * This method also add up the total time in seconds of the player taken to complete the wall
     */
    public void doneLevel(){
        totalTime+=time.elapsed()/1000;
        TutorialLevelView.message = "ALL WALLS DESTROYED   Time Taken in Sec: "+totalTime;
    }

    /**
     * This method is to set message when user clicked the restart in pause menu
     */
    public void restartLevel(){
        TutorialLevelView.message = "Restarting Game...";
    }

    /**
     * This method is the action to set MUTE message in pause menu
     */
    public void setMute(){
        TutorialLevelView.MUTE = "Un Mute BGM";
    }

    /**
     * This method is to set Un Mute message in pause menu
     */
    public void setUnMute(){
        TutorialLevelView.MUTE = "Mute BGM";
    }

    /**
     * This getter method is to get the font style in game screen
     * @return font style in pause menu
     */
    public Font getStyle(){
        return style;
    }

    /**
     * This getter method is to get the font style in pause menu
     * @return font style in pause menu
     */
    public Font getMenuFont() {
        return menuFont;
    }


}