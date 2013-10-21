/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.data;

import cz.tpsoft.footballmatch.util.Physics;

/**
 *
 * @author tomas.praslicak
 */
public class Ball {
    private double radius;
    private double frictionCoef;

    public Ball() {
        this(0.22);
    }
    
    public Ball(double radius) {
        this.radius = radius;
        frictionCoef = 6 * Math.PI * Physics.AIR_VISCOSITY_0DG * radius;
    }
    
    public double getRadius() {
        return radius;
    }

    public double getFrictionCoef() {
        return frictionCoef;
    }
    
    
}
