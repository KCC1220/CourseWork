package main.java;

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

    public JLabel getLabelBall(){return labelBall;}

    public JLabel getLabelPlayer(){return labelPlayer;}

    public Color getPlayerColour() {return pColour;}

    void autoLocate(JFrame frame){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (size.width - frame.getWidth()) / 2;
        int y = (size.height - frame.getHeight()) / 2;
        frame.setLocation(x,y);
    }


    public void setBallColour(Color color){
        bColour = color;
    }
    public void setPlayerColour(Color color){
        pColour = color;
    }
    public Color getBallColour() {
        return bColour;
    }

    public JButton getP_red() {
        return p_red;
    }

    public JButton getP_yellow() {
        return p_yellow;
    }

    public JButton getP_green() {
        return p_green;
    }

    public JButton getP_cyan() {
        return p_cyan;
    }

    public JButton getP_blue() {
        return p_blue;
    }

    public JButton getP_magenta() {
        return p_magenta;
    }

    public JButton getP_pink() {
        return p_pink;
    }

    public JButton getB_red() {
        return b_red;
    }

    public JButton getB_yellow() {
        return b_yellow;
    }

    public JButton getB_green() {
        return b_green;
    }

    public JButton getB_cyan() {
        return b_cyan;
    }

    public JButton getB_blue() {
        return b_blue;
    }

    public JButton getB_magenta() {
        return b_magenta;
    }

    public JButton getB_pink() {
        return b_pink;
    }

    public JButton getArcade() {
        return arcade;
    }

    public JButton getStart() {
        return start;
    }

    public void setPColour(String color) {
        label_p = color;
    }

    public String getPColour(){
        return label_p;
    }
    public void setBColour(String color){
        label_b = color;
    }
    public String getBColour(){
        return label_b;
    }
}
