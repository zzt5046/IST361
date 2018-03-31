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
public class UserCtrl {
    
    User currentUser;
    
    public UserCtrl(){
        System.out.println("--UserCtrl instantiated");  
    }
    
    public UserCtrl(User user){
        
        currentUser = user;
        System.out.println("--UserCtrl instantiated");
    }
    
    void setUsername(String name){
        currentUser.setUsername(name);
    }
    
    void setPassword(String pass){
        currentUser.setPassword(pass);
    }
    
    User getUser(String username) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        UserCtrl ctrl = new UserCtrl();
        ArrayList<User> users = ctrl.getAllUsers();
        User selected = null;
        
        if(users.isEmpty()){System.out.println("the error is here");}
        for(int x = 0; x < users.size(); x++){
            if(username.equals(users.get(x).getUsername())){
                selected = users.get(x);
            }
        }
        return selected;
    }
    
    ArrayList<User> getAllUsers() throws FileNotFoundException, IOException, ClassNotFoundException{
        
        ArrayList<User> users = new ArrayList<>();
        
        File folder = new File("users/");
        
        try{
            File[] listOfFiles = folder.listFiles();
        
        for (File file : listOfFiles) {
            if (file.isFile()) {
                
                //find file and read object info

                FileInputStream fiStream = new FileInputStream(folder + "/" + file.getName());
                ObjectInputStream oiStream = new ObjectInputStream(fiStream);
                
                //Cast object and add to arraylist
                User userFile = (User) oiStream.readObject();
                users.add(userFile);
                
                fiStream.close();
                oiStream.close();
            }
        }
        }catch(NullPointerException ex){
            ex.printStackTrace();
        }
        return users;     
    }
    
    void register(String username, String password){
        
        try{
        
            User newUser = new User(username, password);
            
            //saving object data to file
            File saveFile = new File("users/" + username + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(saveFile));
            out.writeObject(newUser);
            
            System.out.println(newUser.getUsername() + "'s user info stored.");
            
        }catch(FileNotFoundException missingFile){
            
            JOptionPane.showMessageDialog(null, "Error regarding save file.","Error",JOptionPane.ERROR_MESSAGE);
            
        }catch(IOException ioExcept){
            
            JOptionPane.showMessageDialog(null, "Something went wrong.","Error",JOptionPane.ERROR_MESSAGE);
            
        }
    }
}
