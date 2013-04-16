/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch;

import cz.tpsoft.footballmatch.data.Stadium;
import cz.tpsoft.footballmatch.view.Main;

/**
 *
 * @author tomas.praslicak
 */
public class FootballMatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main main = new Main();
        Stadium stadium = new Stadium();
        main.getPitch().setStadium(stadium);
        main.setVisible(true);
    }
}
