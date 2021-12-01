package main.java;

import java.io.*;

public class HighScore {

    static int highScore=0;
    String path1 = "Brick_Destroy-master/src/main/resources/score.txt";


    public HighScore(){

        if(highScore==0){
            highScore = this.GetHighScoreLvl();
        }
    }

    public int GetHighScoreLvl(){
        FileReader readFile=null;
        BufferedReader reader=null;

        try {
            //format ss

            readFile = new FileReader(path1);
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

    public void CheckScore(int score,int level){
        String latest;
        File scoreFile = null;
        if (score < highScore){
            highScore = score;
            latest = String.valueOf(highScore);

            scoreFile = new File(path1);

            FileWriter writeFile;
            BufferedWriter writer = null;
            System.out.println(latest);
            try {
                writeFile = new FileWriter(scoreFile);
                writer = new BufferedWriter(writeFile);
                writer.write(latest);
            } catch (Exception e)  {
                e.printStackTrace();
            }
            finally{
                try{
                    if(writer != null)
                        writer.close();
                }
                catch (Exception ignored){}
            }


        }
    }
    public int getHighScore(){
        return highScore;
    }

}
