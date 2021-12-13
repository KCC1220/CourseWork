package main.java.model;

import javax.swing.*;
import java.awt.*;

public class ColourModel {
    private static Color pColour=Color.green;
    private static Color bColour = Color.BLUE;



    private static final String C_Red = "Red";
    private static final String C_Yellow = "Yellow";
    private static final String C_Green = "Green";
    private static final String C_Cyan = "Cyan";
    private static final String C_Blue = "Blue";
    private static final String C_Magenta = "Magenta";
    private static final String C_Pink = "Pink";



    private static final JLabel labelBall = new JLabel("                 Ball:\n");
    private static final JLabel labelPlayer = new JLabel("Player:");



    private final JButton p_red=new JButton(C_Red);
    private final JButton p_yellow = new JButton(C_Yellow);
    private final JButton p_green = new JButton(C_Green);
    private final JButton p_cyan = new JButton(C_Cyan);
    private final JButton p_blue = new JButton(C_Blue);
    private final JButton p_magenta = new JButton(C_Magenta);
    private final JButton p_pink = new JButton(C_Pink);

    private final JButton b_red = new JButton((C_Red));
    private final JButton b_yellow = new JButton(C_Yellow);
    private final JButton b_green = new JButton(C_Green);
    private final JButton b_cyan = new JButton(C_Cyan);
    private final JButton b_blue = new JButton(C_Blue);
    private final JButton b_magenta = new JButton(C_Magenta);
    private final JButton b_pink = new JButton(C_Pink);


    private final JButton arcade = new JButton("Tutorial");
    private final JButton start = new JButton("START");



    private static String label_p;
    private static String label_b;

    /**
     * This constructor is to initialise all the button in choosing colour menu
     */
    public ColourModel(){
        p_red.setBounds(10,20,2,4);
        p_red.setBackground(Color.red);
        p_red.setFocusable(false);
        p_yellow.setBounds(10,25,2,4);
        p_yellow.setBackground(Color.yellow.darker());
        p_yellow.setFocusable(false);

        p_green.setBounds(10,30,2,4);
        p_green.setBackground(Color.green);
        p_green.setFocusable(false);

        p_cyan.setBounds(10,35,2,4);
        p_cyan.setBackground(Color.cyan);
        p_cyan.setFocusable(false);

        p_blue.setBounds(10,40,2,4);
        p_blue.setBackground(Color.blue);
        p_blue.setFocusable(false);
        p_magenta.setBounds(10,45,2,4);
        p_magenta.setBackground(Color.magenta);
        p_magenta.setFocusable(false);

        p_pink.setBounds(10,50,2,4);
        p_pink.setBackground(Color.pink);
        p_pink.setFocusable(false);

        start.setBounds(50,16,2,4);
        start.setFocusable(false);

        arcade.setBounds(50,16,2,4);
        arcade.setFocusable(false);

        b_red.setBounds(30,20,2,4);
        b_red.setBackground(Color.red);
        b_red.setFocusable(false);


        b_yellow.setBounds(30,25,2,4);
        b_yellow.setBackground(Color.yellow.darker());
        b_yellow.setFocusable(false);

        b_green.setBounds(30,30,2,4);
        b_green.setBackground(Color.green);
        b_green.setFocusable(false);

        b_cyan.setBounds(30,35,2,4);
        b_cyan.setBackground(Color.cyan);
        b_cyan.setFocusable(false);

        b_blue.setBounds(30,40,2,4);
        b_blue.setBackground(Color.blue);
        b_blue.setFocusable(false);

        b_magenta.setBounds(30,45,2,4);
        b_magenta.setBackground(Color.magenta);
        b_magenta.setFocusable(false);

        b_pink.setBounds(30,50,2,4);
        b_pink.setBackground(Color.pink);
        b_pink.setFocusable(false);


    }

