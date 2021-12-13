package main.java.ball;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;


public class RubberBall extends Ball {


    private static final int DEF_RADIUS = 10;


    /**
     * This method is to create the ball object.
     * @param center is the initial point of the ball.
     */
    public RubberBall(Point2D center){
        super(center, DEF_RADIUS, DEF_RADIUS);
    }


    /**
     * This method is to create the ball shape.
     *
     * @param center is to position to create the ball.
     * @param radiusA is the horizontal radius of the ball.
     * @param radiusB is the vertical radius of the ball.
     * @return return the shape of the ball.
     */
    @Override
    protected Shape makeBall(Point2D center, int radiusA, int radiusB) {

        double x = center.getX() - (float)(radiusA / 2);
        double y = center.getY() - (float)(radiusB / 2);

        return new Ellipse2D.Double(x,y,radiusA,radiusB);
    }
}