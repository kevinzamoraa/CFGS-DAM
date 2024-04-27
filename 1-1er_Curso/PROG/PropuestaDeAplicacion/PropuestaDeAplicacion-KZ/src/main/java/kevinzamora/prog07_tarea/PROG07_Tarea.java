/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kevinzamora.prog07_tarea;

import kevinzamora.prog07_tarea.View.MainMenu;
//import kevinzamora.prog07_tarea.View.Principal;

/**
 *
 * @author kzdesigner
 */
public class PROG07_Tarea {

    public static void main(String[] args) {
//        Principal principalObj = new Principal();
//        principalObj.loadMainMenu();
        
MainMenu mainMenuObj = new MainMenu();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }
    
}
