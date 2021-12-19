/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author zachm
 */
public class PlayerModel {
    private int PlayerID,GAMEID;
    private String PLAYER_NAME;

    /**
     * @return the PlayerID
     */
    public int getPlayerID() {
        return PlayerID;
    }

    /**
     * @param PlayerID the PlayerID to set
     */
    public void setPlayerID(int PlayerID) {
        this.PlayerID = PlayerID;
    }

    /**
     * @return the GAMEID
     */
    public int getGAMEID() {
        return GAMEID;
    }

    /**
     * @param GAMEID the GAMEID to set
     */
    public void setGAMEID(int GAMEID) {
        this.GAMEID = GAMEID;
    }

    /**
     * @return the PLAYER_NAME
     */
    public String getPLAYER_NAME() {
        return PLAYER_NAME;
    }

    /**
     * @param PLAYER_NAME the PLAYER_NAME to set
     */
    public void setPLAYER_NAME(String PLAYER_NAME) {
        this.PLAYER_NAME = PLAYER_NAME;
    }
    
}
