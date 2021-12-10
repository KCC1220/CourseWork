package main.java.bricks;

import main.java.bricks.Brick;

import java.awt.*;



public class ClayBrick extends Brick {

    private static final String NAME = "Clay Brick";
    private static final Color DEF_INNER = new Color(178, 34, 34).darker();
    private static final Color DEF_BORDER = Color.GRAY;
    private static final int CLAY_STRENGTH = 1;


    /**
     * This is the constructor to create object of Clay Brick.
     * @param point is the X and Y point to create the Clay Brick.
     * @param size is the size of the Clay Brick.
     */
    public ClayBrick(Point point, Dimension size){
        super(NAME,point,size,DEF_BORDER,DEF_INNER,CLAY_STRENGTH);
    }

    /**
     * This method is to make the Clay Brick.
     * @param pos is the position of the X and Y of the wall that need to be created.
     * @param size is the size of the wall.
     * @return is the shape of the wall at the specific X and Y position.
     */
    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) {
        return new Rectangle(pos,size);
    }

    /**
     * This method is to get the brick face of Clay Brick.
     * @return the Clay Brick style.
     */
    @Override
    public Shape getBrick() {
        return super.brickFace;
    }


}
