/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase/Entidad Filosofo. Extiende la clase 'Thread'
 * @author kzdesigner
 */
public class Filosofo extends Thread {
    
    // Definición de variables
    private Mesa mesa;
    private int comensal;
    private int indiceComensal;
    
    /** 
     * Constructor de la clase Filósofo 
     * @param mesa Mesa donde se sientan los filósofos
     * @param comensal Comensales que se sientan/están sentados en la mesa
     */
    public Filosofo(Mesa mesa, int comensal) {
    
        this.comensal = comensal;
        this.indiceComensal = comensal - 1;
        this.mesa = mesa;
    
    }
    
    /**
     * 
     * Método 'run()' para ejecutar el programa principal de nuestra aplicación. 
     * Su funcionamiento interno se encuentra explicado en diferentes comentarios.
     * Retorna 'void'
     *  
     */
    public void run() {
        // Ejecutamos un bucle 'infinito while(true)'(o 'mientras sea verdadero')
        while(true) {
            // Utilizamos un método de control de excepciones 'try catch'
            try {
                // Ejecutamos el método 'pensando' de la entidad Filosofo
                this.pensando();
                // Imprimimos el siguiente mensaje adjuntando el comensal en cuestión
                System.out.println("Filósofo " + this.comensal + " esta hambriento");
                // Cojemos el palillo/turno y asignamos el índice del comensal a la 
                // posición correspondiente de nuestra Mesa
                mesa.cogerPalillos(this.indiceComensal);
                // Ejecutamos el método 'comiendo' de la entidad Filosofo
                this.comiendo();
                // Imprimimos el siguiente mensaje adjuntando el índice del comensal
                System.out.println("Filósofo " + this.comensal + " ha terminado "
                        + "de comer y hay palillos libres: " 
                        // Asignamos el índice del comensal en los métodos de 
                        // control de 'turno' configurados en la clase Mesa
                        + this.mesa.palilloIzquierdo(this.indiceComensal) + ", " 
                        + this.mesa.palilloDerecho(this.indiceComensal)
                );
                mesa.dejarPalillos(this.indiceComensal);
            } catch (InterruptedException ex) { // Capturamos los errores
                Logger.getLogger(Filosofo.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    /** 
     * Método pensando() para mostrar que un Filósofo está pensando y definir una 
     * pausa/interrupción determinada. Retorna 'void'
     * @throws InterruptedException Captura de las posibles interrupciones
     */
    public void pensando() throws InterruptedException {
        System.out.println("Filósofo " + this.comensal + " está pensando");
        Thread.sleep(2000);
    }
    
    /** 
     * Método comiendo() para mostrar que un Filósofo está comiendo y definir una 
     * pausa/interrupción determinada. Retorna 'void'
     * @throws InterruptedException Captura de los posibles errores de ejecución
     */
    public void comiendo() throws InterruptedException {
        System.out.println("Filósofo " + this.comensal + " está comiendo");
        Thread.sleep(2000);
    }
    
}
