/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.util;

import cz.tpsoft.footballmatch.data.Ball;
import cz.tpsoft.footballmatch.data.MatchBall;
import javax.vecmath.Vector3d;

/**
 *
 * @author tomas.praslicak
 */
public class BallPhysics extends Physics {
    
    public static Vector3d getSpeedVector(MatchBall ball, int timeDiff) {
        /*double friction = ball.getBall().getFrictionCoef() * ball.getSpeed().abs();
        Vector3d ret = new Vector3d(ball.getSpeed()).multiple(Math.max(0, 0.9-friction * timeDiff / 1000));*/
        Vector3d ret = new Vector3d(ball.getSpeed());
        ret.y -= 9.81 * (timeDiff / 1000d);
        
        /*if (ball.getPosition().y + ret.y < 0) {
            ret.y = -ret.y;
        }*/
        
        return ret;
    }
    
    public static Vector3d getNewPosition(MatchBall ball, int timeDiff) {
        Vector3d ret = new Vector3d(ball.getPosition());
        Vector3d add = new Vector3d(ball.getSpeed());
        add.scale((double)timeDiff / 1000d);
        ret.add(add);
        
        /*if (ret.y < 0) {
            ret.y = -ret.y;
        }
        */
        return ret;
    }
}
