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
import javax.swing.JOptionPane;

/**
 *
 * @author Zach
 */
public class GoalCtrl {
    
    User currentUser;
    
    public GoalCtrl(User user){
        currentUser = user;
    }
    
    public GoalCtrl(){
        
    }
    
    void editCalories(CalorieLimit limit) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        ValueList list = getList();
        list.setCalorieLimit(limit);
        saveList(list);
    }
    
    void editExercise(ExerciseGoal goal) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        ValueList list = getList();
        list.setExerciseGoal(goal);
        saveList(list);
    }
    
    void saveList(ValueList list){
        
        try{
        
            //saving object data to file
            File saveFile = new File("data/" + currentUser.getUsername() + "Goals.ser");
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(saveFile));
            out.writeObject(list);
            
            System.out.println(currentUser.getUsername() + "'s goals stored.");
            
        }catch(FileNotFoundException missingFile){
            
            JOptionPane.showMessageDialog(null, "Error regarding save file.","Error",JOptionPane.ERROR_MESSAGE);
            
        }catch(IOException ioExcept){
            ioExcept.printStackTrace();
            JOptionPane.showMessageDialog(null, "Something went wrong.","Error",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    ValueList getList() throws FileNotFoundException, IOException, ClassNotFoundException{
        
        File folder = new File("data/");
        String targetFile = currentUser.getUsername() + "Goals.ser";
        ValueList goals = null;
        
        try{
            File[] listOfFiles = folder.listFiles();
        
        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().equals(targetFile)) {
                
                //find file and read object info

                FileInputStream fiStream = new FileInputStream(folder + "/" + file.getName());
                ObjectInputStream oiStream = new ObjectInputStream(fiStream);
                
                //Cast object and add to arraylist
                ValueList dataFile = (ValueList) oiStream.readObject();
                goals = dataFile;
                
                fiStream.close();
                oiStream.close();
                break;
            }
        }
        }catch(NullPointerException ex){
            ex.printStackTrace();
        }
        
        return goals;
    }
}
