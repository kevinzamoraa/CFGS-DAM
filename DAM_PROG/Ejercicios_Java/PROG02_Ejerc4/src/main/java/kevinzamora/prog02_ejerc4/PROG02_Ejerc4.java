/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package kevinzamora.prog02_ejerc4;

import java.util.Scanner;

/**
 *
 * @author kzdesigner
 */
public class PROG02_Ejerc4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int edadIntroducida;

        do {

            System.out.print("\n Introduce tu edad:");
            edadIntroducida = scanner.nextInt();

            switch (edadIntroducida) {
                case 0:
                    System.out.print("Eres menor de edad");
                    break;
                case 1:
                    System.out.print("Eres menor de edad");
                    break;
                case 2:
                    System.out.print("Eres menor de edad");
                    break;
                case 3:
                    System.out.print("Eres menor de edad");
                    break;
                case 4:
                    System.out.print("Eres menor de edad");
                    break;
                case 5:
                    System.out.print("Eres menor de edad");
                    break;
                case 6:
                    System.out.print("Eres menor de edad");
                    break;
                case 7:
                    System.out.print("Eres menor de edad");
                    break;
                case 8:
                    System.out.print("Eres menor de edad");
                    break;
                case 9:
                    System.out.print("Eres menor de edad");
                    break;
                case 10:
                    System.out.print("Eres menor de edad");
                    break;
                case 11:
                    System.out.print("Eres menor de edad");
                    break;
                case 12:
                    System.out.print("Eres menor de edad");
                    break;
                case 13:
                    System.out.print("Eres menor de edad");
                    break;
                case 14:
                    System.out.print("Eres menor de edad");
                    break;
                case 15:
                    System.out.print("Eres menor de edad");
                    break;
                case 16:
                    System.out.print("Eres menor de edad");
                    break;
                case 17:
                    System.out.print("Eres menor de edad");
                    break;
                default:
                    System.out.print("Eres mayor de edad");
                    break;

            }

        } while (edadIntroducida <= 18);
    }
}
