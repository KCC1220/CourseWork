package main.java.debugpanel;

import main.java.ball.Ball;
import main.java.level.Wall;
import main.java.view.GameBoardView;
import main.java.view.TutorialLevelView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class DebugConsole extends JDialog implements WindowListener{

    private static final String TITLE = "Debug Console";


    private final JFrame owner;
    private final main.java.debugpanel.DebugPanel debugPanel;
    private GameBoardView gameBoard;
    private TutorialLevelView arcadeLevel;
    private final Wall wall;
    private int type= 0;

    /**
     * This is the constructor of debug console.
     * This is to create the dialog window on the screen
     *
     * @param owner is the window that game board draw on
     * @param wall is the current wall object
     * @param gameBoard is the game board
     */
    public DebugConsole(JFrame owner, Wall wall, GameBoardView gameBoard){

        this.wall = wall;
        this.owner = owner;
        this.gameBoard = gameBoard;
        initialize();

        debugPanel = new main.java.debugpanel.DebugPanel(wall);
        this.add(debugPanel,BorderLayout.CENTER);


        this.pack();
    }
    /**
     * This is the constructor of debug console.
     * This is to create the dialog window on the screen
     *
     * @param owner is the window that game board draw on
     * @param wall is the current wall object
     * @param arcadeLevel is the game board
     */
    public DebugConsole(JFrame owner, Wall wall, TutorialLevelView arcadeLevel){

        this.wall = wall;
        this.owner = owner;
        this.arcadeLevel = arcadeLevel;
        initialize();
        debugPanel = new main.java.debugpanel.DebugPanel(wall,"test");
        this.add(debugPanel,BorderLayout.CENTER);
        type=1;

        this.pack();
    }

    /**
     * This method is to set all the properties of dialog window
     */
    private void initialize(){
        this.setModal(true);
        this.setTitle(TITLE);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.addWindowListener(this);
        this.setFocusable(true);
    }

    /**
     * This method is to set the location of dialog window on the player screen
     */
    private void setLocation(){
        int x = ((owner.getWidth() - this.getWidth()) / 2) + owner.getX();
        int y = ((owner.getHeight() - this.getHeight()) / 2) + owner.getY();
        this.setLocation(x,y);
    }


    @Override
    public void windowOpened(WindowEvent windowEvent) {

    }

    /**
     * This method is the action when the window being closed
     * @param windowEvent is to track what is the status of the window
     */
    @Override
    public void windowClosing(WindowEvent windowEvent) {
        if(type==0){gameBoard.repaint();}
        else if(type==1){arcadeLevel.repaint();}
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    /**
     * This method is the action when ths window being activated
     * @param windowEvent is to track the window activity
     */
    @Override
    public void windowActivated(WindowEvent windowEvent) {
        setLocation();
        Ball b = Wall.ball;
        debugPanel.setValues(b.getSpeedX(),b.getSpeedY());
    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }
}