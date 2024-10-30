/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ejercicio2;

import ejercicio2.Filosofo;
import ejercicio2.Mesa;

/**
 * 
 * Clase Principal de nuestra aplicación. Esta contiene solamente un método 'main'.
 * Y este se encarga de crear las instancias de los objetos 'Mesa' y 'Filosofo', 
 * para así poder ponerla en funcionamiento.
 * @author kzdesigner
 */
public class Principal {

    /**
     * Método principal dedicado a inicializar y ejecutar nuestra aplicación
     * retorna 'void'
     */
    public void main() {
        
        // Creamos una instancia de la entidad Mesa, introduciendo el valor 5 como 
        // parámetro y aludiendo así a uno de los dos constructores de la clase 'Semaphore'
        Mesa m = new Mesa(5);
        
        // Bucle 'for' para ir creando, instanciando e inicializando un 'Filósofo' por cada 
        // posición (se han definido 5 posiciones) de la Mesa(o Semáforo) definida
        for (int i = 1; i <= 5; i++) {
            // Instanciamos la entidad Filosofo en cada iteración del bucle 'for' y este 
            // ha sido configurado con el mismo número de iteraciones que posiciones definidas
            // en nuestra Mese/Semaphore
            Filosofo f = new Filosofo (m, i);
            // Ejecutamos el método 'start' de la clase Filosofo
            f.start();
        }
        
    }
}
