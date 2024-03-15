/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kevinzamora.prog07_tarea.Models;

import java.util.ArrayList;

/**
 *
 * @author kzdesigner
 */
public class Cuenta {
    
    Persona titular;
    Number saldo;
    String numCuenta;
    String tipoCuenta;

    public Cuenta() {
    }

    public Cuenta(Persona titular, Number saldo, String numCuenta, String tipoCuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numCuenta = numCuenta;
        this.tipoCuenta = tipoCuenta;
    }
    
    
    
}
