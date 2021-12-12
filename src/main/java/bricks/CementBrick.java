package main.java.bricks;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;


public class CementBrick extends Brick {


    private static final String NAME = "Cement Brick";
    private static final Color DEF_INNER = new Color(147, 147, 147);
    private static final Color DEF_BORDER = new Color(217, 199, 175);
    private static final int CEMENT_STRENGTH = 2;

    private final Crack crack;
    private Shape brickFace;

    /**
     * This is a constructor for Cement Brick which it will create the object of Cement Brick.
     * @param point is where to create the Cement Brick.
     * @param size is the size of the Cement Brick.
     */
    public CementBrick(Point point, Dimension size){
        super(NAME,point,size,DEF_BORDER,DEF_INNER,CEMENT_STRENGTH);
        crack = new Crack(DEF_CRACK_DEPTH,DEF_STEPS);
        brickFace = super.brickFace;
    }

    /**
     * This method is to make the shape of Cement Brick.
     * @param pos is the position of the X and Y of the wall that need to be created.
     * @param size is the size of the wall.
     * @return the shape of Cement Brick in the location.
     */
    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) {
        return new Rectangle(pos,size);
    }

    /**
     * This method is to bounce the ball and check whether the Cement Brick break when the ball hit the brick.
     * If the Cement Brick is not broken, yet then it will make crack on the Cement Brick.
     *
     * @param point is where the ball going to bounce after impact with the brick.
     * @param dir is the direction of the brick to crack (For Cement Brick Only).
     * @return is there any impact of the ball and the wall.
     */
    @Override
    public boolean setImpact(Point2D point, int dir) {
        if(super.isBroken())
            return false;
        super.impact();
        if(!super.isBroken()){
            crack.makeCrack(point,dir,this);
            updateBrick();
            return false;
        }
        return true;
    }

    /**
     * This method is to get the brick face of Cement Brick.
     * @return Cement Brick face.
     */
    @Override
    public Shape getBrick() {
        return brickFace;
    }

    /**
     * This method is to update the brick to crack when the ball first hit the Cement Brick and draw cracked line on it.
     */
    private void updateBrick(){
        if(!super.isBroken()){
            GeneralPath gp = crack.draw();
            gp.append(super.brickFace,false);
            brickFace = gp;
        }
    }

    /**
     * This method is to repair the Cement Brick back.
     */
    public void repair(){
        super.repair();
        crack.reset();
        brickFace = super.brickFace;
    }
}