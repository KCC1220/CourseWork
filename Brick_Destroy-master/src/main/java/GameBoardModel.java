package main.java;

import javax.swing.*;
import java.awt.*;

public class GameBoardModel {
    private static final String CONTINUE = "Continue";
    private static final String RESTART = "Restart";
    private static final String EXIT = "Exit";
    private static final String PAUSE = "Pause Menu";
    private static String MUTE ="Mute BGM";
    private static final int TEXT_SIZE = 30;
    private static final Color MENU_COLOR = new Color(0,255,0);
    private static final int DEF_WIDTH = 600;
    private static final int DEF_HEIGHT = 450;

    private static final Color BG_COLOR = Color.WHITE;

    private Timer gameTimer;

    private final Wall wall;

    private String message;
    private String timing;
    private String seconds;

    private boolean showPauseMenu;

    private final Font menuFont;

    private Rectangle continueButtonRect;
    private Rectangle exitButtonRect;
    private Rectangle restartButtonRect;
    private Rectangle muteButton;
    private int strLen;




    String stopWatch;


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
        message = String.format("Bricks: %d Balls %d"+ "   Best Time For All Level:%d",wall.getBrickCount(),wall.getBallCount(), hs.getHighScore());
    }
    public DebugConsole setDebugConsole(JFrame frame, Wall wall,GameBoard gameBoard){
        return new DebugConsole(frame,wall,gameBoard);
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




}
