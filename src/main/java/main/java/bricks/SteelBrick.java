package main.java.bricks;


import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;


public class SteelBrick extends Brick {

    private static final String NAME = "Steel Brick";
    private static final Color DEF_INNER = new Color(203, 203, 201);
    private static final Color DEF_BORDER = Color.BLACK;
    private static final int STEEL_STRENGTH = 1;
    private static final double STEEL_PROBABILITY = 0.4;

    private final Random rnd;
    private final Shape brickFace;

    /**
     * This constructor is to create an object to the Steel Brick.
     * @param point is the X and Y position of the Steel Brick.
     * @param size is teh size of the brick.
     */
    public SteelBrick(Point point, Dimension size){
        super(NAME,point,size,DEF_BORDER,DEF_INNER,STEEL_STRENGTH);
        rnd = new Random();
        brickFace = super.brickFace;
    }


    /**
     * This method is to make the shape of the Steel Brick.
     * @param pos is the position of the X and Y of the wall that need to be created.
     * @param size is the size of the wall.
     * @return the Steel Brick shape.
     */
    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) {
        return new Rectangle(pos,size);
    }

    /**
     * This method is to get the face of the brick.
     * @return steel brick's face.
     */
    @Override
    public Shape getBrick() {
        return brickFace;
    }

    /**
     * This method is to check whether the brick is broken or not after the impact.
     * @param point is where the ball going to bounce after impact with the brick.
     * @param dir is the direction of the brick to crack (For Cement Brick Only).
     * @return is whether the brick had broken or not.
     */
    public  boolean setImpact(Point2D point , int dir){
        if(super.isBroken())
            return false;
        impact();
        return  super.isBroken();
    }

    /**
     * This method is to see whether the steel brick is broken or not following a random probability
     */
    public void impact(){
        if(rnd.nextDouble() < STEEL_PROBABILITY){
            super.impact();
        }
    }

}