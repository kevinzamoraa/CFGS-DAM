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

    Vehiculo vehiculoSeleccionado;
    Vehiculo vehiculoCreado;
    String matriculaSeleccionada = "any";
    Concesionario concesionario1 = new Concesionario();

    public void loadMainMenu() {

        System.out.println("BIENVENID@S A NUESTRO INVENTARIO DE VEHICULOS: \n");
        System.out.println("NUESTRAS OPCIONES: \n "
                + "1. Nuevo Vehículo. \n 2. Listar Vehículos. \n "
                + "3. Buscar Vehículo. \n 4. Modificar kms Vehículo. \n "
                + "5. Salir \n");

        /* Inicialización del inventario con algunos vehiculos a modo de base, 
        para la realización de las pruebas pertinentes */
        concesionario1.cargarVehiculosPredefinidos();
        // concesionario1.imprimeVehiculos(concesionario1.getVehiculos());

        System.out.println("SELECCIONA UNA OPCIÓN (Introduce un nº entero):");
        Scanner scanner = new Scanner(System.in);
        int opcion = Integer.parseInt(scanner.nextLine());

        switch (opcion) {

            case 1:
                System.out.println("INTRODUCIR DATOS - CREAR NUEVO VEHÍCULO: \n");
                vehiculoCreado = concesionario1.creaUnVehiculo(concesionario1.getVehiculos());
                concesionario1.setVehiculo(vehiculoCreado);

                if (concesionario1.errores >= 3) {
                    System.out.println("HAS COMETIDO 3 ERRORES Y SE TE REDIRIGE "
                            + "A LA PANTALLA PRINCIPAL. MÁS SUERTE LA PRÓXIMA VEZ. \n VUELVE A INICIAR LA APLICACIÓN "
                            + "PARA VOLVER A INTENTARLO");
                    concesionario1.errores = 0;
                    return;
                }
//                System.out.println(concesionario1.getArraySize());
                concesionario1.imprimeVehiculos(concesionario1);
                loadMainMenu();
                break;
            case 2:
                concesionario1.listaVehiculos();
//                System.out.println("TODO: Nota para cuando ya se ha añadido un nuevo vehiculo: \n"
//                        + "El programa manifiesta una reverberación de la lectura del bucle "
//                        + "que no es mostrada en la lectura inicial. Si me da tiempo de depurar, intentaré corregirlo \n");
                loadMainMenu();
                break;
            case 3:
                System.out.println("BÚSCA UN VEHÍCULO: \n ");
                concesionario1.imprimeCaracteristicasVehiculos();
                System.out.println("TODO: Falta por depurar y reparar la selección de un vehículo cuando este lo acabemos de "
                        + "crear/introducir y está almacenado sólo en memoria 'volatil'. De momento, nuestro programa no "
                        + "resulta capaz de leer y mostrar la información referente a dicho item \n");
                System.out.println("INTRODUCE LA MATRÍCULA DEL VEHÍCULO A BUSCAR: ");
                matriculaSeleccionada = scanner.nextLine();
                
                if (matriculaSeleccionada != "any") {
                    vehiculoSeleccionado = concesionario1.encontrarVehiculoPorMatricula(matriculaSeleccionada);
                    if (vehiculoSeleccionado != null) {
                        // El siguiente paso de podría eliminar y a su vez, también se podría introducir los mensajes de respuesta dentro de la función
                        concesionario1.setVehiculoSeleccionado(vehiculoSeleccionado);
                        vehiculoSeleccionado = concesionario1.getVehiculoSeleccionado();
                        System.out.print("El vehiculo se ha encontrado correctamente y estos son los datos correspondientes: \n"
                                + vehiculoSeleccionado.toString() + "\n\n");
                        loadMainMenu();
                        break;
                    } else {
                        System.out.println("La matrícula introducida no se encuentra registrada en nuestra base de datos \n");
                        loadMainMenu();
                        break;
                    }
                } else {
                    System.out.println("No se ha detectado ninguna matrícula \n");
                    loadMainMenu();
                    break;
                }
            case 4:
                System.out.println("ACTUALIZAR KILÓMETROS:");
                int nuevoKilometraje = 0;

                if (matriculaSeleccionada.equals("any")) {
                    System.out.println("No hay ningún vehículo seleccionado/buscado previamente. Para poder "
                            + "actualizar su número de kilómetros, primero tendrás que buscarlo adecuadamente: \n");
                    System.out.println("Introduce la matrícula a buscar:");
                    matriculaSeleccionada = scanner.nextLine();
                    vehiculoSeleccionado = concesionario1.encontrarVehiculoPorMatricula(matriculaSeleccionada);
                    // El siguiente paso de podría eliminar y a su vez, también se podría introducir los mensajes de respuesta dentro de la función
                    concesionario1.setVehiculoSeleccionado(vehiculoSeleccionado);
                } else {
                    matriculaSeleccionada = vehiculoSeleccionado.getMatricula();
                    vehiculoSeleccionado = concesionario1.encontrarVehiculoPorMatricula(matriculaSeleccionada);
                }
                int kmsAnt;

                System.out.println("Se ha seleccionado el siguiente vehículo: \n" + vehiculoSeleccionado.toString() + "\n");
                System.out.println("Introduce su nuevo kilometraje: ");
                nuevoKilometraje = Integer.parseInt(scanner.nextLine());
                kmsAnt = concesionario1.vehiculoSeleccionado.getNumKilometros();
                concesionario1.actualizarKms(nuevoKilometraje, concesionario1.vehiculoSeleccionado);
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
