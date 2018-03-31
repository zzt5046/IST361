/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist361;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Zach
 */

public class LoginBackend {
    
    UserCtrl ctrl;
    
    public LoginBackend(){
        System.out.println("--LoginBackend Instantiated");
    }
    
    void authenticateUser(String username, String password) throws IOException, ClassNotFoundException{
        
        boolean auth = false;
        User authedUser = null;
        
        try{
            FileInputStream fiStream = new FileInputStream("users/" + username + ".ser");
            ObjectInputStream oiStream = new ObjectInputStream(fiStream);
               
            User userFile = (User) oiStream.readObject();
            
            if(userFile.getPassword().equals(password)){
                auth = true;
                authedUser = userFile;
            }
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "User does not exist.");
        }
        
        if(auth){
            MainMenuFrame mainMenu = new MainMenuFrame(authedUser);
        }
        else{
            LoginFrame login = new LoginFrame();
        }
    }
}
