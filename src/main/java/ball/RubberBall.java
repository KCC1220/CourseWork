/*
 *  Brick Destroy - A simple Arcade video game
 *   Copyright (C) 2017  Filippo Ranza
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package main.java.ball;

import main.java.ball.Ball;

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
