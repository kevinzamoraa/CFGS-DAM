/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import java.util.logging.*;

/**
 *
 * Clase 'Productor', encargada de extraer de forma aleatoria un caracter de dentro 
 * de una colección con las letras del alfabeto. A su vez, también se realiza la 
 * gestión de los turnos de lectura/escritura en el 'buffer'.
 * @author kzdesigner
 */
public class Productor extends Thread {
    
    // Definición de variables
    private Buffer buffer;
    private final String letters = "abcdefghijklmnopqrstuvwxyz";
    private int produced;
    private final int LIMIT = 15;
    
    // Constructor de clase
    public Productor(Buffer buffer) {
        this.produced = 0;
        this.buffer = buffer;
    }
    
    // Método principal de la clase Productor para ejecutar el proceso de escritura
    public void run() {
    
        while (produced < LIMIT) {
            
            // Controlamos y capturamos los posibles errores
            try {
                // Extraemos una letra aleatoria y la guardamos en la variable c
                char c = letters.charAt((int) (Math.random() * letters.length()));
                // Ejecutamos el método encargado a escribir un nuevo caracter
                buffer.producir(c);
                // Incrementamos la variable 'produced'(producida) en una unidad
                produced++;
                // Imprimir un mensaje por terminal y añadir el caracter generado
                System.out.println("Depositado el caracter " + c + " del 'buffer'");
                // Generamos una pausa o interrupción de duración aleatoria
                sleep ((long) (Math.random() * 4000));
            // Capturamos los posibles errores y los almacenamos en un logger
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
    }
    
}
