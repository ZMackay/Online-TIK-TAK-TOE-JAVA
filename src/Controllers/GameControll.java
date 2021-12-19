/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

//import Connection.DBConnection;
import Interfaces.DataAccessTemplate;
import Models.GameModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Conn.DBConnection;
import javax.swing.JTextArea;

/**
 *
 * @author zachm
 */
public class GameControll implements DataAccessTemplate<GameModel> {

    private String SQLall = "SELECT * FROM GAME";
    private String SQLinsert = "INSERT INTO GAME(PLAYER1ID) VALUE(?)";
    private String gameShell = "INSERT INTO GAME() VALUES()";

    public static int instanceGameID;
    public static JTextArea openGamesArea;

    @Override
    public GameModel getItem(int key) {
        try {
            GameModel game = new GameModel();
            PreparedStatement pstmt = DBConnection.con.prepareStatement("SELECT * FROM GAME WHERE GAMEID = ?");
            pstmt.setInt(1, key);
            ResultSet rset = pstmt.executeQuery();

            if (rset != null) {
                while (rset.next()) {
                    game.setGAMEID(rset.getInt("GAMEID"));
                    game.setGameOver(rset.getBoolean("GAMEOVER"));
                    game.setPlayer1ID(rset.getInt("PLAYER1ID"));
                    game.setPlayer2ID(rset.getInt("PLAYER2ID"));
                    game.setWinnerID(rset.getInt("WINNERID"));
                }

            }
            return game;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(GameModel item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void update(int PLAYERID) {
        try {
            if (PlayerController.player1) {
                PreparedStatement pstmt = DBConnection.con.prepareStatement("UPDATE GAME SET PLAYER1ID = ? WHERE GAMEID = ?");
                pstmt.setInt(1, PLAYERID);
                pstmt.setInt(2, instanceGameID);
                System.out.println("UPDATING GAME TABLE TO INCLUDE THIS INSTANCE TO PLAYER 1");
                pstmt.executeUpdate();
            } else if (PlayerController.player2) {
                PreparedStatement pstmt = DBConnection.con.prepareStatement("UPDATE GAME SET PLAYER2ID = ? WHERE GAMEID = ?");
                pstmt.setInt(1, PLAYERID);
                pstmt.setInt(2, instanceGameID);
                System.out.println("UPDATING GAME TABLE TO INCLUDE THIS INSTANCE TO PLAYER 1");
                pstmt.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(GameModel item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(GameModel item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void insertWinnerID(){
        try{
            
            PreparedStatement pstmt = DBConnection.con.prepareStatement("UPDATE GAME SET WINNERID = ? WHERE GAMEID = ?");
            pstmt.setInt(1,PlayerController.playerID);
            pstmt.setInt(2, instanceGameID);
            pstmt.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<GameModel> getAllItemsFromDatabase() {
        ArrayList<GameModel> games = new ArrayList<GameModel>();
        try {
            PreparedStatement pstmt = DBConnection.con.prepareStatement(SQLall);
            ResultSet rset = pstmt.executeQuery();
            if (rset != null) {
                while (rset.next()) {
                    GameModel game = new GameModel();
                    game.setGAMEID(rset.getInt("GAMEID"));
                    game.setPlayer1ID(rset.getInt("PLAYER1ID"));
                    game.setPlayer2ID(rset.getInt("PLAYER2ID"));
                    game.setWinnerID(rset.getInt("WINNERID"));
                    game.setGameOver(rset.getBoolean("GAMEOVER"));
                    games.add(game);
                }
            }
            return games;
        } catch (SQLException e) {
            System.out.println("DB2 Database connection Failed! in the player get all from database method, and it's returning null.");
            e.printStackTrace();
            return null;
        }
    }
    public static List<GameModel> getOpenGamesFromDatabase() {
        ArrayList<GameModel> games = new ArrayList<GameModel>();
        try {
            PreparedStatement pstmt = DBConnection.con.prepareStatement("SELECT * FROM GAME WHERE PLAYER2ID IS NULL AND GAMEOVER = FALSE");
            ResultSet rset = pstmt.executeQuery();
            if (rset != null) {
                while (rset.next()) {
                    GameModel game = new GameModel();
                    game.setGAMEID(rset.getInt("GAMEID"));
                    game.setPlayer1ID(rset.getInt("PLAYER1ID"));
                    game.setPlayer2ID(rset.getInt("PLAYER2ID"));
                    game.setWinnerID(rset.getInt("WINNERID"));
                    game.setGameOver(rset.getBoolean("GAMEOVER"));
                    games.add(game);
                }
            }
            return games;
        } catch (SQLException e) {
            System.out.println("DB2 Database connection Failed! in the player get all from database method, and it's returning null.");
            e.printStackTrace();
            return null;
        }
    }

    public void createShell() {

        try {
            PreparedStatement pstmt = DBConnection.con.prepareStatement(gameShell);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        GameControll.instanceGameID = this.getMostRecentGAMEID();
    }

    public int getMostRecentGAMEID() {
        ResultSet rs = null;
        int val = 0;
        try {
            PreparedStatement pstmt = DBConnection.con.prepareStatement("SELECT MAX(GAMEID) FROM GAME AS GAMEID");
            rs = pstmt.executeQuery();
            rs.next();
            val = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }

    public boolean checkForPlayer2(int GAMEID) {
        boolean val = false;
        GameModel game = this.getItem(GAMEID);
        if (!game.equals(null)) {
            if (game.isGameOver() != true) {
                if (game.getPlayer2ID() != 0){ 
                    System.out.println("PLAYER 2 ALREADY FILLED");
                    System.out.println(game.getPlayer2ID());
                }else{
                    System.out.println("NOT FILLED");
                    val = true;
                }

            }

        }

        return val;
    }
    
    public static void setOpenGameText(String str){
        openGamesArea.setText(str);
    }
    
    public static void setGameOverTrue(){
        try{
            
            PreparedStatement pstmt = DBConnection.con.prepareStatement("UPDATE GAME SET GAMEOVER = ? WHERE GAMEID = ?");
            pstmt.setBoolean(1, true);
            pstmt.setInt(2, instanceGameID);
            pstmt.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
