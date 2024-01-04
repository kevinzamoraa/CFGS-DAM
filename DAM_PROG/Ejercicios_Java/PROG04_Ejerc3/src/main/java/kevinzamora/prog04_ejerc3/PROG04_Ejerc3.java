/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kevinzamora.prog04_ejerc3;

import java.util.Scanner;

/**
 *
 * @author kzdesigner
 */
public class PROG04_Ejerc3 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduce dos números y obtén su Minimo Común Múltiple: \n");
        System.out.println("Introduce el primer número: ");
        int num1 = scanner.nextInt();
        System.out.println("Introduce el segundo número: ");
        int num2 = scanner.nextInt();
        if (num1 < 0 || num2 < 0) { System.out.println("Alguno de los números introducidos NO resulta válido"); }
        else {
            int leastCommunMultiple = mcm(num1, num2);
            System.out.println("El mínimo común multiple de los números introducidos es: " + leastCommunMultiple);
        }
        
    }
    
    public static int mcm(int number1, int number2) {
    if (number1 == 0 || number2 == 0) {
        return 0;
    }
    int absNumber1 = Math.abs(number1);
    int absNumber2 = Math.abs(number2);
    int absHigherNumber = Math.max(absNumber1, absNumber2);
    int absLowerNumber = Math.min(absNumber1, absNumber2);
    int mcm = absHigherNumber;
    while (mcm % absLowerNumber != 0) {
        mcm += absHigherNumber;
    }
    return mcm;
}
}
