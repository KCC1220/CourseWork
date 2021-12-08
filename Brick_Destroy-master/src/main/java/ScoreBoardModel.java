package main.java;

import javax.swing.*;
import java.io.File;

public class ScoreBoardModel {


    private JTable table = new JTable();
    private String filePath = "Brick_Destroy-master/src/main/resources/score.txt";
    private File file = new File(filePath);
    private JButton back = new JButton("Back");
    public JTable getTable() {
        return table;
    }

    public String getFilePath() {
        return filePath;
    }

    public File getFile() {
        return file;
    }

    public JButton getBack() {
        return back;
    }



}
