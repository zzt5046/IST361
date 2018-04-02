/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist361;

import java.io.Serializable;

/**
 *
 * @author Zach
 */
public class CalorieLimit implements Serializable{
    
    User currentUser;
    int cals;
    
    public CalorieLimit(User user, int calories){
        
        currentUser = user;
        cals = calories;
    }
    
    void setLimit(int calories){
        
        cals = calories;
    }
    
    int getLimit(){
        return cals;
    }
}
