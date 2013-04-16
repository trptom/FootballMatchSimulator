/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.data;

import cz.tpsoft.footballmatch.enums.Positions;
import cz.tpsoft.footballmatch.util.Vec2F;
import java.awt.Point;
import javax.swing.text.Position;

/**
 *
 * @author Administrator
 */
public class MatchPlayer {
    private Match parent;
    private Player player;
    private Point prefferedPosition;
    private Positions position;
    private Vec2F coords = new Vec2F();

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

    public Vec2F getCoords() {
        return coords;
    }

    public void setCoords(Vec2F coords) {
        setCoords(coords.getX(), coords.getY());
    }

    public void setCoords(double x, double y) {
        coords.setX(x);
        coords.setY(y);
    }
    
    public final void recountPrefferedPosition() {
        prefferedPosition = new Point(
                getParent().getStadium().getPitchHeight() * getPosition().getPrefferedPosition().x / 100,
                getParent().getStadium().getPitchWidth() * getPosition().getPrefferedPosition().y / 100);
    }
}
