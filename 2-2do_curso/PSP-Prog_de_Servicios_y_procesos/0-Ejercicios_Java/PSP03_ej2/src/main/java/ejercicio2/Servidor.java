/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import ejercicio2.HiloServidor;
import ejercicio2.Cliente;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * Clase/Entidad Servidor dedicada a iniciar nuestro servidor.
 * @author kzdesigner
 */
public class Servidor {
    
    /** 
     * Método 'main' dedicado a establecer e iniciar nuestro servidor.
     * @param args Argumentos
     */
    public static void main(String[] args) {
        
        /** 
         * Definimos un método de control de excepciones 'try catch'
         */
        try {
            /** 
             * Definimos una variable 'servidor' de tipo 'ServerSocket' y le pasamos 
             * como parámetro el puerto 1500.
             */
            ServerSocket servidor = new ServerSocket(1500);
            System.out.println("Se ha iniciado el servidor");
            
            /** 
             * Bucle 'mientras' para ejecutar el programa mientras sea verdadero.
             */
            while(true) {
            
                /** Definición de la variable sc, a la cual se le asigna el 
                 método 'aceptar' del servidor. */
                Socket sc = servidor.accept();
                
                /** Creamos una instancia de la clase HiloServidor. */
                HiloServidor hs = new HiloServidor(sc);
                /** Implementamos el método 'start' del objeto 'hs' */
                hs.start();
            
            }
            
        } catch (IOException ex) { /** Capturamos las excepciones y las 
         * guardamos en un 'Logger' */
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
