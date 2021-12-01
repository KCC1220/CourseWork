package main.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class timer {
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

    void start(){
        timer.start();
    }
    void stop(){
        timer.stop();
    }

    void reset(){
        elapsedTime=0;
        seconds=0;
        minutes=0;
        hour=0;
    }


    String timeInString(){
        return time;
    }

    int elapsed(){
        return elapsedTime;
    }

}
