package main.java;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

public class ScoreBoard extends JComponent implements ActionListener {

    JFrame frame = new JFrame();
    ScoreBoardController controller = new ScoreBoardController();
    public ScoreBoard(){
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
    @Override
    public void actionPerformed(ActionEvent e) {
        controller.actionPerformed(e,frame);
    }


}
