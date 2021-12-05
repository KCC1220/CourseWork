package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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
    public JLabel display10(){
        return model.display10 ;
    }

    public JButton back(){
        return model.back;
    }
    public void autoLocate(JFrame frame) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (size.width - frame.getWidth()) / 2;
        int y = (size.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }
    public void backToMainMenu(JFrame label) {
            label.dispose();
            EventQueue.invokeLater(() -> new GameFrame().initialize());

    }
}
