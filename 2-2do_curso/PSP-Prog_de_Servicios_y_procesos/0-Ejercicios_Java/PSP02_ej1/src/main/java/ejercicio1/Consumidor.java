/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import static java.lang.Thread.sleep;
import java.util.logging.*;

/**
 *
 * Clase/Entidad 'Consumidor' extendiendo la clase nativa Thread y dedicada a la recogida 
 * de los diferentes carácteres.
 * @author kzdesigner
 * 
 */
public class Consumidor extends Thread {
    
    // Definición de variables
    private Buffer buffer;
    private int consumed;
    private final int LIMIT = 15;
    
    /** 
     * Constructor de clase
     * @param buffer Memoria 'buffer'
     */
    public Consumidor(Buffer buffer) {
        this.consumed = 0;
        this.buffer = buffer;
    }
    
    /** Uno de los métodos principales de nuestra aplicación. Este se encarga de 
    * ir consumiendo diferentes carácteres aleatórios desde nuestra cadena de 
    * carácteres. Dicho caracter se introduce en un "string informativo". Y tras 
    * imprimir dicho mensaje, se pausa la ejecución durante el tiempo definido.
    * 
    */
    public void run() {
    
        while (consumed < LIMIT) {
        
            // Encapsulamos esta parte del programa en un método 'try catch'
            try {
                // Consumimos un caracter y lo guardamos en una variable
                char c = buffer.consumir(); 
                // Incrementamos la variable 'consumed'(o consumido) en una unidad
                consumed++;
                // Imprimimos un mensaje insertando el caracter consumido en su interior
                System.out.println("Recogido el caracter " + c + " del 'buffer'");
                // Generamos una pausa de duración aleatoria
                sleep ((long) (Math.random() * 4000));
            } catch (InterruptedException ex) {
                // Capturamos los posibles errores de ejecución y para ello utilizamos un Logger
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
    }
    
}
