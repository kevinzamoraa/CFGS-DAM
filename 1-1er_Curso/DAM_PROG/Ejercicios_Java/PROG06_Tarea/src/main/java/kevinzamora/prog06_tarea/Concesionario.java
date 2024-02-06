/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kevinzamora.prog06_tarea;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kzdesigner
 */
public class Concesionario {
    
    // Declaración e Inicialización de los "Coches ejemplo"
    Vehiculo coche1 = new Vehiculo(1, "Audi", "A6", "12345ABC",
            10000, LocalDate.of(2015, 3, 11), "Manolo",
            "Coche 'largo' de gama media-alta", 70000.50, "12345678M");
    Vehiculo coche2 = new Vehiculo(2, "Ford", "Focus", "12345CBA",
            7000, LocalDate.of(2013, 5, 10), "Conchi",
            "Coche 'corto' de gama media", 25000, "12345678N");
    Vehiculo coche3 = new Vehiculo(3, "Fiat", "Punto", "12346ABC",
            200000, LocalDate.of(2005, 9, 20), "Blai",
            "Coche 'corto' de gama media-baja", 6000, "12345678O");

    // Colección de Vehículos
    public List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    
    Vehiculo vehiculoSeleccionado;
    Vehiculo vehiculoObj = new Vehiculo();
    int errores = vehiculoObj.errores;
    
    // Métodos GETTER
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    public Vehiculo getVehiculoSeleccionado() {
        return vehiculoSeleccionado;
    }
    
    // Inicialización de nuestra colección de vehiculos
    public void cargarVehiculosPredefinidos() {
        vehiculos.add(coche1);
        vehiculos.add(coche2);
        vehiculos.add(coche3);
    }
    
    // Métodos importados desde la clase Vehiculo
    
    public Vehiculo encontrarVehiculoPorMatricula(String matricula, List<Vehiculo> vehiculos) {
        return vehiculoObj.encontrarVehiculoPorMatricula(matricula, vehiculos);
    }
    
    public void imprimeVehiculos(List<Vehiculo> vehiculos) {
        vehiculoObj.imprimeVehiculos(vehiculos);
    }
    
    public void imprimeCaracteristicasVehiculos(List<Vehiculo> vehiculos) {
        vehiculoObj.imprimeCaracteristicasVehiculos(vehiculos);
    }

    public void creaUnVehiculo(List<Vehiculo> vehiculos) {
        vehiculoObj.creaUnVehiculo(vehiculos);
    }

    public void actualizarKms(int kms, Vehiculo vehiculo) {
        vehiculo.setNumKilometros(kms);
    }
}
