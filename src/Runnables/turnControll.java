/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runnables;

import Conn.DBConnection;
import Controllers.PlayerController;

/**
 *
 * @author zachm
 */
public class turnControll implements Runnable {
    private boolean started = false;
    @Override
    public void run() {
        System.out.println("TURN CONTROLL");
        
        
        
        while(true){
            if(PlayerController.turn){
                
            }else if(!PlayerController.turn && !started){
                Thread t1 = new Thread(new BoardCheck());
                t1.start();
            }
        }
    }
    
}
