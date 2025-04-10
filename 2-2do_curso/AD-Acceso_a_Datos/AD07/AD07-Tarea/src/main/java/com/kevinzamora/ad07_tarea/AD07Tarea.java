/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.kevinzamora.ad07_tarea;

/**
 *
 * @author kzdesigner
 */
public class AD07Tarea {

    public static void main(String[] args) {
        SensorTemperatura sensor = new SensorTemperatura();
        
        // Agregar listener para eventos
        sensor.addPropertyChangeListener((evt) -> {
            System.out.println("Cambio detectado:");
            System.out.println("Propiedad: " + evt.getPropertyName());
            System.out.println("Valor anterior: " + evt.getOldValue());
            System.out.println("Nuevo valor: " + evt.getNewValue());
        });
        
        // Pruebas básicas
        sensor.setEstadoActivo(true);
        sensor.setTemperatura(25.5);
        System.out.println("Temperatura actual: " + sensor.getTemperatura());
        System.out.println("Promedio de temperatura: " + 
                          sensor.calcularPromedioTemperatura(5));
    }
}
