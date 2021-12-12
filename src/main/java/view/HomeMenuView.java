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

import main.java.GameFrame;
import main.java.controller.HomeMenuController;
import main.java.model.HomeMenuModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;


public class HomeMenuView extends JComponent implements MouseListener, MouseMotionListener {




    Rectangle startButton;
    Rectangle exitButton ;
    Rectangle infoButton ;
    Rectangle scoreButton;

    public static boolean startClicked;
    private boolean menuClicked;
    private boolean settingClicked;
    private boolean scoreClicked;


    HomeMenuController controller;

    /**
     * This is the constructor of home menu view
     * @param owner is the frame created
     * @param area is the area of the window
     */
    public HomeMenuView(GameFrame owner, Dimension area){
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        controller = new HomeMenuController(owner,area);
        this.setPreferredSize(area);





    }

    /**
     * This is the override method in JComponent to paint all the drawing component
     * @param g the graphic component
     */
    public void paint(Graphics g){
        drawMenu((Graphics2D)g);
    }

    /**
     * This is the method to draw everything in the method
     * @param g2d is the graphic component
     */
    public void drawMenu(Graphics2D g2d){

        drawContainer(g2d);

        /*
        all the following method calls need a relative
        painting directly into the HomeMenu rectangle,
        so the translation is made here so the other methods do not do that.
         */
        Color prevColor = g2d.getColor();
        Font prevFont = g2d.getFont();

        double x = controller.getMenuFace().getX();
        double y = controller.getMenuFace().getY();

        g2d.translate(x,y);

        //methods calls
        drawText(g2d);
        drawButton(g2d);
        //end of methods calls

        g2d.translate(-x,-y);
        g2d.setFont(prevFont);
        g2d.setColor(prevColor);
    }

    /**
     * This method is to draw the container for the main menu
     * @param g2d is the graphics component
     */
    private void drawContainer(Graphics2D g2d){
        Color prev = g2d.getColor();



        g2d.drawImage(controller.getBackground(), 0, 0,null);


        g2d.setColor(prev);
    }

    /**
     * This method is to draw all the text in the home menu
     * @param g2d is the graphics component
     */
    private void drawText(Graphics2D g2d){

        g2d.setColor(controller.getTextColor());

        FontRenderContext frc = g2d.getFontRenderContext();

        Rectangle2D greetingsRect = controller.getGreetingsFont().getStringBounds(controller.getGreetings(),frc);
        Rectangle2D gameTitleRect = controller.getGameTitleFont().getStringBounds(controller.getGreetings(),frc);
        Rectangle2D creditsRect = controller.getCreditsFont().getStringBounds(controller.getCredits(),frc);

        int sX,sY;

        sX = (int)(controller.getMenuFace().getWidth() - greetingsRect.getWidth()) / 2;
        sY = (int)(controller.getMenuFace().getHeight() / 6);

        g2d.setFont(controller.getGreetingsFont());
        g2d.drawString(controller.getGreetings(),sX,sY);

        sX = (int)(controller.getMenuFace().getWidth() - gameTitleRect.getWidth()) / 2;
        sY += (int) gameTitleRect.getHeight() * 1.1;//add 10% of String height between the two strings

        g2d.setFont(controller.getGameTitleFont());
        g2d.drawString(controller.getGameTitle(),sX,sY);

        sX = (int)(controller.getMenuFace().getWidth() - creditsRect.getWidth()) / 2;
        sY += (int) creditsRect.getHeight() * 1.1;

        g2d.setFont(controller.getCreditsFont());
        g2d.drawString(controller.getCredits(),sX,sY);


    }

