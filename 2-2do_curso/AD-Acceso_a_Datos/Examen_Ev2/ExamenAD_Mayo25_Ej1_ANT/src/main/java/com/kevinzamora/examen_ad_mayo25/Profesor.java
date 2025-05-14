/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kevinzamora.examen_ad_mayo25;
import java.io.Serializable;

/**
 *
 * @author Kevin
 */
public class Profesor implements Serializable{
    
    String nombre;
    int antiguedadEnEscuela;
    int edad;
    Curso curso;
    
    public Profesor(String nombre, int antiguedadEnEscuela, int edad) {
        this.nombre = nombre;
        this.antiguedadEnEscuela = antiguedadEnEscuela;
        this.edad = edad;
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAntiguedadEnEscuela() {
        return antiguedadEnEscuela;
    }

    public void setAntiguedadEnEscuela(int antiguedadEnEscuela) {
        this.antiguedadEnEscuela = antiguedadEnEscuela;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    

    @Override
    public String toString() {
        return "Datos del profesor:\n " + "Nombre:" + nombre 
                + ",\n Antiguedad en la Escuela:" + antiguedadEnEscuela 
                + ",\n Edad:" + edad
                + ",\n " + curso;
    }
    
    
    
}
