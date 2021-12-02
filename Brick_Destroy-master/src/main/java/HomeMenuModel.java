package main.java;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HomeMenuModel {

    private static final String GREETINGS = "Welcome to:";
    private static final String GAME_TITLE = "Brick Destroy";
    private static final String CREDITS = "Version 0.1";
    private static final String START_TEXT = "Start";
    private static final String EXIT_TEXT = "Exit";
    private static final String INFO_TEXT = "Info";

    private static final Color TEXT_COLOR = new Color(255, 255, 255);//pure white
    private static final Color CLICKED_BUTTON_COLOR = Color.GREEN.darker().brighter();
    private static final Color CLICKED_TEXT = Color.CYAN;



    private final Rectangle menuFace;
    private final Rectangle startButton;
    private final Rectangle exitButton;
    private final Rectangle infoButton;


    private final Font greetingsFont;
    private final Font gameTitleFont;
    private final Font creditsFont;
    private final Font buttonFont;

    private final String imageURL;
    private BufferedImage background=null;






    public HomeMenuModel(Dimension area) {
        menuFace = new Rectangle(new Point(0,0),area);
        imageURL = "Brick_Destroy-master/src/main/resources/photos/background.jpg";
        try {
            background = ImageIO.read(new File(imageURL));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Dimension btnDim = new Dimension(area.width / 3, area.height / 12);
        startButton = new Rectangle(btnDim);
        exitButton = new Rectangle(btnDim);
        infoButton = new Rectangle(btnDim);


        greetingsFont = new Font("Noto Mono",Font.PLAIN,25);
        gameTitleFont = new Font("Noto Mono",Font.BOLD,40);
        creditsFont = new Font("Monospaced",Font.PLAIN,25);
        buttonFont = new Font("Monospaced",Font.PLAIN,startButton.height-2);

    }
    public BufferedImage getBackground(){
        return background;
    }



    public Rectangle getMenuFace(){return menuFace;}
    public Font getGreetingsFont(){
        return greetingsFont;
    }

    public Font getGameTitleFont(){
        return gameTitleFont;
    }
    public Font getCreditsFont(){
        return creditsFont;
    }
    public Font getButtonFont(){
        return buttonFont;
    }
    public Color getTextColor(){
        return TEXT_COLOR;
    }

    public Rectangle getStartButton(){return startButton;}
    public Rectangle getExitButton(){return exitButton;}
    public Rectangle getInfoButton(){return infoButton;}
    public String getGreetings(){return GREETINGS;}
    public String getGameTitle(){return GAME_TITLE;}
    public String getCredits(){return CREDITS;}
    public String getMenuText(){return EXIT_TEXT;}
    public String getStartText(){return START_TEXT;}

    public String getSettingText(){return INFO_TEXT;}
    public Color getClickedButtonColor(){return CLICKED_BUTTON_COLOR;}
    public Color getClickedText(){return CLICKED_TEXT;}







}
