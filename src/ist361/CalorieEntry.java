package ist361;

import java.io.Serializable;

/**
 *
 * @author Zach
 */
public class CalorieEntry implements Serializable{

    String title;
    int calorieAmount;
    String description;
    String date;

    public CalorieEntry(String title, int amount, String dateString, String desc){

        this.title = title;
        calorieAmount = amount;
        description = desc;
        this.date = dateString;
    }
    
    void setTitle(String name){
        title =name;
    }
    
    void setCalories(int cals){
        calorieAmount = cals;
    }
    
    void setDescription(String desc){
        description = desc;
    }
    void setDate(String dateString){
        this.date = dateString;
    }
    
    String getTitle(){
        return title;
    }
    
    int getCalories(){
        return calorieAmount;
    }
    
    String getDescription(){
        return description;
    }
    
    String getDate(){
        return this.date;
    }
    
}