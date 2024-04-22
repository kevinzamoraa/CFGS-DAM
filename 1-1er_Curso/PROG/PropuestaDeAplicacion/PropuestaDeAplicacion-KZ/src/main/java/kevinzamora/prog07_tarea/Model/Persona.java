/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kevinzamora.prog07_tarea.Model;

/**
 *
 * @author kzdesigner
 */
public class Persona {
    
    // Parámetros
    String nombre;
    String apellidos;
    String DNI;
    
    // Constructores
    public Persona() {
    }

    public Persona(String nombre, String apellidos, String DNI) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
    }
    
    // Métodos auxiliares
    public String toString() {
        return nombre + " " + apellidos + " " + DNI;
    }
    
}
