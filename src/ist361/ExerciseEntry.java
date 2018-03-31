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
public class ExerciseEntry implements Serializable{
    
    double hourTime;
    String date;
    String description;
    
    public ExerciseEntry(double hours, String date, String desc){
        
        hourTime = hours;
        this.date = date;
        description = desc;
    }
    
    void setTime(int hours){
        
        hourTime = hours;
    }
    
    void setDate(String date){
        
        this.date = date;
    }
    
    void setDescription(String desc){
        
        description = desc;
    }
    
    double getTime(){
        return hourTime;
    }
    
    String getDate(){
        return date;
    }
    
    String getDesc(){
        return description;
    }
}
