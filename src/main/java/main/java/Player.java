package main.java;

import main.java.ball.Ball;

import java.awt.*;


public class Player {





    private static final int DEF_MOVE_AMOUNT = 5;

    private final Rectangle playerFace;
    private final Point ballPoint;
    public static int moveAmount;
    private final int min;
    private final int max;

    /**
     * This is the player constructor
     * It will create the object of player
     *
     * @param ballPoint is the X and Y point of the ball
     * @param width is the width of the player
     * @param height os the height of the player
     * @param container os the rectangle of the player
     */
    public Player(Point ballPoint,int width,int height,Rectangle container) {
        this.ballPoint = ballPoint;
        moveAmount = 0;
        playerFace = makeRectangle(width, height);
        min = container.x + (width / 2);
        max = min + container.width - width;

    }

    /**
     *This method is to make the player's rectangle out
     * @param width is the width of the player
     * @param height is the height of the player
     * @return is the player's rectangle
     */
    private Rectangle makeRectangle(int width,int height){
        Point p = new Point((int)(ballPoint.getX() - (width / 2)),(int)ballPoint.getY());
        return  new Rectangle(p,new Dimension(width,height));
    }

    /**
     * This is to check the player impact with ball or not
     * @param b is the ball
     * @return true or false the player have impact with ball
     */
    public boolean impact(Ball b){
        return playerFace.contains(b.getPosition()) && playerFace.contains(b.down) ;
    }

    /**
     * This is to move the player
     */
    public void move(){
        double x = ballPoint.getX() + moveAmount;
        if(x < min || x > max)
            return;
        ballPoint.setLocation(x,ballPoint.getY());
        playerFace.setLocation(ballPoint.x - (int)playerFace.getWidth()/2,ballPoint.y);
    }

    /**
     * This is the player to move left
     */
    public void moveLeft(){
        moveAmount = -DEF_MOVE_AMOUNT;
    }

    /**
     * This is the player to move right
     */
    public void moveRight(){
        moveAmount = DEF_MOVE_AMOUNT;
    }

    /**
     * This is the player to stop
     */
    public void stop(){
        moveAmount = 0;
    }

    /**
     * This method is to get the player rectangle
     */
    public Shape getPlayerFace(){
        return  playerFace;
    }

    /**
     * This is to move the player to a certain point
     * @param p is the X and Y of the point
     */
    public void moveTo(Point p){
        ballPoint.setLocation(p);
        playerFace.setLocation(ballPoint.x - (int)playerFace.getWidth()/2,ballPoint.y);
    }
}