/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kevinzamora.prog07_tarea.Model;

import java.util.ArrayList;

/**
 *
 * @author kzdesigner
 */
public class CuentaCorrientePersonal extends CuentaCorriente {
    
    // Parámetros
    ArrayList<String> listaEntidades;
    Double comisionMantenimiento;
    
    // Constructores
    public CuentaCorrientePersonal() {}

    public CuentaCorrientePersonal(Persona titular, Double saldo, String numCuenta, 
            ArrayList<String> listaEntidades, Double comisionMantenimiento) {
        this.titular = titular;
        this.saldo = saldo;
        this.numCuenta = numCuenta;
        this.listaEntidades = listaEntidades;
        this.comisionMantenimiento = comisionMantenimiento;
    }
    
    // Método toString
    public String toString() {
        return "Datos de la cuenta corriente personal: \n" + numCuenta + " - " 
                + titular.toString() + " -> " + saldo + "€ / Comisión de mantenimiento:" 
                + comisionMantenimiento + ", Lista de entidades: " + listaEntidades;
    }
    
    
    
    
    
}
