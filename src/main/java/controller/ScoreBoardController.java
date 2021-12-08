package main.java.controller;

import main.java.GameFrame;
import main.java.model.ScoreBoardModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScoreBoardController {
    ScoreBoardModel model1;

    /**
     * Method to set the content in the JTable.
     *
     */
    public void setTable() {
        model1 = new ScoreBoardModel();
        BufferedReader reader;
        {
            try {
                reader = new BufferedReader(new FileReader(model1.getFile()));
                String firstLine = reader.readLine().trim();
                String[] columnsName = firstLine.split("/");
                DefaultTableModel model = (DefaultTableModel) model1.getTable().getModel();
                model.setColumnIdentifiers(columnsName);

                Object[] tableLines = reader.lines().toArray();
                for (Object tableLine : tableLines) {
                    String line = tableLine.toString().trim();
                    String[] dataRow = line.split("/");
                    model.addRow(dataRow);
                }
                model1.getTable().setModel(model);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public JTable getTable(){
        return model1.getTable();
    }

    public JButton getBack(){
        return model1.getBack();
    }

    /**
     * This method is to locate the window created to be stayed at the middle of player's screen.
     *
     * @param frame is the window that need to be located in the middle.
     */
    public void autoLocate(JFrame frame) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (size.width - frame.getWidth()) / 2;
        int y = (size.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }

    /**
     *
     * This method is to track player click on the button.
     *
     * @param e is a mouse tracking event.
     * @param frame is to pass in the current window.
     */
    public void actionPerformed(ActionEvent e, JFrame frame) {
        if (e.getSource() == getBack()){
            frame.dispose();
            EventQueue.invokeLater(() -> new GameFrame().initialize());
        }
    }

}
