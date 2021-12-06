package main.java;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static main.java.GameBoard.MUTE;
import static main.java.GameBoard.message;

public class GameBoardModel {


    private static final int TEXT_SIZE = 30;
    private static final int DEF_WIDTH = 600;
    private static final int DEF_HEIGHT = 550;



    public static Wall wall;




    public static boolean showPauseMenu;

    private final Font menuFont;


    public static DebugConsole debugConsole;




    String stopWatch;
    static Time time = new Time();


    Record record = new Record();
    static int level=-1;
    HighScore hs = new HighScore();
    int totalTime;

    Font style;

    public static int audio=1;

    public GameBoardModel(){
        showPauseMenu = false;

        style = new Font("Noto Mono",Font.BOLD,15);
        wall = new Wall(new Rectangle(0,15,DEF_WIDTH,DEF_HEIGHT),30,3,(float)6/2,new Point(300,430));
        menuFont = new Font("Monospaced",Font.PLAIN,TEXT_SIZE);
        style = new Font("Noto Mono",Font.BOLD,15);
    }
    public DebugConsole setDebugConsole(JFrame frame, Wall wall,GameBoard gameBoard){
        debugConsole = new DebugConsole(frame,wall,gameBoard);
        return debugConsole;
    }

    public Wall getWall() {
        return wall;
    }


    public int getDefWidth(){
        return DEF_WIDTH;
    }

    public int getHighScore(){
        return hs.getHighScore();
    }
    public void gameOver(){
        message = "Game Over";
    }

    public void nextLevel(){
        totalTime+=time.elapsed()/1000;
        message = "Go to Next Level   Time Taken in Sec: "+(time.elapsed()/1000)+"  Best Time in Sec of All Level: "+getHighScore();
    }

    public void doneLevel(){
        totalTime+=time.elapsed()/1000;
        message = "ALL WALLS DESTROYED   Time Taken in Sec: "+totalTime+"     Best Time in Sec of All Level: : "+getHighScore();
    }

    public void restartLevel(){
        message = "Restarting Game...";
    }

    public void writeRecord(){
        stopWatch = time.timeInString();
        try {
            System.out.println(totalTime);
            record.write("\n"+level+"   "+stopWatch);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void checkHighScore(){
        hs.CheckScore(totalTime);
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
