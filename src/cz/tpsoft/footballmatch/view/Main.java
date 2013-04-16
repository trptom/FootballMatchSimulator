/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author tomas.praslicak
 */
public class Main extends JFrame {
    private Pitch pitch = new Pitch();

    public Main() {
        setSize(640, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
        add(pitch, BorderLayout.CENTER);
    }

    public Pitch getPitch() {
        return pitch;
    }
}
