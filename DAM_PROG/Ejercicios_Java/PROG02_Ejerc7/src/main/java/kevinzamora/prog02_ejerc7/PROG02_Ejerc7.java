/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kevinzamora.prog02_ejerc7;

import java.util.Scanner;

/**
 *
 * @author kzdesigner
 */
public class PROG02_Ejerc7 {

    public static void main(String[] args) {
        // System.out.println("Hello World!");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce el valor del índice C1 \n");
        int C1 = scanner.nextInt();
        System.out.print("\n Introduce el valor del índice C2 \n");
        int C2 = scanner.nextInt();
        
        float resultado = (C2*-1)/C1;
        System.out.print("\n El resultado de la ecuación de primer grado, entre los dos índices introducidos, es: " + resultado);
    }
}
