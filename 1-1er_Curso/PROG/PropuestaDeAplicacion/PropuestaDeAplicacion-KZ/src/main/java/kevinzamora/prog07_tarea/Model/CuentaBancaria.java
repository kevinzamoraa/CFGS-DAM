/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kevinzamora.prog07_tarea.Model;

import java.util.ArrayList;
//import kevinzamora.prog07_tarea.Controler.Imprimible;

/**
 *
 * @author kzdesigner
 */
public class CuentaBancaria /*implements Imprimible*/ {
    
    // DEFINICIÓN DE PARÁMETROS
    Persona titular;
    Double saldo;
    String numCuenta;
    String tipoCuenta;
    
    // CONSTRUCTORES
    public CuentaBancaria() {
    }

    public CuentaBancaria(Persona titular, Double saldo, String numCuenta, String tipoCuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numCuenta = numCuenta;
        this.tipoCuenta = tipoCuenta;
    }
    
    // MÉTODOS GETTER
    public Persona getTitular() {
        return titular;
    }
    public Double getSaldo() {
        return saldo;
    }
    public String getNumCuenta() {
        return numCuenta;
    }
    public String getTipoCuenta() {
        return tipoCuenta;
    }
    
    // MÉTODOS SETTER
    public void setTitular(String nombre, String Apellidos, String DNI) {
        Persona nuevoTitular = new Persona(nombre, Apellidos, DNI);
        titular = nuevoTitular;
    }
    public void setSaldo(double nuevoSaldo) {
        saldo = nuevoSaldo;
    }
    public void setNumCuenta(String nuevoNumCuenta) {
        numCuenta = nuevoNumCuenta;
    }
    public void setTipoCuenta(String tipoCuentaSelec) {
        tipoCuenta = tipoCuenta;
    }
    
    // MÉTODOS AUXILIARES
    public String toString() {
        return "Nº Cuenta: " + numCuenta + ", Titular: " + titular.nombre + 
                " " + titular.apellidos + ", Saldo actual: " + saldo + "€ \n ";
    }
}
