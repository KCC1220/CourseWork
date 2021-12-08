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
package main.java.view;

import main.java.*;
import main.java.ball.Ball;
import main.java.bricks.Brick;
import main.java.controller.ArcadeLevelController;
import main.java.debugpanel.DebugConsole;
import main.java.level.Wall;
import main.java.model.ColourModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;


public class ArcadeLevel extends JComponent implements KeyListener,MouseListener,MouseMotionListener {

    private static final String CONTINUE = "Continue";
    private static final String RESTART = "Restart";
    private static final String EXIT = "Exit";
    private static final String PAUSE = "Pause Menu";
    public static String MUTE ="Mute BGM";
    private static final int TEXT_SIZE = 30;
    private static final Color MENU_COLOR = new Color(0,255,0);


    private static final int DEF_WIDTH = 600;
    private static final int DEF_HEIGHT = 550;

    private static final Color BG_COLOR = Color.WHITE;

    public static Timer gameTimer;

    private final Wall wall;

    public static  String message;
    private String timing;
    private String seconds;



    private final Font menuFont;

    public static Rectangle continueButtonRect;
    public static Rectangle exitButtonRect;
    public static Rectangle restartButtonRect;
    public static Rectangle muteButton;
    private int strLen;


    Font style;



    ArcadeLevelController controller = new ArcadeLevelController();

    /**
     * This is the constructor of this Arcade Level class.
     * This constructor will initiate the game session
     *
     * @param owner is to prepare the window for paint method to paint on it
     */
    public ArcadeLevel(JFrame owner){

        super();
        strLen = 0;
        menuFont = controller.getMenuFont();
        style = controller.getStyleFont();

        controller.initialize(this);
        message = "";
        timing ="";
        seconds = "";
        wall = controller.getWall();
        DebugConsole debugConsole = controller.setDebugConsole(owner, wall, this);
        //initialize the first level
        wall.nextArcadeLevel();

        gameTimer = new Timer(10,e ->{
            controller.move();
            controller.findImpacts();
            message = String.format("Bricks: %d Balls %d",controller.getBrickCount(),controller.getBallCount());
            timing = String.format("%02d : %02d",controller.getMinutes(),controller.getSeconds());
            seconds = String.format("%02d",controller.getElapsedTime()/1000);
            controller.check(this);
        });

    }

    /**
     * This is a method that was overwritten in JComponent.
     *
     * It will be called automatically, and it is meant to paint everything into the screen.
     * @param g is the graphics component in JComponent.
     */
    public void paint(Graphics g){

        Graphics2D g2d = (Graphics2D) g;

        clear(g2d);
        g2d.setFont(style);
        g2d.setColor(Color.BLUE);
        g2d.drawString(message,30,500);
        g2d.drawString(timing,30,480);
        g2d.drawString(seconds,550,480);
        g2d.drawLine(0,450,600,450);

        drawBall(Wall.ball,g2d);

        for(Brick b : wall.bricks)
            if(!b.isBroken())
                drawBrick(b,g2d);

        drawPlayer(Wall.player,g2d);

        if(controller.pauseMenu())
            drawMenu(g2d);

        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * This method is to clear everything that is currently painted in the window.
     *
     *
     * @param g2d is the graphics component of JComponents meant for us to draw on the screen.
     */
    private void clear(Graphics2D g2d){
        Color tmp = g2d.getColor();
        g2d.setColor(BG_COLOR);
        g2d.fillRect(0,0,getWidth(),getHeight());
        g2d.setColor(tmp);
    }

    /**
     *This method is to draw bricks in the window.
     *
     *
     * @param brick is the type of Brick Class, and it tells what is the type of brick to be drawn on the screen.
     * @param g2d is the same as previous.
     */
    private void drawBrick(Brick brick, Graphics2D g2d){
        Color tmp = g2d.getColor();

        g2d.setColor(brick.getInnerColor());
        g2d.fill(brick.getBrick());

        g2d.setColor(brick.getBorderColor());
        g2d.draw(brick.getBrick());


        g2d.setColor(tmp);
    }

    /**
     * This method is to draw the ball on the screen.
     *
     * @param ball is to tell what kind of ball to be drawn on the screen.
     * @param g2d is the same as previous.
     */
    private void drawBall(Ball ball, Graphics2D g2d){
        Color tmp = g2d.getColor();
        ColourModel model = new ColourModel();

        Shape s = ball.getBallFace();

        g2d.setColor(model.getBallColour());
        g2d.fill(s);

        g2d.setColor(model.getBallColour().darker().darker());
        g2d.draw(s);

        g2d.setColor(tmp);
    }

    /**
     * This method is to draw the player rectangle on the screen.
     *
     * @param p get the type of player that need to be drawn on the screen.
     * @param g2d is the same as previous.
     */

    private void drawPlayer(Player p, Graphics2D g2d){
        Color tmp = g2d.getColor();
        ColourModel model = new ColourModel();

        Shape s = p.getPlayerFace();
        g2d.setColor(model.getPlayerColour());
        g2d.fill(s);

        g2d.setColor(model.getPlayerColour().darker().darker());
        g2d.draw(s);

        g2d.setColor(tmp);
    }

    /**
     * This method is to draw pause menu on the screen.
     *
     * @param g2d is the sae as previous.
     */
    private void drawMenu(Graphics2D g2d){
        obscureGameBoard(g2d);
        drawPauseMenu(g2d);
    }

    /**
     * This method is to make the window obscure.
     *
     * @param g2d is the same as previous.
     */
    private void obscureGameBoard(Graphics2D g2d){

        Composite tmp = g2d.getComposite();
        Color tmpColor = g2d.getColor();

        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.55f);
        g2d.setComposite(ac);

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0,DEF_WIDTH,DEF_HEIGHT);

