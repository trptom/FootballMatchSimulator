/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.data;

import cz.tpsoft.footballmatch.enums.Attributes;
import java.util.HashMap;

/**
 *
 * @author tomas.praslicak
 */
public class Player {
    public HashMap<Attributes, Integer> attributes = Attributes.getDefaultattributes();

    public HashMap getAttributes() {
        return attributes;
    }
    
   public int getAttribute(Attributes attribute) {
       Integer tmp = attributes.get(attribute);
       return tmp != null ? tmp : 0;
   }
   
   public Integer getAttributeInteger(Attributes attribute) {
       return attributes.get(attribute);
   }
   
   public void setAttribute(Attributes attribute, int value) {
       attributes.put(attribute, value);
   }
   
   public void setAttributeInteger(Attributes attribute, Integer value) {
       attributes.put(attribute, value);
   }
}
