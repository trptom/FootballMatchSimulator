/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.data;

import cz.tpsoft.footballmatch.enums.Positions;
import java.awt.Point;
import javax.vecmath.Vector2d;

/**
 *
 * @author Administrator
 */
public class MatchPlayer {
    private Match parent;
    private Player player;
    private Point prefferedPosition;
    private Positions position;
    private Vector2d coords = new Vector2d();

    public MatchPlayer(Match parent, Player player, Positions position) {
        this.parent = parent;
        this.player = player;
        this.position = position;
        recountPrefferedPosition();
    }

    public Match getParent() {
        return parent;
    }

    public Player getPlayer() {
        return player;
    }

    public Positions getPosition() {
        return position;
    }

    public Point getPrefferedPosition() {
        return prefferedPosition;
    }

    public Vector2d getCoords() {
        return coords;
    }

    public void setCoords(Vector2d coords) {
        coords.set(coords);
    }

    public void setCoords(double x, double y) {
        coords.set(x, y);
    }
    
    public final void recountPrefferedPosition() {
        prefferedPosition = new Point(
                getParent().getStadium().getPitchHeight() * getPosition().getPrefferedPosition().x / 100,
                getParent().getStadium().getPitchWidth() * getPosition().getPrefferedPosition().y / 100);
    }
}
