package main.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Time {
     static JLabel  timelabel = new JLabel();
     static int elapsedTime=0;
     int seconds =0;
     int minutes=0;
     int hour=0;




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

    public int getSeconds(){
        return seconds;
    }
    public int getMinutes(){
        return minutes;
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
