/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.enums;

import java.util.HashMap;

/**
 *
 * @author tomas.praslicak
 */
public enum Attributes {
    SPEED,
    SHOOTING,
    PASSING,
    VISION,
    STAMINA;
    
    public static final int DEFAULT_VALUE = 10;
    
    public static HashMap<Attributes, Integer> getDefaultattributes() {
        HashMap<Attributes, Integer> ret = new HashMap<>();
        for (Attributes att : Attributes.values()) {
            ret.put(att, DEFAULT_VALUE);
        }
        return ret;
    }
}
