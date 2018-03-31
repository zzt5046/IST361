/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist361;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Zach
 */
public class RegisterBackend {
   
    UserCtrl ctrl;
    
    public RegisterBackend(){
        
    }
    
    boolean registerUser(String username, String password, String confirm){
        
        ctrl = new UserCtrl();
        boolean success = false;
        
        if(password.equals(confirm)){
            ctrl.register(username, password);
            success = true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Your passwords don't match.");
        }
        
        return success;
    }
}
