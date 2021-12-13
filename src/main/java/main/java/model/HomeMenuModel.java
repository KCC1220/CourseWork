package main.java.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HomeMenuModel {

    private static final String GREETINGS = "Welcome to:";
    private static final String GAME_TITLE = "Brick Destroy";
    private static final String CREDITS = "CKC Version";
    private static final String START_TEXT = "Start";
    private static final String EXIT_TEXT = "Exit";
    private static final String INFO_TEXT = "Control";
    private static final String SCORE_TEXT = "Score";

    private static final Color TEXT_COLOR = new Color(255, 255, 255);//pure white
    private static final Color CLICKED_BUTTON_COLOR = Color.GREEN.darker().brighter();
    private static final Color CLICKED_TEXT = Color.CYAN;



    private final Rectangle menuFace;
    private final Rectangle startButton;
    private final Rectangle scoreButton;
    private final Rectangle exitButton;
    private final Rectangle infoButton;


    private final Font greetingsFont;
    private final Font gameTitleFont;
    private final Font creditsFont;
    private final Font buttonFont;

    private BufferedImage background=null;


    /**
     * This is the constructor for Home Menu Model
     * It will initialise all the variable for home menu
     * @param area is the area of the window
     */
    public HomeMenuModel(Dimension area) {
        menuFace = new Rectangle(new Point(0,0),area);
        String imageURL = "src/main/resources/photos/finalbackground.jpg";
        try {
            background = ImageIO.read(new File(imageURL));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Dimension btnDim = new Dimension(area.width / 3, area.height / 12);
        startButton = new Rectangle(btnDim);
        scoreButton = new Rectangle(btnDim);
        exitButton = new Rectangle(btnDim);
        infoButton = new Rectangle(btnDim);
        greetingsFont = new Font("Noto Mono",Font.PLAIN,25);
        gameTitleFont = new Font("Noto Mono",Font.BOLD,40);
        creditsFont = new Font("Monospaced",Font.PLAIN,25);
        buttonFont = new Font("Monospaced",Font.PLAIN,startButton.height-2);

    }

    /**
     * This is a getter method to get the background image
     * @return the background image
     */
    public BufferedImage getBackground(){
        return background;
    }
    /**
     * This is a getter method to get the "Score" text for score button"
     * @return the string of "Score"
     */
    public String getScoreText(){
        return SCORE_TEXT;
    }
    /**
     * This is a getter method to get the rectangle of home menu
     * @return the rectangle for home menu
     */
    public Rectangle getMenuFace(){return menuFace;}
    /**
     * This is a getter method to get the greeting's font style
     * @return font of greetingd
     */
    public Font getGreetingsFont(){
        return greetingsFont;
    }

    /**
     * This is a getter method to get the game title font style
     * @return the font of game title
     */
    public Font getGameTitleFont(){
        return gameTitleFont;
    }
    /**
     * This is a getter method to get the credit font style
     * @return the font of credit
     */
    public Font getCreditsFont(){
        return creditsFont;
    }
    /**
     * This is a getter method to get the button font style
     * @return the font of button
     */
    public Font getButtonFont(){
        return buttonFont;
    }
    /**
     * This is a getter method to get the colour of the text of the button
     * @return the colour of the text in button
     */
    public Color getTextColor(){
        return TEXT_COLOR;
    }
    /**
     * This is a getter method to get the rectangle of Start Button
     * @return start button's rectangle
     */
    public Rectangle getStartButton(){return startButton;}
    /**
     * This is a getter method to get the rectangle of Exit Button
     * @return exit button's rectangle
     */
    public Rectangle getExitButton(){return exitButton;}
    /**
     * This is a getter method to get the rectangle of Score Button
     * @return score button's rectangle
     */
    public Rectangle getScoreButton(){return scoreButton;}
    /**
     * This is a getter method to get the rectangle of Info Button
     * @return info button's rectangle
     */
    public Rectangle getInfoButton(){return infoButton;}

    /**
     * This getter method is to get the Greetings "Welcome To" string
     * @return the string of "Welcome To"
     */
    public String getGreetings(){return GREETINGS;}
    /**
     * This getter method is to get the Greetings "Brick Destroy" string
     * @return the string of "Brick Destroy"
     */
    public String getGameTitle(){return GAME_TITLE;}
    /**
     * This getter method is to get the Greetings "CKC Version" string
     * @return the string of "CKC Version"
     */
    public String getCredits(){return CREDITS;}
    /**
     * This getter method is to get the Greetings "Exit" string
     * @return the string of "Exit"
     */
    public String getMenuText(){return EXIT_TEXT;}
    /**
     * This getter method is to get the Greetings "Start" string
     * @return the string of "Start"
     */
    public String getStartText(){return START_TEXT;}
    /**
     * This getter method is to get the Greetings "Instruction" string
     * @return the string of "Instruction"
     */
    public String getSettingText(){return INFO_TEXT;}
    /**
     * This getter method is to get the button colour when the player clicked on the button
     * @return Color for button clicked
     */
    public Color getClickedButtonColor(){return CLICKED_BUTTON_COLOR;}
    /**
     * This getter method is to get the text colour when the player clicked on the button
     * @return Color for text clicked
     */
    public Color getClickedText(){return CLICKED_TEXT;}







}