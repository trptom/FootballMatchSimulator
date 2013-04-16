/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.view;

import cz.tpsoft.footballmatch.data.Stadium;
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
    
    private Stadium stadium;
    private double resize = 1d; // horizontal, vertical
    private int[] center = { 0, 0 }; // horizontal, vertical
    private Rectangle pitchRect;

    public Pitch() {
        this(null);
    }

    public Pitch(Stadium stadium) {
        addComponentListener(this);
        
        this.stadium = stadium;
        
        recountConstants();
    }
    
    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
        recountConstants();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(GRASS_COLOR);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        if (pitchRect != null) {
            g.setColor(LINE_COLOR);
            g.drawRect(pitchRect.x, pitchRect.y, pitchRect.width, pitchRect.height);
        }
    }
    
    private void recountConstants() {
        if (stadium != null) {
            double[] tmp = {
                ((Integer)stadium.getPitchHeight()).doubleValue() / ((Integer)(getWidth() - (2 * SIDE_PADDING))).doubleValue(),
                ((Integer)stadium.getPitchWidth()).doubleValue() / ((Integer)(getHeight() - (2 * SIDE_PADDING))).doubleValue()
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
                    center[0] - (int)(resize * ((Integer)stadium.getPitchHeight()).doubleValue() / 2d),
                    center[1] - (int)(resize * ((Integer)stadium.getPitchWidth()).doubleValue() / 2d),
                    (int)(resize * ((Integer)stadium.getPitchHeight()).doubleValue()),
                    (int)(resize * ((Integer)stadium.getPitchWidth()).doubleValue()));
            
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
