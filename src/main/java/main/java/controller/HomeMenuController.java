package main.java.controller;




import main.java.GameFrame;
import main.java.model.HomeMenuModel;

import java.awt.*;
import java.awt.image.BufferedImage;


public class HomeMenuController{
    public HomeMenuModel model;
    private final GameFrame owner;

    /**
     * This is the constructor for home menu controller
     *
     * @param owner is the game frame
     * @param area is the area of the window
     */
    public HomeMenuController(GameFrame owner, Dimension area){
        model = new HomeMenuModel(area);
        this.owner = owner;
    }

    /**
     * This method is to start the game
     */
    public void enableStart(){
        owner.enableColour();
    }

    /**
     * This method is to start the info page
     */
    public void enableInfo(){
        owner.enableInfo();
    }

    /**
     * This method is to exit the game
     */
    public void enableExit(){
        System.out.println("Goodbye " + System.getProperty("user.name"));
        System.exit(0);
    }

    /**
     * This getter method is to get the background image
     * @return background image
     */
    public BufferedImage getBackground(){
        return model.getBackground();
    }

    /**
     * This getter method is to get the "SCORE" text
     * @return "SCORE" string
     */
    public String getScoreText(){
        return model.getScoreText();
    }
    /**
     * This getter method is to get the "SCORE" text
     * @return "SCORE" string
     */
    public Rectangle getMenuFace(){return model.getMenuFace();}
    /**
     * This getter method is to get the "SCORE" text
     * @return "SCORE" string
     */
    public Font getGreetingsFont(){
        return model.getGreetingsFont();
    }
    /**
     * This getter method is to get the font style for game title
     * @return font style for game tittle
     */
    public Font getGameTitleFont(){
        return model.getGameTitleFont();
    }
    /**
     * This getter method is to get the font style of credit
     * @return font style for credit
     */
    public Font getCreditsFont(){
        return model.getCreditsFont();
    }
    /**
     * This getter method is to get the font style of button
     * @return font style for button
     */
    public Font getButtonFont(){
        return model.getButtonFont();
    }
    /**
     * This getter method is to get colour of text
     * @return color of text
     */
    public Color getTextColor(){
        return model.getTextColor();
    }
    /**
     * This getter method is to get the rectangle button for start
     * @return a rectangle for start
     */
    public Rectangle getStartButton(){return model.getStartButton();}
    /**
     * This getter method is to get the rectangle button for exit
     * @return a rectangle for exit
     */
    public Rectangle getExitButton(){return model.getExitButton();}
    /**
     * This getter method is to get the rectangle button for score
     * @return a rectangle for score
     */
    public Rectangle getScoreButton(){return model.getScoreButton();}
    /**
     * This getter method is to get the rectangle button for info
     * @return a rectangle for info
     */
    public Rectangle getInfoButton(){return model.getInfoButton();}
    /**
     * This getter method is to get the string of greetings
     * @return greetings string
     */
    public String getGreetings(){return model.getGreetings();}
    /**
     * This getter method is to get the string of game title
     * @return greetings string
     */
    public String getGameTitle(){return model.getGameTitle();}
    /**
     * This getter method is to get the string of credits
     * @return credits string
     */
    public String getCredits(){return model.getCredits();}
    /**
     * This getter method is to get the string of exit button
     * @return exit button string
     */
    public String getExitText(){return model.getMenuText();}
    /**
     * This getter method is to get the string of start button
     * @return start button string
     */
    public String getStartText(){return model.getStartText();}
    /**
     * This getter method is to get the string of info button
     * @return info button string
     */
    public String getInfoText(){return model.getSettingText();}
    /**
     * This getter method is to get the color when the button being clicked
     * @return colour of button
     */
    public Color getClickedButtonColor(){return model.getClickedButtonColor();}

    /**
     * This getter method is to get the colour of clicked text
     * @return colour of text
     */
    public Color getClickedText(){return model.getClickedText();}



}