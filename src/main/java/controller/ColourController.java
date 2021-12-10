package main.java.controller;


import main.java.model.ColourModel;

import javax.swing.*;
import java.awt.*;




public class ColourController {
    private static final ColourModel model = new ColourModel();

    /**
     * This method is to track which button the player clicked on.
     * @param select is the selection of button.
     */
    public void clickedButton(int select){

        if (select==1){
            model.setPlayerColour(Color.yellow.darker());
            updatePlayerColour("     YELLOW");

        }
        if (select== 2){
            model.setPlayerColour(Color.blue);
            updatePlayerColour("           BLUE");

        }
        if (select== 3){
            model.setPlayerColour(Color.green);
            updatePlayerColour("       GREEN");

        }
        if (select== 4){
            model.setPlayerColour(Color.cyan);
            updatePlayerColour("        CYAN");

        }
        if (select== 5){
            model.setPlayerColour(Color.red);

            updatePlayerColour("           RED");
        }
        if (select== 6){
            model.setPlayerColour(Color.magenta);
            updatePlayerColour("MAGENTA");

        }
        if (select== 7){
            model.setPlayerColour(Color.pink);
            updatePlayerColour("           PINK");

        }
        if (select== 8){
            model.setBallColour(Color.yellow.darker());
            updateBallColor("     YELLOW");

        }
        if (select== 9){
            model.setBallColour(Color.blue);
            updateBallColor("       BLUE");

        }
        if (select== 10){
            model.setBallColour(Color.green);
            updateBallColor("   GREEN     ");
        }
        if (select== 11){
            model.setBallColour(Color.cyan);
            updateBallColor("CYAN        ");

        }
        if (select== 12){
            model.setBallColour(Color.red);
            updateBallColor("RED        ");
        }
        if (select== 13){
            model.setBallColour(Color.magenta);
            updateBallColor("MAGENTA");

        }
        if (select== 14){
            model.setBallColour(Color.pink);
            updateBallColor("PINK        ");

        }
    }

    /**
     * This method is to update to the model that the colour of the player had been changed.
     * @param colour is the chosen colour.
     */
    public void updatePlayerColour(String colour){
        model.setPColour(colour);
    }
    /**
     * This method is to update to the model that the colour of the ball had been changed.
     * @param colour is the chosen colour.
     */
    public void updateBallColor(String colour){model.setBColour(colour);}

    /**
     * This mthod is to locate the window at the window of the player's screen.
     * @param frame is the window that need to be located.
     */
    public void autoLocate(JFrame frame){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (size.width - frame.getWidth()) / 2;
        int y = (size.height - frame.getHeight()) / 2;
        frame.setLocation(x,y);
    }

    /**
     * This is a getter method to return Player Red Button.
     * @return player red colour button.
     */
    public JButton getP_red() {
        return model.getP_red();
    }
    /**
     * This is a getter method to return Player Yellow Button.
     * @return player yellow colour button.
     */
    public JButton getP_yellow() {
        return model.getP_yellow() ;
    }

    /**
     * This is a getter method to return Player Green Button.
     * @return player green colour button.
     */
    public JButton getP_green() {

        return model.getP_green();
    }
    /**
     * This is a getter method to return Player Cyan Button.
     * @return player cyan colour button.
     */
    public JButton getP_cyan() {
        return model.getP_cyan();
    }

    /**
     * This is a getter method to return Player Green Button.
     * @return player green colour button.
     */
    public JButton getP_blue() {
        return model.getP_blue();
    }
    /**
     * This is a getter method to return Player Magenta Button.
     * @return player magenta colour button.
     */
    public JButton getP_magenta() {return model.getP_magenta();}
    /**
     * This is a getter method to return Player Pink Button.
     * @return player pink colour button.
     */
    public JButton getP_pink() {
        return model.getP_pink();
    }

    /**
     * This is a getter method to return Ball Red Button.
     * @return ball red colour button.
     */
    public JButton getB_red() {
        return model.getB_red();
    }

    /**
     * This is a getter method to return Ball Yellow Button.
     * @return ball yellow colour button.
     */
    public JButton getB_yellow() {
        return model.getB_yellow();
    }

    /**
     * This is a getter method to return Ball Green Button.
     * @return ball green colour button.
     */
    public JButton getB_green() {
        return model.getB_green();
    }
    /**
     * This is a getter method to return Ball Cyan Button.
     * @return ball cyan colour button.
     */
    public JButton getB_cyan() {
        return model.getB_cyan();
    }

    /**
     * This is a getter method to return Ball Blue Button.
     * @return ball blue colour button.
     */
    public JButton getB_blue() {
        return model.getB_blue();
    }

    /**
     * This is a getter method to return Ball Magenta Button.
     * @return ball magenta colour button.
     */
    public JButton getB_magenta() {
        return model.getB_magenta();
    }

    /**
     * This is a getter method to return Ball Pink Button.
     * @return ball pink colour button.
     */
    public JButton getB_pink() {
        return model.getB_pink();
    }

    /**
     * This getter method is to get the string of color name that the player chosen for ball.
     * @return the chosen colour name.
     */
    public String getBColour(){
        return model.getBColour();
    }
    /**
     * This getter method is to get the string of color name that the player chosen for player.
     * @return the chosen colour name.
     */
    public String getPColour(){
        return model.getPColour();
    }

    /**
     * This is a getter method to get the Start Button
     * @return start button
     */
    public JButton getStart() {
        return model.getStart();
    }
    /**
     * This is a getter method to get the Tutorial Button
     * @return tutorial button
     */
    public JButton getArcade() {
        return model.getArcade();
    }

    /**
     * This getter function is to get "BALL" label
     * @return Labeling
     */
    public JLabel getLabelBall(){return model.getLabelBall();}
    /**
     * This getter function is to get "PLAYER" label
     * @return Labeling
     */
    public JLabel getLabelPlayer(){return model.getLabelPlayer();}
    /**
     * This getter function is to get Player Colour.
     * @return Colour of player
     */
    public Color getPlayerColour() {return model.getPlayerColour();}
    /**
     * This getter function is to get Ball Colour.
     * @return Colour of ball
     */
    public Color getBallColour() {return model.getBallColour();
    }







}
