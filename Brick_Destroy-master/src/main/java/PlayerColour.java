package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PlayerColour extends JComponent implements ActionListener{
    public static Color colour=Color.green;
    public static Color b_colour = Color.BLUE;



    private static final String C_Red = "Red";
    private static final String C_Yellow = "Yellow";
    private static final String C_Green = "Green";
    private static final String C_Cyan = "Cyan";
    private static final String C_Blue = "Blue";
    private static final String C_Magenta = "Magenta";
    private static final String C_Pink = "Pink";

    GameFrame gameframe;


    public static final int DEF_WIDTH = 450;
    public static final int DEF_HEIGHT = 300;




    JButton p_red=new JButton(C_Red);
    JButton p_yellow = new JButton(C_Yellow);
    JButton p_green = new JButton(C_Green);
    JButton p_cyan = new JButton(C_Cyan);
    JButton p_blue = new JButton(C_Blue);
    JButton p_magenta = new JButton(C_Magenta);
    JButton p_pink = new JButton(C_Pink);
    JButton b_red = new JButton((C_Red));
    JButton b_yellow = new JButton(C_Yellow);
    JButton b_green = new JButton(C_Green);
    JButton b_cyan = new JButton(C_Cyan);
    JButton b_blue = new JButton(C_Blue);
    JButton b_magenta = new JButton(C_Magenta);
    JButton b_pink = new JButton(C_Pink);
    JButton arcade = new JButton("Arcade");
    JFrame frame;
    JButton start = new JButton("START");
    JLabel label_p;
    JLabel label_b;



    public PlayerColour(){



            p_red.setBounds(10,20,2,4);
            p_red.setBackground(Color.red);
            p_red.setFocusable(false);
            p_red.addActionListener(this);
            JLabel label = new JLabel("Player:");
            p_yellow.setBounds(10,25,2,4);
            p_yellow.setBackground(Color.yellow.darker());
            p_yellow.setFocusable(false);
            p_yellow.addActionListener(this);
            p_green.setBounds(10,30,2,4);
            p_green.setBackground(Color.green);
            p_green.setFocusable(false);
            p_green.addActionListener(this);
            p_cyan.setBounds(10,35,2,4);
            p_cyan.setBackground(Color.cyan);
            p_cyan.setFocusable(false);
            p_cyan.addActionListener(this);
            p_blue.setBounds(10,40,2,4);
            p_blue.setBackground(Color.blue);
            p_blue.setFocusable(false);
            p_blue.addActionListener(this);
            p_magenta.setBounds(10,45,2,4);
            p_magenta.setBackground(Color.magenta);
            p_magenta.setFocusable(false);
            p_magenta.addActionListener(this);
            p_pink.setBounds(10,50,2,4);
            p_pink.setBackground(Color.pink);
            p_pink.setFocusable(false);
            p_pink.addActionListener(this);
            start.setBounds(50,16,2,4);
            start.setFocusable(false);
            start.addActionListener(this);
        arcade.setBounds(50,16,2,4);
        arcade.setFocusable(false);
        arcade.addActionListener(this);
        b_red.setBounds(30,20,2,4);
        b_red.setBackground(Color.red);
        b_red.setFocusable(false);
        b_red.addActionListener(this);
        JLabel label2 = new JLabel("                 Ball:\n");
        b_yellow.setBounds(30,25,2,4);
        b_yellow.setBackground(Color.yellow.darker());
        b_yellow.setFocusable(false);
        b_yellow.addActionListener(this);
        b_green.setBounds(30,30,2,4);
        b_green.setBackground(Color.green);
        b_green.setFocusable(false);
        b_green.addActionListener(this);
        b_cyan.setBounds(30,35,2,4);
        b_cyan.setBackground(Color.cyan);
        b_cyan.setFocusable(false);
        b_cyan.addActionListener(this);
        b_blue.setBounds(30,40,2,4);
        b_blue.setBackground(Color.blue);
        b_blue.setFocusable(false);
        b_blue.addActionListener(this);
        b_magenta.setBounds(30,45,2,4);
        b_magenta.setBackground(Color.magenta);
        b_magenta.setFocusable(false);
        b_magenta.addActionListener(this);
        b_pink.setBounds(30,50,2,4);
        b_pink.setBackground(Color.pink);
        b_pink.setFocusable(false);
        b_pink.addActionListener(this);
        label_b = new JLabel( "          BLUE");
        label_p = new JLabel("         GREEN");
        JPanel panel = new JPanel();

            panel.add(label);
            panel.add(label2);

            panel.add(p_red);
            panel.add(b_red);
            panel.add(p_yellow);
            panel.add(b_yellow);
            panel.add(p_green);
            panel.add(b_green);
            panel.add(p_cyan);
            panel.add(b_cyan);
            panel.add(p_blue);
            panel.add(b_blue);
            panel.add(p_magenta);
            panel.add(b_magenta);
            panel.add(p_pink);
            panel.add(b_pink);
            panel.add(label_p);
            panel.add(label_b);
            panel.add(start);
            panel.add(arcade);
        frame = new JFrame("CC");
        frame.setContentPane(panel);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(200,350));
            frame.pack();
            frame.setResizable(false);
            autoLocate(frame);

            frame.setVisible(true);



    }
    public static Color colouring(){
        return colour;
    }
    public static Color b_colour(){
        return b_colour;
    }
    public void updatePlayerColour(String Color){
        label_p.setText(Color);
    }
    public void updateBallColor(String Color){
        label_b.setText(Color);
    }

    private void autoLocate(JFrame frame){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (size.width - frame.getWidth()) / 2;
        int y = (size.height - frame.getHeight()) / 2;
        frame.setLocation(x,y);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == start)
        {
            frame.dispose();
            gameframe = new GameFrame();
            gameframe.enableGameBoard();

        }
        if(e.getSource() == arcade)
        {
            frame.dispose();
            gameframe = new GameFrame();
            gameframe.enableArcadeGameBoard();

        }
        if (e.getSource() == p_yellow){
            colour = Color.yellow.darker();
            updatePlayerColour("     YELLOW");

        }
        if (e.getSource() == p_blue){
            colour = Color.blue;
            updatePlayerColour("           BLUE");

        }
        if (e.getSource() == p_green){
            colour = Color.green;
            updatePlayerColour("       GREEN");

        }
        if (e.getSource() == p_cyan){
            colour = Color.cyan;
            updatePlayerColour("        CYAN");

        }
        if (e.getSource() == p_red){
            colour = Color.red;
            updatePlayerColour("           RED");

        }
        if (e.getSource() == p_magenta){
            colour = Color.magenta;
            updatePlayerColour("MAGENTA");

        }
        if (e.getSource() == p_pink){
            colour = Color.pink;
            updatePlayerColour("           PINK");

        }
        if (e.getSource() == b_yellow){
            b_colour = Color.yellow.darker();
            updateBallColor("     YELLOW");

        }
        if (e.getSource() == b_blue){
            b_colour = Color.blue;
            updateBallColor("       BLUE");

        }
        if (e.getSource() == b_green){
            b_colour = Color.green;
            updateBallColor("   GREEN     ");

        }
        if (e.getSource() == b_cyan){
            b_colour = Color.cyan;
            updateBallColor("CYAN        ");

        }
        if (e.getSource() == b_red){
            b_colour = Color.red;
            updateBallColor("RED        ");

        }
        if (e.getSource() == b_magenta){
            b_colour = Color.magenta;
            updateBallColor("MAGENTA");

        }
        if (e.getSource() == b_pink){
            b_colour = Color.pink;
            updateBallColor("PINK        ");

        }
    }


}