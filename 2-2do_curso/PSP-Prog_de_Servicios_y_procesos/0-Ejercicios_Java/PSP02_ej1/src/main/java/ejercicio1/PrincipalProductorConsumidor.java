/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ejercicio1;

import java.util.logging.*;

/**
 *
 * Clase principal de nuestro/a proyecto/aplicación. Esta contiene un método 'main'
 * y en este procedemos a inicializar/instanciar las clases/entidades necesarias 
 * para su ejecución y correcto funcionamiento.
 * @author kzdesigner
 */
public class PrincipalProductorConsumidor {

    /** 
     *
     * Este método 'main' sirve para iniciar nuestra aplicación y en su interior 
     * definimos las/los variables/objetos necesarias para su ejecución. En 
     * consecuencia, creamos una instancia/llamada hacia las clases/entidades 'Buffer', 
     * 'Productor' y 'Consumidor'. Y a su vez, también utilizamos los métodos 'start', 
     * 'Thread.sleep' y 'join', para gestionar así los 'turnos' de escrutura/lectura 
     * de nuestro 'buffer'. Por último, también añadimos el método 'try catch', 
     * dedicado al control de excepciones, para así poder prevenir y capturar 
     * posibles errores/fallos de ejecución.
     * @param args
     */
    public static void main(String[] args) {
        
        try {
        
            Buffer b = new Buffer (6);
            Productor p = new Productor (b);
            Consumidor c = new Consumidor (b);
            
            p.start();
            Thread.sleep(3000);
            c.start();
            
            p.join();
            c.join();
            System.out.println("Termina el programa");
        
        } catch (InterruptedException ex) {
            Logger.getLogger(PrincipalProductorConsumidor.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
    }
}
