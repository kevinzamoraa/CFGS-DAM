/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kevinzamora.prog05_ejerc1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import kevinzamora.prog05_ejer1_util.Validaciones;

/**
 *
 * @author kzdesigner // Autor y nombre del equipo de Kevin Zamora Amela
 */
public class Vehiculo {

    Scanner scanner = new Scanner(System.in);
    Validaciones validacionObj = new Validaciones();

    // Propiedades
    int id;
    private String fabricante;
    private String modelo;
    private String matricula;
    private int numKilometros;
    private LocalDate fechaMatriculacion;
    private String propietario;
    private String descripcion;
    private double precio;
    private String dniPropietario;

    // Constructores
    public Vehiculo() {
    }

    public Vehiculo(int id, String fabricante, String modelo, String matricula, int numKilometros,
            LocalDate fechaMatriculacion, String propietario, String descripcion, double precio, String dniPropietario) {
        this.id = id;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.matricula = matricula;
        this.numKilometros = numKilometros;
        this.fechaMatriculacion = fechaMatriculacion;
        this.propietario = propietario;
        this.descripcion = descripcion;
        this.precio = precio;
        this.dniPropietario = dniPropietario;
    }

    // Método TO STRING
    public String toString() {
        return "ID: " + id + ". Marca: " + fabricante + " Modelo: " + modelo
                + " Matricula: " + matricula + " Nº Kms: " + numKilometros
                + " fecha de fabricación: " + fechaMatriculacion + " Propietario: "
                + propietario + " Descripción: " + descripcion + " Precio: "
                + precio + "€ DNI del Propietario: " + dniPropietario;
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

    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public String getPropietario() {
        return propietario;
    }

    public String getDniPropietario() {
        return dniPropietario;
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

    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
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
    public int get_Anios(LocalDate fechaMatriculacion) {
        int antiguedad = 0;
        LocalDate fechaActual = LocalDate.now();
        // DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        // String fechaActualFormateada = fechaActual.format(myFormatObj);
        antiguedad = fechaActual.compareTo(fechaMatriculacion);
//        System.out.println(antiguedad);
        return antiguedad;
    }

    /* Mini CRUD | En una aplicación real, estarían presentes las cuatro funciones del CRUD,
    estas serían privadas y posiblemente, también usaríamos una interfaz para así proteger un poco 
    más su ejecución 'inadecuada', ante algún ataque o vulnerabilidad en la ciberseguridad */
    public Vehiculo encontrarVehiculoPorID(int id, Vehiculo[] vehiculos) {
        Vehiculo vehiculoEncontrado; // Variable auxiliar prescindible

        for (Vehiculo vehiculo : vehiculos) {
            if (id == vehiculo.id) {
                vehiculoEncontrado = vehiculo;
                /* Este paso sería innecesario, 
                aunque así se comprende mejor el funcionamiento del programa */
                System.out.println("Se ha encontrado un vehiculo identificado "
                        + "con el ID introducido y se has cargado sus datos para "
                        + "poder condultarlos y/o modificarlos");
                return vehiculoEncontrado;
            } else {
                vehiculoEncontrado = null;
                System.out.println("No se ha encontrado ningún vehículo con el ID introducido");
                return vehiculoEncontrado;
                /* Aquí también se podría prescindir de la variable 
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

    public void creaUnVehiculo(Vehiculo[] vehiculos) {
        int nuevoId = vehiculos.length + 1;
        // System.out.println(nuevoId);

        System.out.println("Fabricante/Marca: ");
        String fabricante1 = scanner.nextLine();
        System.out.println("Modelo: ");
        String modelo1 = scanner.nextLine();
        System.out.println("Matrícula: ");
        String matricula1 = scanner.nextLine();
        int numKms;
        boolean numKmsIsCorrect = false;
        do {
            System.out.println("Nº de Kilometros: ");
            numKms = Integer.parseInt(scanner.nextLine());
            numKmsIsCorrect = validacionObj.comprobarKilometros(numKms);
//            if (numKms <= 0) {
//                System.out.println("EL NÚMERO DE KILÓMETROS NO PUEDE RESULTAR CERO NI "
//                        + "MUCHO MENOS SER NEGATIVO");
//            }
//        } while (numKms <= 0);
        } while (numKmsIsCorrect != true);
        LocalDate fechaMatriculacion1;
        LocalDate momentoActual;
        boolean FMisCorrect = false;
        do {
            System.out.println("Año de Matriculación: ");
            System.out.println("Introduce el día (número entero):");
            int diaMatriculacion = Integer.parseInt(scanner.nextLine());
            System.out.println("Introduce el mes (número entero)");
            int mesMatriculacion = Integer.parseInt(scanner.nextLine());
            System.out.println("Introduce el año (número entero)");
            int anioMatriculacion = Integer.parseInt(scanner.nextLine());
            fechaMatriculacion1 = LocalDate.of(anioMatriculacion, mesMatriculacion,
                    diaMatriculacion);
            // DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/mm/yyyy");
            // String fechaMatriculacionFormateada = fechaMatriculacion1.format(myFormatObj);
            momentoActual = LocalDate.now();
            FMisCorrect = validacionObj.comprobarFechaMatriculacion(fechaMatriculacion1);
//            if (momentoActual.isBefore(fechaMatriculacion1)) {
//                System.out.println("LA FECHA DE MATRICULACIÓN ES INCORRECTA, ACTUALÍCELA "
//                        + "PARA CONTINUAR \n");
//            }
//        } while (momentoActual.isBefore(fechaMatriculacion1));
        } while (FMisCorrect != true);
        System.out.println("Descripción: ");
        String descripcion1 = scanner.nextLine();
        System.out.println("Precio: ");
        double precio1 = Double.parseDouble(scanner.nextLine());
        System.out.println("Nombre del propietario: ");
        String propietario1 = scanner.nextLine();
        String dniPropietario1;
        boolean dniPropietario1IsCorrect = false;
        do {
        System.out.println("DNI del propietario: ");
        dniPropietario1 = scanner.nextLine();
        dniPropietario1IsCorrect = validacionObj.comprobarDni(dniPropietario1);
        } while (dniPropietario1IsCorrect = true);
        

        System.out.println("\nSE VA A INSERTAR EL SIGUIENTE ELEMENTO EN NUESTRA BASE DE DATOS \n"
                + "¿ES CORRECTO? RESPONDE 'Y' PARA DECIR 'SÍ' O 'N' PARA DECIR 'NO'");
        Vehiculo nuevoVehiculo = new Vehiculo(nuevoId, fabricante1, modelo1,
                matricula1, numKms, fechaMatriculacion1,
                propietario1, descripcion1, precio1, dniPropietario1);
        System.out.println(nuevoVehiculo.toString());

        String confirmacion = scanner.nextLine();
        switch (confirmacion) {
            case "Y":
                try {
                vehiculos[nuevoId] = nuevoVehiculo;
                System.out.println("ASÍ SE ALOJARÍA NUESTRO NUEVO ELEMENTO, \n AUNQUE PARA VERLO JUNTO AL RESTO, "
                        + "PRIMERO DEBERÍAMOS RECARGAR Y VOLVER A LEER EL 'ARRAY'.\n ADEMÁS, TAMPOCO RECUERDO "
                        + "BIEN CÓMO PODÍAMOS INTRODUCIR NUEVOS DATOS EN UN 'ARRAY HARDCODEADO'");
                System.out.println(vehiculos[nuevoId]);
                System.out.println("EL NUEVO VEHÍCULO HA SIDO INTRODUCIDO CORRECTAMENTE");
            } catch (Exception e) {
            }
            ;
            break;
            case "N":
                System.out.println("HA DECIDIDO DESISTIR DURANTE LA CREACIÓN DE ESTE "
                        + "NUEVO VEHÍCULO EN NUESTRA BASE DE DATOS");
                break;
            default:
                System.out.println("SE HA PRODUCIDO UN ERROR EN TIEMPO DE EJECUCIÓN");
        }
    }

    public void actualizarKms(int kms, Vehiculo vehiculo) {
        vehiculo.setNumKilometros(kms);
    }

}
