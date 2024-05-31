/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kevinzamora.parcial2_tarea;

import vista.Calculadora;

/**
 *
 * @author kzdesigner
 */
public class Principal {
    public void showCalculadora() {
        Calculadora calculadoraObj = new Calculadora();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Calculadora().setVisible(true);
        });
    }
}
