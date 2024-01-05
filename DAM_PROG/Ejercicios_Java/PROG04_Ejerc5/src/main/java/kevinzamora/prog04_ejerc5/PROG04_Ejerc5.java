/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package kevinzamora.prog04_ejerc5;

import java.util.Scanner;

/**
 *
 * @author kzdesigner
 */
public class PROG04_Ejerc5 {

    int numDivRealizadas = 0;
    float resultadoDivision;

    public static void main(String[] args) {

        PROG04_Ejerc5 myClass = new PROG04_Ejerc5();
        try {
            myClass.dividir();
        } catch (ArithmeticException e) {
            System.out.println("ERROR: NO ES POSIBLE DIVIDIR UN NÚMERO ENTRE CERO \n ¡HASTA PRONTO!");
        } catch (Exception e) {
            System.out.println("SE HA PRODUCIDO UN ERROR DESCONOCIDO");
        }

    }

    private void dividir() {

        Scanner scanner = new Scanner(System.in);
        int dividendo = 6;
        int divisor = 2;

        while ((dividendo / divisor) != -1) {
            System.out.println("\n CALCULANDO TÚ DIVISIÓN: \n ¡VAMOS ALLÁ! \n");
            System.out.println("INTRODUCE EL DIVIDENDO (Número Entero):");
            dividendo = scanner.nextInt();
            System.out.println("INTRODUCE EL DIVISOR (Número Entero):");
            divisor = scanner.nextInt();

            resultadoDivision = dividendo / divisor;
            numDivRealizadas++;

            System.out.println("RESULTADO DE LA DIVISIÓN ENTRE " + dividendo
                    + " Y " + divisor + ": " + resultadoDivision);
            System.out.println("\n DIVISIONES REALIZADAS: " + numDivRealizadas);
        }
    }
}
