/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist361;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Zach
 */
class CalorieEntryList implements Serializable{
    
    User currentUser;
    ArrayList<CalorieEntry> entries;
    
    public CalorieEntryList(User user, CalorieEntry firstEntry){
        
        currentUser = user;
        entries = new ArrayList<CalorieEntry>();
        entries.add(firstEntry);
    }
    
    public CalorieEntryList(){
        
    }
    
    void addEntry(CalorieEntry entry){
        entries.add(entry);
    }
    
    ArrayList<CalorieEntry> getList(){
        return entries;
    }
    
    User getUser(){
        return currentUser;
    }
    
}
