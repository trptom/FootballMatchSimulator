/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.util;

/**
 *
 * @author Administrator
 */
public class Vec2DOld {
    /**
     * 
     * @param x souradnice bodu X.
     * @param y souradnice bodu Y.
     * @return odklon od X osy v XY rovine v intervalu -PI..PI (zaporne hodnoty
     * jsou vraceny, pokud je bod pod osou, tedy y je zaporne).
     */
    public static double getAngle(double x, double y) {
        return Math.atan2(y, x);
    }
    
    private double x;
    private double y;

    public Vec2DOld() {
        this(0d, 0d);
    }
    
    public Vec2DOld(double x, double y) {
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
