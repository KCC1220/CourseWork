package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//public class PlayerColour extends Application {
//    static Color main = Color.MAGENTA;
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("Player Colour");
//        Pane root = new Pane();
//        Text func1 = new Text();
//        func1.setText("Changing the colour of the player\n\n");
//        func1.setFont(Font.font("Verdana",48));
//
//
//        javafx.scene.control.Button blue = new javafx.scene.control.Button("BLUE");
//        blue.setStyle("-fx-background-color:#0000FF");
//        blue.setMaxSize(200,48);
//        blue.setOnAction(event -> {
//            setColor(Color.BLUE);
//        });
//        javafx.scene.control.Button yellow = new javafx.scene.control.Button("YELLOW");
//        yellow.setStyle("-fx-background-color:#FFFF00");
//        yellow.setMaxSize(200,48);
//        yellow.setOnAction(event -> {
//            setColor(Color.YELLOW);
//        });
//        javafx.scene.control.Button green = new javafx.scene.control.Button("GREEN (DEFAULT)");
//        green.setStyle("-fx-background-color:#00FF00");
//        green.setMaxSize(200,48);
//        green.setOnAction(event->{
//            setColor(Color.GREEN);
//        });
//        javafx.scene.control.Button cyan = new javafx.scene.control.Button("CYAN");
//        green.setStyle("-fx-background-color:#00FFFF");
//        green.setMaxSize(200,48);
//        cyan.setOnAction(event -> {
//            setColor(Color.CYAN);
//        });
//        javafx.scene.control.Button red = new javafx.scene.control.Button("RED");
//        green.setStyle("-fx-background-color:#FF0000");
//        green.setMaxSize(200,48);
//        red.setOnAction(event->{
//            setColor(Color.RED);
//        });
//        javafx.scene.control.Button magenta = new Button("MAGENTA");
//        green.setStyle("-fx-background-color:#FF00FF");
//        green.setMaxSize(200,48);
//        magenta.setOnAction(event->{
//            setColor(Color.MAGENTA);
//        });
//        VBox vbox = new VBox();
//        vbox.getChildren().addAll(blue,yellow,green,cyan,red,magenta);
//
//
//        primaryStage.setScene(new Scene(root, 400, 400));
//        primaryStage.show();
//    }
//
//    public void setColor( Color Color){
//        main = Color;
//
//    }
//
//
//}
public class PlayerColour extends JComponent implements ActionListener{
    public static Color colour;



    private static final String C_Red = "Red";
    private static final String C_Yellow = "Yellow";
    private static final String C_Green = "Green";
    private static final String C_Cyan = "Cyan";
    private static final String C_Blue = "Blue";
    private static final String C_Magenta = "Magenta";
    private static final String C_Pink = "Pink";
    HomeMenu homeMenu;
    GameFrame gameframe;


    private static final int DEF_WIDTH = 450;
    private static final int DEF_HEIGHT = 300;

    private static final Color BG_COLOR = Color.WHITE;


    JButton red = new JButton(C_Red);
    JButton yellow = new JButton(C_Yellow);
    JButton green = new JButton(C_Green);
    JButton cyan = new JButton(C_Cyan);
    JButton blue = new JButton(C_Blue);
    JButton magenta = new JButton(C_Magenta);
    JButton pink = new JButton(C_Pink);
    JFrame frame;
    JButton start = new JButton("Start");



    public PlayerColour(){
            frame = new JFrame();
            JPanel panel = new JPanel();
            this.setPreferredSize(new Dimension(DEF_WIDTH,DEF_HEIGHT));

            red.setBounds(50,16,2,4);
            red.setBackground(Color.red);
            red.setFocusable(false);
            red.addActionListener(this);
            JLabel label = new JLabel("Choosing the colour of player\n");
            yellow.setBounds(50,16,2,4);
            yellow.setBackground(Color.yellow);
            yellow.setFocusable(false);
            yellow.addActionListener(this);
            green.setBounds(50,16,2,4);
            green.setBackground(Color.green);
            green.setFocusable(false);
            green.addActionListener(this);
            cyan.setBounds(50,16,2,4);
            cyan.setBackground(Color.cyan);
            cyan.setFocusable(false);
            cyan.addActionListener(this);
            blue.setBounds(50,16,2,4);
            blue.setBackground(Color.blue);
            blue.setFocusable(false);
            blue.addActionListener(this);
            magenta.setBounds(50,16,2,4);
            magenta.setBackground(Color.magenta);
            magenta.setFocusable(false);
            magenta.addActionListener(this);
            pink.setBounds(50,16,2,4);
            pink.setBackground(Color.pink);
            pink.setFocusable(false);
            pink.addActionListener(this);
            start.setBounds(50,16,2,4);
            start.setFocusable(false);
            start.addActionListener(this);
            panel.add(label);
            panel.add(red);
            panel.add(yellow);
            panel.add(green);
            panel.add(cyan);
            panel.add(blue);
            panel.add(magenta);
            panel.add(pink);
            panel.add(start);

            frame.add(panel,BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setTitle("Choosing Colour");
            frame.setSize(DEF_WIDTH,DEF_HEIGHT);
            autoLocate(frame);

            frame.setVisible(true);
            System.out.println(colour);



    }
    public static Color colouring(){
        return colour;
    }

    private void autoLocate(JFrame frame){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (size.width - frame.getWidth()) / 2;
        int y = (size.height - frame.getHeight()) / 2;
        frame.setLocation(x,y);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == start)
        {
            frame.dispose();
            gameframe = new GameFrame();
            gameframe.enableGameBoard();

        }
        if (e.getSource() == yellow){
            colour = Color.yellow;

        }
        if (e.getSource() == blue){
            colour = Color.blue;

        }
        if (e.getSource() == green){
            colour = Color.green;

        }
        if (e.getSource() == cyan){
            colour = Color.cyan;

        }
        if (e.getSource() == red){
            colour = Color.red;

        }
        if (e.getSource() == magenta){
            colour = Color.magenta;

        }
        if (e.getSource() == pink){
            colour = Color.pink;

        }
    }


}