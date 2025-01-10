/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

import  java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Clase/Entidad HiloServidor que extiende a la clase nativa o tipo 'Hilo'
 * @author kzdesigner
 */
public class HiloServidor extends Thread {

    /** 
     * Definición de la variable 'sc' de tipo 'socket'/(o zócalo), para la conexión
     */
    private Socket sc;
    
    public HiloServidor(Socket sc) {
        this.sc = sc;
    }
    
    /** 
     * Método sobreescrito 'run()', encargado de ejecutar el funcionamiento 
     * principal de nuestra aplicación y también de establecer la conexión entre 
     * cliente y servidor.
     * 
     */
    @Override
    public void run() {
    
        /** 
         * Mostramos el mensaje 'cliente conectado' e inicializamos los flujos 
         * de entrada y de salida de datos mediante las variables 'in' y 'out'.
         */
        System.out.println("Cliente conectado");
        DataInputStream in = null;
        DataOutputStream out = null;
        /** 
         * Método de control de excepciones 'try catch'
         */
        try {
            /** 
             * Asignación e inicialización de los flujos de entrada/salida a las 
             * variables.
             */
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            
            out.writeUTF("Introduce el usuario: ");
            String usuario = in.readUTF().trim();
            
            out.writeUTF("Introduce la contraseña: ");
            String password = in.readUTF().trim();
            
            if(usuario.equals("kevin") && password.equals("secreta")) {
                
                out.writeBoolean(true);
                           
                boolean salir = false;
                
                while(!salir) {
                    
                    out.writeUTF("Introduce un comando (ls/get/exit)");
                    String comando = in.readUTF().trim();
                    
                    switch(comando) {
                        case "ls":
                            File directorioActual = new File("./ficheros");
                            File[] ficheros = directorioActual.listFiles();
                                                        
                            ArrayList<String> nombresFicheros = new ArrayList<>();
                            for (int i = 0; i < ficheros.length; i++) {
                                if(ficheros[i].isFile()) {
                                    nombresFicheros.add(ficheros[i].getName());
                                }
                            }
                            
                            out.writeInt(nombresFicheros.size());
                            
                            for (String nombresFichero : nombresFicheros) {
                                out.writeUTF(nombresFichero);
                            }
                            
                            break;
                        case "get":
                            /** 
                            * Creación de una variable 'ruta' de tipo 'texto' y guardado de la 
                            * ruta del archivo a leer en su interior, la cual ha sido solicitada 
                            * previamente por teclado.
                            */
                           String ruta = in.readUTF();

                           /** 
                            * Creación de una variable de tipo/clase nativo/a 'Fichero/File' y 
                            * creación de un nuevo objeto 'File' pasándole el parámetro 'ruta'.
                            * @param ruta
                            */
                           File f = new File("./ficheros/" + ruta);

                           /** 
                            * Sentencia condicional 'if else/si sino' para comprovar si existe 
                            * o no un archivo que leer ubicado en la ruta introducida.
                            */
                           if(f.exists()) {
                               /** 
                                * Si existe el archivo, escribimos un booleano con valor 
                                * verdadero en el servidor, para indicar que sí se ha detectado. 
                                */
                               out.writeBoolean(true);

                               /** 
                                * Definimos una variable 'br' de la clase nativa 'BufferedReader' 
                                * y creamos una instancia de dicho archivo pasándole como  
                                * parámetro la creación de un nuevo 'FileReader', la cual le 
                                * pasa a su vez la variable 'ruta' como parámetro. Dicha 
                                * variable 'br' es la encargada de establecer la conexión con 
                                * el fichero a leer y poder proceder así con su lectura.
                                */
                               BufferedReader br = new BufferedReader(new FileReader("./ficheros/" + ruta));

                               /** 
                                * Creamos e inicializamos las variables linea y contenido de 
                                * tipo 'texto'
                                */
                               String linea = "";
                               String contenido = "";

                               /** 
                                * Bucle 'mientras' dedicado a recorrer/leer el fichero mientras 
                                * haya una nueva línea.
                                */
                               while((linea = br.readLine()) != null) {
                                   contenido += linea + "\r\n";
                               }

                               /** 
                                * Cerramos la conexión
                                */
                               br.close();

                               /** 
                                * Creamos una colección de tipo 'byte' y guardamos en esta el 
                                * contenido del archivo convertida a 'bytes'.
                                */
                               byte[] contenidoFichero = contenido.getBytes();

                               /**
                                * Escribimos la longitud del archivo y se la enviamos al servidor.
                                * @param contenidoFichero.length Longitud del fichero
                                */
                               out.writeInt(contenidoFichero.length);

                               /** 
                                * Bucle 'para' dedicado a recorrer/leer el archivo línea por 
                                * línea o mejor dicho: 'byte' por 'byte'.
                                */
                               for (int i = 0; i < contenidoFichero.length; i++) {
                                   out.writeByte(contenidoFichero[i]);
                               }

                           } else {
                               /** 
                                * En caso de no encontrar el archivo, escribimos/enviamos un 
                                * valor 'falso'.
                                */
                               out.writeBoolean(false);
                           }
                            break;
                        case "exit":
                            salir = true;
                            break;
                    }
                    
                }
                
            } else {
                
                out.writeBoolean(false);
                
            }
                        
            
            
            /** 
             * Cerramos la conexión e imprimimos el mensaje correspondiente.
             */            
            sc.close();
            System.out.println("Cliente desconectado");
            
        } catch (IOException ex) { /** Controlamos las excepciones y guardamos 
         la información de estos en un 'Logger'. */
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            /** 
             * Definimos un método de control de excepciones 'try catch'.
             */
            try {
                /** 
                 * Cerramos los flujos de datos de entrada y de salida.
                 */
                in.close();
                out.close();
            } catch (IOException ex) {
                /** 
                 * Guardamos la información de los errores en un 'Logger'.
                 */
                Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    /** 
     * Método 'generarNumeroAleatorio' dedicado a la función que se indica con 
     * su nombre.
     * @param min Valor mínimo
     * @param max Valor máximo
     * @return num Número generado
     */
    private int generarNumeroAleatorio(int min, int max) {
        int num = (int) (Math.random()*(max - min + 1) + (min));
        return num;
    }
    
}
