/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.kevinzamora.principal;

/**
 *
 * @author Kevin
 */
public class ExamenDI_T1_25 {

    public static void main(String[] args) {
        Principal principalDialog = new Principal();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
}
