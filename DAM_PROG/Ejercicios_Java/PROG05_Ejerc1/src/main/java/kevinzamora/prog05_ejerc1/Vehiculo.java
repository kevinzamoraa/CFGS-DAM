/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kevinzamora.prog05_ejerc1;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author kzdesigner // Autor y nombre del equipo de Kevin Zamora Amela
 */
public class Vehiculo {
    
    // Propiedades
    private String fabricante;
    private String modelo;
    private String matricula;
    private int numKilometros;
    private int anioFabricacion;
    private String propietario;
    private String descripcion;
    private double precio;

    // Constructores
    public Vehiculo() {}
    
    public Vehiculo(String fabricante, String modelo, String matricula, int numKilometros, int antiguedad, String propietario, String descripcion, double precio) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.matricula = matricula;
        this.numKilometros = numKilometros;
        this.anioFabricacion = anioFabricacion;
        this.propietario = propietario;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    // Métodos GETTER
    public String getFabricante() {
        return fabricante;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public String getMatricula() {
        return matricula;
    }
    
    public int getNumKilometros() {
        return numKilometros;
    }
    
    public int getAnioFabricacion() {
        return anioFabricacion;
    }
    
    public String getPropietario() {
        return propietario;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    // Métodos SETTER
    public void setFabricante(String nombreFabricante) {
        this.fabricante = nombreFabricante;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public void setNumKilometros(int numKms) {
        this.numKilometros = numKms;
    }
    
    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }
    
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    // Funciones
    public float get_Anios(int anioFabricacion) {
        int antiguedad = 0;
        LocalDate anioActual = LocalDate.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy");
        String anioActualFormateado = anioActual.format(myFormatObj);
        int anioActualInt = Integer.parseInt(anioActualFormateado);
        antiguedad = anioActualInt - anioFabricacion;
        System.out.println(antiguedad);
        return antiguedad;
    }
    
//    public Vehiculo encontrarVehiculoPorId(int id) {
//        Vehiculo vehiculoEncontrado;
//        
//        return vehiculoEncontrado;
//    }
    
    // Colección de Vehículos
    public Vehiculo[] vehiculos;
    
}