    /**
     * This getter method is to get the label of "Ball"
     * @return "Ball" label
     */
    public JLabel getLabelBall(){return labelBall;}
    /**
     * This getter method is to get the label of "Player"
     * @return "Player" label
     */
    public JLabel getLabelPlayer(){return labelPlayer;}
    /**
     * This getter method is to get colour of player
     * @return player's rectangle colour
     */
    public Color getPlayerColour() {return pColour;}
    /**
     * This setter method is to set the colour of ball
     * @param color ball colour
     */
    public void setBallColour(Color color){
        bColour = color;
    }
    /**
     * This setter method is to set the colour of player's rectangle
     * @param color player's rectangle colour
     */
    public void setPlayerColour(Color color){
        pColour = color;
    }
    /**
     * This getter method is to get colour of ball
     * @return ball colour
     */
    public Color getBallColour() {
        return bColour;
    }
    /**
     * This getter method is to get Player's Red Button
     * @return Player's red button
     */
    public JButton getP_red() {
        return p_red;
    }
    /**
     * This getter method is to get Player's Yellow Button
     * @return Player's yellow button
     */
    public JButton getP_yellow() {
        return p_yellow;
    }
    /**
     * This getter method is to get Player's Green Button
     * @return Player's green button
     */
    public JButton getP_green() {
        return p_green;
    }
    /**
     * This getter method is to get Player's Cyan Button
     * @return Player's cyan button
     */
    public JButton getP_cyan() {
        return p_cyan;
    }
    /**
     * This getter method is to get Player's Blue Button
     * @return Player's blue button
     */
    public JButton getP_blue() {
        return p_blue;
    }
    /**
     * This getter method is to get Player's Magenta Button
     * @return Player's magenta button
     */
    public JButton getP_magenta() {
        return p_magenta;
    }
    /**
     * This getter method is to get Player's Pink Button
     * @return Player's pink button
     */
    public JButton getP_pink() {
        return p_pink;
    }
    /**
     * This getter method is to get Ball's Red Button
     * @return Ball's red button
     */
    public JButton getB_red() {
        return b_red;
    }
    /**
     * This getter method is to get Ball's Yellow Button
     * @return Ball's yellow button
     */
    public JButton getB_yellow() {
        return b_yellow;
    }
    /**
     * This getter method is to get Ball's Green Button
     * @return Ball's green button
     */
    public JButton getB_green() {
        return b_green;
    }
    /**
     * This getter method is to get Ball's Cyan Button
     * @return Ball's cyan button
     */
    public JButton getB_cyan() {
        return b_cyan;
    }
    /**
     * This getter method is to get Ball's Blue Button
     * @return Ball's blue button
     */
    public JButton getB_blue() {
        return b_blue;
    }
    /**
     * This getter method is to get Ball's Magenta Button
     * @return Ball's magenta button
     */
    public JButton getB_magenta() {
        return b_magenta;
    }
    /**
     * This getter method is to get Ball's Pink Button
     * @return Ball's pink button
     */
    public JButton getB_pink() {
        return b_pink;
    }
    /**
     * This getter method will give the Tutorial Level Button
     * * @return Tutorial button
     */
    public JButton getArcade() {
        return arcade;
    }
    /**
     * This getter method will give the Start Level Button
     * * @return Start button
     */
    public JButton getStart() {
        return start;
    }
    /**
     * This method is to set the name of the colour of player's rectangle that player chosen
     * @param color is the player chosen colour's name for player's rectangle
     */
    public void setPColour(String color) {
        label_p = color;
    }
    /**
     * This getter method will return the name of the player's chosen colour for player's rectangle
     * * @return name of the colour chosen for player's rectangle
     */
    public String getPColour(){
        return label_p;
    }
    /**
     * This method is to set the name of the colour of ball that player chosen
     * @param color is the player chosen colour's name for ball
     */
    public void setBColour(String color){
        label_b = color;
    }
    /**
     * This getter method will return the name of the player's chosen colour for ball
     * * @return name of the colour chosen for ball
     */
    public String getBColour(){
        return label_b;
    }
}