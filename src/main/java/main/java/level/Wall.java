package main.java.level;

import main.java.Player;
import main.java.ball.Ball;
import main.java.ball.RubberBall;
import main.java.bricks.Brick;
import main.java.bricks.Crack;
import main.java.controller.GameBoardController;
import main.java.model.GameBoardModel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;


public class Wall {

    private static final int LEVELS_COUNT = 4;
    private static final int ARCADE_LEVELS_COUNT = 3;

    private static final int CLAY = 1;
    private static final int STEEL = 2;
    private static final int CEMENT = 3;

    private final Random rnd;
    private final Rectangle area;

    public Brick[] bricks;

    public static Ball ball;
    public static Player player;

    private Brick[][] levels;
    private Brick[][] arcadeLevels;
    private int level;
    private int arcadeLevel;

    private final Point startPoint;
    private int brickCount;
    private int ballCount;
    private boolean ballLost;

    main.java.level.MakeLevelType makeLevel = new main.java.level.MakeLevelType();

    /**
     * This is the constructor of wall.
     * It will make the all the levels of the game.
     * It will also make the player and ball on the screen.
     *
     * @param drawArea is the draw area of for the wall
     * @param brickCount is the number of brick
     * @param lineCount is the line of wall
     * @param brickDimensionRatio is the size of the brick
     * @param ballPos is the initial position of ball
     */
    //Normal Level
    public Wall(Rectangle drawArea, int brickCount, int lineCount, double brickDimensionRatio, Point ballPos){

        this.startPoint = new Point(ballPos);

        levels = makeLevels(drawArea,brickCount,lineCount,brickDimensionRatio);
        level = 0;

        ballCount = 3;
        ballLost = false;

        rnd = new Random();

        makeBall(ballPos);
        int speedX,speedY;
        do{
            speedX = rnd.nextInt(5) - 2;
        }while(speedX == 0);
        do{
            speedY = -rnd.nextInt(3);
        }while(speedY == 0);

        ball.setSpeed(speedX,speedY);

        player = new Player((Point) ballPos.clone(),150,10, drawArea);

        area = drawArea;
    }
    /**
     * This is the constructor of wall.
     * It will make the all the tutorial levels of the game.
     * It will also make the player and ball on the screen.
     *
     * @param drawArea is the draw area of for the wall
     * @param brickCount is the number of brick
     * @param lineCount is the line of wall
     * @param brickDimensionRatio is the size of the brick
     * @param ballPos is the initial position of ball
     */
    //wall for training
    public Wall(Rectangle drawArea, int brickCount, int lineCount, Point ballPos,double brickDimensionRatio){

        this.startPoint = new Point(ballPos);

        arcadeLevels = makeArcadeLevels(drawArea,brickCount,lineCount,brickDimensionRatio);
        arcadeLevel = 0;

        ballCount = 3;
        ballLost = false;

        rnd = new Random();

        makeBall(ballPos);
        int speedX,speedY;
        do{
            speedX = rnd.nextInt(5) - 2;
        }while(speedX == 0);
        do{
            speedY = -rnd.nextInt(3);
        }while(speedY == 0);

        ball.setSpeed(speedX,speedY);

        player = new Player((Point) ballPos.clone(),150,10, drawArea);

        area = drawArea;
    }

    /**
     * This method is to make the ball at the position.
     * @param ballPos position of the ball
     */
    private void makeBall(Point2D ballPos){
        ball = new RubberBall(ballPos);
    }

