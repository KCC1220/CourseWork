package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class PlayerColour extends Application {
    static Color main = Color.MAGENTA;


    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Player Colour");
        Pane root = new Pane();
        Text func1 = new Text();
        func1.setText("Changing the colour of the player\n\n");
        func1.setFont(Font.font("Verdana",48));


        javafx.scene.control.Button blue = new javafx.scene.control.Button("BLUE");
        blue.setStyle("-fx-background-color:#0000FF");
        blue.setMaxSize(200,48);
        blue.setOnAction(event -> {
            setColor(Color.BLUE);
        });
        javafx.scene.control.Button yellow = new javafx.scene.control.Button("YELLOW");
        yellow.setStyle("-fx-background-color:#FFFF00");
        yellow.setMaxSize(200,48);
        yellow.setOnAction(event -> {
            setColor(Color.YELLOW);
        });
        javafx.scene.control.Button green = new javafx.scene.control.Button("GREEN (DEFAULT)");
        green.setStyle("-fx-background-color:#00FF00");
        green.setMaxSize(200,48);
        green.setOnAction(event->{
            setColor(Color.GREEN);
        });
        javafx.scene.control.Button cyan = new javafx.scene.control.Button("CYAN");
        green.setStyle("-fx-background-color:#00FFFF");
        green.setMaxSize(200,48);
        cyan.setOnAction(event -> {
            setColor(Color.CYAN);
        });
        javafx.scene.control.Button red = new javafx.scene.control.Button("RED");
        green.setStyle("-fx-background-color:#FF0000");
        green.setMaxSize(200,48);
        red.setOnAction(event->{
            setColor(Color.RED);
        });
        javafx.scene.control.Button magenta = new Button("MAGENTA");
        green.setStyle("-fx-background-color:#FF00FF");
        green.setMaxSize(200,48);
        magenta.setOnAction(event->{
            setColor(Color.MAGENTA);
        });
        VBox vbox = new VBox();
        vbox.getChildren().addAll(blue,yellow,green,cyan,red,magenta);


        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }

    public void setColor( Color Color){
        main = Color;

    }

}
