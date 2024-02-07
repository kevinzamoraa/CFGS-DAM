/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kevinzamora.prog06_tarea;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author kzdesigner // Autor y nombre del equipo de Kevin Zamora Amela
 */
public class Principal {

    String matriculaVehiculoSeleccionado;
    Vehiculo vehiculoSeleccionado;
    Concesionario concesionario1 = new Concesionario();
    List<Vehiculo> vehiculos = concesionario1.getVehiculos();

    public void loadMainMenu() {

        System.out.println("BIENVENID@S A NUESTRO INVENTARIO DE VEHICULOS: \n");
        System.out.println("NUESTRAS OPCIONES: \n "
                + "1. Nuevo Vehículo. \n 2. Listar Vehículos. \n "
                + "3. Buscar Vehículo. \n 4. Modificar kms Vehículo. \n "
                + "5. Salir \n");
        
        /* Inicialización del inventario con algunos vehiculos a modo de base, 
        para la realización de las pruebas pertinentes */
        concesionario1.cargarVehiculosPredefinidos();
        
        System.out.println("SELECCIONA UNA OPCIÓN (Introduce un nº entero):");
        Scanner scanner = new Scanner(System.in);
        int opcion = Integer.parseInt(scanner.nextLine());

        switch (opcion) {

            case 1:
                System.out.println("INTRODUCIR DATOS - CREAR NUEVO VEHÍCULO: \n");
                concesionario1.creaUnVehiculo(vehiculos);

                if (concesionario1.errores >= 3) {
                    System.out.println("HAS COMETIDO 3 ERRORES Y SE TE REDIRIGE "
                            + "A LA PANTALLA PRINCIPAL. MÁS SUERTE LA PRÓXIMA VEZ. \n VUELVE A INICIAR LA APLICACIÓN "
                            + "PARA VOLVER A INTENTARLO");
                    concesionario1.errores = 0;
                    return;
                }
                loadMainMenu();
                break;
            case 2:
                System.out.println("LISTA DE VEHÍCULOS: \n");
                concesionario1.imprimeVehiculos(vehiculos);
                System.out.println("TODO: Nota para cuando ya se ha añadido un nuevo vehiculo: \n"
                        + "El programa manifiesta una reverberación de la lectura del bucle "
                        + "que no es mostrada en la lectura inicial. Si me da tiempo de depurar, intentaré corregirlo \n");
                loadMainMenu();
                break;
            case 3:
                System.out.println("BÚSCA UN VEHÍCULO: \n ");
                concesionario1.imprimeCaracteristicasVehiculos(vehiculos);
                System.out.println("INTRODUCE LA MATRÍCULA DEL VEHÍCULO A BUSCAR: \n");
                matriculaVehiculoSeleccionado = scanner.nextLine();
                vehiculoSeleccionado = concesionario1.encontrarVehiculoPorMatricula(matriculaVehiculoSeleccionado, vehiculos);
                // El siguiente paso de podría eliminar y a su vez, también se podría introducir los mensajes de respuesta dentro de la función
                concesionario1.setVehiculoSeleccionado(vehiculoSeleccionado);
                if (vehiculoSeleccionado != null) {
                    System.out.print("El vehiculo se ha encontrado correctamente y estos son los datos correspondientes: " 
                            + vehiculoSeleccionado.toString() + "\n");
                } else { System.out.println("No se ha detectado ningún valor válido introducido con el que realizar la busqueda \n"); }
                System.out.println(("Se ha seleccionado el siguiente vehículo:" + concesionario1.vehiculoSeleccionado).toString());
                loadMainMenu();
                break;
            case 4:
                System.out.println("ACTUALIZAR KILÓMETROS: \n Introduce su nuevo kilometraje: ");
                int nuevoKilometraje = Integer.parseInt(scanner.nextLine());
                vehiculoSeleccionado = concesionario1.vehiculoSeleccionado;
                int kmsAnt = concesionario1.vehiculoSeleccionado.getNumKilometros();
                concesionario1.actualizarKms(nuevoKilometraje, concesionario1.vehiculoSeleccionado);
                int kmsVehiculoSeleccionado = concesionario1.vehiculoSeleccionado.getNumKilometros();
                System.out.println(("Se han actualizado correctamente los kms del vehículo: \n" 
                        + concesionario1.vehiculoSeleccionado).toString()
                                    + "\n Antes tenía " + kmsAnt + " kilometros \n");
                // System.out.print("PULSE CUALQUIER TECLA PARA CONTINUAR");
                /* System.in.read(); // Probando a implementar una interrupción; en .NET podemos usar:
                Console.ReadKey()*/
                loadMainMenu();
                break;
            case 5:
                System.out.println("¡HASTA PRONTO!");
                break;
            default:
                System.out.println("LA OPCIÓN INTRODUCIDA NO ES VÁLIDA \n");
                // System.out.print("PULSE CUALQUIER TECLA PARA CONTINUAR");
                /* System.in.read(); // Probando a implementar una interrupción; en .NET podemos usar:
                Console.ReadKey()*/
                break;
        }
    }
}
