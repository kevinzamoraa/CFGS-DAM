/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kevinzamora.final1_tarea;

import vista.Calculadora;

/**
 *
 * @author kzdesigner // Autor: Kevin Zamora Amela
 */
public class Principal {
    /* Hemos creado esta clase intermedia en respuesta al enunciado presentado y funcionando a modo 
    de 'puente' entre nuestra clase raiz y la clase que implementa el entorno gráfico y también la 
    funcionalidad de nuestra calculadora */
    
    /* Hemos creado también un método auxiliar, el cual hemos llamado desde nuestra clase raiz. 
    Mediante este, creamos una instancia de nuestra clase Calculadora y acto seguido,
    aludimos al método  'setVisible' (derivado de la clase JFrame), para modificar así el estado 
    de nuestra clase Calculadora y hacerla visible */
    /**
     * Método auxiliar para instanciar y visualizar la interfaz gráfica de nuestra aplicación
     */
    public void showCalculadora() {
        Calculadora calculadoraObj = new Calculadora();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Calculadora().setVisible(true);
        });
    }
}
