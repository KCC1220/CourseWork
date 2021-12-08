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

    MakeLevelType makeLevel = new MakeLevelType();

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

    private void makeBall(Point2D ballPos){
        ball = new RubberBall(ballPos);
    }

    private Brick[][] makeLevels(Rectangle drawArea, int brickCount, int lineCount, double brickDimensionRatio){
        Brick[][] tmp = new Brick[LEVELS_COUNT][];
        tmp[0] = makeLevel.makeSingleTypeLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY);
        tmp[1] = makeLevel.makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY,CEMENT);
        tmp[2] = makeLevel.makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY,STEEL);
        tmp[3] = makeLevel.makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,STEEL,CEMENT);
        return tmp;
    }

    private Brick[][] makeArcadeLevels(Rectangle drawArea, int brickCount,int lineCount,double brickDimensionRatio){
        Brick[][] tmp = new Brick[ARCADE_LEVELS_COUNT][];
        tmp[0] = makeLevel.makeTutorialLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY);
        tmp[1] = makeLevel.makeTutorialLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CEMENT);
        tmp[2] = makeLevel.makeTutorialLevel(drawArea,brickCount,lineCount,brickDimensionRatio,STEEL);
        return tmp;
    }


    public void move(){
        player.move();
        ball.move();
    }

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

    private boolean impactBorder(){
        Point2D p = ball.getPosition();
        return ((p.getX() < area.getX()) ||(p.getX() > (area.getX() + area.getWidth())));
    }

    public int getBrickCount(){
        return brickCount;
    }

    public int getBallCount(){
        return ballCount;
    }

    public boolean isBallLost(){
        return ballLost;
    }

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

    public void wallReset(){
        for(Brick b : bricks)
            b.repair();
        brickCount = bricks.length;
        ballCount = 3;
    }

    public boolean ballEnd(){
        return ballCount == 0;
    }

    public boolean isDone(){
        return brickCount == 0;
    }

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
    public void nextArcadeLevel(){
        if(!hasArcadeLevel()){
            JOptionPane.showConfirmDialog(null,"This is already the last level","Alert", JOptionPane.DEFAULT_OPTION);
        }
        else {
            bricks = arcadeLevels[arcadeLevel++];
            this.brickCount = bricks.length;
        }
    }


    public boolean hasLevel(){
        return level < levels.length;
    }
    public boolean hasArcadeLevel(){
        return arcadeLevel < arcadeLevels.length;
    }


    public void setBallXSpeed(int s){
        ball.setXSpeed(s);
    }

    public void setBallYSpeed(int s){
        ball.setYSpeed(s);
    }

    public void resetBallCount(){
        ballCount = 3;
    }
}