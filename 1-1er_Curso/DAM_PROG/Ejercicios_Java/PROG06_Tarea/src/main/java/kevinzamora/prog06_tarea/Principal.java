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
        int opcion = scanner.nextInt();

        switch (opcion) {

            case 1:
                System.out.println("INTRODUCIR DATOS - CREAR NUEVO VEHÍCULO: \n");

                concesionario1.creaUnVehiculo(vehiculos);
//                concesionario1.imprimeVehiculos(vehiculos);
//                System.out.println("NO VEO LA CAUSA POR LA QUE EL PROGRAMA NO ES CAPAZ DE AÑADIR EL NUEVO \n"
//                        + "ITEM A NUESTRO 'ARRAY' CARGADO EN MEMORIA, AUNQUE SEA SÓLO PARA PODER MOSTRARLO \n"
//                        + "TEMPORALMENTE. AGRADECERÍA ALGO DE AYUDA PARA LOGRAR LOCALIZAR EL 'ERROR' "
//                        + "EN CUESTIÓN\n\n");

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
                loadMainMenu();
                break;
            case 3:
                System.out.println("BÚSCA UN VEHÍCULO: \n ");
                concesionario1.imprimeCaracteristicasVehiculos(vehiculos);
                System.out.println("INTRODUCE LA MATRÍCULA DEL VEHÍCULO A BUSCAR: \n");
                matriculaVehiculoSeleccionado = scanner.nextLine();
                vehiculoSeleccionado = concesionario1.encontrarVehiculoPorMatricula(matriculaVehiculoSeleccionado, vehiculos);
                if (vehiculoSeleccionado != null) {
                    System.out.print("El vehiculo se ha encontrado correctamente y estos son los datos correspondientes: \n\n");
                    System.out.print(vehiculoSeleccionado.toString());
                } else { System.out.println("No se ha detectado ningún valor válido introducido con el que realizar la busqueda"); }
                loadMainMenu();
                break;
            case 4:
                System.out.println("ACTUALIZAR KILÓMETROS: \n Introduce su nuevo kilometraje: ");
                int nuevoKilometraje = scanner.nextInt();
                concesionario1.actualizarKms(nuevoKilometraje, concesionario1.vehiculoSeleccionado);
                int kmsVehiculoSeleccionado = concesionario1.vehiculoSeleccionado.getNumKilometros();
                System.out.println("Los kilometros del coche has sido actualizados correctamente; ahora tiene "
                        + kmsVehiculoSeleccionado + " kilometros \n");
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
