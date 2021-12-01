package main.java;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

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
