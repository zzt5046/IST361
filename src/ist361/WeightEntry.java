package ist361;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zach
 */
public class WeightEntry {
    
    User currentUser;
    int weight;
    
    public WeightEntry(User currentUser, int weight){
        
        this.currentUser = currentUser;
        this.weight = weight;
    }
    
    void setWeight(int x){
        weight = x;
    }
    
    int getWeight(){
        return weight;
    }
}
