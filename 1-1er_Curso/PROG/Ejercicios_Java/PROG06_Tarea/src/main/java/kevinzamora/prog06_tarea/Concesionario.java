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
    Vehiculo coche1 = new Vehiculo(1, "Audi", "A6", "1234ABC",
            10000, LocalDate.of(2015, 3, 11), "Manolo",
            "Coche 'largo' de gama media-alta", 70000.50, "12345678M");
    Vehiculo coche2 = new Vehiculo(2, "Ford", "Focus", "1234CBA",
            7000, LocalDate.of(2013, 5, 10), "Conchi",
            "Coche 'corto' de gama media", 25000, "5678KWN");
    Vehiculo coche3 = new Vehiculo(3, "Fiat", "Punto", "7234ABC",
            200000, LocalDate.of(2005, 9, 20), "Blai",
            "Coche 'corto' de gama media-baja", 6000, "12345678O");

    // Colección de Vehículos
    public List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    Vehiculo vehiculoSeleccionado;
    Vehiculo vehiculoObj = new Vehiculo();
    int errores = vehiculoObj.errores;
    int arraySizeMemory = 3;
    List<Vehiculo> vehiculosAux;

    // Métodos GETTER
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
    public void setVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public Vehiculo getVehiculoSeleccionado() {
        return vehiculoSeleccionado;
    }

    public void setVehiculoSeleccionado(Vehiculo vehiculoSeleccionadoIntroducido) {
        vehiculoSeleccionado = vehiculoSeleccionadoIntroducido;
    }
    
    public int getArraySize() {
        return vehiculoObj.getArraySize();
    }
    
    public int getArraySizeMemory() {
        return arraySizeMemory;
    }

    // Inicialización de nuestra colección de vehiculos
    public void cargarVehiculosPredefinidos() {
        vehiculos.add(coche1);
        vehiculos.add(coche2);
        vehiculos.add(coche3);
        vehiculoObj.setArraySize(3);
    }

    // Métodos importados desde la clase Vehiculo
    public Vehiculo encontrarVehiculoPorMatricula(String matricula) {
        return vehiculoSeleccionado = vehiculoObj.encontrarVehiculoPorMatricula(matricula, vehiculosAux, arraySizeMemory);
    }

    public void imprimeVehiculos(Concesionario concesionario1) {
        vehiculoObj.imprimeVehiculos(vehiculos, getArraySize());
        vehiculosAux = vehiculos;
    }
    
    public void listaVehiculos() {
        vehiculoObj.imprimeVehiculos(vehiculos, arraySizeMemory);
    }

    public void imprimeCaracteristicasVehiculos() {
        vehiculoObj.imprimeCaracteristicasVehiculos(vehiculos, arraySizeMemory);
    }

    public Vehiculo creaUnVehiculo(List<Vehiculo> vehiculos) {
        Vehiculo vehiculoCreado = vehiculoObj.creaUnVehiculo(vehiculos, getArraySize());
        if (vehiculoCreado != null) {
            int arraySize = vehiculoObj.getArraySize();
            int nuevoArraySize = arraySize + 1;
            vehiculoObj.setArraySize(nuevoArraySize);
            arraySizeMemory = nuevoArraySize;
            vehiculos.add(vehiculoCreado);
        }
        return vehiculoCreado;
    }

    public void actualizarKms(int kms, Vehiculo vehiculo) {
        vehiculo.setNumKilometros(kms);
    }
}
