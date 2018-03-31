/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//HLTH-E

package ist361;

import java.io.File;

/**
 *
 * @author Zach
 */
public class runApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        checkDirectories();
        LoginFrame login = new LoginFrame();
    }

     static void checkDirectories() {
         
        File userDirectory = new File("users/");
        File dataDirectory = new File("data/");
        
        if (!userDirectory.exists()){
            userDirectory.mkdir();
        }
        
        if (!dataDirectory.exists()){
            dataDirectory.mkdir();
        }
    }
    
}
