/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARCIAL1;

import PARCIAL1_util.pisoRepo;

/**
 *
 * @author kzdesigner
 */
public class Principal {
    
    pisoRepo pisoObj = new pisoRepo();
    
    public static void main(String[] args) {
        
        Principal principalObj = new Principal();
        principalObj.loadMainMenuImp();
            
    }
    
    public void loadMainMenuImp() {
        pisoObj.loadMainMenu();
    }
}
