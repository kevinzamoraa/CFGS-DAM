/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package kevinzamora.prog04_ejerc2;

import java.util.Scanner;

/**
 *
 * @author kzdesigner
 */
public class PROG04_Ejerc2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Programa para comprobar si el número es positivo \n o negativo y si es positivo, entonces también muestra si es o no primo. \n El programa termina tras procesar 5 números \n");

        int i = 1;
        while (i <= 5) {
            System.out.print("\n Introduce un número: \n");
            int num = scanner.nextInt();
            i++;
            if (num < 0) {
                System.out.println("\n El número es negativo");
            } else {
                boolean isPrimeN = false;
                for (int j = 2; j <= num / 2; ++j) {
                    // Condición de un número NO PRIMO
                    if (num % j == 0) {
                        isPrimeN = true;
                        break;
                    }
                }

                if (!isPrimeN) {
                    System.out.println(num + " es un número primo ");
                } else {
                    System.out.println(num + " no es un número primo ");
                }
            }
        }
    }
}
