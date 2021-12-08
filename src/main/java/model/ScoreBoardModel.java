package main.java.model;

import javax.swing.*;
import java.io.File;

public class ScoreBoardModel {


    private final JTable table = new JTable();
    private final String filePath = "src/main/resources/score.txt";
    private final File file = new File(filePath);
    private final JButton back = new JButton("Back");
    public JTable getTable() {
        return table;
    }

    public File getFile() {
        return file;
    }

    public JButton getBack() {
        return back;
    }



}
