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
public class ExerciseEntryList implements Serializable{
    
    User currentUser;
    ArrayList<ExerciseEntry> entries;
    
    public ExerciseEntryList(User user, ExerciseEntry firstEntry){
        
        currentUser = user;
        entries = new ArrayList<ExerciseEntry>();
        entries.add(firstEntry);
    }
    
    public ExerciseEntryList(){
        
    }
    
    void addEntry(ExerciseEntry entry){
        entries.add(entry);
    }
    
    ArrayList<ExerciseEntry> getList(){
        return entries;
    }
    
    User getUser(){
        return currentUser;
    }
}
