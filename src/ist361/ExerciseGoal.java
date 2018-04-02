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
public class ExerciseGoal implements Serializable{
    
    User currentUser;
    double hours;
    
    public ExerciseGoal(User user, double hours){
        
        currentUser = user;
        this.hours = hours;
    }
    
    void setGoal(int hours){
        
        this.hours = hours;
    }
    
    double getGoal(){
        return hours;
    }
}
