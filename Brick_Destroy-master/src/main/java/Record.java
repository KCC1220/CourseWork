package main.java;


import java.io.*;

public class Record {
    private final String path = "Brick_Destroy-master/src/main/resources/score.txt";
    FileReader fileReader;
    public static String lastLine;

    public void write(String s) throws IOException {
        FileWriter writer = new FileWriter(path,true);
        writer.write(s);
        writer.close();
    }

    public void checkLastLine() throws IOException{
        fileReader = new FileReader(path);
        BufferedReader reader = new BufferedReader(fileReader);
        while(reader.readLine()!=null){
            lastLine = reader.readLine();
        }
    }

}
