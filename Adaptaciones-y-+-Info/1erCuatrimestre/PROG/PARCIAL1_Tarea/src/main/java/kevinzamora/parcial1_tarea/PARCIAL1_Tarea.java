/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kevinzamora.parcial1_tarea;

import PARCIAL1_util.pisoRepo;
import PARCIAL1.Piso;
import PARCIAL1.Principal;
import java.util.Scanner;

/**
 *
 * @author kzdesigner
 */
public class PARCIAL1_Tarea {
    
    Piso pisoCreado;
    Principal principalObj = new Principal();

    public static void main(String[] args) {
        
        PARCIAL1_Tarea parcial1Obj = new PARCIAL1_Tarea();
        parcial1Obj.loadMainMenuImp();        
        
    }

    public void loadMainMenuImp() {
        principalObj.loadMainMenuImp();
    }
    
}
