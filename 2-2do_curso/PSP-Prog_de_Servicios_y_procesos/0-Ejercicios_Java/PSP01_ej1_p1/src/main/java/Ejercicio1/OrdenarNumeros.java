/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kzdesigner
 */
public class OrdenarNumeros {
    /**
     * Método 'main' donde desarrollamos nuestra aplicación para ordenar los numeros introducidos mediante teclado.
     * - En su interior encontramos un contenedor try-catch con el que logramos controlar las excepciones/fallos que 
     * se puedan producir durante la entrada de parámetros.
     * - También hacemos uso de la clase nativa ImputStreamReader y BufferedReader, junto al 
     * método 'split' (perteneciente a la clase String); mediante todas ellas logramos 
     * capturar y manipular los datos introducidos por teclado.
     * - En el interior del método de control de excepciones también encontramos un bucle while, 
     * con el cual conseguimos que se siga solicitando datos de entrada hasta que pulsemos la tecla 'enter'
     * y el estado de la variable 'bf' pasa a ser null, saliendo del bucle.
     * - Una vez introducidos y guardados los datos, se procede a eliminar los espacios que hemos introducido entre medias
     * y a guardar los números introducidos resultantes en el interior de un 'array'/ colección de datos de tipo int/entero, 
     * mediante el uso y la conversión a entero del 'array' auxiliar 'datos', el cual es de tipo String.
     * @param args
     */
    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader bf = new BufferedReader(isr);
            
            String entradaTeclado = null;
            
            System.out.print("Introduce los números a ordenar a través del teclado y separados por un espacio: \n");
            while((entradaTeclado = bf.readLine()) != null) {
                String datos[] = entradaTeclado.split(" ");
                int numeros[] = new int[datos.length];
                
                for (int i = 0; i < numeros.length; i++) {
                    numeros[i] = Integer.parseInt(datos[i]);
                }
                
                Arrays.sort(numeros);
                
                System.out.println("A continuación, se muestran ordenados los números introducidos: ");
                for(int i = 0; i < numeros.length; i++) {
                    System.out.print(numeros[i] + " ");
                }
                System.out.println(" ");
            }
        } catch (IOException ex) {
            Logger.getLogger(OrdenarNumeros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
