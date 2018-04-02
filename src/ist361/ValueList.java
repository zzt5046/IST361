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
public class ValueList implements Serializable{
    
    User currentUser;
    CalorieLimit limit;
    ExerciseGoal goal;

    
    public ValueList(User user, CalorieLimit calorieLimit, ExerciseGoal exerciseGoal){
        
        currentUser = user;
        this.limit = calorieLimit;
        this.goal = exerciseGoal;
    }
    
    void setCalorieLimit(CalorieLimit newLimit){
        
        limit = newLimit;
    }
    
    void setExerciseGoal(ExerciseGoal newGoal){
        
        goal = newGoal;
    }
    
    CalorieLimit getCalorieLimit(){
        return limit;
    }
    
    ExerciseGoal getExerciseGoal(){
        return goal;
    }
    
    User getUser(){
        return currentUser;
    }
}
