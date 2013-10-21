/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch;

import cz.tpsoft.footballmatch.data.Ball;
import cz.tpsoft.footballmatch.data.Match;
import cz.tpsoft.footballmatch.data.Player;
import cz.tpsoft.footballmatch.data.Stadium;
import cz.tpsoft.footballmatch.view.Main;

/**
 *
 * @author tomas.praslicak
 */
public class FootballMatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ball ball = new Ball(0.22);
        System.out.println(ball.getFrictionCoef());
        
        Main main = new Main();
        Match match = new Match(new Stadium(), new Player[][] {
            {
                new Player(),
                new Player(),
                new Player(),
                new Player(),
                new Player(),
                new Player(),
                new Player(),
                new Player(),
                new Player(),
                new Player(),
                new Player()
            },
            {
                new Player(),
                new Player(),
                new Player(),
                new Player(),
                new Player(),
                new Player(),
                new Player(),
                new Player(),
                new Player(),
                new Player(),
                new Player()
            }
        });
        main.getPitch().setMatch(match);
        main.setVisible(true);
        
//        new BallBehaviour().setVisible(true);
    }
}
