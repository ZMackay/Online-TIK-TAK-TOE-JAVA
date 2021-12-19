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
public class GameModel {
    private int GAMEID,player1ID,player2ID,winnerID;
    private boolean gameOver;

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
     * @return the player1ID
     */
    public int getPlayer1ID() {
        return player1ID;
    }

    /**
     * @param player1ID the player1ID to set
     */
    public void setPlayer1ID(int player1ID) {
        this.player1ID = player1ID;
    }

    /**
     * @return the player2ID
     */
    public int getPlayer2ID() {
        return player2ID;
    }

    /**
     * @param player2ID the player2ID to set
     */
    public void setPlayer2ID(int player2ID) {
        this.player2ID = player2ID;
    }

    /**
     * @return the winnerID
     */
    public int getWinnerID() {
        return winnerID;
    }

    /**
     * @param winnerID the winnerID to set
     */
    public void setWinnerID(int winnerID) {
        this.winnerID = winnerID;
    }

    /**
     * @return the gameOver
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * @param gameOver the gameOver to set
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    
}
