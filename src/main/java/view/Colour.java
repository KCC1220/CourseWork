package main.java.view;

import main.java.controller.ColourController;
import main.java.model.ColourModel;
import main.java.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Colour extends JComponent implements ActionListener{

    public ColourController colourController = new ColourController();




    public static final int DEF_HEIGHT = 300;





    JFrame frame;
    public static JLabel label_p;
    public static JLabel label_b;


    /**
     * This is the Colour constructor which will show the choosing colour screen
     */
    public Colour(){
        JPanel panel = new JPanel();
        label_b = new JLabel( "          BLUE");
        label_p = new JLabel("         GREEN");
        colourController.getP_red().addActionListener(this);
        colourController.getP_yellow().addActionListener(this);
        colourController.getP_green().addActionListener(this);
        colourController.getP_cyan().addActionListener(this);
        colourController.getP_blue().addActionListener(this);
        colourController.getP_magenta().addActionListener(this);
        colourController.getP_pink().addActionListener(this);
        colourController.getStart().addActionListener(this);
        colourController.getArcade().addActionListener(this);
        colourController.getB_red().addActionListener(this);
        colourController.getB_yellow().addActionListener(this);
        colourController.getB_green().addActionListener(this);
        colourController.getB_cyan().addActionListener(this);
        colourController.getB_blue().addActionListener(this);
        colourController.getB_magenta().addActionListener(this);
        colourController.getB_pink().addActionListener(this);
        panel.add(colourController.getLabelPlayer());
        panel.add(colourController.getLabelBall());
        panel.add(colourController.getP_red());
        panel.add(colourController.getB_red());
        panel.add(colourController.getP_yellow());
        panel.add(colourController.getB_yellow());
        panel.add(colourController.getP_green());
        panel.add(colourController.getB_green());
        panel.add(colourController.getP_cyan());
        panel.add(colourController.getB_cyan());
        panel.add(colourController.getP_blue());
        panel.add(colourController.getB_blue());
        panel.add(colourController.getP_magenta());
        panel.add(colourController.getB_magenta());
        panel.add(colourController.getP_pink());
        panel.add(colourController.getB_pink());
        panel.add(label_p);
        panel.add(label_b);
        panel.add(colourController.getStart());
        panel.add(colourController.getArcade());
        frame = new JFrame("CC");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(200,350));
        frame.pack();
        frame.setResizable(false);
        colourController.autoLocate(frame);
        frame.setVisible(true);



    }


    /**
     * This method is to track the action preformed on the button in the screen
     * @param e is to track the action performed by player
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        GameFrame gameframe;
        if(e.getSource() == colourController.getStart())
        {
            frame.dispose();
            gameframe = new GameFrame();
            gameframe.enableGameBoard();

        }
        if(e.getSource() == colourController.getArcade())
        {
            frame.dispose();
            gameframe = new GameFrame();
            gameframe.enableArcadeGameBoard();

        }


        if (e.getSource() == colourController.getP_yellow()){
            colourController.clickedButton(1);
            label_p.setText(colourController.getPColour());



        }
        if (e.getSource() == colourController.getP_blue()){

            colourController.clickedButton(2);
            label_p.setText(colourController.getPColour());


        }
        if (e.getSource() == colourController.getP_green()){

            colourController.clickedButton(3);
            label_p.setText(colourController.getPColour());


        }
        if (e.getSource() == colourController.getP_cyan()){

            colourController.clickedButton(4);
            label_p.setText(colourController.getPColour());


        }
        if (e.getSource() == colourController.getP_red()){

            colourController.clickedButton(5);
            label_p.setText(colourController.getPColour());


        }
        if (e.getSource() == colourController.getP_magenta()){

            colourController.clickedButton(6);
            label_p.setText(colourController.getPColour());


        }
        if (e.getSource() == colourController.getP_pink()){

            colourController.clickedButton(7);
            label_p.setText(colourController.getPColour());


        }
        if (e.getSource() == colourController.getB_yellow()){

            colourController.clickedButton(8);
            label_b.setText(colourController.getBColour());

        }
        if (e.getSource() == colourController.getB_blue()){

            colourController.clickedButton(9);
            label_b.setText(colourController.getBColour());


        }
        if (e.getSource() == colourController.getB_green()){

            colourController.clickedButton(10);
            label_b.setText(colourController.getBColour());


        }
        if (e.getSource() == colourController.getB_cyan()){

            colourController.clickedButton(11);
            label_b.setText(colourController.getBColour());


        }
        if (e.getSource() == colourController.getB_red()){

            colourController.clickedButton(12);
            label_b.setText(colourController.getBColour());


        }
        if (e.getSource() == colourController.getB_magenta()){

            colourController.clickedButton(13);
            label_b.setText(colourController.getBColour());

        }
        if (e.getSource() == colourController.getB_pink()){

            colourController.clickedButton(14);
            label_b.setText(colourController.getBColour());


        }
    }




}