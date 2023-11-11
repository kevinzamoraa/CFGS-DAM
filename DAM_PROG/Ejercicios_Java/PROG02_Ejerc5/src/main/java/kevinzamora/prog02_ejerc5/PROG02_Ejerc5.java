/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kevinzamora.prog02_ejerc5;

import java.util.Scanner;

/**
 *
 * @author kzdesigner
 */
public class PROG02_Ejerc5 {

    public static void main(String[] args) {
        // System.out.println("Hello World!");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce un número de segundos:");
        float segundosIntroducidos = scanner.nextInt();
        
        if (segundosIntroducidos >= 60) {
            segundosIntroducidos = segundosIntroducidos/60;
            System.out.print(segundosIntroducidos + " minutos \n");
            if (segundosIntroducidos >= 60) {
                segundosIntroducidos = segundosIntroducidos/60;
                System.out.print(segundosIntroducidos + " horas \n");
                if (segundosIntroducidos >= 60) {
                    segundosIntroducidos = segundosIntroducidos/60;
                    System.out.print(segundosIntroducidos + " días \n");
                }
            }
        }
    }
}
