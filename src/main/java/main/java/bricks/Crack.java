package main.java.bricks;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;


import static main.java.bricks.Brick.rnd;


public class Crack{
    private static final int CRACK_SECTIONS = 3;
    private static final double JUMP_PROBABILITY = 0.7;

    public static final int LEFT = 10;
    public static final int RIGHT = 20;
    public static final int UP = 30;
    public static final int DOWN = 40;
    public static final int VERTICAL = 100;
    public static final int HORIZONTAL = 200;



    private final GeneralPath crack;

    private final int crackDepth;
    private final int steps;


    /**
     * This constructor is to create object for crack.
     *
     * @param crackDepth is how long the crack should go.
     * @param steps is how the crack line looks like.
     */
    public Crack(int crackDepth, int steps){



        crack = new GeneralPath();
        this.crackDepth = crackDepth;
        this.steps = steps;

    }


    /**
     * This method is to draw the cracked line on the brick.
     * @return is the cracked line.
     */
    public GeneralPath draw(){

        return crack;
    }

    /**
     * This method is to remove the crack line on the brick.
     */
    public void reset(){
        crack.reset();
    }

    /**
     * This method is to calculate where the crack start and stop.
     *
     * @param point is the point that the ball and the brick have impact.
     * @param direction is from where the ball having impact with the brick.
     * @param b is the type of brick.
     */
    protected void makeCrack(Point2D point, int direction, main.java.bricks.Brick b){
        Rectangle bounds = b.brickFace.getBounds();
        Point impact = new Point((int)point.getX(),(int)point.getY());
        Point start = new Point();
        Point end = new Point();


        switch(direction){
            case LEFT:
                start.setLocation(bounds.x + bounds.width, bounds.y);
                end.setLocation(bounds.x + bounds.width, bounds.y + bounds.height);
                Point tmp = makeRandomPoint(start,end,VERTICAL);
                makeCrack(impact,tmp);

                break;
            case RIGHT:
                start.setLocation(bounds.getLocation());
                end.setLocation(bounds.x, bounds.y + bounds.height);
                tmp = makeRandomPoint(start,end,VERTICAL);
                makeCrack(impact,tmp);

                break;
            case UP:
                start.setLocation(bounds.x, bounds.y + bounds.height);
                end.setLocation(bounds.x + bounds.width, bounds.y + bounds.height);
                tmp = makeRandomPoint(start,end,HORIZONTAL);
                makeCrack(impact,tmp);
                break;
            case DOWN:
                start.setLocation(bounds.getLocation());
                end.setLocation(bounds.x + bounds.width, bounds.y);
                tmp = makeRandomPoint(start,end,HORIZONTAL);
                makeCrack(impact,tmp);

                break;

        }
    }

    /**
     * This method is to draw the crack on the brick.
     *
     * @param start the starting point of the cracked line.
     * @param end he end point of the cracked line.
     */
    protected void makeCrack(Point start, Point end){

        GeneralPath path = new GeneralPath();


        path.moveTo(start.x,start.y);

        double w = (end.x - start.x) / (double)steps;
        double h = (end.y - start.y) / (double)steps;

        int bound = crackDepth;
        int jump  = bound * 5;

        double x,y;

        for(int i = 1; i < steps;i++){

            x = (i * w) + start.x;
            y = (i * h) + start.y + randomInBounds(bound);

            if(inMiddle(i, steps))
                y += jumps(jump);

            path.lineTo(x,y);

        }

        path.lineTo(end.x,end.y);
        crack.append(path,true);
    }

    /**
     * This method is to produce a random number for the cracked line looks different every time.
     * @param bound is how long the crack should go.
     * @return is return a random number
     */
    private int randomInBounds(int bound){
        int n = (bound * 2) + 1;
        return rnd.nextInt(n) - bound;
    }

    /**
     * This method is to check whether the impact of ball and the brick is at the middle.
     * @param i is dot of the cracked line.
     * @param divisions is how many dot should it be.
     * @return to see whether it is at the middle of not
     */
    private boolean inMiddle(int i, int divisions){
        int low = (Crack.CRACK_SECTIONS / divisions);
        int up = low * (divisions - 1);

        return  (i > low) && (i < up);
    }

    /**
     * This method is to make the dot line jump and not all is in a line.
     * @param bound is
     * @return is a random number to draw the cracked line
     */
    private int jumps(int bound){

        if(rnd.nextDouble() > Crack.JUMP_PROBABILITY)
            return randomInBounds(bound);
        return  0;

    }

    /**
     * This method is to determine the start point of the cracked line to the end either from horizontal or vertical.
     * @param from the point that the crack line start.
     * @param to the point that the crack line until.
     * @param direction the direction on how the line should be.
     * @return the cracked line either a horizontal line or a vertical line.
     */
    private Point makeRandomPoint(Point from,Point to, int direction){

        Point out = new Point();
        int pos;

        switch (direction) {
            case HORIZONTAL -> {
                pos = rnd.nextInt(to.x - from.x) + from.x;
                out.setLocation(pos, to.y);
            }
            case VERTICAL -> {
                pos = rnd.nextInt(to.y - from.y) + from.y;
                out.setLocation(to.x, pos);
            }
        }
        return out;
    }



}