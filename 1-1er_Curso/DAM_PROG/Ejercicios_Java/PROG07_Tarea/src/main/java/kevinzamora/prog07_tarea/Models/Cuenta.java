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
    
    // DEFINICIÓN DE PARÁMETROS
    Persona titular;
    Number saldo;
    String numCuenta;
    String tipoCuenta;
    
    // CONSTRUCTORES
    public Cuenta() {
    }

    public Cuenta(Persona titular, Number saldo, String numCuenta, String tipoCuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numCuenta = numCuenta;
        this.tipoCuenta = tipoCuenta;
    }
    
    // MÉTODOS GETTER
    public Persona getTitular() {
        return titular;
    }
    public Number getSaldo() {
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
    public String completeInfoToString() {
        return "Nº Cuenta: " + numCuenta + ", Titular: " + titular.nombre + 
                " " + titular.apellidos + ", Saldo actual: " + saldo + "€ \n ";
    }
    
}
