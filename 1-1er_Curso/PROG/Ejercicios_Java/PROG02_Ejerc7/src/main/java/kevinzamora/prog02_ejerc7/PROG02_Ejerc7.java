/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kevinzamora.prog02_ejerc7;

import java.text.DecimalFormat;
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
        float C1 = scanner.nextFloat();
        
        System.out.print("\n Introduce el valor del índice C2 \n");
        float C2 = scanner.nextFloat();
        
        double resultado = (C2*-1)/C1;
        System.out.println("\n Resultado antes de aplicar el patrón de 4 decimales: " + resultado);
        
        DecimalFormat dfResult = new DecimalFormat("##.####");
        String formatedResult = dfResult.format(resultado);
        
        System.out.print("\n El resultado de la ecuación de primer grado, entre los dos índices introducidos, es: " + formatedResult);
    }
}
