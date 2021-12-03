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
package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.io.*;

import static main.java.HighScore.highScore;


public class GameBoard extends JComponent implements KeyListener,MouseListener,MouseMotionListener {

    private static final String CONTINUE = "Continue";
    private static final String RESTART = "Restart";
    private static final String EXIT = "Exit";
    private static final String PAUSE = "Pause Menu";
    private static String MUTE ="Mute BGM";
    private static final int TEXT_SIZE = 30;
    private static final Color MENU_COLOR = new Color(0,255,0);


    private static final int DEF_WIDTH = 600;
    private static final int DEF_HEIGHT = 450;

    private static final Color BG_COLOR = Color.WHITE;

    private Timer gameTimer;

    private final Wall wall;

    private String message;
    private String timing;
    private String seconds;

    private boolean showPauseMenu;

    private final Font menuFont;

    private Rectangle continueButtonRect;
    private Rectangle exitButtonRect;
    private Rectangle restartButtonRect;
    private Rectangle muteButton;
    private int strLen;

    private final DebugConsole debugConsole;

    static Time time = new Time();
    String stopWatch;


    Record record = new Record();
    static int level=-1;
    HighScore hs = new HighScore();
    int totalTime;

    Font style;

    static int audio=1;




    public GameBoard(JFrame owner){
        super();
        strLen = 0;

        showPauseMenu = false;
        menuFont = new Font("Monospaced",Font.PLAIN,TEXT_SIZE);
        style = new Font("Noto Mono",Font.BOLD,15);

        this.initialize();
        message = "";
        timing ="";
        seconds = "";
        wall = new Wall(new Rectangle(0,15,DEF_WIDTH,DEF_HEIGHT),30,3,(float)6/2,new Point(300,430));

        debugConsole = new DebugConsole(owner,wall,this);
        //initialize the first level
        wall.nextLevel();

        gameTimer = new Timer(10,e ->{
            wall.move();
            wall.findImpacts();
            message = String.format("Bricks: %d Balls %d"+ "   Best Time For All Level:%d",wall.getBrickCount(),wall.getBallCount(), hs.getHighScore());
            timing = String.format("%02d : %02d",time.getMinutes(),time.getSeconds());
            seconds = String.format("%02d",time.elapsed()/1000);
            if(wall.isBallLost()){
                if(wall.ballEnd()){
                    wall.wallReset();
                    time.reset();
                    message = "Game Over";
                }
                wall.ballReset();
                gameTimer.stop();
                time.stop();
            }
            else if(wall.isDone()){
                if(wall.hasLevel()){
                    time.stop();
                    stopWatch = time.timeInString();
                    try {
                        totalTime+=time.elapsed()/1000;
                        System.out.println(totalTime);
                        record.write("\n"+level+"   "+stopWatch);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    message = "Go to Next Level   Time Taken in Sec: "+(time.elapsed()/1000)+"  Best Time in Sec of All Level: "+highScore;
                    gameTimer.stop();
                    wall.ballReset();
                    wall.wallReset();
                    wall.nextLevel();
                }
                else{
                    time.stop();
                    try {
                        stopWatch = time.timeInString();
                        totalTime+=time.elapsed()/1000;
                        record.write("\n"+level+"   "+stopWatch);
                    }catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    time.stop();
                    hs.CheckScore(totalTime);

                    message = "ALL WALLS DESTROYED   Time Taken in Sec: "+totalTime+"     Best Time in Sec of All Level: : "+highScore;
                    gameTimer.stop();
                }
            }
            repaint();
        });

    }



    private void initialize(){
        this.setPreferredSize(new Dimension(DEF_WIDTH,550));
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }



    public void paint(Graphics g){

        Graphics2D g2d = (Graphics2D) g;

        clear(g2d);
        g2d.setFont(style);
        g2d.setColor(Color.BLUE);
        g2d.drawString(message,30,500);
        g2d.drawString(timing,30,480);
        g2d.drawString(seconds,550,480);
        g2d.drawLine(0,450,600,450);

        drawBall(wall.ball,g2d);

        for(Brick b : wall.bricks)
            if(!b.isBroken())
                drawBrick(b,g2d);

        drawPlayer(wall.player,g2d);

        if(showPauseMenu)
            drawMenu(g2d);

        Toolkit.getDefaultToolkit().sync();
    }

    private void clear(Graphics2D g2d){
        Color tmp = g2d.getColor();
        g2d.setColor(BG_COLOR);
        g2d.fillRect(0,0,getWidth(),getHeight());
        g2d.setColor(tmp);
    }

    private void drawBrick(Brick brick, Graphics2D g2d){
        Color tmp = g2d.getColor();

        g2d.setColor(brick.getInnerColor());
        g2d.fill(brick.getBrick());

        g2d.setColor(brick.getBorderColor());
        g2d.draw(brick.getBrick());


        g2d.setColor(tmp);
    }

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

    private void drawMenu(Graphics2D g2d){
        obscureGameBoard(g2d);
        drawPauseMenu(g2d);
    }

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

        switch(keyEvent.getKeyCode()){
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                wall.player.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                wall.player.movRight();
                break;
            case KeyEvent.VK_ESCAPE:
                showPauseMenu = !showPauseMenu;
                repaint();
                time.stop();
                gameTimer.stop();
                break;
            case KeyEvent.VK_SPACE:

                if(!showPauseMenu) {
                    if(gameTimer.isRunning()) {
                        time.stop();
                        gameTimer.stop();

                    }
                    else {

                        gameTimer.start();
                        time.start();
                    }
                }

                break;

            case KeyEvent.VK_F1:
                if(keyEvent.isAltDown() && keyEvent.isShiftDown())
                    debugConsole.setVisible(true);
            default:
                wall.player.stop();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        wall.player.stop();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if (!showPauseMenu)
            return;
        if (continueButtonRect.contains(p)) {
            showPauseMenu = false;
            repaint();
        } else if (restartButtonRect.contains(p)) {
            message = "Restarting Game...";
            time.reset();
            wall.ballReset();
            wall.wallReset();
            showPauseMenu = false;
            repaint();
        } else if (exitButtonRect.contains(p)) {
            System.exit(0);
        } else if (muteButton.contains(p)) {
            if (audio == 1) {
                try {
                    GraphicsMain.stopBGM();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MUTE = "Un-mute BGM";
                audio=0;

            }else if(audio==0) {
                GraphicsMain.startBGM();
                MUTE="Mute BGM";
                audio=1;
            }
            }

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

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(exitButtonRect != null && showPauseMenu) {
            if (exitButtonRect.contains(p) || continueButtonRect.contains(p) || restartButtonRect.contains(p) || muteButton.contains(p))
                this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            else
                this.setCursor(Cursor.getDefaultCursor());
        }
        else{
            this.setCursor(Cursor.getDefaultCursor());
        }
    }

    public void onLostFocus(){
        gameTimer.stop();
        time.stop();
        message = "Focus Lost";
        repaint();
    }

}
