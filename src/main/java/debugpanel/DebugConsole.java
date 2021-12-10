/*
 *  Brick Destroy - A simple Arcade video game
 *   Copyright (C) 2017  Filippo Ranza
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package main.java.debugpanel;

import main.java.ball.Ball;
import main.java.level.Wall;
import main.java.view.ArcadeLevel;
import main.java.view.GameBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class DebugConsole extends JDialog implements WindowListener{

    private static final String TITLE = "Debug Console";


    private final JFrame owner;
    private final DebugPanel debugPanel;
    private GameBoard gameBoard;
    private ArcadeLevel arcadeLevel;
    private final Wall wall;
    private int type= 0;

    /**
     * This is the constructor of debug console.
     * This is to create the dialog window on the screen
     *
     * @param owner is the window that game board draw on
     * @param wall is the current wall object
     * @param gameBoard is the game board
     */
    public DebugConsole(JFrame owner, Wall wall, GameBoard gameBoard){

        this.wall = wall;
        this.owner = owner;
        this.gameBoard = gameBoard;
        initialize();

        debugPanel = new DebugPanel(wall);
        this.add(debugPanel,BorderLayout.CENTER);


        this.pack();
    }
    /**
     * This is the constructor of debug console.
     * This is to create the dialog window on the screen
     *
     * @param owner is the window that game board draw on
     * @param wall is the current wall object
     * @param arcadeLevel is the game board
     */
    public DebugConsole(JFrame owner, Wall wall, ArcadeLevel arcadeLevel){

        this.wall = wall;
        this.owner = owner;
        this.arcadeLevel = arcadeLevel;
        initialize();
        debugPanel = new DebugPanel(wall,"test");
        this.add(debugPanel,BorderLayout.CENTER);
        type=1;

        this.pack();
    }

    /**
     * This method is to set all the properties of dialog window
     */
    private void initialize(){
        this.setModal(true);
        this.setTitle(TITLE);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.addWindowListener(this);
        this.setFocusable(true);
    }

    /**
     * This method is to set the location of dialog window on the player screen
     */
    private void setLocation(){
        int x = ((owner.getWidth() - this.getWidth()) / 2) + owner.getX();
        int y = ((owner.getHeight() - this.getHeight()) / 2) + owner.getY();
        this.setLocation(x,y);
    }


    @Override
    public void windowOpened(WindowEvent windowEvent) {

    }

    /**
     * This method is the action when the window being closed
     * @param windowEvent is to track what is the status of the window
     */
    @Override
    public void windowClosing(WindowEvent windowEvent) {
        if(type==0){gameBoard.repaint();}
        else if(type==1){arcadeLevel.repaint();}
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    /**
     * This method is the action when ths window being activated
     * @param windowEvent is to track the window activity
     */
    @Override
    public void windowActivated(WindowEvent windowEvent) {
        setLocation();
        Ball b = Wall.ball;
        debugPanel.setValues(b.getSpeedX(),b.getSpeedY());
    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }
}
