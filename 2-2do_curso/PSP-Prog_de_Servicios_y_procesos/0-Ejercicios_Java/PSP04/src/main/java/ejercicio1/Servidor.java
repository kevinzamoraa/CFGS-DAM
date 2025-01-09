/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import ejercicio1.HiloServidor;
import ejercicio1.Cliente;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * Clase / Entidad Servidor.
 * @author kzdesigner
 */
public class Servidor {
    
    /**
     * Método 'main' dedicado a construir y habilitar el servidor.
     * @param args Argumentos
     */
    public static void main(String[] args) {
        
        /**
         * Método de control de excepciones 'try catch'.
         */
        try {
            // Creación de un 'zócalo' para alojar el servidor en el puerto 2000 
            ServerSocket servidor = new ServerSocket(2000);
            System.out.println("Se ha iniciado el servidor");
            
            // Bucle 'mientras sea verdadero'
            while(true) {
            
                // Llamada al método 'aceptar()' del objeto servidor y guardado 
                // del 'resultado' en una variable 'sc' de tipo 'Socket'
                Socket sc = servidor.accept();
                
                // Instancia/creación de un objeto de la entidad 'HiloServidor', 
                // encargada de ejecutar y definir el funcionamiento y las etapas 
                // de nuestra aplicación y a la cual le pasamos la aceptación del
                // servidor llamada 'sc'
                HiloServidor hs = new HiloServidor(sc);
                // Ejecución del método 'start' del objeto 'hs'
                hs.start();
            
            }
            
        } catch (IOException ex) { // Control y captura de los posibles errores
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
