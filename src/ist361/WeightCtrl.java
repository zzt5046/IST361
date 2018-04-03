/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist361;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Zach
 */
public class WeightCtrl {
    
    User currentUser;
    
    public WeightCtrl(User currentUser){
        this.currentUser = currentUser;
    }
    
    public WeightCtrl(){
        
    }
    
    void saveData(WeightEntry data){
        
        try{
            
            //saving object data to file
            File saveFile = new File("users/" + currentUser.getUsername() + "WeightList.ser");
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(saveFile));
            out.writeObject(data);
            
            System.out.println(currentUser.getUsername() + "'s weight data stored.");
            
        }catch(FileNotFoundException missingFile){
            
            JOptionPane.showMessageDialog(null, "Error regarding save file.","Error",JOptionPane.ERROR_MESSAGE);
            
        }catch(IOException ioExcept){
            
            JOptionPane.showMessageDialog(null, "Something went wrong.","Error",JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    
    WeightEntry getWeightData(User user) throws FileNotFoundException, IOException, ClassNotFoundException{
        
        File folder = new File("data/");
        String targetFile = currentUser.getUsername() + "WeightList.ser";
        WeightEntry entry = null;
        
        try{
            File[] listOfFiles = folder.listFiles();
        
        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().equals(targetFile)) {
                
                //find file and read object info

                FileInputStream fiStream = new FileInputStream(folder + "/" + file.getName());
                ObjectInputStream oiStream = new ObjectInputStream(fiStream);
                
                //Cast object and add to arraylist
                WeightEntry data = (WeightEntry) oiStream.readObject();
                entry = data;
                
                fiStream.close();
                oiStream.close();
                break;
            }
        }
        }catch(NullPointerException ex){
            ex.printStackTrace();
        }
        
        return entry; 
        
    }
}
