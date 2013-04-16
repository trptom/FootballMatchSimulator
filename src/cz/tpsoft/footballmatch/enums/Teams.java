/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.enums;

/**
 *
 * @author Administrator
 */
public enum Teams {
    HOME(0),
    AWAY(1);
    
    private int id;

    private Teams(int id) {
        this.id = id;
    }
    
    public int getTeamId() {
        return this.id;
    }
}
