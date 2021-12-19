/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runnables;


import Conn.DBConnection;
import Controllers.GameControll;
import Controllers.PlayerController;
import Models.GameModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zachm
 */
public class openGameCheck implements Runnable {

    @Override
    public void run() {
        
        List<GameModel> holder = GameControll.getOpenGamesFromDatabase();
        while(true){ 
            
            
            String str = "";
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(openGameCheck.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            List<GameModel> temp = GameControll.getOpenGamesFromDatabase();
            
                
               // replaceVals(holder, temp);
                for(GameModel x : temp){
                    int GameId = x.getGAMEID();
                    str += "OPEN GAME: ID "+ GameId +"\n PLAYER: " + PlayerController.getPlayerName(GameId)+"\n----------------------------------\n";
                }
                
                GameControll.setOpenGameText(str);
            
        }
    }
    
    public void replaceVals(List<GameModel> chat1, List<GameModel> chat2){
        chat1= new ArrayList<GameModel>();
        chat1.addAll(chat2);
        
    }
    
}
