/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kevinzamora.prog02_ejerc9;

import java.util.Scanner;

/**
 *
 * @author kzdesigner
 */
public class PROG02_Ejerc9 {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce un año y averigua si este es/fue bisiestos: \n");
        int introducedYear = scanner.nextInt();
        
        if ((introducedYear % 4 == 0) && ((introducedYear % 100 != 0) || (introducedYear % 400 == 0))) {
            System.out.println("Es/Fue año bisiesto");
        } else {
            System.out.println("NO es/fue año bisiesto");
        }
        
    }
}
