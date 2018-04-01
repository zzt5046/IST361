/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist361;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Zach
 */
public class ExerciseEntryBackend {
    
    User currentUser;
    
    public ExerciseEntryBackend(User currentUser){
        this.currentUser = currentUser;
        System.out.println("--ExerciseEntryBackend Instantiated");
    }
    
    void addExerciseEntry(String title, double hours, String date, String desc) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        ExerciseEntry entry = new ExerciseEntry(title, hours, date, desc);
        
        ExerciseEntryCtrl ctrl = new ExerciseEntryCtrl(currentUser);
        ctrl.addEntry(entry);
    }
}
