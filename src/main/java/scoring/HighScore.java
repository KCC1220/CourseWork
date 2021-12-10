package main.java.scoring;

import java.io.*;

public class HighScore {

    public static int highScore=0;
    String path1 = "src/main/resources/highscore1.txt";

    /**
     * This is the constructor of high score class.
     * It will initiate to find the current high score
     */
    public HighScore(){

        if(highScore==0){
            highScore = this.GetHighScoreLvl();
        }
    }

    /**
     * This method is to get the current high score in the high score file
     * @return the current high score
     */
    public int GetHighScoreLvl(){
        FileReader readFile;
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

    /**
     * This method is to check whether the player score beat the high score and set the score in the high score file
     * @param score is player's score
     */
    public void CheckScore(int score){
        String latest;
        File scoreFile;
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

    /**
     * This getter method is to get the high score
     * @return high score
     */
    public int getHighScore(){
        return highScore;
    }

}
