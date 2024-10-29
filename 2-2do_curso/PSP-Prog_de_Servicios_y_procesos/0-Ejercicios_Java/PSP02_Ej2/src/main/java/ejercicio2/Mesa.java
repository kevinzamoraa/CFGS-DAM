/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import java.util.concurrent.Semaphore;

/**
 *
 * Entidad o Clase Mesa. Esta clase implementa la clase nativa 'Semaphore' y 
 * realiza la gestión de los diferentes 'turnos' dedicados a 'pensar' o 'comer'
 * @author kzdesigner
 */
public class Mesa {
    
    // Definición de variables
    private Semaphore[] palillos;
    
    /**
     * Constructor de la clase Mesa
     * @param numPalillos Número de posiciones que queremos que tenga la mesa
     */
    public Mesa (int numPalillos) {
    
        this.palillos = new Semaphore[numPalillos];
        for (int i = 0; i < numPalillos; i++) {
            this.palillos[i] = new Semaphore(1);
        }
        
    }
    
    /**
     * Método para definir el valor del palillo izquierdo.
     * @param i Indice del filósofo que coge un palillo
     * retorna un entero
     */
    public int palilloIzquierdo(int i) {
        // Retornamos la variable introducida como parámetro
        return i; 
        
    }
    
    /** 
     * Método para calcular y definir el palillo derecho.
     * @param i Indice del filósofo que coge un palillo
     * retorna un entero
     */
    public int palilloDerecho(int i) {
        // Evaluamos el valor de i y gestionamos la operación adecuada en cada caso
        if (i == 0) {
            return this.palillos.length - 1;
        } else {
            return i - 1;   
        }
        
    }
    
    /** 
     * Método para coger palillos.
     * @param comensal ID del comensal
     * no retorna nada
     * @throws InterruptedException Captura la interrupción
     */
    public void cogerPalillos(int comensal) throws InterruptedException {
        // Cogemos/Capturamos los palillos izquierdo y derecho
        this.palillos[this.palilloIzquierdo(comensal)].acquire();
        this.palillos[this.palilloDerecho(comensal)].acquire();
    
    }
    
    /** 
     * Método para coger palillos.
     * @param comensal ID del comensal
     * no retorna nada
     * @throws InterruptedException 
     */
    public void dejarPalillos(int comensal) throws InterruptedException {
        // Dejamos/Liberamos los palillos izquierdo y derecho
        this.palillos[this.palilloIzquierdo(comensal)].release();
        this.palillos[this.palilloDerecho(comensal)].release();
    
    }
    
}
