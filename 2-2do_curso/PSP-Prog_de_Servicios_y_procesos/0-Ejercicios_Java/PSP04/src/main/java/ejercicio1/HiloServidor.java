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
        // Creación e inicialización de variables
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
            
            // Mostramos el número aleatorio generado
            System.out.println("Num generado: " + numAleatorio);
            
            // Bucle 'Haz mientras'. Este solicita un número por teclado 
            // hasta que se adevina el número 'secreto' generado en el 'servidor'
            do {
                
                out.writeUTF("Escribe un numero entre 1 y 100");
                
                // Leemos el entero vía teclado
                numUsuario = in.readInt();
                
                // Mostramos el número introducido
                System.out.println("Numero recibido: " + numUsuario);
                
                // Bucle 'si / si no'. En este se compara el valor introducido 
                // con el generado por el método 'calcularNumeroAleatorio' 
                // alojado en la clase 'HiloServidor' y se muestra un mensaje
                if(numUsuario == numAleatorio){
                    out.writeUTF("¡Has ganado!");
                }else if (numUsuario < numAleatorio){
                    out.writeUTF("El numero buscado es mayor");
                }else{
                    out.writeUTF("El numero buscado es menor");
                }
                // Evaluamos sí el número del usuario y el generado son iguales
                out.writeBoolean(numUsuario == numAleatorio);
                
              // Mientras el número introducido y el generado sean diferentes 
              // se ejecutará reiteradamente el programa anterior
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
    
    /** 
     * Método generarNumeroAleatorio dedicado a la creación de números al azar
     * @param min Valor mínimo
     * @param max Valor máximo
     * @return num Número aleatorio generado
     */
    private int generarNumeroAleatorio(int min, int max) {
        int num = (int) (Math.random()*(max - min + 1) + (min));
        return num;
    }
    
}
