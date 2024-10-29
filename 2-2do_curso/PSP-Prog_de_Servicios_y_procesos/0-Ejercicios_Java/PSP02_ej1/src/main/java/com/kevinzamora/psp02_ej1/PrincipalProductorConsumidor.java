/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.kevinzamora.psp02_ej1;

import ejercicio1.Buffer;
import ejercicio1.Consumidor;
import ejercicio1.Productor;
import java.util.logging.*;

/**
 *
 * Clase principal de nuestro/a proyecto/aplicación. Esta contiene un método 'main'
 * y en este procedemos a inicializar/instanciar las clases/entidades necesarias 
 * para su ejecución y correcto funcionamiento.
 * @author kzdesigner
 */
public class PrincipalProductorConsumidor {

    /** 
     *
     * Este método 'main' sirve para iniciar nuestra aplicación y en su interior 
     * definimos las/los variables/objetos necesarias para su ejecución. En 
     * consecuencia, creamos una instancia/llamada hacia las clases/entidades 'Buffer', 
     * 'Productor' y 'Consumidor'. Y a su vez, también utilizamos los métodos 'start', 
     * 'Thread.sleep' y 'join', para gestionar así los 'turnos' de escrutura/lectura 
     * de nuestro 'buffer'. Por último, también añadimos el método 'try catch', 
     * dedicado al control de excepciones, para así poder prevenir y capturar 
     * posibles errores/fallos de ejecución.
     * @param args Argumentos
     */
    public static void main(String[] args) {
        
        // Encapsulamos el contenido del método principal en un método de control de 
        // excepciones 'try catch'
        try {
        
            // Creamos una instancia de las diferentes entidades de nuestra applicación
            Buffer b = new Buffer (6); // Definimos la capacidad de nuestro 'buffer' a 6
            Productor p = new Productor (b); // Insertamos el 'buffer' en la clase Productor
            Consumidor c = new Consumidor (b); // Insertar el 'buffer' en la clase Consumidor
            
            p.start(); // Empezamos el proceso del productor con el método 'start'
            Thread.sleep(3000); // Definimos un tiempo de pausa o espera
            c.start(); // Iniciamos el proceso del consumidor con el método 'start'
            
            p.join(); // Juntamos el resultado del proceso del productor y del 
                      // consumidor mediante los métodos 'join'
            c.join();
            // Mostramos por pantalla un mensaje final
            System.out.println("Termina el programa");
        
        } catch (InterruptedException ex) { // Capturamos los errores en un 'Logger'
            Logger.getLogger(PrincipalProductorConsumidor.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
    }
}
