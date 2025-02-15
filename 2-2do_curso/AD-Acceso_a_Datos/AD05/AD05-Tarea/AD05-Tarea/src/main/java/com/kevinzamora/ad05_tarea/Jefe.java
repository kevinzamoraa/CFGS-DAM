/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kevinzamora.ad05_tarea;

/**
 *
 * @author kzdesigner
 */
public class Jefe {
    
    private String nombre;
    private int añosEmpresa;
    private int edad;
    private Hijo hijo;

    public Jefe(String nombre, int añosEmpresa, int edad, Hijo hijo) {
        this.nombre = nombre;
        this.añosEmpresa = añosEmpresa;
        this.edad = edad;
        this.hijo = hijo;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAñosEmpresa() {
        return añosEmpresa;
    }

    public void setAñosEmpresa(int añosEmpresa) {
        this.añosEmpresa = añosEmpresa;
    }

    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Hijo getHijo() {
        return hijo;
    }

    @Override
    public String toString() {
        return "Jefe{" +
                "nombre='" + nombre + '\'' +
                ", añosEmpresa=" + añosEmpresa +
                ", edad=" + edad +
                ", hijo=" + (hijo != null ? hijo.toString() : "null") +
                '}';
    }

    
}
