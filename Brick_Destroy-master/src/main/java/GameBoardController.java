package main.java;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameBoardController {
    GameBoardModel model = new GameBoardModel();
    static Time time = new Time();
    Wall wall = model.getWall();



    public void move(){
        model.getWall().move();
    }

    public Boolean isBallLost(){
        return model.getWall().isBallLost();
    }

    public void initialize(GameBoard board){
        board.setPreferredSize(new Dimension(model.getDefWidth(),550));
        board.setFocusable(true);
        board.requestFocusInWindow();
        board.addKeyListener(board);
        board.addMouseListener(board);
        board.addMouseMotionListener(board);
    }

}
