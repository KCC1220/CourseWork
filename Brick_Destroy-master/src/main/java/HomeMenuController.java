package main.java;




import javafx.scene.Scene;


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
    public void setCursor(){

    }



}