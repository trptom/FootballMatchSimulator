/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.view;

import cz.tpsoft.footballmatch.data.Match;
import cz.tpsoft.footballmatch.data.MatchPlayer;
import cz.tpsoft.footballmatch.data.Stadium;
import cz.tpsoft.footballmatch.enums.Teams;
import cz.tpsoft.footballmatch.util.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JPanel;

/**
 *
 * @author tomas.praslicak
 */
public class Pitch extends JPanel implements ComponentListener {
    public static final Color GRASS_COLOR = new Color(0, 150, 0);
    public static final Color LINE_COLOR = new Color(255, 255, 255);
    public static final int SIDE_PADDING = 10;
    
    private Timer timer = new Timer(50, new Timer.Action() {
        @Override
        public void doAction() {
            if (match != null) {
                match.updatePlayersCoords();
                repaint();
            }
        }
    });
    private Match match;
    private double resize = 1d; // horizontal, vertical
    private int[] center = { 0, 0 }; // horizontal, vertical
    private Rectangle pitchRect;

    public Pitch() {
        this(null);
    }

    public Pitch(Match match) {
        addComponentListener(this);
        
        this.match = match;
        
        recountConstants();
        
        timer.start();
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
    
    @Override
    protected synchronized void paintComponent(Graphics g) {
        g.setColor(GRASS_COLOR);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        if (pitchRect != null) {
            g.setColor(LINE_COLOR);
            g.drawRect(pitchRect.x, pitchRect.y, pitchRect.width, pitchRect.height);
            // stredova cara
            g.drawLine(center[0], pitchRect.y, center[0], pitchRect.y + pitchRect.height);
            
            int topLineY = center[1] - (int)(20.15 * resize);
            int bottomLineY = center[1] + (int)(20.15 * resize);
            int leftLineX = pitchRect.x + (int)(16.5 * resize);
            int rightLineX = pitchRect.x + pitchRect.width - (int)(16.5 * resize);
            // leve vapno
            g.drawLine(pitchRect.x, topLineY, leftLineX, topLineY);
            g.drawLine(pitchRect.x, bottomLineY, leftLineX, bottomLineY);
            g.drawLine(leftLineX, topLineY, leftLineX, bottomLineY);
            // prave vapno
            g.drawLine(pitchRect.x + pitchRect.width, topLineY, rightLineX, topLineY);
            g.drawLine(pitchRect.x + pitchRect.width, bottomLineY, rightLineX, bottomLineY);
            g.drawLine(rightLineX, topLineY, rightLineX, bottomLineY);
            
            int circleSize = (int)(18.3d * resize);
            // stredovy kruh
            g.drawArc(center[0] - (circleSize / 2),
                    center[1] - (circleSize / 2),
                    circleSize, circleSize, 0, 360);
            // levy kruh u vapna
            g.drawArc(center[0] - (circleSize / 2),
                    center[1] - (circleSize / 2),
                    circleSize, circleSize, 0, 360);
            // pravy kruh u vapna
            g.drawArc(center[0] - (circleSize / 2),
                    center[1] - (circleSize / 2),
                    circleSize, circleSize, 0, 360);
        }
        
        if (pitchRect != null && match != null) {
            MatchPlayer[] players;
            g.setColor(Color.red);
            players = match.getPlayers(Teams.HOME);
            for (MatchPlayer player : players) {
                int x = pitchRect.x + (int)(player.getCoords().x * resize);
                int y = pitchRect.y + (int)(player.getCoords().y * resize);
                g.fillRect(x-5, y-5, 10, 10);
            }
            g.setColor(Color.blue);
            players = match.getPlayers(Teams.AWAY);
            for (MatchPlayer player : players) {
                int x = pitchRect.x + pitchRect.width - (int)(player.getCoords().x * resize);
                int y = pitchRect.y + pitchRect.height - (int)(player.getCoords().y * resize);
                g.fillRect(x-5, y-5, 10, 10);
            }
        }
    }
    
    private void recountConstants() {
        if (match != null) {
            double[] tmp = {
                ((Integer)match.getStadium().getPitchHeight()).doubleValue() / ((Integer)(getWidth() - (2 * SIDE_PADDING))).doubleValue(),
                ((Integer)match.getStadium().getPitchWidth()).doubleValue() / ((Integer)(getHeight() - (2 * SIDE_PADDING))).doubleValue()
            };

            if (tmp[0] < tmp[1]) {
                resize = 1d / tmp[1];
            } else {
                resize = 1d / tmp[0];
            }

            center = new int[] {
                getWidth() / 2,
                getHeight() / 2
            };

            pitchRect = new Rectangle(
                    center[0] - (int)(resize * ((Integer)match.getStadium().getPitchHeight()).doubleValue() / 2d),
                    center[1] - (int)(resize * ((Integer)match.getStadium().getPitchWidth()).doubleValue() / 2d),
                    (int)(resize * ((Integer)match.getStadium().getPitchHeight()).doubleValue()),
                    (int)(resize * ((Integer)match.getStadium().getPitchWidth()).doubleValue()));
            
            repaint();
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        recountConstants();
    }

    @Override
    public void componentMoved(ComponentEvent e) {}

    @Override
    public void componentShown(ComponentEvent e) {}

    @Override
    public void componentHidden(ComponentEvent e) {}
}
