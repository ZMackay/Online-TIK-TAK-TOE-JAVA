/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runnables;

import Controllers.PlayerController;
import Controllers.BoardController;
import Controllers.ChatController;
import Controllers.GameControll;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author zachm
 */
public class BoardCheck implements Runnable {

    BoardController boardCont = new BoardController();

    @Override
    public void run() {
        System.out.println("GATHERING CURRENT BOARD");
        List board = boardCont.getBoardVals(GameControll.instanceGameID);
        List boardTemp = null;
        System.out.println("Checking");
        while (true && !winFound) {
            //System.out.println(PlayerController.turn);
            if (PlayerController.turn) {

                boardTemp = boardCont.getBoardVals(GameControll.instanceGameID);
                if (!board.equals(boardTemp)) {
                    PlayerController.turn = false;
                    System.out.println("CHANGE CAUGHT DURING TURN");
                    board = boardTemp;
                    changeBoardDisplay();
                    checkForWin();
                }

            } else if (!PlayerController.turn) {

                boardTemp = boardCont.getBoardVals(GameControll.instanceGameID);
                if (!board.equals(boardTemp)) {
                    PlayerController.turn = true;
                    System.out.println("CHANGE CAUGHT");
                    board = boardTemp;
                    changeBoardDisplay();
                    checkForWin();
                }

            }

        }
        
        if(winFound){
            System.out.println("Inserting winner ID");
            GameControll.insertWinnerID();
        }

    }

    public void changeBoardDisplay() {
        BufferedImage x = null, o = null;
        try {
            x = ImageIO.read(this.getClass().getResource("/Resources/x.png"));

        } catch (IOException ex) {
            Logger.getLogger(BoardCheck.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            o = ImageIO.read(this.getClass().getResource("/Resources/o.png"));
        } catch (IOException ex) {
            Logger.getLogger(BoardCheck.class.getName()).log(Level.SEVERE, null, ex);
        }

        int Height = BoardController.boardSegs[1].getHeight();
        int Width = BoardController.boardSegs[1].getWidth();

        x = resizedIMG(x, Width - 10, Height);
        o = resizedIMG(o, Width - 10, Height);

        boardCont.getBoardVals(GameControll.instanceGameID);
        for (int i = 0; i < BoardController.boardSegs.length; i++) {
            if (BoardController.boardVals[i] == 1) {
                System.out.println("setting image");
                BoardController.boardSegs[i].setIcon(new ImageIcon(x));
                BoardController.boardSegs[i].setVisible(true);
            } else if (BoardController.boardVals[i] == 2) {
                System.out.println("setting image");
                BoardController.boardSegs[i].setIcon(new ImageIcon(o));
                BoardController.boardSegs[i].setVisible(true);
            }
        }

    }

    private BufferedImage resizedIMG(BufferedImage img, int x, int y) {
        BufferedImage resizedRS = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedRS.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, 5, 0, x, y, null);
        g2.dispose();

        return resizedRS;
    }
    public static boolean winFound = false;

