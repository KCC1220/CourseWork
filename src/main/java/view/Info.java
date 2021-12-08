package main.java.view;



import main.java.controller.InfoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Info extends JComponent implements ActionListener {
    InfoController controller = new InfoController();
    JFrame frame = new JFrame();
    public Info() {
        JPanel panel = new JPanel();

        panel.add(controller.display1());
        panel.add(controller.display2());
        panel.add(controller.display3());
        panel.add(controller.display4());
        panel.add(controller.display5());
        panel.add(controller.display6());
        panel.add(controller.display7());
        panel.add(controller.display8());
        panel.add(controller.display9());
        panel.add(controller.display10());
        panel.add(controller.back());
        controller.back().addActionListener(this);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Instruction");
        frame.setSize( 1000, Colour.DEF_HEIGHT);
        controller.autoLocate(frame);
        frame.setVisible(true);

    }





    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == controller.back()){
            controller.backToMainMenu(frame);
        }
    }


}

