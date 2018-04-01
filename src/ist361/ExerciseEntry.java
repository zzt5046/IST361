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
    
    String title;
    double hourTime;
    String date;
    String description;
    
    public ExerciseEntry(String title, double hours, String date, String desc){
        
        this.title = title;
        hourTime = hours;
        this.date = date;
        description = desc;
    }
    
    void setTitle(String name){
        
        title = name;
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
    
    String getTitle(){
        return title;
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
