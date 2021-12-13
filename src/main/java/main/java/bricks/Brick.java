package main.java.bricks;

import main.java.ball.Ball;

import java.awt.*;

import java.awt.geom.Point2D;
import java.util.Random;


abstract public class Brick  {

    public static final int DEF_CRACK_DEPTH = 1;
    public static final int DEF_STEPS = 35;


    public static final int UP_IMPACT = 100;
    public static final int DOWN_IMPACT = 200;
    public static final int LEFT_IMPACT = 300;
    public static final int RIGHT_IMPACT = 400;



    public static Random rnd;
    Shape brickFace;



    private final Color border;
    private final Color inner;

    private final int fullStrength;
    private int strength;

    private boolean broken;

    /**
     * This is a constructor to create a wall object.
     * @param name is the type of wall. Only for identification.
     * @param pos is the X and Y position of the wall.
     * @param size is the size of the wall.
     * @param border is the color of inner wall.
     * @param inner is the color of wall border.
     * @param strength is how many times hit to break the wall.
     */
    public Brick( String name,Point pos,Dimension size,Color border,Color inner,int strength){
        rnd = new Random();
        broken = false;
        brickFace = makeBrickFace(pos,size);
        this.border = border;
        this.inner = inner;
        this.fullStrength = this.strength = strength;

    }


    /**
     * This is to make the face of a brick.
     * @param pos is the position of the X and Y of the wall that need to be created.
     * @param size is the size of the wall.
     * @return is the wall.
     */
    protected abstract Shape makeBrickFace(Point pos, Dimension size);

    /**
     * This method is to bounce the ball and check whether the brick break when the ball hit the brick.
     * @param point is where the ball going to bounce after impact with the brick.
     * @param dir is the direction of the brick to crack (For Cement Brick Only).
     * @return is whether the brick break or not.
     */
    public  boolean setImpact(Point2D point , int dir){
        if(broken)
            return false;
        impact();
        return  broken;
    }

    public abstract Shape getBrick();


    /**
     * This method is to get the color of brick's border.
     * @return the colour of border of the brick.
     */
    public Color getBorderColor(){
        return  border;
    }

    /**
     * This method is to get the brick's inner color.
     * @return the inner colour of the brick.
     */
    public Color getInnerColor(){
        return inner;
    }

    /**
     * This method is to find where the ball have make impact with the wall.
     * @param b is the ball object.
     * @return is where the ball having impact with the brick.
     */
    public final int findImpact(Ball b){
        if(broken)
            return 0;
        int out  = 0;
        if(brickFace.contains(b.right))
            out = LEFT_IMPACT;
        else if(brickFace.contains(b.left))
            out = RIGHT_IMPACT;
        else if(brickFace.contains(b.up))
            out = DOWN_IMPACT;
        else if(brickFace.contains(b.down))
            out = UP_IMPACT;
        return out;
    }

    /**
     * This method is to check whether the brick is broken or not.
     * @return is whether teh brick break.
     */
    public final boolean isBroken(){
        return broken;
    }

    /**
     * This is to repair the brick to make it have full strength again,
     */
    public void repair() {
        broken = false;
        strength = fullStrength;
    }

    /**
     * This method is reduce the strength of the brick when it had impacted with ball.
     */
    public void impact(){
        strength--;
        broken = (strength == 0);
    }



}