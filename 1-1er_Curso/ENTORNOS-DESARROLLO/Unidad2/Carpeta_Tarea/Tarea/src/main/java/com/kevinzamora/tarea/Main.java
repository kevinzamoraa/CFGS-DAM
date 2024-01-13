/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kevinzamora.tarea;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Kanonimus
 */
public class Main extends JFrame {

    public Main() {
        JLabel lblSaludo = new JLabel("  Hola Mundo. Creando mi primer ejemplo");
        add(lblSaludo);
        this.setSize(400, 200);
        this.setTitle("Prueba con JFrame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }

}
