/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

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
 * Clase/Entidad Cliente
 * @author kzdesigner
 */
public class Cliente {
    
    /**
     * Método 'main' dedicado a definir y ejecutar toda la información necesaria 
     * para el funcionamiento del lado del cliente en un proceso de comunicación.
     * @param args Argumentos
     */
    public static void main(String[] args) {
    
        /** Método 'try catch' dedicado al control de excepciones */
        try {
            
            /** Creamos una instancia/llamada hacia la clase 'Socket'(o zócalo) y 
            * definimos el puerto y la dirección de conexión mediante uno de sus 
            * constructores, introduciendo en este dichos dos parámetros
            */
            Socket sc = new Socket("localhost", 1500);
            
            /** Creamos e inicializamos las variables dedicadas a crear los 
            * flujos de datos de entrada y salida */
            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());
            
            /** Creamos y definimos la variable de la función 'salir' en 'falso' */
            boolean salir = false;
            
            /** Creamos y inicializamos un objeto del tipo Scanner dedicado a la 
            * recogida de datos a través del teclado */
            Scanner scanner = new Scanner(System.in);
            /** Usamos el caracter '\n' para definir un salto de línea */
            scanner.useDelimiter("\n");
            
            String mensaje = in.readUTF().trim();
            System.out.println(mensaje);
            String usuario = scanner.next();
            out.writeUTF(usuario);
            
            mensaje = in.readUTF().trim();
            System.out.println(mensaje);
            String password = scanner.next();
            out.writeUTF(password);
            
            boolean heEntrado = in.readBoolean();
            
            if (heEntrado) {
                
                salir = false;
                
                while(!salir) {
                    
                    mensaje = in.readUTF().trim();
                    System.out.println(mensaje);
                    String comando = scanner.next();
                    out.writeUTF(comando);
                    //System.out.println(comando);
                    
                    switch(comando) {
                        case "ls":
                            int numFiles = in.readInt();
                            for (int i = 0; i < numFiles; i++) {
                                String nombreFichero = in.readUTF().trim();
                                System.out.println(nombreFichero);
                            }
                            break;
                        case "get":
                            System.out.println("Introduce la ruta del archivo a mostrar:");
                            /** Leemos la ruta del archivo a leer introducida mediante teclado */
                            String ruta = scanner.next();

                            /** Escribimos la ruta introducida enviándola hacia el servidor */
                            out.writeUTF(ruta);

                            /** Leemos la variable 'existe' para definir si se debe un archivo */
                            boolean existe = in.readBoolean();

                            /** Evaluamos si existe el archivo */
                            if (existe) {

                                /** Inicializamos la variable 'longitud' y leemos el valor entero 
                                * por teclado */
                                int longitud = in.readInt();

                                /** Creamos una colección de tipo 'byte' y creamos una variable 
                                * de este tipo, introduciendo y guardando la longitud del 
                                * archivo en su interior */
                                byte[] contenido = new byte[longitud];

                                /** Bucle para recorrer el archivo y leer cada línea, leyendo el 
                                * 'byte' que la representa a nivel informático */
                                for (int i = 0; i < longitud; i++) {
                                    contenido[i] = in.readByte();
                                }

                                /** Creación de la variable 'contenidoFichero' y volcado del 
                                * contenido del fichero guardándolo en formato 'texto' */
                                String contenidoFichero = new String(contenido);

                                /** Imprimimos el contenido del fichero */
                                System.out.println(contenidoFichero);

                            } else {
                                /** Definimos un mensaje alternativo para cuando no haya archivo */
                                System.out.println("Error, no existe el fichero");
                            }
                            break;
                        case "exit":
                            salir = true;
                            break;
                    }
                    
                }
                
            } else {
                System.out.println("Usuario o contraseña incorrectos");
            }
            
            /** Cerramos el zócalo de conexión */
            sc.close();
                    
        } catch (IOException ex) {
            /** Capturamos los posibles errores y los registramos en un 'Logger' */
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
