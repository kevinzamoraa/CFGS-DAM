/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kevinzamora.prog05_ejerc1;

import java.util.Scanner;

/**
 *
 * @author kzdesigner  // Autor y nombre del equipo de Kevin Zamora Amela
 */
public class Principal {
    
    int idVehiculoSeleccionado;
    Vehiculo vehiculoSeleccionado;
    
    public void loadMainMenu() {
        
        System.out.println("BIENVENID@S A NUESTRO INVENTARIO DE VEHICULOS: \n");
        System.out.println("NUESTRAS OPCIONES: \n 0. Busca un Vehiculo. \n "
                + "1. Nuevo Vehiculo. \n 2. Ver Matrícula. \n "
                + "3. Ver Número de Kilometros. \n 4. Actualizar Kilometros. \n "
                + "5. Ver años de antiguedad \n 6. Mostrar propietario. \n "
                + "7. Mostrar descripción. \n 8. Mostrar Precio. \n 9. Salir \n");
        
        System.out.println("SELECCIONA UNA OPCIÓN (Introduce un nº entero):");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        
        switch (opcion) {
            
            case 0:
                System.out.println("BÚSCA UN VEHÍCULO: \n ");
                System.out.println("INTRODUCE EL NÚMERO ID A BUSCAR: \n ");
                idVehiculoSeleccionado = scanner.nextInt();
                
                break;
            case 1:
                System.out.println("INTRODUCIR DATOS - NUEVO VEHÍCULO: \n");
                
                loadMainMenu();
                break;
            case 2:
                System.out.println("VER MATRICULA DEL VEHICULO: \n");
                                
                loadMainMenu();
                break;
            case 3:
                System.out.println("VER NÚMERO DE KILÓMETROS: \n");
                
                loadMainMenu();
                break;
            case 4:
                System.out.println("ACTUALIZAR KILÓMETROS: \n");
                
                loadMainMenu();
                break;
            case 5:
                System.out.println("VER AÑOS DE ANTIGUEDAD: \n");
                
                loadMainMenu();
                break;
            case 6:
                System.out.println("MOSTRAR PROPIETARIO: \n");
                
                loadMainMenu();
                break;
            case 7:
                System.out.println("MOSTRAR DESCRIPCIÓN: \n");
                
                loadMainMenu();
                break;
            case 8:
                System.out.println("MOSTRAR PRECIO: \n");
                
                loadMainMenu();
                break;
            case 9:
                System.out.println("¡HASTA PRONTO!");
                break;
            default:
                System.out.println("LA OPCIÓN INTRODUCIDA NO ES VÁLIDA");
                loadMainMenu();
                break;
            
        }
    
    }
    
}
