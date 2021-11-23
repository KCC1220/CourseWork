package main.java;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class info extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Instruction of the Game");
        Text func1 = new Text();
        func1.setText("Instruction\n\n");
        func1.setFont(Font.font("Verdana",48));
        String instruct=("This is the instruction of the game.\n" +
                "This game named as Brick Master. This game is a 2D arcade game which basically it help to train a player's reflexes\n" +
                "To start the game, you can press the 'START' button in the main menu\n" +
                "After you press the main menu, you are free to choose some of the colours that shows on the screen.\n" +
                "You can choose the colours for PLAYER and BALL\n" +
                "After the desired colour being chosen, you can press the start button to load the game\n" +
                "After the game being loaded, you can press SPACEBAR to start the game\n" +
                "To control the player, you can use A for moving to left while D for moving to the right or LEFT ARROW for moving to the left while RIGHT ARROW for moving to the right\n" +
                "The mission of te game is to break all the brick in the game. Therefore you will proceed to the next level\n" +
                "You will have three chances to missed the ball");
        Label display = new Label(instruct);
        GridPane root = new GridPane();
        root.add(display,0,0,1,1);
        root.setAlignment(Pos.CENTER);



    }
}
