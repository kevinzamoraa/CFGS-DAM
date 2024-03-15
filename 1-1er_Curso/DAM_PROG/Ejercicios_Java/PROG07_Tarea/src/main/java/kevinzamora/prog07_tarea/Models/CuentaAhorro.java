/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kevinzamora.prog07_tarea.Models;

/**
 *
 * @author kzdesigner
 */
public class CuentaAhorro extends Cuenta {
    
    // Definición de parámetros
    Persona titular;
    Number saldo;
    String numCuenta;
    Double tipoInteresAnual;
    
    // Constructores
    public CuentaAhorro() {
    }

    public CuentaAhorro(Persona titular, Number saldo, String numCuenta, 
            Double tipoInteresAnual) {
        this.titular = titular;
        this.saldo = saldo;
        this.numCuenta = numCuenta;
        this.tipoInteresAnual = tipoInteresAnual;
    }
    
}
