package main.java.scoring;

import javax.swing.*;

public class Time {
     static JLabel  timelabel = new JLabel();
     public static int elapsedTime=0;
     public int seconds =0;
     public int minutes=0;
     public int hour=0;




     String seconds_string = String.format("%02d",seconds);
     String minutes_string = String.format("%02d",minutes);
     String hour_string = String.format("%02d",hour);
     String time = hour_string+":"+minutes_string+":"+seconds_string;

    Timer timer = new Timer(1000, e -> {
        elapsedTime = elapsedTime+1000;
        hour = elapsedTime/36000000;
        minutes = (elapsedTime/60000)%60;
        seconds = (elapsedTime/1000)%60;
        String seconds_string = String.format("%02d",seconds);
        String minutes_string = String.format("%02d",minutes);
        String hour_string = String.format("%02d",hour);
        timelabel.setText(hour_string+":"+minutes_string+":"+seconds_string);
        time = hour_string+":"+minutes_string+":"+seconds_string;

    });

    public void start(){
        timer.start();
    }
    public void stop(){
        timer.stop();
    }

    public String check(int elapsedTime){
        Time.elapsedTime = elapsedTime;
        hour = elapsedTime/36000000;
        minutes = (elapsedTime/60000)%60;
        seconds = (elapsedTime/1000)%60;
        String seconds_string = String.format("%02d",seconds);
        String minutes_string = String.format("%02d",minutes);
        String hour_string = String.format("%02d",hour);
        time = hour_string+":"+minutes_string+":"+seconds_string;
        return time;
    }


    public void reset(){
        elapsedTime=0;
        seconds=0;
        minutes=0;
        hour=0;
    }


    public String timeInString(){
        return time;
    }

    public int elapsed(){
        return elapsedTime;
    }

}
