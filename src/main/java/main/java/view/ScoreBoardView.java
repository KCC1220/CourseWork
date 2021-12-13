package main.java.view;

import main.java.controller.ScoreBoardController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreBoardView extends JComponent implements ActionListener {

    JFrame frame = new JFrame();
    ScoreBoardController controller = new ScoreBoardController();
    /**
     * This is the constructor of Score board
     * This will initialise and show the score board screen.
     */
    public ScoreBoardView(){
        JPanel panel = new JPanel();
        controller.setTable();
        panel.add(add(new JScrollPane(controller.getTable())));
        panel.add(controller.getBack());
        controller.getBack().addActionListener(this);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Score");
        frame.setSize( 500,500);
        controller.autoLocate(frame);
        frame.setVisible(true);
    }

    /**
     * This method is to track the action preformed
     * @param e the action of the player
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        controller.actionPerformed(e,frame);
    }


}