/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.data;

import javax.vecmath.Vector3d;

/**
 *
 * @author tomas.praslicak
 */
public class MatchBall {
    private Ball ball;
    private Vector3d speed = new Vector3d();
    private Vector3d position = new Vector3d();

    public MatchBall(Ball ball) {
        this.ball = ball;
    }

    public Ball getBall() {
        return ball;
    }

    public Vector3d getSpeed() {
        return speed;
    }

    public Vector3d getPosition() {
        return position;
    }
    
    
}
