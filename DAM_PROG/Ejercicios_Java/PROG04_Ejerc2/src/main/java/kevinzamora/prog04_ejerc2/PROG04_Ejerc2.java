/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package kevinzamora.prog04_ejerc2;

import java.util.Scanner;

/**
 *
 * @author kzdesigner // Autor y nombre del equipo de Kevin Zamora Amela
 */
// Clase contenedora del ejercicio 2 de la tarea PROG04
public class PROG04_Ejerc2 {

    public static void main(String[] args) {

        // Declaración e inicialización del lector de teclado
        Scanner scanner = new Scanner(System.in);

        // Mensaje explicativo
        System.out.print("Programa para comprobar si el número es positivo \n "
                + "o negativo y si es positivo, entonces también muestra si es o no primo. \n "
                + "El programa termina tras procesar 5 números \n");

        int i = 1;
        // Número de ciclos/números procesados definidos por el enunciado del ejercicio
        while (i <= 5) { // Primer bucle: dedicado a repetir el proceso las veces indicadas
            // Solicitamos y leemos el número vía teclado
            System.out.print("\n Introduce un número: \n");
            int num = scanner.nextInt();
            // Incrementamos en una unidad el índice condicional
            i++;
            // Comprobamos que dicho número no sea negativo, en cuyo caso finalizará nuestro programa
            if (num < 0) {
                System.out.println("\n El número es negativo");
            } else { /* En su defecto, procedemos a realizar si es o no un número primo, tras verificar 
                que es positivo */
                /* Declaramos e inicializamos una variable de tipo 'boleano' la cual modulará qué 
                mensaje mostrar al/a la usuario/a */
                boolean isPrimeN = false;
                for (int j = 2; j <= num / 2; ++j) {
                    // Evaluamos la condición inversa, en nuestro caso: que sea un número NO PRIMO
                    if (num % j == 0) { /* Si el residuo de la división entre el número y el indice iterado
                        resulta cero, podremos concluir que dicho número es primo */
                        isPrimeN = true;
                        break;
                    }
                }
                // Mostramos distinto mensaje según si es o no un número primo
                if (!isPrimeN) {
                    System.out.println(num + " es un número primo ");
                } else {
                    System.out.println(num + " no es un número primo ");
                }
            }
        }
    }
}
