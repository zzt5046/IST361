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
public class WeightList implements Serializable{
    
    ArrayList<Integer> weights;
    
    public WeightList(int firstWeight){
         weights = new ArrayList<Integer>();
         weights.add(firstWeight);
    }
    
    void addWeight(int weight){
        
        weights.add(weight);
    }
    
    ArrayList<Integer> getWeightList(){
        return weights;
    }
}