    /**
     * This method is to make all the level of the game
     * @param drawArea is the area for the wall to draw
     * @param brickCount is the number of bricks
     * @param lineCount is the line of the wall
     * @param brickDimensionRatio is the size of the brick
     * @return all the levels
     */
    private Brick[][] makeLevels(Rectangle drawArea, int brickCount, int lineCount, double brickDimensionRatio){
        Brick[][] tmp = new Brick[LEVELS_COUNT][];
        tmp[0] = makeLevel.makeSingleTypeLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY);
        tmp[1] = makeLevel.makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY,CEMENT);
        tmp[2] = makeLevel.makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY,STEEL);
        tmp[3] = makeLevel.makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,STEEL,CEMENT);
        return tmp;
    }
    /**
     * This method is to make all the training level of the game
     * @param drawArea is the area for the wall to draw
     * @param brickCount is the number of bricks
     * @param lineCount is the line of the wall
     * @param brickDimensionRatio is the size of the brick
     * @return all the training levels
     */
    private Brick[][] makeArcadeLevels(Rectangle drawArea, int brickCount,int lineCount,double brickDimensionRatio){
        Brick[][] tmp = new Brick[ARCADE_LEVELS_COUNT][];
        tmp[0] = makeLevel.makeTutorialLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY);
        tmp[1] = makeLevel.makeTutorialLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CEMENT);
        tmp[2] = makeLevel.makeTutorialLevel(drawArea,brickCount,lineCount,brickDimensionRatio,STEEL);
        return tmp;
    }

    /**
     * This method is to initiate the player and the ball to move
     */
    public void move(){
        player.move();
        ball.move();
    }

    /**
     * This method is to check whether there is impact of ball with the brick
     */
    public void findImpacts(){
        if(player.impact(ball)){
            ball.reverseY();
        }
        else if(impactWall()){
            /*for efficiency reverse is done into method impactWall
             * because for every brick program checks for horizontal and vertical impacts
             */
            brickCount--;
        }
        else if(impactBorder()) {
            ball.reverseX();
        }
        else if(ball.getPosition().getY() < area.getY()){
            ball.reverseY();
        }
        else if(ball.getPosition().getY() > 450){
            ballCount--;
            ballLost = true;
        }
    }

    /**
     * This method is the action to be done when there is impact
     * @return in which direction the brick need to crack
     */
    private boolean impactWall(){
        for(Brick b : bricks){
            switch (b.findImpact(ball)) {
                //Vertical Impact
                case Brick.UP_IMPACT -> {
                    ball.reverseY();
                    return b.setImpact(ball.down, Crack.UP);
                }
                case Brick.DOWN_IMPACT -> {
                    ball.reverseY();
                    return b.setImpact(ball.up, Crack.DOWN);
                }
                //Horizontal Impact
                case Brick.LEFT_IMPACT -> {
                    ball.reverseX();
                    return b.setImpact(ball.right, Crack.RIGHT);
                }
                case Brick.RIGHT_IMPACT -> {
                    ball.reverseX();
                    return b.setImpact(ball.left, Crack.LEFT);
                }
            }
        }
        return false;
    }

    /**
     * This method is to check whether there is impact with the border
     * @return true false of whether the ball impact with border
     */
    private boolean impactBorder(){
        Point2D p = ball.getPosition();
        return ((p.getX() < area.getX()) ||(p.getX() > (area.getX() + area.getWidth())));
    }

    /**
     * This getter method is to get the number of brick
     * @return number of bricks
     */
    public int getBrickCount(){
        return brickCount;
    }

    /**
     * This getter method is to get the number of ball left
     * @return number of ball left
     */
    public int getBallCount(){
        return ballCount;
    }

    /**
     * This method is to check whether the ball had hit the line and lost
     * @return true or false on whether the ball hit the line
     */
    public boolean isBallLost(){
        return ballLost;
    }

    /**
     * This method is to reset the ball and player move to the starting position
     */
    public void ballReset(){
        player.moveTo(startPoint);
        ball.moveTo(startPoint);
        int speedX,speedY;
        do{
            speedX = rnd.nextInt(5) - 2;
        }while(speedX == 0);
        do{
            speedY = -rnd.nextInt(3);
        }while(speedY == 0);

        ball.setSpeed(speedX,speedY);
        ballLost = false;
    }

    /**
     * This method is to repaint all the brick back on the window
     */
    public void wallReset(){
        for(Brick b : bricks)
            b.repair();
        brickCount = bricks.length;
        ballCount = 3;
    }

    /**
     * This method is to check whether all the ball had lost or not
     * @return true or false on whether all the ball is lost or not
     */
    public boolean ballEnd(){
        return ballCount == 0;
    }

    /**
     * This method is to check whether all the brick is already break
     * @return true or false on whether all the ball is broken
     */
    public boolean isDone(){
        return brickCount == 0;
    }

    /**
     * This method is to initiate next level and track whether it is the last level or not
     */
    public void nextLevel(){
        GameBoardController.resetTime();
        if(!hasLevel()){
            JOptionPane.showConfirmDialog(null,"This is already the last level","Alert", JOptionPane.DEFAULT_OPTION);
        }
        else {
            bricks = levels[level++];
            GameBoardModel.level++;
            this.brickCount = bricks.length;
        }

    }

    /**
     * This method is to go to the next training level and also check whether this is the last level of training level or not
     */
    public void nextArcadeLevel(){
        if(!hasArcadeLevel()){
            JOptionPane.showConfirmDialog(null,"This is already the last level","Alert", JOptionPane.DEFAULT_OPTION);
        }
        else {
            bricks = arcadeLevels[arcadeLevel++];
            this.brickCount = bricks.length;
        }
    }

    /**
     * This method is to check whether there is more level or not
     * @return true or false on whether the level is finished or not
     */
    public boolean hasLevel(){
        return level < levels.length;
    }
    /**
     * This method is to check whether there is more training level or not
     * @return true or false on whether the training level is finished or not
     */
    public boolean hasArcadeLevel(){
        return arcadeLevel < arcadeLevels.length;
    }

    /**
     * This method is to set the ball moving speed on the X-axis
     * @param s moving speed on X-axis
     */
    public void setBallXSpeed(int s){
        ball.setXSpeed(s);
    }
    /**
     * This method is to set the ball moving speed on the Y-axis
     * @param s moving speed on Y-axis
     */
    public void setBallYSpeed(int s){
        ball.setYSpeed(s);
    }
    /**
     * This method is to reset all the ball to 3 chance
     */
    public void resetBallCount(){
        ballCount = 3;
    }
}