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

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class HomeMenuView extends JComponent implements MouseListener, MouseMotionListener {

//    private static final String GREETINGS = "Welcome to:";
//    private static final String GAME_TITLE = "Brick Destroy";
//    private static final String CREDITS = "Version 0.1";
//    private static final String START_TEXT = "Start";
//    private static final String MENU_TEXT = "Exit";
//    private static final String SETTING_TEXT = "Info";
//
//    private static final Color BG_COLOR = Color.GREEN.darker();
//    private static final Color TEXT_COLOR = new Color(255, 255, 255);//pure white
//private static final Color CLICKED_BUTTON_COLOR = Color.GREEN.darker().brighter();
//    private static final Color CLICKED_TEXT = Color.WHITE;
//
//
//
////    private final Rectangle menuFace;
////    private final Rectangle startButton;
////    private final Rectangle menuButton;
////    private final Rectangle settingButton;


    Rectangle startButton;
    Rectangle exitButton ;
    Rectangle infoButton ;

    private final GameFrame owner;

    private boolean startClicked;
    private boolean menuClicked;
    private boolean settingClicked;

    HomeMenuModel model;
    HomeMenuController controller;


    public HomeMenuView(GameFrame owner, Dimension area){
        this.setFocusable(true);
        this.requestFocusInWindow();

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.owner = owner;
        model = new HomeMenuModel(area);
        controller = new HomeMenuController(this.owner);
        this.setPreferredSize(area);





    }


    public void paint(Graphics g){
        drawMenu((Graphics2D)g);
    }


    public void drawMenu(Graphics2D g2d){

        drawContainer(g2d);

        /*
        all the following method calls need a relative
        painting directly into the HomeMenu rectangle,
        so the translation is made here so the other methods do not do that.
         */
        Color prevColor = g2d.getColor();
        Font prevFont = g2d.getFont();

        double x = model.getMenuFace().getX();
        double y = model.getMenuFace().getY();

        g2d.translate(x,y);

        //methods calls
        drawText(g2d);
        drawButton(g2d);
        //end of methods calls

        g2d.translate(-x,-y);
        g2d.setFont(prevFont);
        g2d.setColor(prevColor);
    }

    private void drawContainer(Graphics2D g2d){
        Color prev = g2d.getColor();



        g2d.drawImage(model.getBackground(), 0, 0,null);


        g2d.setColor(prev);
    }

    private void drawText(Graphics2D g2d){

        g2d.setColor(model.getTextColor());

        FontRenderContext frc = g2d.getFontRenderContext();

        Rectangle2D greetingsRect = model.getGreetingsFont().getStringBounds(model.getGreetings(),frc);
        Rectangle2D gameTitleRect = model.getGameTitleFont().getStringBounds(model.getGreetings(),frc);
        Rectangle2D creditsRect = model.getCreditsFont().getStringBounds(model.getCredits(),frc);

        int sX,sY;

        sX = (int)(model.getMenuFace().getWidth() - greetingsRect.getWidth()) / 2;
        sY = (int)(model.getMenuFace().getHeight() / 6);

        g2d.setFont(model.getGreetingsFont());
        g2d.drawString(model.getGreetings(),sX,sY);

        sX = (int)(model.getMenuFace().getWidth() - gameTitleRect.getWidth()) / 2;
        sY += (int) gameTitleRect.getHeight() * 1.1;//add 10% of String height between the two strings

        g2d.setFont(model.getGameTitleFont());
        g2d.drawString(model.getGameTitle(),sX,sY);

        sX = (int)(model.getMenuFace().getWidth() - creditsRect.getWidth()) / 2;
        sY += (int) creditsRect.getHeight() * 1.1;

        g2d.setFont(model.getCreditsFont());
        g2d.drawString(model.getCredits(),sX,sY);


    }

    private void drawButton(Graphics2D g2d){

        FontRenderContext frc = g2d.getFontRenderContext();
        Rectangle menuFace = model.getMenuFace();
        Font buttonFont = model.getButtonFont();

        Rectangle2D startRect = buttonFont.getStringBounds(model.getStartText(),frc);
        Rectangle2D exitRect = buttonFont.getStringBounds(model.getMenuText(),frc);
        Rectangle2D settingRect = buttonFont.getStringBounds(model.getSettingText(),frc);

        startButton = model.getStartButton();
        exitButton = model.getExitButton();
        infoButton = model.getInfoButton();

        g2d.setFont(buttonFont);
//this is the start button
        int x = (menuFace.width - startButton.width) / 2;
        int y =(int) ((menuFace.height - startButton.height) * 0.6);

        startButton.setLocation(x,y);

        x = (int)(startButton.getWidth() - startRect.getWidth()) / 2;
        y = (int)(startButton.getHeight() - startRect.getHeight()) / 2;

        x += startButton.x;
        y += startButton.y + (startButton.height * 0.9);



        //move to controller
        if(startClicked){
            Color tmp = g2d.getColor();
            g2d.setColor(model.getClickedButtonColor());
            g2d.draw(startButton);
            g2d.setColor(model.getClickedText());
            g2d.drawString(model.getStartText(),x,y);
            g2d.setColor(tmp);
        }
        else{
            g2d.draw(startButton);
            g2d.drawString(model.getStartText(),x,y);
        }
//this is te exit button
        x = startButton.x;
        y = startButton.y;

        y *= 1.2;

        exitButton.setLocation(x,y);




        x = (int)(exitButton.getWidth() - exitRect.getWidth()) / 2;
        y = (int)(exitButton.getHeight() - exitRect.getHeight()) / 2;

        x += exitButton.x;
        y += exitButton.y + (startButton.height * 0.9);

        if(menuClicked){
            Color tmp = g2d.getColor();

            g2d.setColor(model.getClickedButtonColor());
            g2d.draw(exitButton);
            g2d.setColor(model.getClickedText());
            g2d.drawString(model.getMenuText(),x,y);
            g2d.setColor(tmp);
        }
        else{
            g2d.draw(exitButton);
            g2d.drawString(model.getMenuText(),x,y);
        }
//this is the info button
        x = startButton.x;
        y = exitButton.y;

        y *= 1.2;

        infoButton.setLocation(x,y);




        x = (int)(infoButton.getWidth() - settingRect.getWidth()) /2;
        y = (int)(infoButton.getHeight() - settingRect.getHeight()) / 2;

        x += infoButton.x;
        y += infoButton.y + (startButton.height * 0.9);

        if(settingClicked){
            Color tmp = g2d.getColor();

            g2d.setColor(model.getClickedButtonColor());
            g2d.draw(infoButton);
            g2d.setColor(model.getClickedText());
            g2d.drawString(model.getSettingText(),x,y);
            g2d.setColor(tmp);
        }
        else{
            g2d.draw(infoButton);
            g2d.drawString(model.getSettingText(),x,y);
        }




    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(startButton.contains(p)){
            controller.enableStart();
        }
        else if(exitButton.contains(p)){
            System.out.println("Goodbye " + System.getProperty("user.name"));
            System.exit(0);
        }
        else if (infoButton.contains(p)){
            controller.enableInfo();
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(startButton.contains(p)){
            startClicked = true;
            repaint(startButton.x,startButton.y,startButton.width+1,startButton.height+1);

        }
        else if(exitButton.contains(p)){
            menuClicked = true;
            repaint(exitButton.x,exitButton.y,exitButton.width+1,exitButton.height+1);
        }
        else if (infoButton.contains(p)){
            settingClicked = true;
            repaint(infoButton.x,infoButton.y,infoButton.width+1,infoButton.height+1);

        }
    }

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
        if(startButton.contains(p) || exitButton.contains(p) || infoButton.contains(p))
            this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        else
            this.setCursor(Cursor.getDefaultCursor());

    }
}