package com.ejemplos.prueba;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kzdesigner
 */

public class SensorTemperatura implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // Propiedades privadas
    private double temperatura;
    private boolean estadoActivo;
    
    // Lista de listeners para eventos
    private List<PropertyChangeListener> listeners = new ArrayList<>();
    
    // Constructor sin argumentos
    public SensorTemperatura() {
        this.temperatura = 0.0;
        this.estadoActivo = false;
    }
    
    // Getters y setters
    public double getTemperatura() {
        return temperatura;
    }
    
    public void setTemperatura(double temperatura) {
        double oldValue = this.temperatura;
        this.temperatura = temperatura;
        firePropertyChange("temperatura", oldValue, temperatura);
    }
    
    public boolean getEstadoActivo() {
        return estadoActivo;
    }
    
    public void setEstadoActivo(boolean estadoActivo) {
        boolean oldValue = this.estadoActivo;
        this.estadoActivo = estadoActivo;
        firePropertyChange("estadoActivo", oldValue ? 1.0 : 0.0, estadoActivo ? 1.0 : 0.0);
    }
    
    // Método de comportamiento
    public double calcularPromedioTemperatura(int numMuestras) {
        if (!estadoActivo) {
            throw new IllegalStateException("El sensor debe estar activo");
        }
        // Simulación del cálculo promedio
        return temperatura * numMuestras / numMuestras;
    }
    
    // Gestión de eventos
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        listeners.add(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        listeners.remove(listener);
    }
    
    private void firePropertyChange(String propertyName, double oldValue, double newValue) {
        PropertyChangeEvent evt = new PropertyChangeEvent(this, propertyName, oldValue, newValue);
        for (PropertyChangeListener listener : listeners) {
            listener.propertyChange(evt);
        }
    }
}
