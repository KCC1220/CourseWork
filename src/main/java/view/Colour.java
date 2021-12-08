package main.java.view;

import main.java.controller.ColourController;
import main.java.model.ColourModel;
import main.java.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Colour extends JComponent implements ActionListener{

    public ColourModel colourModel = new ColourModel();
    ColourController colourController = new ColourController();




    public static final int DEF_HEIGHT = 300;





    JFrame frame;
    public static JLabel label_p;
    public static JLabel label_b;



    public Colour(){


        JPanel panel = new JPanel();

        label_b = new JLabel( "          BLUE");
        label_p = new JLabel("         GREEN");

        colourModel.getP_red().addActionListener(this);

        colourModel.getP_yellow().addActionListener(this);

        colourModel.getP_green().addActionListener(this);

        colourModel.getP_cyan().addActionListener(this);

        colourModel.getP_blue().addActionListener(this);

        colourModel.getP_magenta().addActionListener(this);

        colourModel.getP_pink().addActionListener(this);

        colourModel.getStart().addActionListener(this);

        colourModel.getArcade().addActionListener(this);

        colourModel.getB_red().addActionListener(this);


        colourModel.getB_yellow().addActionListener(this);

        colourModel.getB_green().addActionListener(this);

        colourModel.getB_cyan().addActionListener(this);

        colourModel.getB_blue().addActionListener(this);

        colourModel.getB_magenta().addActionListener(this);

        colourModel.getB_pink().addActionListener(this);

        panel.add(colourModel.getLabelPlayer());
        panel.add(colourModel.getLabelBall());

        panel.add(colourModel.getP_red());
        panel.add(colourModel.getB_red());
        panel.add(colourModel.getP_yellow());
        panel.add(colourModel.getB_yellow());
        panel.add(colourModel.getP_green());
        panel.add(colourModel.getB_green());
        panel.add(colourModel.getP_cyan());
        panel.add(colourModel.getB_cyan());
        panel.add(colourModel.getP_blue());
        panel.add(colourModel.getB_blue());
        panel.add(colourModel.getP_magenta());
        panel.add(colourModel.getB_magenta());
        panel.add(colourModel.getP_pink());
        panel.add(colourModel.getB_pink());
        panel.add(label_p);
        panel.add(label_b);
        panel.add(colourModel.getStart());
        panel.add(colourModel.getArcade());
        frame = new JFrame("CC");
        frame.setContentPane(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(200,350));
        frame.pack();
        frame.setResizable(false);
        colourModel.autoLocate(frame);

        frame.setVisible(true);



    }





    @Override
    public void actionPerformed(ActionEvent e) {
        GameFrame gameframe;
        if(e.getSource() == colourModel.getStart())
        {
            frame.dispose();
            gameframe = new GameFrame();
            gameframe.enableGameBoard();

        }
        if(e.getSource() == colourModel.getArcade())
        {
            frame.dispose();
            gameframe = new GameFrame();
            gameframe.enableArcadeGameBoard();

        }


        if (e.getSource() == colourModel.getP_yellow()){
            colourController.clickedButton(1);
            label_p.setText(colourModel.getPColour());



        }
        if (e.getSource() == colourModel.getP_blue()){

            colourController.clickedButton(2);
            label_p.setText(colourModel.getPColour());


        }
        if (e.getSource() == colourModel.getP_green()){

            colourController.clickedButton(3);
            label_p.setText(colourModel.getPColour());


        }
        if (e.getSource() == colourModel.getP_cyan()){

            colourController.clickedButton(4);
            label_p.setText(colourModel.getPColour());


        }
        if (e.getSource() == colourModel.getP_red()){

            colourController.clickedButton(5);
            label_p.setText(colourModel.getPColour());


        }
        if (e.getSource() == colourModel.getP_magenta()){

            colourController.clickedButton(6);
            label_p.setText(colourModel.getPColour());


        }
        if (e.getSource() == colourModel.getP_pink()){

            colourController.clickedButton(7);
            label_p.setText(colourModel.getPColour());


        }
        if (e.getSource() == colourModel.getB_yellow()){

            colourController.clickedButton(8);
            label_b.setText(colourModel.getBColour());

        }
        if (e.getSource() == colourModel.getB_blue()){

            colourController.clickedButton(9);
            label_b.setText(colourModel.getBColour());


        }
        if (e.getSource() == colourModel.getB_green()){

            colourController.clickedButton(10);
            label_b.setText(colourModel.getBColour());


        }
        if (e.getSource() == colourModel.getB_cyan()){

            colourController.clickedButton(11);
            label_b.setText(colourModel.getBColour());


        }
        if (e.getSource() == colourModel.getB_red()){

            colourController.clickedButton(12);
            label_b.setText(colourModel.getBColour());


        }
        if (e.getSource() == colourModel.getB_magenta()){

            colourController.clickedButton(13);
            label_b.setText(colourModel.getBColour());

        }
        if (e.getSource() == colourModel.getB_pink()){

            colourController.clickedButton(14);
            label_b.setText(colourModel.getBColour());


        }
    }




}