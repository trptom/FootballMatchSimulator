/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.util;

/**
 *
 * @author Administrator
 */
public class Vec2F {
    private double x;
    private double y;

    public Vec2F() {
        this(0d, 0d);
    }
    
    public Vec2F(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public double abs() {
        return Math.sqrt(x*x + y*y);
    }
}
