/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplos.prueba;
import com.ejemplos.prueba.SensorTemperatura;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author kzdesigner
 */



public class PruebaSensor {
    public static void main(String[] args) {
        // Crear instancia del sensor
        SensorTemperatura sensor = new SensorTemperatura();
        
        // Registrar listener para eventos
        sensor.addPropertyChangeListener((PropertyChangeEvent evt) -> {
            System.out.println("Cambio detectado:");
            System.out.println("Propiedad: " + evt.getPropertyName());
            System.out.println("Valor anterior: " + evt.getOldValue());
            System.out.println("Nuevo valor: " + evt.getNewValue());
        });
        
        // Probar el sensor
        System.out.println("Probando el sensor...");
        sensor.setTemperatura(25.5);
        sensor.setEstadoActivo(true);
        System.out.println("Temperatura actual: " + sensor.getTemperatura());
        System.out.println("Estado actual: " + sensor.getEstadoActivo());
        
        // Probar el método de cálculo
        double promedio = sensor.calcularPromedioTemperatura(5);
        System.out.println("Promedio de temperatura: " + promedio);
    }
}
