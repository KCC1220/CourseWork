package main.java.scoring;


import java.io.*;

public class Record {
    private final String path = "src/main/resources/score.txt";
    FileReader fileReader;
    public static String lastLine,line;

    /**
     *This method is to write string data into the score file.
     *
     * @param s is the parameter to write in to the file. In this case it is the Time in string.
     * @throws IOException This is to catch the exception when the file path is not found.
     */
    public void write(String s) throws IOException {
        FileWriter writer = new FileWriter(path,true);
        writer.write(s);
        writer.close();
    }

    /**
     * This function can help in making sure that the record is recorded in the last line of the file.
     * It is mainly for testing. To check whether the last line is the newly inserted String.
     *
     * @throws IOException This is to catch the exception if the file path is not found
     *
     */
    public void checkLastLine() throws IOException{
        fileReader = new FileReader(path);
        BufferedReader reader = new BufferedReader(fileReader);
        while((line=reader.readLine())!=null){
            lastLine = line;
        }
        reader.close();
    }

}