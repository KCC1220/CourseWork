package main.java;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static main.java.GameBoard.MUTE;
import static main.java.GameBoard.message;

public class GameBoardModel {
    private static final String CONTINUE = "Continue";
    private static final String RESTART = "Restart";
    private static final String EXIT = "Exit";
    private static final String PAUSE = "Pause Menu";

    private static final int TEXT_SIZE = 30;
    private static final Color MENU_COLOR = new Color(0,255,0);
    private static final int DEF_WIDTH = 600;
    private static final int DEF_HEIGHT = 450;

    private static final Color BG_COLOR = Color.WHITE;

    private Timer gameTimer;

    public static Wall wall;


    private String timing;
    private String seconds;

    public static boolean showPauseMenu;

    private final Font menuFont;

    private Rectangle continueButtonRect;
    private Rectangle exitButtonRect;
    private Rectangle restartButtonRect;
    private Rectangle muteButton;
    private int strLen;
    public static DebugConsole debugConsole;




    String stopWatch;
    static Time time = new Time();


    Record record = new Record();
    static int level=-1;
    HighScore hs = new HighScore();
    int totalTime;

    Font style;

    static int audio=1;

    public GameBoardModel(){
        showPauseMenu = false;
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

    public String getMessage(){
        return message;
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

    public void onLostFocus(){
        message = "Lost Focus";
    }




}
