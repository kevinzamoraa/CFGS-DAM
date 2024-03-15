/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kevinzamora.prog07_tarea;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author kzdesigner // Autor y nombre del equipo de Kevin Zamora Amela
 */
public class Principal {

    public void loadMainMenu() {

        System.out.println("BIENVENID@S A NUESTRO INVENTARIO DE VEHICULOS: \n");
        System.out.println("NUESTRAS OPCIONES: \n "
                + "1. Nuevo Vehículo. \n 2. Listar Vehículos. \n "
                + "3. Buscar Vehículo. \n 4. Modificar kms Vehículo. \n "
                + "5. Salir \n");

        System.out.println("SELECCIONA UNA OPCIÓN (Introduce un nº entero):");
        Scanner scanner = new Scanner(System.in);
        int opcion = Integer.parseInt(scanner.nextLine());

        switch (opcion) {

            case 1:
                System.out.println("INTRODUCIR DATOS - CREAR NUEVO VEHÍCULO: \n");
                
                loadMainMenu();
                break;
            case 2:
                
                loadMainMenu();
                break;
            case 3:
                System.out.println("BÚSCA UN VEHÍCULO: \n ");
                
                System.out.println("TODO: Falta por depurar y reparar la selección de un vehículo cuando este lo acabemos de "
                        + "crear/introducir y está almacenado sólo en memoria 'volatil'. De momento, nuestro programa no "
                        + "resulta capaz de leer y mostrar la información referente a dicho item \n");
                System.out.println("INTRODUCE LA MATRÍCULA DEL VEHÍCULO A BUSCAR: ");
                
                
                break;
            case 4:
                System.out.println("ACTUALIZAR KILÓMETROS:");
                int nuevoKilometraje = 0;

                
                loadMainMenu();
                break;
            case 5:
                System.out.println("¡HASTA PRONTO!");
                break;
            default:
                System.out.println("LA OPCIÓN INTRODUCIDA NO ES VÁLIDA \n");
                
                break;
        }
    }
}
