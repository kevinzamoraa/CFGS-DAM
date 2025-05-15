<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_ad_mayo25_ej1;

import java.io.Serializable;

/**
 *
 * @author Kevin
 */
public class Curso implements Serializable {
    
    String nombre;
    int numHoras;

    public Curso() {
    }

    public Curso(String nombre, int numHoras) {
        this.nombre = nombre;
        this.numHoras = numHoras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumHoras() {
        return numHoras;
    }

    public void setNumHoras(int numHoras) {
        this.numHoras = numHoras;
    }

    @Override
    public String toString() {
        return "\n " + "- Nombre: " + nombre 
                + ",\n - Número de horas:" + numHoras;
    }
    
    
    
}
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_ad_mayo25_ej1;

import java.io.Serializable;

/**
 *
 * @author Kevin
 */
public class Curso implements Serializable {
    
    String nombre;
    int numHoras;

    public Curso() {
    }

    public Curso(String nombre, int numHoras) {
        this.nombre = nombre;
        this.numHoras = numHoras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumHoras() {
        return numHoras;
    }

    public void setNumHoras(int numHoras) {
        this.numHoras = numHoras;
    }

    @Override
    public String toString() {
        return "\n " + "- Nombre: " + nombre 
                + ",\n - Número de horas:" + numHoras;
    }
    
    
    
}
>>>>>>> 4edd254b066f20d2eed74d2b2d2c4cc239e38875
