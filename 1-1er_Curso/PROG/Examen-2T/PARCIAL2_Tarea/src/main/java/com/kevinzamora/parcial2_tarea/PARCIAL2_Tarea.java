/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.kevinzamora.parcial2_tarea;

import vista.MainMenu;

/**
 *
 * @author kzdesigner
 */
public class PARCIAL2_Tarea {

    public static void main(String[] args) {
        
        MainMenu mainMenuObj = new MainMenu();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }
        
}
