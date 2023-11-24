/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kevinzamora.prog03_ejerc1;

import java.util.Scanner;
import nuevo_paquete.prog03_Ejerc1.Fecha;

/**
 *
 * @author kzdesigner
 */
public class PROG03_Ejerc1 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        Fecha introducedDate = new Fecha();
        
        int introducedDay;
        //enum includedMonth = introducedDate.getMonth();
        int introducedYear;
               
        System.out.println("Introduce el día deseado (Número Entero):");
        introducedDay = scanner.nextInt();
        System.out.println("\n Introduce el mes deseado (Escribe el nombre de un mes)");
        //introducedMonth = scanner.nextLine();
        
        //Fecha fecha = new Fecha();
        //System.out.println(Fecha);
    }
}
