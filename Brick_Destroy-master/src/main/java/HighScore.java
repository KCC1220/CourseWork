package main.java;

import java.io.*;

public class HighScore {

    static int highScore=0;

    public HighScore(){

        if(highScore==0){
            highScore = this.GetHighScoreLvl1();
        }
    }

    public int GetHighScoreLvl1(){
        FileReader readFile=null;
        BufferedReader reader=null;
        try {
            //format ss
            readFile = new FileReader("Brick_Destroy-master/src/main/resources/highscore1.txt");
            reader = new BufferedReader(readFile);
            return Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            return 0;
        }
        finally {
            try {
                if(reader!=null)
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void CheckScore(int score){
        String latest;
        if (score < highScore){
            highScore = score;
            latest = String.valueOf(highScore);
            File scoreFile = new File("Brick_Destroy-master/src/main/resources/highscore1.txt");
            FileWriter writefile = null;
            BufferedWriter writer = null;
            System.out.println(latest);
            try {
                writefile = new FileWriter(scoreFile);
                writer = new BufferedWriter(writefile);
                writer.write(latest);
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally{
                try{
                    if(writer != null)
                        writer.close();
                }
                catch (Exception e){}
            }


        }
    }

}
