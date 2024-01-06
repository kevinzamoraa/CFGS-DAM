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
    int id;
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
    
    public Vehiculo(int id, String fabricante, String modelo, String matricula, int numKilometros, int anioFabricacion, String propietario, String descripcion, double precio) {
        this.id = id;
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
    public int getId() {
        return id;
    }
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
    public int get_Anios(int anioFabricacion) {
        int antiguedad = 0;
        LocalDate anioActual = LocalDate.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy");
        String anioActualFormateado = anioActual.format(myFormatObj);
        int anioActualInt = Integer.parseInt(anioActualFormateado);
        antiguedad = anioActualInt - anioFabricacion;
//        System.out.println(antiguedad);
        return antiguedad;
    }
    
    /* Mini CRUD | En una aplicación real, estarían presentes las cuatro funciones del CRUD,
    estas serían privadas y posiblemente, también usaríamos una interfaz para así proteger un poco 
    más su ejecución 'inadecuada', ante algún ataque o vulnerabilidad en la ciberseguridad */
    
    public Vehiculo encontrarVehiculoPorID(int id, Vehiculo[] vehiculos) {
        Vehiculo vehiculoEncontrado; // Variable auxiliar prescindible
        
        for (Vehiculo vehiculo : vehiculos) {
            if(id == vehiculo.id) {
                vehiculoEncontrado = vehiculo; /* Este paso sería innecesario, 
                aunque así se comprende mejor el funcionamiento del programa */
                System.out.println("Se ha encontrado un vehiculo identificado "
                        + "con el ID introducido y se has cargado sus datos para "
                        + "poder condultarlos y/o modificarlos");
                return vehiculoEncontrado;
            } else {
                vehiculoEncontrado = null;
                System.out.println("No se ha encontrado ningún vehículo con el ID introducido");
                return vehiculoEncontrado; /* Aquí también se podría prescindir de la variable 
                y devolver directamente 'null' como resultado de la función */
            }
        }
        return null;
    }
    
    public void imprimeVehiculos(Vehiculo[] vehiculos) {
        System.out.println("LISTA DE VEHICULOS: \n");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.id + ". " + vehiculo.fabricante + " " + vehiculo.modelo);
        }
        System.out.println("\n");
    }
    
    public void creaUnVehiculo(String fabricante, String modelo, String matricula, int numKilometros, 
            int antiguedad, String propietario, String descripcion, double precio, Vehiculo[] vehiculos) {
        int nuevoId = vehiculos.length + 1;
        Vehiculo nuevoVehiculo = new Vehiculo(nuevoId, fabricante, modelo, matricula, numKilometros, 
                antiguedad, propietario, descripcion, precio);
        vehiculos[nuevoId] = nuevoVehiculo;
    }
    
    public void actualizarKms(int kms, Vehiculo vehiculo) {
        vehiculo.setNumKilometros(kms);
    }
    
}
