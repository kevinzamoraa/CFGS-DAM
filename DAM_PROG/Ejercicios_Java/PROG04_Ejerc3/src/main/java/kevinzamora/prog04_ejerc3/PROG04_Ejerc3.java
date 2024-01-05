/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kevinzamora.prog04_ejerc3;

import java.util.Scanner;

/**
 *
 * @author kzdesigner // Autor y nombre del equipo de Kevin Zamora Amela
 */
// Clase contenedora de la resolución del ejercicio 3 de la tarea PROG04
public class PROG04_Ejerc3 {

    public static void main(String[] args) {
        
        // Declaramos e iniciamos la variable referente a nuestro lector de teclado
        Scanner scanner = new Scanner(System.in);
        
        // Mostramos los mensajes explicativos pertinentes mediante pantalla
        System.out.println("Introduce dos números y obtén su Minimo Común Múltiple: \n");
        // Solicitamos y, acto seguido, leemos el número introducido
        System.out.println("Introduce el primer número: ");
        int num1 = scanner.nextInt();
        // Repetimos dicha operación con el segundo número requerido para el cálculo del mcm de ambos
        System.out.println("Introduce el segundo número: ");
        int num2 = scanner.nextInt();
        // Verificamos que ninguno de los dos números sea igual a 0
        if (num1 < 0 || num2 < 0) { System.out.println("Alguno de los números introducidos NO resulta válido"); }
        else { /* En su defecto, calculamos su mcm mediante la función creada para ello */
            int leastCommunMultiple = mcm(num1, num2);
            // Mostramos el resultado de dicho cálculo vía pantalla
            System.out.println("El mínimo común multiple de los números introducidos es: " + leastCommunMultiple);
        }
        
    }
    
    // Función creada y encapsulada para realizar el cálculo del mínimo cómun múltiple de ambos nums. introducidos
    public static int mcm(int number1, int number2) {
    /* No me había dado cuenta de que la siguiente comprobación se encuentra duplicada en nuestro programa. La dejo 
        aquí para recalcar que todxs somos humanxs */
    if (number1 == 0 || number2 == 0) {
        return 0;
    }
    // Calculamos los números absolutos de los dos valores introducidos mediante teclado
    int absNumber1 = Math.abs(number1);
    int absNumber2 = Math.abs(number2);
    // Comprobamos cuál de los dos es el máximo y cuál es el mínimo, como valores necesarios para el cálculo
    int absHigherNumber = Math.max(absNumber1, absNumber2);
    int absLowerNumber = Math.min(absNumber1, absNumber2);
    // Definimos el mcm como el valor máximo obtenido anteriormente
    int mcm = absHigherNumber;
    // Procedemos a la iteración mientras el residuo entre el valor mínimo y el número itroducido sea distinto de 0
    while (mcm % absLowerNumber != 0) {
        /* Incrementamos el valor del valor absoluto (más grande de ambos números introducidos) en una unidad y 
        y lo asignamos a la variable 'mcm'*/
        mcm += absHigherNumber;
    }
    /* Una vez se deja de cumplir la condición del bucle, salimos de este y procedemos a devolver el valor de su 
    minimo común multiple (en forma de entero), tal y como hemos indicado en la declaración de nuestra función*/
    return mcm;
}
}
