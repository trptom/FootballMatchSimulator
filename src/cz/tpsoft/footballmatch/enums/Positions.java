/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.enums;

import java.awt.Point;

/**
 *
 * @author Administrator
 */
public enum Positions {
    GK     (99, 50),
    DEF_L  (70, 10),
    DEF_LC (70, 35),
    DEF_C  (70, 50),
    DEF_RC (70, 65),
    DEF_R  (70, 90),
    MID_L  (50, 10),
    MID_LC (50, 35),
    MID_C  (50, 50),
    MID_RC (50, 65),
    MID_R  (50, 90),
    ATT_L  (30, 10),
    ATT_LC (30, 35),
    ATT_C  (30, 50),
    ATT_RC (30, 65),
    ATT_R  (30, 90);
    
    Point prefferedPosition;

    private Positions(int prefferedX, int prefferedY) {
        this.prefferedPosition = new Point(prefferedX, prefferedY);
    }

    public Point getPrefferedPosition() {
        return prefferedPosition;
    }
    
    
}
