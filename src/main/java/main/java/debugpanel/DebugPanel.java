package main.java.debugpanel;

import main.java.level.Wall;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;


public class DebugPanel extends JPanel {

    private static final Color DEF_BKG = Color.WHITE;


    private final JButton skipLevel;
    private final JButton resetBalls;

    private JSlider ballXSpeed;
    private JSlider ballYSpeed;

    /**
     * This is the constructor for debug panel.
     * This will create the button and slider on the debug panel
     * @param wall is the current wall object
     */
    public DebugPanel(Wall wall){

        initialize();

        skipLevel = makeButton("Skip Level",e -> wall.nextLevel());
        resetBalls = makeButton("Reset Balls",e -> wall.resetBallCount());

        ballXSpeed = makeSlider(-4,4,e -> wall.setBallXSpeed(ballXSpeed.getValue()));
        ballYSpeed = makeSlider(-4,4,e -> wall.setBallYSpeed(ballYSpeed.getValue()));

        this.add(skipLevel);
        this.add(resetBalls);

        this.add(ballXSpeed);
        this.add(ballYSpeed);

    }
    /**
     * This is the constructor for debug panel.
     * This will create the button and slider on the debug panel
     * @param wall is the current wall object
     * @param arcade is only for differentiation purpose.
     */
    public DebugPanel(Wall wall,String arcade){

        initialize();

        skipLevel = makeButton("Skip Level",e -> wall.nextArcadeLevel());
        resetBalls = makeButton("Reset Balls",e -> wall.resetBallCount());

        ballXSpeed = makeSlider(-4,4,e -> wall.setBallXSpeed(ballXSpeed.getValue()));
        ballYSpeed = makeSlider(-4,4,e -> wall.setBallYSpeed(ballYSpeed.getValue()));

        this.add(skipLevel);
        this.add(resetBalls);

        this.add(ballXSpeed);
        this.add(ballYSpeed);

    }

    /**
     * This is to set all the location of the button and slide in the window
     */
    private void initialize(){
        this.setBackground(DEF_BKG);
        this.setLayout(new GridLayout(2,2));
    }

    /**
     * This method is to make button on the debug panel
     * @param title the button name
     * @param e is to track whether player clicked on it
     * @return is the button created with action listener
     */
    private JButton makeButton(String title, ActionListener e){
        JButton out = new JButton(title);
        out.addActionListener(e);
        return  out;
    }

    /**
     * This method is to make the slide on the debug panel
     * @param min is minimum of the slider
     * @param max is maximum of the slider
     * @param e is the check the interaction of player with the slider
     * @return slider
     */
    private JSlider makeSlider(int min, int max, ChangeListener e){
        JSlider out = new JSlider(min,max);
        out.setMajorTickSpacing(1);
        out.setSnapToTicks(true);
        out.setPaintTicks(true);
        out.addChangeListener(e);
        return out;
    }

    /**
     * This method is to set the changed speed on X axis and Y axis
     * @param x is the changed X axis speed from the slider
     * @param y is the changed Y axis speed from the slider
     */
    public void setValues(int x,int y){
        ballXSpeed.setValue(x);
        ballYSpeed.setValue(y);
    }

}