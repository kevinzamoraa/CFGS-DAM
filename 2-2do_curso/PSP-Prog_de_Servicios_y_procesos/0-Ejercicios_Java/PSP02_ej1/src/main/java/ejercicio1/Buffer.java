/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import java.util.logging.*;

/**
 *
 * Clase/Entidad 'Buffer' dedicada a la gestión de la memoria y también a la 
 * administración de los 'turnos' de lectura y escritura
 * @author kzdesigner
 */
public class Buffer {
    
    // Definición de variables
    private char[] buffer;
    private int next;
    private boolean itsFullFilled;
    private boolean itsEmpty;
    
    /** 
     * Constructor de clase 
     * @param size Tamaño de nuestro buffer
     */
    public Buffer(int size) {
    
        this.buffer = new char[size];
        this.next = 0;
        this.itsFullFilled = false;
        this.itsEmpty = true;
        
    }
    
    /** 
     *
     * Método 'Consumir' dedicado a capturar un nuevo caracter.
     * Retorna un 'synchronized char'
     */
    public synchronized char consumir() {
    
        // Bucle para gestionar los "turnos" para consumir/producir
        while (this.itsEmpty) {
        
            // Creamos un método de control de excepciones "try catch" para 
            // capturar posibles errores durante la ejecución
            try {
                wait(); // Método 'nativo' para bloquear el buffer
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
                           
        }
        
        // Restamos una unidad a la variable 'next'(o siguiente). Esta variable 
        // nos sirve para gestionar la escritura y el espacio disponible en 
        // nuestro 'buffer'(o memoria volátil)
        this.next--;
        
        // Gestionamos cuando está vacio nuestro 'buffer'
        this.itsFullFilled = false;
            
        if (this.next == 0) {
            this.itsEmpty = true;   
        }
        
        // Notificamos a todos los procesos que estén a la espera para que pueda 
        // comenzar el siguiente
        notifyAll();
        
        // Retornamos nuestro 'buffer' y almacenamos en este el siguiente valor
        return this.buffer[this.next];
            
    }
    
    /** 
     *
     * Método 'Producir' dedicado a capturar un nuevo caracter.
     * Retorna un 'synchronized void'(o vacio sincronizado)
     * @param c Caracter seleccionado
     */
    public synchronized void producir(char c) {
    
        // Comprobamos si el 'buffer' está lleno
        while (this.itsFullFilled) {
        
            // Definimos un método de control de excepciones 'try catch' para 
            // capturar los posibles errores que se puedan dar durante su ejecución
            try {
                wait(); // Método 'nativo' para bloquear el 'buffer'
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
        // Escribimos el caracter en la siguiente posición de nuestro 'buffer'
        this.buffer[this.next] = c;
        
        // Añadimos una unidad a la variable 'next'(o siguiente)
        this.next++;
        // Definimos que nuestro 'buffer' no está vacio
        this.itsEmpty = false;
        
        // Cambiamos el estado de nuestro 'buffer' a 'lleno' cuando la posición 
        // siguiente sea la última disponible en nuestro 'buffer'
        if(this.next == this.buffer.length) {
            this.itsFullFilled = true; // El buffer 'está' lleno
        }
        
        // Notificamos que se puede volver a escribir/producir
        notifyAll();
        
    }
    
}
