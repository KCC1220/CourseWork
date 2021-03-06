package main.java;

import java.io.File;

import javax.sound.sampled.*;







public class Audio extends Thread{
    static Clip clip;
    AudioInputStream audioStream;

    /**
     * This is the override method to thread.
     * It will start the thread and play the BGM
     */
    @Override
    public void run() {
        File file = new File("src/main/resources/music/BGM.wav");

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