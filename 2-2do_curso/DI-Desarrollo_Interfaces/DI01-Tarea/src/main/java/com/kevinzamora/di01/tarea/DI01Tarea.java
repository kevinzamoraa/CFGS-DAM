/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.kevinzamora.di01.tarea;

import com.kevinzamora.di01.tarea.ReservaSalonDialog;

/**
 *
 * @author kzdesigner
 */
public class DI01Tarea {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        ReservaSalonDialog reservaSalonDialogObj = new ReservaSalonDialog();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservaSalonDialog().setVisible(true);
            }
        });
    }
}
