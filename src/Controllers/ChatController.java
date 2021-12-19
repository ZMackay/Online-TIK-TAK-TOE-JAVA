/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Conn.DBConnection;
import Interfaces.DataAccessTemplate;
import Models.ChatModel;
import Runnables.ChatMaster;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTextArea;
/**
 *
 * @author zachm
 */
public class ChatController implements DataAccessTemplate<ChatModel>{
    
    public static JTextArea chatBox;
    public static boolean started = false;
    
    public ChatController(){
       
    }

    @Override
    public List<ChatModel> getAllItemsFromDatabase() {
        try{
            List<ChatModel> chat = new ArrayList<ChatModel>();
            PreparedStatement pstmt = DBConnection.con.prepareStatement("SELECT * FROM CHAT WHERE GAMEID = ?");
            pstmt.setInt(1, GameControll.instanceGameID);
            ResultSet rset = pstmt.executeQuery();

            if (rset != null) {
                while (rset.next()) {
                    ChatModel model = new ChatModel();
                    model.setChat_ID(rset.getInt("chat_ID"));
                    model.setGAMEID(rset.getInt("GAMEID"));
                    model.setMSG(rset.getString("MSG"));
                    chat.add(model);
                }
            }
            return chat;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ChatModel getItem(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ChatModel item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(ChatModel item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public static void insert(String msg) {
        try{
            PreparedStatement pstmt = DBConnection.con.prepareStatement("INSERT INTO CHAT(GAMEID,MSG) VALUES (?,?)");
            pstmt.setInt(1, GameControll.instanceGameID);
            pstmt.setString(2, PlayerController.getPlayerName()+": "+msg);
            pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insert(ChatModel item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static List<ChatModel> chat;
    
    public static void chatHandel(){
        String completeBox = "";
        
        for(int i =0; i < chat.size(); i++){
            
            completeBox += chat.get(i).getMSG()+"\n";
            
            System.out.println(completeBox);
        }
        
        chatBox.setText(completeBox);
        
    }
        Thread chatThread = null;
    public void startChat(JTextArea chatbox){
        chatBox = chatbox;
        
        if(started){
           
        }else{
        chatThread = new Thread(new ChatMaster());
        chatThread.start();
        started = true;
        }
        
        
        
        
        
        
    }
    
    
    
}
