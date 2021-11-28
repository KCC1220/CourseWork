package main.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Record {


    void write(String s) throws IOException {
        FileWriter writer = new FileWriter(GraphicsMain.path,true);
        writer.write(s);
        writer.close();
    }

}
