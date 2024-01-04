/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kevinzamora.prog04_ejerc1;

import java.util.Scanner;

/**
 *
 * @author kzdesigner
 */
public class PROG04_Ejerc1 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce un número entero (<30) y obtén su tabla de multiplicar: ");
        int num = scanner.nextInt();
        if(num > 30) { System.out.println("El número introducido no es válido"); } 
        else {
            System.out.println("\n El número introducido tiene un formato correcto y es: " + num);
            System.out.println("\n Usando un bucle FOR: \n");
            int i;
            for(i = 0; i <= 10; i++) {
                System.out.printf("%d * %d = %d \n", num, i, num * i);
            }
            System.out.println("\n Usando un bucle WHILE: \n");
            i = 0;
            while(i <= 10) {
                System.out.printf("%d * %d = %d \n", num, i, num * i);
                i++;
            }
            System.out.println("\n Usando un bucle DO WHILE: \n");
            i = 0;
            do {
                System.out.printf("%d * %d = %d \n", num, i, num * i);
                i++;
            } while (i <= 10);
        }
    }
}
