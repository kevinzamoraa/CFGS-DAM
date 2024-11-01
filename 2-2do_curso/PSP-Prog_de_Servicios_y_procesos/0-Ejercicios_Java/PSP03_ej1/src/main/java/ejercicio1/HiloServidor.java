/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * Clase/entidad HiloServidor que extiende a la clase nativa 'Hilo'
 * @author kzdesigner
 */
public class HiloServidor extends Thread {

    /** 
     * Definimos el zócalo/'socket' de conexión
     */
    private Socket sc;
    
    /**
     * Creamos el construcctor de clase a utilizar y definimos que le podamos 
     * pasar el 'zócalo' como parámetro.
     * @param sc Zócalo de conexión (o Socket)
     */
    public HiloServidor(Socket sc) {
        this.sc = sc;
    }
    
    /** 
     * Método 'run()' encargado de conectar el cliente y el servidor y también 
     * de realizar todas , las operaciones de entrada, salida y comparación 
     * necesarias.
     */
    public void run() {
    
        /*
        Imprimimos un mensaje informativo y creamos e inicializamos los 
        flujos de entrada y de salida.
        */
        System.out.println("Cliente conectado");
        DataInputStream in = null;
        DataOutputStream out = null;
        // Definimos un método de control de excepciones 'try catch' para 
        // capturar los posibles errores durante la ejecución del programa
        try {
            // Leemos y asignamos los datos recibidos desde los 'flujos de entrada
            // y salida y los guardamos en las variables 'in' y 'out'
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            
            // Generamos el número aleatorio y lo guardamos en una variable
            int numAleatorio = generarNumeroAleatorio(1,100);
            // Inicializamos la variable 'numUsuario' a cero
            int numUsuario = 0;
            
            // Imprimimos el número generado
            System.out.println("Num generado: " + numAleatorio);
            
            // Creamos un bucle 'haz mientras'
            do {
                
                out.writeUTF("Escribe un numero entre 1 y 100");
                // Imprimimos un mensaje y leemos el 'entero' introducido 
                // por teclado
                numUsuario = in.readInt();
                
                // Imprimimos el número recibido
                System.out.println("Numero recibido: " + numUsuario);
                
                // Realizamos la comparación para saber si es correcto
                if(numUsuario == numAleatorio){
                    out.writeUTF("¡Has ganado!");
                }else if (numUsuario < numAleatorio){
                    out.writeUTF("El numero buscado es mayor");
                }else{
                    out.writeUTF("El numero buscado es menor");
                }
                // Evaluamos sí el número del usuario y el generado son iguales
                out.writeBoolean(numUsuario == numAleatorio);
            } while(numUsuario != numAleatorio);
            
            // Cerramos la conexión e imprimimos el mensaje correspondiente
            sc.close();
            System.out.println("Cliente desconectado");
            
        } catch (IOException ex) { // Capturamos los errores y los guardamos en un 'logger'
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Cerramos los flujos de entrada y de salida
                in.close();
                out.close();
            } catch (IOException ex) { // Capturamos los posibles errores en un logger
                Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    private int generarNumeroAleatorio(int min, int max) {
        int num = (int) (Math.random()*(max - min + 1) + (min));
        return num;
    }
    
}
