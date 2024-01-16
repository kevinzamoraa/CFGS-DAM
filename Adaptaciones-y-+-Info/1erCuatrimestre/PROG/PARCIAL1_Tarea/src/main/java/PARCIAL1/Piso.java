/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARCIAL1;

import java.time.LocalDate;

/**
 *
 * @author kzdesigner
 */
public class Piso {
    
    String direccion;
    float precio;
    LocalDate fechaConstruccion;
    Propietario propietario;
    int numHabitaciones;
    int numBanios;
    int tieneGaraje;
    int tieneAscensor;

    public Piso(String direccion, float precio, LocalDate fechaConstruccion,
            Propietario propietario, int numHabitaciones, int numBanios, int tieneGaraje, int tieneAscensor) {
        this.direccion = direccion;
        this.precio = precio;
        this.fechaConstruccion = fechaConstruccion;
        this.propietario = propietario;
        this.numHabitaciones = numHabitaciones;
        this.numBanios = numBanios;
        this.tieneGaraje = tieneGaraje;
        this.tieneAscensor = tieneAscensor;
    }
    
    public Piso () {}
    
    public String getDireccion() {
        return direccion;
    }
    public float getPrecio() {
        return precio;
    }
    public LocalDate getFechaConstruccion() {
        return fechaConstruccion;
    }
    public Propietario getPropietario() {
        return propietario;
    }
    public int getNumHabitaciones() {
        return numHabitaciones;
    }
    public int getNumBanios() {
        return numBanios;
    }
    public int getGaraje() {
        return tieneGaraje;
    }
    public int getAscensor() {
        return tieneAscensor;
    }
    
    public void setPrecio(float nuevoPrecio) {
        precio = nuevoPrecio;
    }
    
    public int get_Anios(LocalDate fechaFabricacion) {
        int antiguedad = 0;
        LocalDate fechaActual = LocalDate.now();
        antiguedad = fechaActual.compareTo(fechaFabricacion);
        return antiguedad;
    }
    
    
}
