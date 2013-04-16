/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author tomas.praslicak
 */
public class Menu extends JMenuBar {

    public Menu() {
        JMenu menu;
        JMenuItem menuItem;
        
        menu = new JMenu("Program");
        menuItem = new JMenuItem("Konec");
        menuItem.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(menu);
    }
}
