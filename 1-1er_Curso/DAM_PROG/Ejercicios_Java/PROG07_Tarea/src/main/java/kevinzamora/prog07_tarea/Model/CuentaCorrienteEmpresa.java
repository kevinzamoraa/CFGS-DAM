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
    
    ArrayList<String> listaEntidades;
    Double tipoInteresPorDescubierto;
    Double maxDescubiertoPermitido;

    public CuentaCorrienteEmpresa() {
    }

    public CuentaCorrienteEmpresa(Persona titular, Number saldo, String numCuenta, 
            ArrayList<String> listaEntidades, Double tipoInteresPorDescubierto, 
            Double maxDescubiertoPermitido) {
        this.numCuenta = numCuenta;
        this.listaEntidades = listaEntidades;
        this.tipoInteresPorDescubierto = tipoInteresPorDescubierto;
        this.maxDescubiertoPermitido = maxDescubiertoPermitido;
    }
    
    // Método toString
    public String toString() {
        return "Datos de la cuenta corriente personal: \n" + numCuenta + " - " 
                + titular.toString() + " -> " + saldo + "€ / Tipo de interés por "
                + "descubierto: " + tipoInteresPorDescubierto + " Máximo descubieto "
                + "permitido: " + maxDescubiertoPermitido + " Lista de entidades: " 
                + listaEntidades;
    }
    
}
