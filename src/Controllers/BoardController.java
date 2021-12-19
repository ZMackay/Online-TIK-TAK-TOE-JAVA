/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Conn.DBConnection;
import Interfaces.DataAccessTemplate;
import Models.BoardModel;
import Runnables.BoardCheck;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author zachm
 */
public class BoardController implements DataAccessTemplate<BoardModel> {
    public static JLabel boardSegs[] = new JLabel[9];
    public static int[] boardVals = new int[9];
    public static boolean clicked = false;
    public static String area = "";
    public static int winRow,winCol;
    public static boolean topLeft,botLeft;

    @Override
    public List<BoardModel> getAllItemsFromDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BoardModel getItem(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getBoardVals(int GAMEID) {
        List boardVals = new ArrayList();
        try {

            PreparedStatement pstmt = DBConnection.con.prepareStatement("SELECT * FROM BOARD WHERE GAMEID = ?");
            pstmt.setInt(1, GAMEID);
            ResultSet rset = pstmt.executeQuery();

            if (rset != null) {
                while (rset.next()) {
                    boardVals.add(rset.getInt("topLeft"));
                    BoardController.boardVals[0] = rset.getInt("topLeft");

                    boardVals.add(rset.getInt("topMid"));
                    BoardController.boardVals[1] = rset.getInt("topMid");

                    boardVals.add(rset.getInt("topRight"));
                    BoardController.boardVals[2] = rset.getInt("topRight");

                    boardVals.add(rset.getInt("midLeft"));
                    BoardController.boardVals[3] = rset.getInt("midLeft");

                    boardVals.add(rset.getInt("midMid"));
                    BoardController.boardVals[4] = rset.getInt("midMid");

                    boardVals.add(rset.getInt("midRight"));
                    BoardController.boardVals[5] = rset.getInt("midRight");

                    boardVals.add(rset.getInt("botLeft"));
                    BoardController.boardVals[6] = rset.getInt("botLeft");

                    boardVals.add(rset.getInt("botMid"));
                    BoardController.boardVals[7] = rset.getInt("botMid");

                    boardVals.add(rset.getInt("botRight"));
                    BoardController.boardVals[8] = rset.getInt("botRight");
                }
            }
            return boardVals;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return boardVals;
    }

    public void PlayerMoveUpdateBoardVal(String Area) {
        
        System.out.println("CLICKED");
        
        String sql = "UPDATE BOARD SET $REPLACE = ? WHERE GAMEID = ?";
        sql = sql.replace("$REPLACE", Area);
        
        if (PlayerController.turn && !BoardCheck.winFound) {
            try { 
                
                System.out.println("UPDATING VALUE OF "+ Area);
                PreparedStatement pstmt = DBConnection.con.prepareStatement(sql);
               
                if (PlayerController.player1) {
                    pstmt.setInt(1, 1);
                } else if (PlayerController.player2) {
                    pstmt.setInt(1, 2);
                }
                pstmt.setInt(2, GameControll.instanceGameID);

                pstmt.executeUpdate();
                
               

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void update(BoardModel item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(BoardModel item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(BoardModel item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void insert(int GAMEID) {
        try {
            PreparedStatement pstmt = DBConnection.con.prepareStatement("INSERT INTO BOARD(GAMEID) VALUES(?)");
            pstmt.setInt(1, GAMEID);
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void INIT_BOARD_SEGS(JLabel topLeft,JLabel topMid,JLabel topRight,JLabel midLeft,JLabel midMid,JLabel midRight,JLabel botLeft,JLabel botMid,JLabel botRight){
        boardSegs[0] = topLeft;
        boardSegs[1] = topMid;
        boardSegs[2] = topRight;
        boardSegs[3] = midLeft;
        boardSegs[4] = midMid;
        boardSegs[5] = midRight;
        boardSegs[6] = botLeft;
        boardSegs[7] = botMid;
        boardSegs[8] = botRight;
    }
    
    public void resetBoard(){
        for(int i = 0; i < 9; i++){
            BoardController.boardSegs[i].setIcon(null);
            BoardController.boardVals[i] = 0;
        }
        BoardCheck.winFound = false;
    }

}
