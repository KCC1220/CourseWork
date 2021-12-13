package main.java.ball;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

abstract public class Ball {

    private Shape ballFace;

    private final Point2D center;

    public Point2D up;
    public Point2D down;
    public Point2D left;
    public Point2D right;



    public static int speedX;
    public static int speedY;


    /**
     * This constructor is to create ball object.
     *
     * @param center is the position to set the ball.
     * @param radiusA is the horizontal radius of the ball.
     * @param radiusB is the vertical radius of the ball.
     */
    public Ball(Point2D center,int radiusA,int radiusB){
        this.center = center;

        up = new Point2D.Double();
        down = new Point2D.Double();
        left = new Point2D.Double();
        right = new Point2D.Double();

        up.setLocation(center.getX(),center.getY()-((float)radiusB / 2));
        down.setLocation(center.getX(),center.getY()+((float)radiusB / 2));

        left.setLocation(center.getX()-((float)radiusA /2),center.getY());
        right.setLocation(center.getX()+((float)radiusA /2),center.getY());


        ballFace = makeBall(center,radiusA,radiusB);
        speedX = 0;
        speedY = 0;
    }

    /**
     * This method is to create the ball shape.
     *
     * @param center is to position to create the ball.
     * @param radiusA is the horizontal radius of the ball.
     * @param radiusB is the vertical radius of the ball.
     * @return is to return the shape of the ball
     */
    protected abstract Shape makeBall(Point2D center,int radiusA,int radiusB);

    /**
     * This method  is to move the ball.
     */
    public void move(){
        RectangularShape tmp = (RectangularShape) ballFace;
        center.setLocation((center.getX() + speedX),(center.getY() + speedY));
        double w = tmp.getWidth();
        double h = tmp.getHeight();
        tmp.setFrame((center.getX() -(w / 2)),(center.getY() - (h / 2)),w,h);
        setPoints(w,h);
        ballFace = tmp;
    }

    /**
     * This method is to set the speed of the ball.
     *
     * @param x is speed of moving on X-axis.
     * @param y is speed of moving on Y-axis.
     */
    public void setSpeed(int x,int y){
        speedX = x;
        speedY = y;
    }

    /**
     * This method is to set the moving speed on X-axis.
     *
     * @param s is the speed of moving on X-axis.
     */
    public void setXSpeed(int s){
        speedX = s;
    }

    /**
     * This method is to set the moving speed on Y-axis.
     * @param s is the speed of moving on Y-axis.
     */
    public void setYSpeed(int s){
        speedY = s;
    }

    /**
     * This method is to bounce back the ball when it collided with border or wall on X-axis.
     */
    public void reverseX(){
        speedX *= -1;
    }

    /**
     * This method is to bounce back the ball when it collided with border or wall on Y-axis.
     */
    public void reverseY(){
        speedY *= -1;
    }

    /**
     * This method is to get the position of the ball.
     *
     * @return the X and Y of the ball.
     */
    public Point2D getPosition(){
        return center;
    }

    /**
     * This method is to get the ball face.
     * @return the face of the ball.
     */
    public Shape getBallFace(){
        return ballFace;
    }

    /**
     * This method is to move the ball to a specific location.
     * @param p is the X and Y location to set the ball.
     */
    public void moveTo(Point p){
        center.setLocation(p);
        RectangularShape tmp = (RectangularShape) ballFace;
        double w = tmp.getWidth();
        double h = tmp.getHeight();
        tmp.setFrame((center.getX() -(w / 2)),(center.getY() - (h / 2)),w,h);
        ballFace = tmp;
    }

    /**
     * This method is to set the location of the ball when it is moving.
     *
     * @param width is the width of the ball.
     * @param height is the height of the ball.
     */
    private void setPoints(double width,double height){
        up.setLocation(center.getX(),center.getY()-(height / 2));
        down.setLocation(center.getX(),center.getY()+(height / 2));

        left.setLocation(center.getX()-(width / 2),center.getY());
        right.setLocation(center.getX()+(width / 2),center.getY());
    }

    /**
     * This method is to get the moving speed on X-axis.
     * @return is the speed of moving speed on X-axis.
     */
    public int getSpeedX(){
        return speedX;
    }

    /**
     * This method is to get the moving speed on Y-axis.
     * @return is the return of moving speed on Y-axis.
     */
    public int getSpeedY(){
        return speedY;
    }


}