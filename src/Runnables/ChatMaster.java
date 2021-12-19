/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runnables;

import Controllers.ChatController;
import Controllers.PlayerController;
import Models.ChatModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zachm
 */
public class ChatMaster implements Runnable {

    @Override
    public void run() {
        ChatController chatCont = new ChatController();
        boolean alreadySaid = false;

        List<ChatModel> chat = chatCont.getAllItemsFromDatabase();
        while(true){
            if(PlayerController.turn && !alreadySaid && !BoardCheck.winFound){
                ChatController.insert("HAS NEXT MOVE");
                alreadySaid = true;
            }else if(!PlayerController.turn){
                alreadySaid = false;
            }
            
            
            //DELAY TO SAVE RESOURCE 
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            List<ChatModel> chatTemp = chatCont.getAllItemsFromDatabase();
             
           
            if(chat.size() != chatTemp.size()){
                chat = chatTemp;
                System.out.println("INCOMING CHAT");
                ChatController.chat = chatTemp;
                ChatController.chatHandel();
               
                replaceVals(chat,chatTemp);
                
            }else{
                
            }

            
        }
    }
    
    
    public void replaceVals(List<ChatModel> chat1, List<ChatModel> chat2){
        chat1= new ArrayList<ChatModel>();
        chat1.addAll(chat2);
        
    }
}
