/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Ejercicio1;

/**
 *
 * @author kzdesigner
 */
public class Aleatorios {

    public static void main(String[] args) {
        
        int cantidadNumerosGenerados = 40;
        
        for (int i = 0; i < cantidadNumerosGenerados; i++) {
            System.out.print(generarNumeroAleatorio(0, 100) + " ");
        }
        
    }
    
    /**
    * Método para generar números aleatorios contenidos entre un valor mínimo y 
    * un máximo introducidos.
    * @param min 
    * @param max
    * @return int
    */
    public static int generarNumeroAleatorio(int min, int max) {
        int num = (int) (Math.random()*(max - min + 1) + (min));
        return num;
    }
}
