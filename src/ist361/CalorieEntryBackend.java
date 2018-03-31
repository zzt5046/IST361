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
class CalorieEntryBackend {
    
    User currentUser;
    
    public CalorieEntryBackend(User currentUser){
        this.currentUser = currentUser;
        System.out.println("--CalorieEntryBackend Instantiated");
    }
    
    void addCalorieEntry(int cals, String date, String desc) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        CalorieEntry entry = new CalorieEntry(cals, date, desc);
        
        CalorieEntryCtrl ctrl = new CalorieEntryCtrl(currentUser);
        ctrl.addEntry(entry);
    }
}
