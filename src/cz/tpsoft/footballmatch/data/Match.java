/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.data;

import cz.tpsoft.footballmatch.enums.Positions;
import cz.tpsoft.footballmatch.enums.Teams;
import javax.swing.text.Position;

/**
 *
 * @author Administrator
 */
public class Match {
    public static Positions[] DEFAULT_POSITIONS = {
        Positions.GK,
        Positions.DEF_L,
        Positions.DEF_LC,
        Positions.DEF_RC,
        Positions.DEF_R,
        Positions.MID_L,
        Positions.MID_LC,
        Positions.MID_RC,
        Positions.MID_R,
        Positions.ATT_LC,
        Positions.ATT_RC,
    };
    
    private Stadium stadium;
    private MatchPlayer[][] players = new MatchPlayer[2][11];

    public Match(Stadium stadium, Player[][] players) {
        this.stadium = stadium;
        
        for (int a=0; a<players.length; a++) {
            for (int b=0; b<players[a].length; b++) {
                MatchPlayer player = new MatchPlayer(this, players[a][b], DEFAULT_POSITIONS[b]);
                this.players[a][b] = player;
                player.setCoords(player.getPrefferedPosition().x, player.getPrefferedPosition().y);
            }
        }
    }

    public Stadium getStadium() {
        return stadium;
    }
    
    
    
    public MatchPlayer[][] getPlayers() {
        return players;
    }
    
    public MatchPlayer[] getPlayers(Teams team) {
        return getPlayers()[team.getTeamId()];
    }
    
    public synchronized void updatePlayersCoords() {
        for (MatchPlayer[] teamPlayers : players) {
            for (MatchPlayer player : teamPlayers) {
                player.setCoords((player.getCoords().getX() + 1) % 50, player.getCoords().getY());
            }
        }
    }
}
