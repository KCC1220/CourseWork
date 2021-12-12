package main.java;



import main.java.view.*;
import main.java.view.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;



public class GameFrame extends JFrame implements WindowFocusListener {

    private static final String DEF_TITLE = "Brick Destroy";

    public static GameBoardView gameBoard;
    private final TutorialLevelView arcadeLevel;
    private final HomeMenuView homeMenu;


    private boolean gaming;

    /**
     * This is the constructor of game frame.
     * It will prepare the window for drawing.
     */
    public GameFrame(){
        super();
        gaming = false;
        this.setLayout(new BorderLayout());
        gameBoard = new GameBoardView(this);
        arcadeLevel = new TutorialLevelView(this);
        homeMenu = new HomeMenuView(this,new Dimension(500,500));
        this.add(homeMenu,BorderLayout.CENTER);
        this.setUndecorated(true);


    }

    /**
     * This method is to initialise all the window with a title.
     */
    public void initialize(){
        this.setTitle(DEF_TITLE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.autoLocate();
        this.setVisible(true);



    }

    /**
     * This method is to enable the game board
     */
    public void enableGameBoard(){
        this.dispose();
        this.remove(homeMenu);
        this.add(gameBoard,BorderLayout.CENTER);
        this.setUndecorated(false);
        initialize();
        /*to avoid problems with graphics focus controller is added here*/
        this.addWindowFocusListener(this);

    }

    /**
     * This method is to enable the tutorial game board
     */
    public void enableArcadeGameBoard(){
        this.dispose();
        this.remove(homeMenu);
        this.add(arcadeLevel,BorderLayout.CENTER);
        this.setUndecorated(false);
        initialize();
        /*to avoid problems with graphics focus controller is added here*/
        this.addWindowFocusListener(this);

    }


    /**
     * This method is to enable the colour choosing screen
     */
    public void enableColour(){

        this.dispose();
        this.remove(homeMenu);
        ColourView playercolour = new ColourView();
        this.setUndecorated(false);
        this.addWindowFocusListener(this);
    }

    /**
     * This method is to enable the info screen
     */
    public void enableInfo(){
        this.dispose();
        this.remove(homeMenu);
        InfoView info = new InfoView();
        this.setUndecorated(false);
        this.addWindowFocusListener(this);
    }


    /**
     * This method is to locate the window at the middle of player's screen
     */
    private void autoLocate(){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (size.width - this.getWidth()) / 2;
        int y = (size.height - this.getHeight()) / 2;
        this.setLocation(x,y);
    }

    /**
     * This method is the action when the player is on the window
     * @param windowEvent is the tracking of window
     */
    @Override
    public void windowGainedFocus(WindowEvent windowEvent) {
        /*
            the first time the frame loses focus is because
            it has been disposed to install the GameBoard,
            so went it regains the focus it's ready to play.
            of course calling a method such as 'onLostFocus'
            is useful only if the GameBoard as been displayed
            at least once
         */
        gaming = true;
    }

    /**
     * This method is the action need to take when the window lost its focus
     * @param windowEvent is to track the player window
     */
    @Override
    public void windowLostFocus(WindowEvent windowEvent) {

        if(gaming)
            gameBoard.onLostFocus();
            arcadeLevel.onLostFocus();

    }
}
