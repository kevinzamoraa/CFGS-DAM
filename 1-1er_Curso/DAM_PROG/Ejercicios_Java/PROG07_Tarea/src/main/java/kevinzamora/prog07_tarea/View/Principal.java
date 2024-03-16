/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kevinzamora.prog07_tarea.View;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import kevinzamora.prog07_tarea.Model.Banco;

/**
 *
 * @author kzdesigner // Autor y nombre del equipo de Kevin Zamora Amela
 */
public class Principal {
    
    /* En la clase Principal definimos y construimos la estructura del menú de 
    navegación de nuestra aplicación */
    /* A su vez, también instanciamos la clase Banco para poder hacer uso de las 
    funciones/métodos, creados para gestionar las diferentes cuentas de nuestra 
    aplicación y desarrollados/ejecutados mediante esta */
    Banco bancoObj = new Banco();

    // Estructura de nuestro menú principal imprimido por pantalla
    public void loadMainMenu() {

        System.out.println("BIENVENID@S A NUESTRO BANCO: \n");
        System.out.println("ADMINISTRA TU CUENTA, NUESTRAS OPCIONES SON: \n "
                + "1. Abrir una nueva cuenta. \n "
                + "2. Ver listado de cuentas disponibles. \n "
                + "3. Obtener los datos de una cuenta concreta. \n "
                + "4. Realizar un ingreso. \n "
                + "5. Retirar efectivo. \n "
                + "6. Consultar el saldo actual de mi cuenta \n "
                + "7. Salir \n");
        
        // Método de entrada para seleccionar la opción deseada
        System.out.println("SELECCIONA UNA OPCIÓN (Introduce un nº entero):");
        Scanner scanner = new Scanner(System.in);
        int opcion = Integer.parseInt(scanner.nextLine());

        // Conmutador/Switch necesario para realizar la selección de la opción deseada
        // En cada opción se procede a llamar la función necesaria mediante 'bancoObj.' y nombre función + ()
        switch (opcion) {
            case 1:
                System.out.println("INTRODUCIR DATOS DE LA NUEVA CUENTA: \n");
                boolean addedAccount = bancoObj.getAbrirCuenta();
                if (addedAccount) {System.out.println("Cuenta añadida con éxito! \n ");} 
                else {System.out.println("No se ha podido añadir. Prueba de nuevo "
                        + "más tarde. \n ");}
                loadMainMenu();
                break;
            case 2:
                System.out.println("LISTA DE CUENTAS DISPONIBLES:");
                bancoObj.getListadoCuentas();                
                loadMainMenu();
                break;
            case 3:
                bancoObj.getInformacionCuenta();
                loadMainMenu();
                break;
            case 4:
                System.out.println("INGRESAR EFECTIVO:");
                bancoObj.ingresar();
                loadMainMenu();
                break;
            case 5:
                System.out.println("RETIRAR EFECTIVO:");
                bancoObj.retirar();
                loadMainMenu();
                break;
            case 6:
                System.out.println("SALDO DE MI CUENTA:");
                bancoObj.getSaldo();
                loadMainMenu();
                break;
            case 7:
                System.out.println("¡HASTA PRONTO!");
                break;
            default:
                System.out.println("LA OPCIÓN INTRODUCIDA NO ES VÁLIDA \n");
                
                break;
        }
    }
}
