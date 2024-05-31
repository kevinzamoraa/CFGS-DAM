/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.kevinzamora.final1_tarea;

/**
 *
 * @author kzdesigner // Autor: Kevin Zamora Amela
 */
public class Final1_Tarea {
    /* Esta es nuestra clase 'raiz' y la única que se puede ejecutar por defecto y mediante el uso 
    de las opciones que nos brinda nuestro IDE. En su defecto, deberíamos modificar la configuración 
    y el más concretamente el 'socket' predefinido de nuestro proyecto */
    public static void main(String[] args) {
        /* Creamos una instancia de nuestra clase Principal, ubicado dentro del método 'main'
        de la clase principal de nuestro proyecto. De esta manera, podremos ejecutar directamente 
        toda nuestra aplicación, haciendo uso del botón 'play' de nuestro IDE; 
        en este caso utilizamos 'Netbeans'*/
        Principal principalObj = new Principal();
        principalObj.showCalculadora();
    }
}
