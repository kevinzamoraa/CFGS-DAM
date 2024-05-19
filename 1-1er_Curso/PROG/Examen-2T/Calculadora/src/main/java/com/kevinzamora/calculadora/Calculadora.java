/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.kevinzamora.calculadora;

import com.kevinzamora.calculadora.vista.CalculadoraGUI;

/**
 *
 * @author kzdesigner
 */
public class Calculadora {

    public static void main(String[] args) {
        CalculadoraGUI mainMenuObj = new CalculadoraGUI();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraGUI().setVisible(true);
            }
        });
    }
}
