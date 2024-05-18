/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import com.kevinzamora.calculadora.vista.CalculadoraGUI;

/**
 *
 * @author kzdesigner
 */
public class Calculadora {

    public static void main(String[] args) {
        CalculadoraGUI calculadoraObj = new CalculadoraGUI();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraGUI().setVisible(true);
            }
        });
    }
}
