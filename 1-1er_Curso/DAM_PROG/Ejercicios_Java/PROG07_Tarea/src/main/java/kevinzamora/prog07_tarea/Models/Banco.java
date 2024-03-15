/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kevinzamora.prog07_tarea.Models;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kzdesigner
 */
public class Banco {
    
    // Declaración de variables contenedoras
    ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>();
    ArrayList<CuentaAhorro> listaCuentasAhorro = new ArrayList<CuentaAhorro>();
    ArrayList<CuentaCorrientePersonal> listaCuentaCPersonal = 
            new ArrayList<CuentaCorrientePersonal>();
    ArrayList<CuentaCorrienteEmpresa> listaCuentaCEmpresa = 
            new ArrayList<CuentaCorrienteEmpresa>();
    Cuenta nuevaCuenta;
    
    // Declaración de variables de lectura o de entrada
    Scanner scanner = new Scanner(System.in);
    
    // Métodos -> Operaciones con cuentas
    // Crear una cuenta nueva
    private boolean abrirCuenta() {
        System.out.println("Introduce el nombre del/de la titular: ");
        String nombre = scanner.nextLine();
        System.out.println("Introduce el/los apellidos del/de la titular: ");
        String apellidos = scanner.nextLine();
        System.out.println("Introduce el DNI del/de la titular: ");
        String DNI = scanner.nextLine();
        Persona nuevxTitular = new Persona(nombre, apellidos, DNI);
        System.out.println("Selecciona el tipo de cuenta deseada: \n "
                + "1. Cuenta de Ahorro \n "
                + "2. Cuenta Corriente Personal \n "
                + "3. Cuenta Corriente Empresa ");
        int tipoCuentaIndicado = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el saldo de la nueva cuenta: ");
        Double nuevoSaldoCuenta = Double.parseDouble(scanner.nextLine());
        System.out.println("Introduce el número de cuenta: ");
        String numCuenta = scanner.nextLine();
        switch (tipoCuentaIndicado) {
            case 1:
                System.out.println("Estás creando una cuenta de ahorro!? \n "
                        + "Si es así, introduce el tipo de interés de la "
                        + "remuneración: ");
                double tipoInteresRemuneracion = Double.parseDouble(scanner.nextLine());
                System.out.println("El tipo de interés ha sido leido correctamente.");
                CuentaAhorro nuevaCuentaAhorro = new CuentaAhorro(nuevxTitular,
                        nuevoSaldoCuenta, numCuenta, tipoInteresRemuneracion);
                nuevaCuenta = new Cuenta(nuevxTitular, nuevoSaldoCuenta, 
                        numCuenta, numCuenta);
                listaCuentas.add(nuevaCuenta);
                listaCuentasAhorro.add(nuevaCuentaAhorro);
                
                return true;
            case 2:
                System.out.println("Estás creando una cuenta corriente personal. \n "
                        + "Si es así, introduce el importe de la comisión de "
                        + "mantenimiento: \n");
                double comisionMantenimiento = Double.parseDouble(scanner.nextLine());
                System.out.println("La comisión de mantenimiento ha sido leido correctamente.");
                break;
            case 3:
                System.out.println("Estás creando una cuenta corriente de empresa!? \n "
                        + "Si es así, introduce el valor máximo de descubierto "
                        + "introducido: \n");
                double nivelMaximoDescubiertoPermitido = 
                        Double.parseDouble(scanner.nextLine());
                System.out.println("El valor del máximo descubierto permitido ha sido "
                        + "leido correctamente. \n");
                System.out.println("Introduce el tipo de interés por descubrimiento: \n");
                double tipoInteresPorDescubrimiento = 
                        Double.parseDouble(scanner.nextLine());
                System.out.println("El valor del máximo descubierto permitido ha sido "
                        + "leido correctamente. \n");
                System.out.println("Introduce el valor de la comisión fija por "
                        + "cada descubierto: \n");
                double comisionFijaPorDescubierto = 
                        Double.parseDouble(scanner.nextLine());
                System.out.println("El valor del máximo descubierto permitido ha sido "
                        + "leido correctamente.");
                break;
            default:
                System.out.println("Se ha producido un pequeño error en tiempo de "
                        + "ejecución. Por favor, inténtelo de nuevo más tarde");
                break;
        }
        
        return false;
    }
    
    private void listadoCuentas() {
        for (Cuenta cuenta : listaCuentas) {
            System.out.println(cuenta);
        }
    }
    
    private void informacionCuenta() {}
    
    /**
     * Fúnción/Método referente a y contenedor de la funcionalidad necesaria 
     * para poder ingresar efectivo en la cuenta en cuestión
     * @param cantidad Inserta la cantidad introducida/deseada
     * @exception Exception Se muestra el error "No se puede ingresar una cantidad negativa" 
     * cuando se intenta ingresar un valor inferior a 0
     **/
    public void ingresar(double cantidad) throws Exception
    {
        if (cantidad<0)
            throw new Exception("No se puede ingresar una cantidad negativa");
//        saldo = saldo + cantidad;
    }
    
    /**
     * Función/Método contenedor de la funcionalidad necesaria para poder 
     * retirar cierta cantidad pasada vía parámetro del saldo disponible en la 
     * cuenta en cuestión
     * @param cantidad Inserta la cantidad introducida/deseada
     * @exception Exception Muestra un error distinto en base a dos supuestos: valor 
     * negativo y saldo insuficiente
     **/
    public void retirar(double cantidad) throws Exception
    {
        if (cantidad <= 0)
            throw new Exception ("No se puede retirar una cantidad negativa");
//        if (estado()< cantidad)
//            throw new Exception ("No se hay suficiente saldo");
//        saldo = saldo - cantidad;
    }
    
    // MÉTODOS GETTER (FUNCIONES OPERATIVAS)
    public boolean getAbrirCuenta() {
        return abrirCuenta();
    }
    public void getListadoCuentas() {
        listadoCuentas();
    }
}
