package main.java;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;
import javax.swing.*;






public class Audio {
    Clip clip;
    AudioInputStream audioStream;
    Scanner scanner = new Scanner(System.in);

    protected Object call() throws Exception {
        File file = new File("Brick_Destroy-master/src/main/resources/music/BGM.wav");
        audioStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        String response = scanner.next();
        return null;
    }

}
