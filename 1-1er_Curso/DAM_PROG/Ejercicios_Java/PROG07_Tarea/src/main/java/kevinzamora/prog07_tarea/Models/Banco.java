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
    
    // Declaración de variables
    ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>();
    Scanner scanner = new Scanner(System.in);
    
    private boolean abrirCuenta() {
        System.out.println("Selecciona el tipo de cuenta deseada: \n"
                + "1. Cuenta de Ahorro \n "
                + "2. Cuenta Corriente Personal \n "
                + "3. Cuenta Corriente Empresa \n ");
        
        return false;
    }
    
    private void listadoCuentas() {}
    
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
    
}
