/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kevinzamora.prog06_tarea;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import kevinzamora.prog06_tarea_util.Validacion;

/**
 *
 * @author kzdesigner // Autor y nombre del equipo de Kevin Zamora Amela
 */
public class Vehiculo {

    Scanner scanner = new Scanner(System.in);
    int errores = 0;
    Validacion validacionObj = new Validacion();
    
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
    @Override
    public String toString() {
        return "ID: " + id + ". Marca: " + fabricante + " Modelo: " + modelo
                + " Matricula: " + matricula + " Nº Kms: " + numKilometros
                + " fecha de fabricación: " + fechaMatriculacion + " Propietario: "
                + propietario + " Descripción: " + descripcion + " Precio: "
                + precio + "€ DNI del Propietario: " + dniPropietario;
    }

    // Métodos GETTER
    public int getErrores() {
        return errores;
    }
    
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
    public Vehiculo encontrarVehiculoPorID(int id, List<Vehiculo> vehiculos) {
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
    
    public Vehiculo encontrarVehiculoPorMatricula(String matricula, List<Vehiculo> vehiculos) {
        Vehiculo vehiculoEncontrado; // Variable auxiliar prescindible

        for (Vehiculo vehiculo : vehiculos) {
            if (matricula.toLowerCase().equals((vehiculo.matricula).toLowerCase())) {
                vehiculoEncontrado = vehiculo;
                /* Este paso sería innecesario, 
                aunque así se comprende mejor el funcionamiento del programa */
                System.out.println("Se ha encontrado un vehiculo identificado "
                        + "con el ID introducido y se has cargado sus datos para "
                        + "poder condultarlos y/o modificarlos");
                return vehiculoEncontrado;
            } else {
                vehiculoEncontrado = null;
                System.out.println("No se ha encontrado ningún vehículo con la matrícula introducida");
                return vehiculoEncontrado;
                /* Aquí también se podría prescindir de la variable 
                y devolver directamente 'null' como resultado de la función */
            }
        }
        return null;
    }

    public void imprimeVehiculos(List<Vehiculo> vehiculos) {
        System.out.println("LISTA DE VEHICULOS EN NUESTRO CONCESIONARIO: \n");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.id + ". " + vehiculo.fabricante + " " + vehiculo.modelo);
        }
        System.out.println("\n");
    }
    
    public void imprimeCaracteristicasVehiculos(List<Vehiculo> vehiculos) {
        System.out.println("LISTA DE VEHICULOS EN NUESTRO CONCESIONARIO: \n");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.toString());
        }
        System.out.println("\n");
    }

    public void creaUnVehiculo(List<Vehiculo> vehiculos) {
        int nuevoId = vehiculos.size() + 1;
        if (nuevoId > 50) {
            System.out.println("Se ha alcanzado el límite de 50 vehículos por concesionario. Ya no se pueden añadir más");
            return; 
        };

        System.out.println("Fabricante/Marca: ");
        String fabricante1 = scanner.nextLine();
        System.out.println("Modelo: ");
        String modelo1 = scanner.nextLine();
        String matricula1;
        boolean matriculaCorrecta = false;
        boolean matriculaRepetida = false;
        do {
            System.out.println("Matrícula: ");
            matricula1 = scanner.nextLine();
            matriculaCorrecta = validacionObj.comprobarMatricula(matricula1);
            matriculaRepetida = validacionObj.comprobarMatriculaRepetida(matricula1,vehiculos);
            if (matriculaCorrecta != true) {
                errores++;
            }
            if (errores >= 3) {System.out.println("HAS COMETIDO 3 ERRORES Y SE TE REDIRIGE "
                    + "A LA PANTALLA PRINCIPAL. MÁS SUERTE LA PRÓXIMA VEZ. \n VUELVE A INICIAR LA APLICACIÓN "
                    + "PARA VOLVER A INTENTARLO"); errores = 0; return; }
        } while (matriculaCorrecta != true && matriculaRepetida != true);
        
        int numKms;
        boolean numKmsIsCorrect = false;
        do {
            System.out.println("Nº de Kilometros: ");
            numKms = Integer.parseInt(scanner.nextLine());
            numKmsIsCorrect = validacionObj.comprobarKilometros(numKms);
            if (numKmsIsCorrect != true) {
                errores++;
            }
            if (errores >= 3) {System.out.println("HAS COMETIDO 3 ERRORES Y SE TE REDIRIGE "
                    + "A LA PANTALLA PRINCIPAL. MÁS SUERTE LA PRÓXIMA VEZ. \n VUELVE A INICIAR LA APLICACIÓN "
                    + "PARA VOLVER A INTENTARLO"); errores = 0; return; } /*Faltaria reiniciar la aplicación 
            o redirigir a la función loadMainMenu() alojada actualmente en la clase 'Principal'. Debido a falta 
            de tiempo y de recursos lo dejamos pendiente de realizar. PD: Debería bastar con mover la función del menú 
            a una clase independiente desde la que pueda ser llamada desde todas partes, para evitar así que el 
            error 'StackOverflow' debido a al llamamiento mutuo entre clases/entidades */
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
            // momentoActual = LocalDate.now();
            FMisCorrect = validacionObj.comprobarFechaMatriculacion(fechaMatriculacion1);
            errores++;
            if (errores >= 3) {System.out.println("HAS COMETIDO 3 ERRORES Y SE TE REDIRIGE "
                    + "A LA PANTALLA PRINCIPAL. MÁS SUERTE LA PRÓXIMA VEZ. \n VUELVE A INICIAR LA APLICACIÓN "
                    + "PARA VOLVER A INTENTARLO"); errores = 0; return; } /*Faltaria reiniciar la aplicación 
            o redirigir a la función loadMainMenu() alojada actualmente en la clase 'Principal'. Debido a falta 
            de tiempo y de recursos lo dejamos pendiente de realizar. PD: Debería bastar con mover la función del menú 
            a una clase independiente desde la que pueda ser llamada desde todas partes, para evitar así que el 
            error 'StackOverflow' debido a al llamamiento mutuo entre clases/entidades */
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
        errores++;
            if (errores >= 3) {System.out.println("HAS COMETIDO 3 ERRORES Y SE TE REDIRIGE "
                    + "A LA PANTALLA PRINCIPAL. MÁS SUERTE LA PRÓXIMA VEZ. \n VUELVE A INICIAR LA APLICACIÓN "
                    + "PARA VOLVER A INTENTARLO"); errores = 0; return; } /*Faltaria reiniciar la aplicación 
            o redirigir a la función loadMainMenu() alojada actualmente en la clase 'Principal'. Debido a falta 
            de tiempo y de recursos lo dejamos pendiente de realizar. PD: Debería bastar con mover la función del menú 
            a una clase independiente desde la que pueda ser llamada desde todas partes, para evitar así que el 
            error 'StackOverflow' debido a al llamamiento mutuo entre clases/entidades */
        } while (dniPropietario1IsCorrect != true);
        

        System.out.println("\nSE VA A INSERTAR EL SIGUIENTE ELEMENTO EN NUESTRA BASE DE DATOS \n"
                + "¿ES CORRECTO? RESPONDE 'Y' PARA DECIR 'SÍ' O 'N' PARA DECIR 'NO'");
        Vehiculo nuevoVehiculo = new Vehiculo(nuevoId, fabricante1, modelo1,
                matricula1, numKms, fechaMatriculacion1,
                propietario1, descripcion1, precio1, dniPropietario1);
        System.out.println(nuevoVehiculo.toString());

        String confirmacion = scanner.nextLine();
        switch (confirmacion) {
            case "Y":
                if (vehiculos.hashCode() <= 49) {
                try {                
                vehiculos.add(nuevoVehiculo);
                System.out.println("EL NUEVO VEHÍCULO HA SIDO INTRODUCIDO CORRECTAMENTE");
            } catch (Exception e) {
            };
                } else { System.out.println("Se ha alcanzado el límite de capacidad de nuestro concesionario, el cual se encuentra definido en 50 vehículos"); }
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
