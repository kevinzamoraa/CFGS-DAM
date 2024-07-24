/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARCIAL1;

/**
 *
 * @author kzdesigner
 */
public class Propietario {
    
    String nombre;
    String dni;

    public Propietario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
    
    public String toString() {
        return nombre + " con DNI: " + dni;
    }
    
}