    private int[][] checkForWin() {

        int[][] winLocs = new int[3][2];

        int Row1[] = new int[3];
        Row1[0] = BoardController.boardVals[0];
        Row1[1] = BoardController.boardVals[1];
        Row1[2] = BoardController.boardVals[2];
        int Row2[] = new int[3];
        Row2[0] = BoardController.boardVals[3];
        Row2[1] = BoardController.boardVals[4];
        Row2[2] = BoardController.boardVals[5];
        int Row3[] = new int[3];
        Row3[0] = BoardController.boardVals[6];
        Row3[1] = BoardController.boardVals[7];
        Row3[2] = BoardController.boardVals[8];

        int[][] boardArrs = new int[3][];
        boardArrs[0] = Row1;
        boardArrs[1] = Row2;
        boardArrs[2] = Row3;

        //horizontal
        if (!winFound) {
            //check for player 1
            if (horizontalCheck(boardArrs, 1)) {
                rowWin(BoardController.winRow,1);
                if (PlayerController.player1) {
                    
                    PlayerController.turn = false;
                    ChatController.insert("Player 1 win at row " + BoardController.winRow);
                    GameControll.setGameOverTrue();
                }
                
                //check player 2
            } else if (horizontalCheck(boardArrs, 2)) {
                rowWin(BoardController.winRow,2);
                if (PlayerController.player2) {
                    
                    PlayerController.turn = false;
                    
                    ChatController.insert("Player 2 win at row " + BoardController.winRow);
                    GameControll.setGameOverTrue();
                }
                
            }
            //vertical
            if(verticalCheck(boardArrs,1)){
                verticalWin(BoardController.winCol,1);
                if (PlayerController.player1) {
                    PlayerController.turn = false;
                    ChatController.insert("Player 1 win at col " + BoardController.winCol);
                    GameControll.setGameOverTrue();
                }
            }else if(verticalCheck(boardArrs,2)){
                verticalWin(BoardController.winCol,2);
                if (PlayerController.player2) {
                    PlayerController.turn = false;
                    ChatController.insert("Player 2 win at col " + BoardController.winCol);
                    GameControll.setGameOverTrue();
                }
            }
            //diagonal
            if(diagonalCheck(boardArrs,1)){
                diagonalWin(1);
                if (PlayerController.player1) {
                    
                    PlayerController.turn = false;
                    if(BoardController.topLeft){
                       ChatController.insert("Player 1 win top left to bottom right"); 
                       GameControll.setGameOverTrue();
                    }else if(BoardController.botLeft){
                        ChatController.insert("Player 1 win bottom left to top right");
                        GameControll.setGameOverTrue();
                    }
                }
                
            }else if(diagonalCheck(boardArrs,2)){
                diagonalWin(2);
                if (PlayerController.player2) {
                    PlayerController.turn = false;
                    if(BoardController.topLeft){
                       ChatController.insert("Player 2 win top left to bottom right"); 
                       GameControll.setGameOverTrue();
                    }else if(BoardController.botLeft){
                        ChatController.insert("Player 2 win bottom left to top right");
                        GameControll.setGameOverTrue();
                    }
                    
                }
            }
            
            
        }

        
        return winLocs;
    }

    private boolean horizontalCheck(int[][] boardArrs, int checkValue) {
        boolean val = false;
        for (int row = 0; row < boardArrs.length; row++) {
            if (boardArrs[row][0] == checkValue && boardArrs[row][1] == checkValue && boardArrs[row][2] == checkValue) {
                BoardController.winRow = row;
                val = true;
            }

            if (val) {
                winFound = true;
                break;
            }

        }

        return val;
    }

    private boolean verticalCheck(int[][] boardArrs, int checkValue) {
        boolean val = false;
        for (int col = 0; col < 3; col++) {
            if (boardArrs[0][col] == checkValue && boardArrs[1][col] == checkValue && boardArrs[2][col] == checkValue) {
                BoardController.winCol = col;
                val = true;
            }

            if (val) {
                winFound = true;
                break;
            }

        }

        return val;
    }
    
    private boolean diagonalCheck(int[][] boardArrs, int checkValue){
        boolean val = false;
        //topLeft to botRight
        if(boardArrs[0][0] == checkValue && boardArrs[1][1] == checkValue && boardArrs[2][2] == checkValue){
            BoardController.topLeft = true;
            val = true;
        }
        //botLeft to topRight
        if(boardArrs[2][0] == checkValue && boardArrs[1][1] == checkValue && boardArrs[0][2] == checkValue){
            BoardController.botLeft = true;
            val = true;
        }
        
        
        if(val){
            winFound = true;
        }
        
        return val;
    }
    
