package main.java.model;

import javax.swing.*;

public class ControlsModel {
    String introduction1 = "This game named as Brick Master. ";
    String introduction2 = "This game is a 2D arcade game which basically it help to train a player's reflexes. ";
    String instruction1 = "To start the game, you can press the 'START' button in the main menu. ";
    String instruction2 ="After you press the main menu, you are free to choose some of the colours that shows on the screen.";
    String instruction3 ="You can choose the colours for PLAYER and BALL. ";
    String instruction4 ="After the desired colour being chosen, you can press the start button to load the game. ";
    String instruction5 = "After the game being loaded, you can press SPACE BAR to start the game. ESC to enter the pause menu.";
    String control="To control the player, you can use A/LEFT ARROW for moving to left while D/RIGHT ARROW for moving to the right. You will have three chances to missed the ball.  ";
    String mechanism1="There are 3 different type of brick which have different type of method to break it. The mission of te game is to break all the brick in the game.";
    String mechanism2 = "Therefore you will proceed to the next level until level 4. When you are in a game you can also use F1 + ALT + SHIFT to open the debug panel. You can set X and Y speed in there.";
    public JLabel display1 = new JLabel(introduction1);
    public JLabel display2 = new JLabel(introduction2);
    public JLabel display3 = new JLabel(instruction1);
    public JLabel display4 = new JLabel(instruction2);
    public JLabel display5 = new JLabel(instruction3);
    public JLabel display6 = new JLabel(instruction4);
    public JLabel display7 = new JLabel(instruction5);
    public JLabel display8 = new JLabel(control);
    public JLabel display9  = new JLabel(mechanism1);
    public JLabel display10  = new JLabel(mechanism2);
    public JButton back = new JButton("back");

}