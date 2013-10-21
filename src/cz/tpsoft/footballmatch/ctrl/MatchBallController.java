/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.ctrl;

import cz.tpsoft.footballmatch.data.MatchBall;
import cz.tpsoft.footballmatch.util.BallPhysics;

/**
 *
 * @author tomas.praslicak
 */
public class MatchBallController {
    private MatchBall matchBall;

    public MatchBallController(MatchBall matchBall) {
        this.matchBall = matchBall;
    }

    public MatchBall getMatchBall() {
        return matchBall;
    }
    
    public void move(int timediff) {
        double prevY = getMatchBall().getPosition().y;
        double prevSpeedY = getMatchBall().getSpeed().y;
        
        getMatchBall().getPosition().set(BallPhysics.getNewPosition(getMatchBall(), timediff));
        getMatchBall().getSpeed().set(BallPhysics.getSpeedVector(getMatchBall(), timediff));
        
        if (getMatchBall().getPosition().y < 0) {
            getMatchBall().getPosition().y = 0;
            getMatchBall().getSpeed().y = Math.max((-getMatchBall().getSpeed().y*0.9)-0.1, 0);
            /*if (prevY <= 0) {
                getMatchBall().getSpeed().y = 0;
                return;
            }
            
            double ySpeedDiff = prevSpeedY - getMatchBall().getSpeed().y;
            double perc = (-getMatchBall().getPosition().y / (prevY-getMatchBall().getPosition().y));
            
            getMatchBall().getPosition().y = -getMatchBall().getPosition().y;
            getMatchBall().getSpeed().y = -getMatchBall().getSpeed().y;
            getMatchBall().getSpeed().y -= 2*ySpeedDiff*perc;
            
            if (getMatchBall().getSpeed().y < 0) {
                getMatchBall().getSpeed().y = 0;
            }*/
        }
    }
}
