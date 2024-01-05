/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package kevinzamora.prog04_ejerc5;

import java.util.Scanner;

/**
 *
 * @author kzdesigner // Autor y nombre del equipo de Kevin Zamora Amela
 */
// Esta es la clase que contiene el desarrollo del ejercicio 5 de la tarea PROG04
public class PROG04_Ejerc5 {
    
    // Declaramos las variables que deben gozar de algo más de persistencia y ser accesibles desde cualquier función
    int numDivRealizadas = 0;
    float resultadoDivision;

    public static void main(String[] args) {
        
        /* Lamada/Ejecución de la función 'dividir' desde la función statica 'main', 
        la cual es cargada automáticamente al inicio de la ejecución */ 
        PROG04_Ejerc5 myClass = new PROG04_Ejerc5();
        // Añadimos el método 'try catch' para capturar los posibles errores en tiempo de ejecución
        try {
            myClass.dividir();
        } catch (ArithmeticException e) { // Este 'catch' captura el tipo de error requerido en el Ej.
            System.out.println("ERROR: NO ES POSIBLE DIVIDIR UN NÚMERO ENTRE CERO \n ¡HASTA PRONTO!");
        } catch (Exception e) { // Este otro 'catch' mucho más genérico captura el resto de errores posibles
            System.out.println("SE HA PRODUCIDO UN ERROR DESCONOCIDO");
        }

    }
    
    /* Función llamada desde la función 'main' para realizar el proceso de solicitud de los datos al usuario
    y su consiguiente procesado de dichos datos, realizando la división de los números/parámetros introducidos
    vía teclado/consola */
    private void dividir() {

        /* Inicializamos las variables necesarias y a usar en la función 'dividir':
        (1) El método para la lectura de parametros/variables desde el teclado
        (2) Y dos variables necesarias en este caso práctico: dividendo y divisor */
        Scanner scanner = new Scanner(System.in);
        int dividendo = 6;
        int divisor = 2;

        while ((dividendo / divisor) != -1) { /* Construimos el bucle para que se ejecute mientras el resultado 
            sea diferente del valor '-1' */
            // Añadimos los títulos pertinentes
            System.out.println("\n CALCULANDO TÚ DIVISIÓN: \n ¡VAMOS ALLÁ! \n");
            System.out.println("INTRODUCE EL DIVIDENDO (Número Entero):");
            // Realizamos la lectura del parámetro introducido mediante teclado y acto seguido
            dividendo = scanner.nextInt();
            System.out.println("INTRODUCE EL DIVISOR (Número Entero):");
            // Volvemos a leer el parámetro vía teclado
            divisor = scanner.nextInt();
            
            // Realizamos la división de los números introducidos
            resultadoDivision = dividendo / divisor;
            // Incrementamos el contador de divisiones realizadas en una unidad
            numDivRealizadas++;
            
            // Mostramos el resultado en pantalla
            System.out.println("RESULTADO DE LA DIVISIÓN ENTRE " + dividendo
                    + " Y " + divisor + ": " + resultadoDivision);
            // Mostramos el valor actual del contador de divisiones calculadas
            System.out.println("\n DIVISIONES REALIZADAS: " + numDivRealizadas);
        }
    }
}