    /**
     * This method is to draw all the button on the home menu screen
     * @param g2d is the graphics component
     */
    private void drawButton(Graphics2D g2d){

        FontRenderContext frc = g2d.getFontRenderContext();
        Rectangle menuFace = controller.getMenuFace();
        Font buttonFont = controller.getButtonFont();

        Rectangle2D startRect = buttonFont.getStringBounds(controller.getStartText(),frc);
        Rectangle2D exitRect = buttonFont.getStringBounds(controller.getExitText(),frc);
        Rectangle2D infoRect = buttonFont.getStringBounds(controller.getInfoText(),frc);
        Rectangle2D scoreRect = buttonFont.getStringBounds(controller.getScoreText(),frc);

        startButton = controller.getStartButton();
        exitButton = controller.getExitButton();
        infoButton = controller.getInfoButton();
        scoreButton = controller.getScoreButton();

        g2d.setFont(buttonFont);
//this is the start button
        int x = (menuFace.width - startButton.width) / 2;
        int y =(int) ((menuFace.height - startButton.height) * 0.6);

        startButton.setLocation(x,y);

        x = (int)(startButton.getWidth() - startRect.getWidth()) / 2;
        y = (int)(startButton.getHeight() - startRect.getHeight()) / 2;

        x += startButton.x;
        y += startButton.y + (startButton.height * 0.9);



        if(startClicked){
            Color tmp = g2d.getColor();
            g2d.setColor(controller.getClickedButtonColor());
            g2d.draw(startButton);
            g2d.setColor(controller.getClickedText());
            g2d.drawString(controller.getStartText(),x,y);
            g2d.setColor(tmp);
        }
        else{
            g2d.draw(startButton);
            g2d.drawString(controller.getStartText(),x,y);
        }
//this is the info button
        x = startButton.x;
        y = startButton.y;

        y *= 1.2;

        infoButton.setLocation(x,y);




        x = (int)(infoButton.getWidth() - infoRect.getWidth()) / 2;
        y = (int)(infoButton.getHeight() - infoRect.getHeight()) / 2;

        x += infoButton.x;
        y += infoButton.y + (startButton.height * 0.9);

        if(settingClicked){
            Color tmp = g2d.getColor();

            g2d.setColor(controller.getClickedButtonColor());
            g2d.draw(infoButton);
            g2d.setColor(controller.getClickedText());
            g2d.drawString(controller.getInfoText(),x,y);
            g2d.setColor(tmp);
        }
        else{
            g2d.draw(infoButton);
            g2d.drawString(controller.getInfoText(),x,y);
        }
//this is the score button
        x = startButton.x;
        y= infoButton.y;

        y*=1.15;

        scoreButton.setLocation(x,y);

        x = (int)(scoreButton.getWidth() - scoreRect.getWidth()) /2;
        y = (int)(scoreButton.getHeight() - scoreRect.getHeight()) / 2;

        x += scoreButton.x;
        y += scoreButton.y + (startButton.height * 0.9);

        if(scoreClicked){
            Color tmp = g2d.getColor();

            g2d.setColor(controller.getClickedButtonColor());
            g2d.draw(scoreButton);
            g2d.setColor(controller.getClickedText());
            g2d.drawString(controller.getScoreText(),x,y);
            g2d.setColor(tmp);
        }
        else{
            g2d.draw(scoreButton);
            g2d.drawString(controller.getScoreText(),x,y);
        }
//this is the info button
        x = startButton.x;
        y = scoreButton.y;

        y *= 1.15;

        exitButton.setLocation(x,y);




        x = (int)(exitButton.getWidth() - exitRect.getWidth()) /2;
        y = (int)(exitButton.getHeight() - exitRect.getHeight()) / 2;

        x += exitButton.x;
        y += exitButton.y + (startButton.height * 0.9);

        if(menuClicked){
            Color tmp = g2d.getColor();

            g2d.setColor(controller.getClickedButtonColor());
            g2d.draw(exitButton);
            g2d.setColor(controller.getClickedText());
            g2d.drawString(controller.getExitText(),x,y);
            g2d.setColor(tmp);
        }
        else{
            g2d.draw(exitButton);
            g2d.drawString(controller.getExitText(),x,y);
        }




    }

    /**
     * This method is to track when the player click on the button on home menu
     * @param mouseEvent is the mouse cliked event
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(startButton.contains(p)){
            controller.enableStart();
        }
        else if(exitButton.contains(p)){
            controller.enableExit();
        }
        else if (infoButton.contains(p)){
            controller.enableInfo();
        }
        else if(scoreButton.contains(p)){
            ScoreBoardView board = new ScoreBoardView();
        }
    }

    /**
     * This method is to track the player pressed on the button
     * @param mouseEvent is the tracking of player mouse's action
     */
    @Override
    public void  mousePressed(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if (startButton.contains(p)) {
            startClicked = true;
            repaint(startButton.x, startButton.y, startButton.width + 1, startButton.height + 1);

        } else if (exitButton.contains(p)) {
            menuClicked = true;
            repaint(exitButton.x, exitButton.y, exitButton.width + 1, exitButton.height + 1);
        } else if (infoButton.contains(p)) {
            settingClicked = true;
            repaint(infoButton.x, infoButton.y, infoButton.width + 1, infoButton.height + 1);

        } else if (scoreButton.contains(p)) {
            scoreClicked = true;
            repaint(scoreButton.x, scoreButton.y, scoreButton.width + 1, scoreButton.height + 1);

        }
    }

    /**
     * This method is to track when the player release press or clicked on the button
     * @param mouseEvent is the action performed on th player's mouse
     */
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if(startClicked ){
            startClicked = false;
            repaint(startButton.x,startButton.y,startButton.width+1,startButton.height+1);
        }
        else if(menuClicked){
            menuClicked = false;
            repaint(exitButton.x,exitButton.y,exitButton.width+1,exitButton.height+1);
        }
        else if (settingClicked){
            settingClicked = false;
            repaint(infoButton.x,infoButton.y,infoButton.width+1,infoButton.height+1);

        }
        else if (scoreClicked) {
            scoreClicked = false;
            repaint(scoreButton.x, scoreButton.y, scoreButton.width + 1, scoreButton.height + 1);
        }
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
     * This method is to track when the user move on the button
     * @param mouseEvent is to track the action of the player mouse
     */
    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(startButton.contains(p) || exitButton.contains(p) || infoButton.contains(p) || scoreButton.contains(p))
            this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        else
            this.setCursor(Cursor.getDefaultCursor());

    }
}