        g2d.setComposite(tmp);
        g2d.setColor(tmpColor);
    }

    /**
     * This method is to draw the Pause Menu on the obscure window.
     *
     * @param g2d is the same as previous
     */
    private void drawPauseMenu(Graphics2D g2d){
        Font tmpFont = g2d.getFont();
        Color tmpColor = g2d.getColor();

        g2d.setFont(menuFont);
        g2d.setColor(MENU_COLOR);

        if(strLen == 0){
            FontRenderContext frc = g2d.getFontRenderContext();
            strLen = menuFont.getStringBounds(PAUSE,frc).getBounds().width;
        }

        int x = (this.getWidth() - strLen) / 2;
        int y = this.getHeight() / 10;


        g2d.drawString(PAUSE,x,y);

        x = this.getWidth() / 8;
        y = this.getHeight() / 4;


        if(continueButtonRect == null){
            FontRenderContext frc = g2d.getFontRenderContext();
            continueButtonRect = menuFont.getStringBounds(CONTINUE,frc).getBounds();
            continueButtonRect.setLocation(x,y-continueButtonRect.height);
        }

        g2d.drawString(CONTINUE,x,y);

        y *= 2;

        if(restartButtonRect == null){
            restartButtonRect = (Rectangle) continueButtonRect.clone();
            restartButtonRect.setLocation(x,y-restartButtonRect.height);
        }

        g2d.drawString(RESTART,x,y);

        y *= 1.5;

        if(exitButtonRect == null){
            exitButtonRect = (Rectangle) continueButtonRect.clone();
            exitButtonRect.setLocation(x,y-exitButtonRect.height);
        }

        g2d.drawString(EXIT,x,y);

        y*=1.3;

        if(muteButton == null){
            muteButton = (Rectangle) continueButtonRect.clone();
            muteButton.setLocation(x,y-muteButton.height);
        }

        g2d.drawString(MUTE,x,y);


        g2d.setFont(tmpFont);
        g2d.setColor(tmpColor);
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        controller.keyPressed(keyEvent,this);

    }

    /**
     * This method is to track whether ths player is on focus or not.
     *
     * @param keyEvent is the key pressed by player.
     */
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        Wall.player.stop();
    }

    /**
     * This method is to track what the user had clicked in the pause menu.
     *
     * @param mouseEvent is the player click event.
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        controller.mouseClicked(mouseEvent,this);


    }


    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    /**
     * This method is to track when the player cursor go pass a button or stay on a button without clicking.
     *
     * @param mouseEvent is to track the player mouse movement.
     */
    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        controller.mouseMoved(mouseEvent,this);

    }

    /**
     * This method is to stop the game when the player is on another window.
     */
    public void onLostFocus(){
        gameTimer.stop();
        controller.stopTime();
        message = "Focus Lost";
        repaint();
    }





}
