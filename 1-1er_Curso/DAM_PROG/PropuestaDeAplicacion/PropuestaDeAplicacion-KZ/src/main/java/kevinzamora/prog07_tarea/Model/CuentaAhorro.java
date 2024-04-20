/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kevinzamora.prog07_tarea.Model;

/**
 *
 * @author kzdesigner
 */
public class CuentaAhorro extends CuentaBancaria {
    
    // Definición de parámetros
    Double tipoInteresAnual;
    
    // Constructores
    public CuentaAhorro() {
    }

    public CuentaAhorro(Persona titular, Double saldo, String numCuenta, 
            Double tipoInteresAnual) {
        this.titular = titular;
        this.saldo = saldo;
        this.numCuenta = numCuenta;
        this.tipoInteresAnual = tipoInteresAnual;
    }
    
    public String toString(){
        return "Datos de la cuenta de ahorros: \n " + numCuenta + " - " + 
                titular.toString() + " / Tipo de interés anual: " + 
                tipoInteresAnual + " / Saldo de la cuenta (€): " + saldo;
    }
    
}