    private void rowWin(int row, int player){
        BufferedImage x = null;
        try {
            if(player == 1){
                x = ImageIO.read(this.getClass().getResource("/Resources/xComp.png"));
            }else{
                x = ImageIO.read(this.getClass().getResource("/Resources/oComp.png"));
            }
            

        } catch (IOException ex) {
            Logger.getLogger(BoardCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int Height = BoardController.boardSegs[1].getHeight();
        int Width = BoardController.boardSegs[1].getWidth();

        x = resizedIMG(x, Width - 10, Height);
        
        if(row == 0){
            if(BoardController.boardVals[0] == player){
            BoardController.boardSegs[0].setIcon(new ImageIcon(x));
            BoardController.boardSegs[1].setIcon(new ImageIcon(x));
            BoardController.boardSegs[2].setIcon(new ImageIcon(x));
            }
        }
        if(row == 1){
            if(BoardController.boardVals[3] == player){
            BoardController.boardSegs[3].setIcon(new ImageIcon(x));
            BoardController.boardSegs[4].setIcon(new ImageIcon(x));
            BoardController.boardSegs[5].setIcon(new ImageIcon(x));
            }
        }
        if(row == 2){
            if(BoardController.boardVals[6] == player){
            BoardController.boardSegs[6].setIcon(new ImageIcon(x));
            BoardController.boardSegs[7].setIcon(new ImageIcon(x));
            BoardController.boardSegs[8].setIcon(new ImageIcon(x));
            }
        }
    }
    
    private void verticalWin(int col, int player){
        BufferedImage x = null;
        try {
            if(player == 1){
                x = ImageIO.read(this.getClass().getResource("/Resources/xComp.png"));
            }else{
                x = ImageIO.read(this.getClass().getResource("/Resources/oComp.png"));
            }
            

        } catch (IOException ex) {
            Logger.getLogger(BoardCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int Height = BoardController.boardSegs[1].getHeight();
        int Width = BoardController.boardSegs[1].getWidth();

        x = resizedIMG(x, Width - 10, Height);
        
        if(col == 0){
            if(BoardController.boardVals[0] == player){
            BoardController.boardSegs[0].setIcon(new ImageIcon(x));
            BoardController.boardSegs[3].setIcon(new ImageIcon(x));
            BoardController.boardSegs[6].setIcon(new ImageIcon(x));
            }
        }
        if(col == 1){
            if(BoardController.boardVals[1] == player){
            BoardController.boardSegs[1].setIcon(new ImageIcon(x));
            BoardController.boardSegs[4].setIcon(new ImageIcon(x));
            BoardController.boardSegs[7].setIcon(new ImageIcon(x));
            }
        }
        if(col == 2){
            if(BoardController.boardVals[2] == player){
            BoardController.boardSegs[2].setIcon(new ImageIcon(x));
            BoardController.boardSegs[5].setIcon(new ImageIcon(x));
            BoardController.boardSegs[8].setIcon(new ImageIcon(x));
            }
        }
    }
    
    private void diagonalWin(int player){
        BufferedImage x = null;
        try {
            if(player == 1){
                x = ImageIO.read(this.getClass().getResource("/Resources/xComp.png"));
            }else{
                x = ImageIO.read(this.getClass().getResource("/Resources/oComp.png"));
            }
            

        } catch (IOException ex) {
            Logger.getLogger(BoardCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int Height = BoardController.boardSegs[1].getHeight();
        int Width = BoardController.boardSegs[1].getWidth();

        x = resizedIMG(x, Width - 10, Height);
        
        if(BoardController.topLeft){
            BoardController.boardSegs[0].setIcon(new ImageIcon(x));
            BoardController.boardSegs[4].setIcon(new ImageIcon(x));
            BoardController.boardSegs[8].setIcon(new ImageIcon(x));
        }
        
        if(BoardController.botLeft){
            BoardController.boardSegs[6].setIcon(new ImageIcon(x));
            BoardController.boardSegs[4].setIcon(new ImageIcon(x));
            BoardController.boardSegs[2].setIcon(new ImageIcon(x));
        }
    }

}
