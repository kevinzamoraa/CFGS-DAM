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
     * Método 'main' dedicado a establecer la conexión con el servidor y 
     * recoger el mensaje con el número generado en el servidor.
     * @param args Argumentos de tipo 'cadena de texto'
     */
    public static void main(String[] args) {
    
        // Método de conexión de excepciones 'try catch'
        try {
            
            // Creamos una instancia del objeto 'Socket'/'zócalo' de conexión 
            // con el servidor y se define la conexión a través del puerto 2000
            Socket sc = new Socket("localhost", 2000);
            
            // Creación e inicialización del flujo de entrada y salida
            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());
            
            // Creamos una variable con valores 'verdadero o falso' dedicada a 
            // habilitar la opción 'salir' y la defenimos en el valor 'falso'
            boolean salir = false;
            
            // Creamos y inicializamos un objeto del tipo Scanner dedicado a la 
            // recogida de datos a través del teclado
            Scanner scanner = new Scanner(System.in);
            
            // Bucle 'Haz mientras'
            do {
                // Inicializamos una variable de tipo 'texto' y leemos el 
                // valor de entrada mediante el método 'leerUTF'
                String mensaje = in.readUTF();
            
                // Imprimimos el mensaje leido por pantalla
                System.out.println(mensaje);

                // Creamos la variable 'num' y leemos el valor por teclado
                int num = scanner.nextInt();
                // Escribimos el módulo leido hacia el servidor
                out.writeInt(num);

                // Leemos el mensaje desde el servidor
                mensaje = in.readUTF();
                // Y lo imprimimos por pantalla
                System.out.println(mensaje);
                
                // Lectura del valor 'Verdadero/Falso' dedicado a orquestar la 
                // función 'salir'
                salir = in.readBoolean();
                
              // Se ejecutará mientras la variable 'salir' tenga un valor 'falso'
            } while (!salir);
            
            // Cerrar la conexión del zócalo de conexión con el servidor
            sc.close();
                    
        } catch (IOException ex) {
            // Captura de los posibles errores y guardado de estos en un 'Logger'
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
