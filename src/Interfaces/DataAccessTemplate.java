/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;

/**
 *
 * @author zachm
 */
public interface DataAccessTemplate<ITEM> {
    public  List <ITEM> getAllItemsFromDatabase ();
    
    public  ITEM  getItem(int  key);
    
    public  void  update(ITEM  item);
    
    public  void  delete(ITEM  item);
    
    public  void  insert(ITEM  item);
}
