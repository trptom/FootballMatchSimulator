/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.data;

/**
 *
 * @author tomas.praslicak
 */
public class Stadium {
    public static final int MIN_PITCH_WIDTH = 60;
    public static final int MAX_PITCH_WIDTH = 110;
    public static final int DEFAULT_PITCH_WIDTH = 80;
    public static final int MIN_PITCH_HEIGHT = 100;
    public static final int MAX_PITCH_HEIGHT = 120;
    public static final int DEFAULT_PITCH_HEIGHT = 110;
    
    int pitchWidth = DEFAULT_PITCH_WIDTH;
    int pitchHeight = DEFAULT_PITCH_HEIGHT;

    public int getPitchWidth() {
        return pitchWidth;
    }

    public int getPitchHeight() {
        return pitchHeight;
    }

    public void setPitchWidth(int pitchWidth) {
        if (pitchWidth < MIN_PITCH_WIDTH || pitchWidth > MAX_PITCH_WIDTH) {
            throw new IllegalArgumentException("neplatna sirka hriste (" +
                    pitchHeight + ")");
        }
        this.pitchWidth = pitchWidth;
    }

    public void setPitchHeight(int pitchHeight) {
        if (pitchHeight < MIN_PITCH_HEIGHT || pitchHeight > MAX_PITCH_HEIGHT) {
            throw new IllegalArgumentException("neplatna delka hriste (" +
                    pitchHeight + ")");
        }
        this.pitchHeight = pitchHeight;
    }
}
