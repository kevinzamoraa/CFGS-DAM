/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARCIAL1_util;

import PARCIAL1.Piso;
import PARCIAL1.Propietario;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author kzdesigner
 */
public class pisoRepo {
    
    Piso pisoSeleccionado = new Piso("C/ Falsa", 10.5f, LocalDate.of(2015,3,11), new Propietario("Pedro", "12345678H"), 2, 1, 1, 1);
    
//    Piso[] pisos = {}
    
    public void loadMainMenu() {
        
        System.out.print("BIENVENIDOS A NUESTRA APLICACIÓN INMOBILIARIA: \n");
        System.out.println("OPCIONES: \n 1. Nuevo Piso. \n 2. Ver dirección. \n 3. Ver precio. \n"
                + "4. Actualizar precio. \n 5. Ver años de antigüedad. \n 6. Mostrar propietario. \n"
                + "7. Mostrar datos. \n 8. Salir. \n");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("SELECCIONA LA OPCIÓN DESEADA: \n");
        int opcionSeleccionada = scanner.nextInt();
        
        switch (opcionSeleccionada) {
        
            case 1:
                System.out.println("AÑADE UN NUEVO PISO: \n");
                System.out.println("Introduce su dirección: \n (En proceso)");
                loadMainMenu();
                break;
            case 2:
                System.out.println("DIRECCIÓN: \n");
                System.out.println(pisoSeleccionado.getDireccion());
                loadMainMenu();
                break;
            case 3:
                System.out.println("PRECIO:");
                System.out.println(pisoSeleccionado.getPrecio());
                loadMainMenu();
                break;
            case 4:
                System.out.println("INTRODUCE EL NUEVO PRECIO:");
                float nuevoPrecio = scanner.nextFloat();
                pisoSeleccionado.setPrecio(nuevoPrecio);
                loadMainMenu();
                break;
            case 5:
                System.out.println("AÑOS DE ANTIGUEDAD:");
                System.out.println(pisoSeleccionado.get_Anios(pisoSeleccionado.getFechaConstruccion()));
                break;
            case 6:
                System.out.println("PROPIETARIO");
                System.out.println(pisoSeleccionado.getPropietario().toString());
                loadMainMenu();
                break;
            case 7:
                System.out.println("DATOS DEL PISO: \n"
                        + "Número de habitaciones: " + pisoSeleccionado.getNumHabitaciones()
                        + " Nº de Baños: " + pisoSeleccionado.getNumBanios() 
                        + " Nº de Garajes: " + pisoSeleccionado.getGaraje()
                        + " Nº de Ascensores: " + pisoSeleccionado.getAscensor());
                loadMainMenu();
                break;
            case 8:
                System.out.println("HASTA PRONTO!!!");
                break;
            default:
                System.out.println("OPCIÓN EQUIVOCADA");
                break;
                
        
        }
    }
    
}
