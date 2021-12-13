package main.java;



import java.awt.*;



public class GraphicsMain{

    static Audio thread1 = new Audio();

    /**
     * This is the main to run the whole game
     */
    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(() -> new GameFrame().initialize());
        startBGM();

    }

    /**
     * This method is to start the BGM
     */
    public static void startBGM(){
        thread1.start();
    }

    /**
     * This method is to stop the BGM
     */
    public static void stopBGM() throws InterruptedException {
        Audio.clip.stop();
    }
    /**
     * This method is to resume the BGM
     */
    public static void resumeBGM(){
        Audio.clip.start();
    }




}