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
public class CalorieEntryCtrl {
    
    User currentUser;
    
    public CalorieEntryCtrl(User user){
        
        currentUser = user;
    }
    
    public CalorieEntryCtrl(){
        
    }
    
    void saveList(CalorieEntryList list){
        
        try{
        
            //saving object data to file
            File saveFile = new File("data/" + currentUser.getUsername() + "CalorieList.ser");
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(saveFile));
            out.writeObject(list);
            
            System.out.println(currentUser.getUsername() + "'s calorie entries stored.");
            
        }catch(FileNotFoundException missingFile){
            
            JOptionPane.showMessageDialog(null, "Error regarding save file.","Error",JOptionPane.ERROR_MESSAGE);
            
        }catch(IOException ioExcept){
            ioExcept.printStackTrace();
            JOptionPane.showMessageDialog(null, "Something went wrong.","Error",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    CalorieEntryList getList(User user) throws FileNotFoundException, IOException, ClassNotFoundException{
        
        File folder = new File("data/");
        String targetFile = user.getUsername() + "CalorieList.ser";
        CalorieEntryList entryList = null;
        
        try{
            File[] listOfFiles = folder.listFiles();
        
        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().equals(targetFile)) {
                
                //find file and read object info

                FileInputStream fiStream = new FileInputStream(folder + "/" + file.getName());
                ObjectInputStream oiStream = new ObjectInputStream(fiStream);
                
                //Cast object and add to arraylist
                CalorieEntryList dataFile = (CalorieEntryList) oiStream.readObject();
                entryList = dataFile;
                
                fiStream.close();
                oiStream.close();
                break;
            }
        }
        }catch(NullPointerException ex){
            ex.printStackTrace();
        }
        
        return entryList;
    }
    
    void addEntry(CalorieEntry entry) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        CalorieEntryList list = getList(currentUser);
        
        if(list == null){
            CalorieEntryList newList = new CalorieEntryList(currentUser, entry);
            saveList(newList);
        }
        
        else{
            list.addEntry(entry);
            saveList(list);
        }
    }
}
