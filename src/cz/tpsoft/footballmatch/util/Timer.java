/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.util;

/**
 *
 * @author Administrator
 */
public class Timer extends Thread {
    public static interface Action {
        public void doAction();
    }
    
    int interval;
    private Action action;

    public Timer(int interval, Action action) {
        this.interval = interval;
        this.action = action;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(interval);
            } catch (InterruptedException ex) {
                ex.printStackTrace(System.out);
                System.exit(-1);
            }
            action.doAction();
        }
    }
}
