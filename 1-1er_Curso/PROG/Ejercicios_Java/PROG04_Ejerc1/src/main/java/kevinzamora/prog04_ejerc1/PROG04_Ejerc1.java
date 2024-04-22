/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kevinzamora.prog04_ejerc1;

import java.util.Scanner;

/**
 *
 * @author kzdesigner // Autor y nombre del equipo de Kevin Zamora Amela
 */
// Esta es la clase que contiene el desarrollo del ejercicio 1 de la tarea PROG04
public class PROG04_Ejerc1 {

    public static void main(String[] args) {
        
        // Declaramos e inicializamos el lector de teclado
        Scanner scanner = new Scanner(System.in);
        
        // Añadimos los títulos explicativos oportunos
        System.out.print("Introduce un número entero (<30) y obtén su tabla de multiplicar: ");
        // Leemos mediante teclado el número para el que queremos calcular su tabla de multiplicar
        int num = scanner.nextInt();
        // Añadimos el límite condicional requerido en dicho ejercicio
        if(num > 30) { System.out.println("El número introducido no es válido"); } 
        else {
            /* En caso de que el valor se encuentre dentro del rango de valores indicado,
            procedemos a calcular su tabla de multiplicar mediante el uso de tres tipos de 
            bucle distintos: FOR, WHILE y DO WHILE*/
            System.out.println("\n El número introducido tiene un formato correcto y es: " + num);
            System.out.println("\n Usando un bucle FOR: \n");
            /* Iniciamos la variable necesaria para realizar el avance en el cálculo a través de cada
            uno de los tres bucles */
            int i;
            for(i = 0; i <= 10; i++) { /* Iteración de 0 a 10. Este bucle no tiene en consideración ninguna 
                condición externa para mediar su ejecución o no */
                /* Utilizamos la función printf para poder imprimir los datos en pantalla de forma
                estructurada, mediante el uso de un patrón con el tipo de dato decimal. Introducimos 
                cada dato en su sitio correspondiente y, en la posición del resultado, realizamos la 
                multiplicación entre el número introducido y el indice encrementado tras cada ciclo
                del recorrido del bucle bucle. Esta función resulta la misma en los tres bucles presentados*/
                System.out.printf("%d * %d = %d \n", num, i, num * i);
            }
            System.out.println("\n Usando un bucle WHILE: \n");
            // Reinicimaos a cero la variable necesaria y declarada para realizar la iteración
            i = 0;
            while(i <= 10) { /* Iteración mientras el índice i sea menor o igual a 10. Este bucle puede no 
                llegar a ejecutarse si la condición no se cumple inicialmente (la condición se evalua antes
                de empezar el bucle)*/
                System.out.printf("%d * %d = %d \n", num, i, num * i);
                i++;
            }
            System.out.println("\n Usando un bucle DO WHILE: \n");
            // Reinicimaos de nuevo a cero la variable necesaria y declarada para realizar la iteración
            i = 0;
            do { /* Operaciones a realizar hasta que se cumpla la condición de salida. Con este bucle nos
                aseguramos de que al menos se ejecutará una vez (La condición se evalua al terminar el primer 
                ciclo) */
                System.out.printf("%d * %d = %d \n", num, i, num * i);
                i++;
            } while (i <= 10);
        }
    }
}
