package main.java;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import javax.sound.sampled.*;
import javax.swing.*;






public class Audio extends Thread{
    static Clip clip;
    AudioInputStream audioStream;
    Boolean status;

    @Override
    public void run() {
        File file = new File("Brick_Destroy-master/src/main/resources/music/BGM.wav");

            try {
                audioStream = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(audioStream);
            } catch (Exception e) {
                e.printStackTrace();
            }

            clip.start();
            clip.loop(clip.LOOP_CONTINUOUSLY);


    }






}
