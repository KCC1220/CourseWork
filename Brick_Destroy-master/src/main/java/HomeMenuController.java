package main.java;


import javafx.fxml.FXML;

import javafx.scene.Scene;


public class HomeMenuController{
    private GameFrame owner;
    private static Scene scene;


    @FXML
    void start(){
        owner.enableSetting();
    }
    @FXML
    private void info(){
        owner.enableInfo();
    }
    @FXML
    private void exit(){
        System.out.println("Goodbye " + System.getProperty("user.name"));
        System.exit(0);
    }


}
