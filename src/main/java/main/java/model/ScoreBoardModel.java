package main.java.model;

import javax.swing.*;
import java.io.File;

public class ScoreBoardModel {


    private final JTable table = new JTable();
    private final String filePath = "src/main/resources/score.txt";
    private final File file = new File(filePath);
    private final JButton back = new JButton("Back");

    /**
     * This getter method is to get the table created
     * @return table created
     */
    public JTable getTable() {
        return table;
    }

    /**
     * This getter method is to return the file
     * @return file created
     */
    public File getFile() {
        return file;
    }
    /**
     * This getter method is to get the back button
     * @return back button
     */
    public JButton getBack() {
        return back;
    }



}