/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.view.debug;

import cz.tpsoft.footballmatch.ctrl.MatchBallController;
import cz.tpsoft.footballmatch.data.Ball;
import cz.tpsoft.footballmatch.data.MatchBall;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.vecmath.Vector2d;
import javax.vecmath.Vector3d;




class PointsList extends LinkedList<Vector2d> {
    private Color color;

    public PointsList(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public double getMaxX() {
        Iterator<Vector2d> i = iterator();
        Vector2d v;
        double max = Double.MIN_VALUE;
        while (i.hasNext()) {
            v = i.next();
            if (v.x > max) {
                max = v.x;
            }
        }
        return max;
    }
    
    public double getMinX() {
        Iterator<Vector2d> i = iterator();
        Vector2d v;
        double max = Double.MAX_VALUE;
        while (i.hasNext()) {
            v = i.next();
            if (v.x < max) {
                max = v.x;
            }
        }
        return max;
    }
    
    public double getMaxY() {
        Iterator<Vector2d> i = iterator();
        Vector2d v;
        double max = Double.MIN_VALUE;
        while (i.hasNext()) {
            v = i.next();
            if (v.y > max) {
                max = v.y;
            }
        }
        return max;
    }
    
    public double getMinY() {
        Iterator<Vector2d> i = iterator();
        Vector2d v;
        double max = Double.MAX_VALUE;
        while (i.hasNext()) {
            v = i.next();
            if (v.y < max) {
                max = v.y;
            }
        }
        return max;
    }
}

class Panel extends JPanel {
    private LinkedList<PointsList> points;

    public Panel(LinkedList<PointsList> points) {
        this.points = points;
    }

    public LinkedList<PointsList> getPoints() {
        return points;
    }

    public void setPoints(LinkedList<PointsList> points) {
        this.points = points;
    }

    @Override
    protected void paintComponent(Graphics g) {
        double minX = Double.MAX_VALUE, minY = Double.MAX_VALUE, maxX = Double.MIN_VALUE, maxY = Double.MIN_VALUE;
        System.out.println("points.length: " + points);
        for (PointsList list : points) {
            System.out.println(" points[].length: " + list.size());
            minX = Math.min(minX, list.getMinX());
            minY = Math.min(minY, list.getMinY());
            maxX = Math.max(maxX, list.getMaxX());
            maxY = Math.max(maxY, list.getMaxY());
        }
        
        System.out.println("Min|Max: " + minX + ", " + minY + " | " + maxX + ", " + maxY);
        
        double koefX = (double)(getWidth() - 20) / (double)maxX - (double)minX;
        double koefY = (double)(getHeight() - 20) / (double)maxY - (double)minY;
        
        System.out.println("Koef: " + koefX + ", " + koefY);
        
        for (PointsList list : points) {
            g.setColor(list.getColor());
            Vector2d previous = null;
            for (Vector2d vector : list) {
                if (previous != null) {
                    g.drawLine(
                            (int)(10 + ((previous.x-minX) * koefX)),
                            (int)((getHeight()-10) - ((previous.y - minY) * koefY)),
                            (int)(10 + ((vector.x-minX) * koefX)),
                            (int)((getHeight()-10) - ((vector.y - minY) * koefY)));
                }
                previous = vector;
            }
        }
        
        g.drawRect(10, 10, getWidth()-20, getHeight()-20);
    }
}

/**
 *
 * @author tomas.praslicak
 */
public class BallBehaviour extends JFrame {
    private LinkedList<PointsList> points = new LinkedList<>();
    private Panel panel = new Panel(points);

    public BallBehaviour() throws HeadlessException {
        super("Simulace mice");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
        add(panel);
        
        generateLines();
        
        panel.repaint();
    }
    
    public final void generateLines() {
        PointsList newItem1 = new PointsList(Color.GREEN);
        PointsList newItem2 = new PointsList(Color.RED);
        
        MatchBall ball = new MatchBall(new Ball());
//        ball.getSpeed().set(Vector3d.getRandomVector(10, Math.PI / 4, 3 * Math.PI / 4, 0, 0));
        ball.getSpeed().set(1, 9, 0);
        
        MatchBallController ctrl = new MatchBallController(ball);
        
        for (int a=0; a<1000; a++) {
            System.out.println(a);
            System.out.println(ball.getSpeed());
            System.out.println(ball.getPosition());
            System.out.println("");
            ctrl.move(10);
            newItem1.addLast(new Vector2d(ball.getPosition().x, ball.getPosition().y*10d));
        }
        
        points.addLast(newItem1);
        points.addLast(newItem2);
    }
}
