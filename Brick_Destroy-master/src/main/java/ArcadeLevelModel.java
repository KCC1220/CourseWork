package main.java;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static main.java.ArcadeLevel.MUTE;
import static main.java.ArcadeLevel.message;

public class ArcadeLevelModel {


    private static final int TEXT_SIZE = 30;
    private static final int DEF_WIDTH = 600;
    private static final int DEF_HEIGHT = 550;



    public static Wall wall;




    public static boolean showPauseMenu;

    private final Font menuFont;


    public static DebugConsole debugConsole;




    static Time time = new Time();


    static int level=-1;
    int totalTime;

    Font style;

    public static int audio=1;

    public ArcadeLevelModel(){
        showPauseMenu = false;

        style = new Font("Noto Mono",Font.BOLD,15);
        wall = new Wall(new Rectangle(0,0,DEF_WIDTH,DEF_HEIGHT),30,3,new Point(300,430),(float)6/2);
        menuFont = new Font("Monospaced",Font.PLAIN,TEXT_SIZE);
        style = new Font("Noto Mono",Font.BOLD,15);
    }
    public DebugConsole setDebugConsole(JFrame frame, Wall wall,ArcadeLevel gameBoard){
        debugConsole = new DebugConsole(frame,wall,gameBoard);
        return debugConsole;
    }

    public Wall getWall() {
        return wall;
    }


    public int getDefWidth(){
        return DEF_WIDTH;
    }
    public void gameOver(){
        message = "Game Over";
    }

    public void nextLevel(){
        totalTime+=time.elapsed()/1000;
        message = "Go to Next Level   Time Taken in Sec: "+(time.elapsed()/1000);
    }

    public void doneLevel(){
        totalTime+=time.elapsed()/1000;
        message = "ALL WALLS DESTROYED   Time Taken in Sec: "+totalTime;
    }

    public void restartLevel(){
        message = "Restarting Game...";
    }


    public void setMute(){
        MUTE = "Un Mute BGM";
    }

    public void setUnMute(){
        MUTE = "Mute BGM";
    }

    public Font getStyle(){
        return style;
    }

    public Font getMenuFont() {
        return menuFont;
    }


}
