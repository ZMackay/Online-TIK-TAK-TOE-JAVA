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
public class ChatModel {
    private int chat_ID,GAMEID;
    private String MSG;

    /**
     * @return the chat_ID
     */
    public int getChat_ID() {
        return chat_ID;
    }

    /**
     * @param chat_ID the chat_ID to set
     */
    public void setChat_ID(int chat_ID) {
        this.chat_ID = chat_ID;
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
     * @return the MSG
     */
    public String getMSG() {
        return MSG;
    }

    /**
     * @param MSG the MSG to set
     */
    public void setMSG(String MSG) {
        this.MSG = MSG;
    }
}
