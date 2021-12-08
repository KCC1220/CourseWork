package main.java.controller;




import javafx.scene.Scene;
import main.java.GameFrame;


public class HomeMenuController{
    private GameFrame owner;
    private static Scene scene;
    public HomeMenuController(GameFrame owner){
        this.owner = owner;
    }

    public void enableStart(){
        owner.enableColour();
    }

    public void enableInfo(){
        owner.enableInfo();
    }
    public void enableExit(){
        System.out.println("Goodbye " + System.getProperty("user.name"));
        System.exit(0);
    }



}
