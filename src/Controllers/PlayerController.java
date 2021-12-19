/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Conn.DBConnection;
import Interfaces.DataAccessTemplate;
import Models.PlayerModel;
import java.util.List;
import java.sql.*;

/**
 *
 * @author zachm
 */
public class PlayerController implements DataAccessTemplate<PlayerModel> {

    public static boolean player1, player2,turn = false;
    public static int playerID;
    
    @Override
    public List<PlayerModel> getAllItemsFromDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PlayerModel getItem(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static String getPlayerName(){
        String sql = null;
        
        if(player1){
            sql = "SELECT PLAYER_NAME FROM PLAYER1 WHERE PLAYER1_ID = ?";
        }else if(player2){
            sql = "SELECT PLAYER_NAME FROM PLAYER2 WHERE PLAYER2_ID = ?";
        }
        
        try{
            PreparedStatement pstmt = DBConnection.con.prepareStatement(sql);
            pstmt.setInt(1, playerID);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getString("PLAYER_NAME");
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public void setPlayerID(){
        int val = 0;
        try{
            PreparedStatement pstmt = null;
            if(player1){
               pstmt = DBConnection.con.prepareStatement("SELECT MAX(PLAYER1_ID) FROM PLAYER1"); 
            }else if(player2){
               pstmt = DBConnection.con.prepareStatement("SELECT MAX(PLAYER2_ID) FROM PLAYER2");
            }
            
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            val = rs.getInt(1);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        PlayerController.playerID = val;
    }

    @Override
    public void update(PlayerModel item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public void delete(PlayerModel item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void insert(String NAME,int GAMEID) {
        if (player1) {
            try{
                System.out.println("INSERTING INTO PLAYER1");
                PreparedStatement pstmt = DBConnection.con.prepareStatement("INSERT INTO PLAYER1(PLAYER_NAME,GAMEID) VALUES (?,?)");
                pstmt.setString(1, NAME);
                pstmt.setInt(2, GAMEID);
                pstmt.executeUpdate();
                
                System.out.println("SETTING PLAYER ID STATIC VARIABLE");
                this.setPlayerID();
                System.out.println("ID SET TO: "+ PlayerController.playerID);
                
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if (player2) {
            try{
                System.out.println("INSERTING INTO PLAYER2");
                PreparedStatement pstmt = DBConnection.con.prepareStatement("INSERT INTO PLAYER2(PLAYER_NAME,GAMEID) VALUES (?,?)");
                pstmt.setString(1, NAME);
                pstmt.setInt(2, GAMEID);
                pstmt.executeUpdate();
                
                System.out.println("SETTING PLAYER ID STATIC VARIABLE");
                this.setPlayerID();
                System.out.println("ID SET TO: "+ PlayerController.playerID);
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void insert(PlayerModel item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static String getPlayerName(int gameID) {
        String sql = null;
        sql = "SELECT PLAYER_NAME FROM PLAYER1 WHERE GAMEID = ?";

        try {
            PreparedStatement pstmt = DBConnection.con.prepareStatement(sql);
            pstmt.setInt(1, gameID);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getString("PLAYER_NAME");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
