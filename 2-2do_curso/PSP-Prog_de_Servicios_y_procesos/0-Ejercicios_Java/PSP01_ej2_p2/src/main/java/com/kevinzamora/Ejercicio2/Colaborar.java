/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.kevinzamora.Ejercicio2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kzdesigner
 */
public class Colaborar {

    public static void main(String[] args) {

        if (args.length == 1) {

            try {
                for (int i = 1; i <= 10; i++) {

                    System.out.println("Lanzado el proceso: " + i);

                    String comando = "java -jar lenguaje.jar " + (i * 10) + " " + args[0];
                    System.out.println("Lanzamos el siguiente comando: " + comando);

                    Runtime.getRuntime().exec(comando);
                }

            } catch (SecurityException ex) {
                System.out.println("Problema de seguridad: \n" + ex.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(Colaborar.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
