/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * Clase/Entidad Cliente. 
 * @author kzdesigner
 */
public class Cliente {
    
    /** 
     * Método 'main'/principal encargado de iniciar el lado del cliente
     * @param args Argumentos
     */
    public static void main(String[] args) {
        
        /** Método de control de excepciones 'try catch' */
        try {
            
            /** Definimos un 'socket'/zócalo para nuestro servidor y lo ubicamos 
            * en el puerto 2000 */
            Socket sc = new Socket("localhost", 2000);
            
            /** Definimos e inicializamos los flujos de datos de entrada y salida */
            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());
            
            /** Definimos la variable booleana para la función 'salir' */
            boolean salir = false;
            
            /** Definimos e inicializamos el medio de entrada de texto por teclado */
            Scanner scanner = new Scanner(System.in);
            
            /** Bucle 'haz mientras' */
            do {
                
                /** Leemos el número/mensaje construido desde el HiloServidor */
                String mensaje = in.readUTF();
                
                /** Imprimimos por pantalla el mensaje recibido */
                System.out.println(mensaje);
                
                /** Leemos el número entero solicitado por pantalla */
                int num = scanner.nextInt();
                /** Escribimos/Enviamos dicho número al 'hilo'/interlocutor */
                out.writeInt(num);
                
                /** Cargamos el mensaje generado desde la clase HiloServidor */
                mensaje = in.readUTF();
                /** E imprimimos dicho mensaje. Sus valores serán: 'verdadero' 
                * cuando ambos números sean iguales o 'falso' cuando sean diferentes */
                System.out.println(mensaje);
                
                /** Leemos el valor del booleano recibido para saber cuándo 
                * se ha adivinado el número 'secreto' generado y salir. */
                salir = in.readBoolean();
                
            } while (!salir); /* Mientras 'salir' sea falso, se repetirá el bucle */
            
            sc.close(); /* Cerramos la conexión */
                    
        } catch (IOException ex) { // Capturamos los posibles errores en un 'logger'
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
