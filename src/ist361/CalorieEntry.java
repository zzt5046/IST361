package ist361;

import java.io.Serializable;

/**
 *
 * @author Zach
 */
public class CalorieEntry implements Serializable{

    int calorieAmount;
    String description;
    String date;

    public CalorieEntry(int amount, String dateString, String desc){

        calorieAmount = amount;
        description = desc;
        this.date = dateString;
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