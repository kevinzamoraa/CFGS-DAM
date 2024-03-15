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
    
    String numCuenta;
    Double tipoInteresAnual;

    public CuentaAhorro() {
    }

    public CuentaAhorro(String numCuenta, Double tipoInteresAnual) {
        this.numCuenta = numCuenta;
        this.tipoInteresAnual = tipoInteresAnual;
    }
    
    
    
}
