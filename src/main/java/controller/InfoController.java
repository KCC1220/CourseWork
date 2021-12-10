package main.java.controller;

import main.java.GameFrame;
import main.java.model.InfoModel;

import javax.swing.*;
import java.awt.*;

public class InfoController {

    InfoModel model = new InfoModel();

    public JLabel display1(){
        return model.display1 ;
    }
    public JLabel display2(){
        return model.display2 ;
    }
    public JLabel display3(){
        return model.display3 ;
    }
    public JLabel display4(){
        return model.display4 ;
    }
    public JLabel display5(){
        return model.display5 ;
    }
    public JLabel display6(){
        return model.display6 ;
    }
    public JLabel display7(){
        return model.display7 ;
    }
    public JLabel display8(){
        return model.display8 ;
    }
    public JLabel display9(){
        return model.display9 ;
    }


    public JButton back(){
        return model.back;
    }

    /**
     * This method is to locate the window created at the middle of player screen
     *
     * @param frame is the window that need to be processed
     */
    public void autoLocate(JFrame frame) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (size.width - frame.getWidth()) / 2;
        int y = (size.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }

    /**
     * This method is to initialise back the home menu and dispose the current window after catch player clicked on the button.
     *
     * @param label is the current window that the button located.
     */
    public void backToMainMenu(JFrame label) {
            label.dispose();
            EventQueue.invokeLater(() -> new GameFrame().initialize());

    }
}
