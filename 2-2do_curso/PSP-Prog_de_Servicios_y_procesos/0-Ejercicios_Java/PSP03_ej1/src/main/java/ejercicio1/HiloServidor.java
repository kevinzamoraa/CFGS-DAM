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
 * Clase/Entidad HiloServidor que extiende a la clase nativa 'hilo'
 * @author kzdesigner
 */
public class HiloServidor extends Thread {

    // Declaración de variables
    private Socket sc;
    
    /**
     * Constructor de la clase HiloServidor
     * @param sc Variable 'zócalo' pasado al constructor como parámetro
     */
    public HiloServidor(Socket sc) {
        this.sc = sc;
    }
    
    /**
     * Método 'run()' dedicado a ejecutar las diferentes 'etapas' de nuestra 
     * aplicación
     */
    public void run() {
    
        System.out.println("Cliente conectado");
        // Creación e inicialización de variables
        DataInputStream in = null;
        DataOutputStream out = null;
        // Método 'try catch' dedicado al control de excepciones
        try {
            // Asignación de los valores leidos en las variables 'in' y 'out'
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            
            // Creación e inicialización de las variables numericas 'numAleatorio'
            // y 'numUsuario', las cuales se relacionan directamente con la 
            // finalidad de nuestra aplicación: adivinar el número aleatorio 
            // generado por parte del usuario de la aplicación, introducido por 
            // teclado
            int numAleatorio = generarNumeroAleatorio(1,100);
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
                
                // Comparamos ambos números y escribimos un 'boleano' hacia el 
                // servidor
                out.writeBoolean(numUsuario == numAleatorio);
                
              // Mientras el número introducido y el generado sean diferentes 
              // se ejecutará reiteradamente el programa anterior
            } while(numUsuario != numAleatorio);
            
            // Cerramos la conexión del cliente con el servidor
            sc.close();
            System.out.println("Cliente desconectado");
            
        } catch (IOException ex) {
            // Capturamos los posibles errores y los almacenamos en un 'Logger'
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Cerramos los flujos de entrada y salida desde/hacia el servidor
                in.close();
                out.close();
            } catch (IOException ex) {
                // Capturamos los posibles errores y los guardamos en un 'Logger'
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
