package main.java.view;



import main.java.controller.ControlsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ControlsView extends JComponent implements ActionListener {
    ControlsController controller = new ControlsController();
    JFrame frame = new JFrame();

    /**
     * This is the constructor for info
     * This will show the info panel to player
     */
    public ControlsView() {
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
        frame.setSize( 1050, 300);
        controller.autoLocate(frame);
        frame.setResizable(false);
        frame.setVisible(true);

    }


    /**
     * This is the method to track the action of player on button
     * @param e is the action of player
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == controller.back()){
            controller.backToMainMenu(frame);
        }
    }


}
