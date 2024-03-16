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
public class CuentaCorrienteEmpresa extends CuentaCorriente {
    
    // Declaración de parámetros
    ArrayList<String> listaEntidades;
    Double comisionFijaPorDescubierto;
    Double tipoInteresPorDescubierto;
    Double maxDescubiertoPermitido;
    
    // Constructores de clase
    public CuentaCorrienteEmpresa() {}

    public CuentaCorrienteEmpresa(Persona titular, Double saldo, String numCuenta, 
            ArrayList<String> listaEntidades, Double comisionFijaPorDescubierto, 
            Double tipoInteresPorDescubierto, Double maxDescubiertoPermitido) {
        this.titular = titular;
        this.saldo = saldo;
        this.numCuenta = numCuenta;
        this.listaEntidades = listaEntidades;
        this.comisionFijaPorDescubierto = comisionFijaPorDescubierto;
        this.tipoInteresPorDescubierto = tipoInteresPorDescubierto;
        this.maxDescubiertoPermitido = maxDescubiertoPermitido;
    }
    
    // Método toString
    public String toString() {
        return "Datos de la cuenta corriente personal: \n" + numCuenta + " - " 
                + titular.toString() + " -> " + saldo + "€ / Comisión fija por descubierto: " 
                + comisionFijaPorDescubierto + ", Tipo de interés por "
                + "descubierto: " + tipoInteresPorDescubierto + ", Máximo descubieto "
                + "permitido: " + maxDescubiertoPermitido + ", Lista de entidades: " 
                + listaEntidades;
    }
    
}
