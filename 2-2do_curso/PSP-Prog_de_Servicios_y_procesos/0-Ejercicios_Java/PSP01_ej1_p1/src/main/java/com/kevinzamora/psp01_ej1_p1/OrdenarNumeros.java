/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.kevinzamora.psp01_ej1_p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kzdesigner
 */
public class OrdenarNumeros {

    public static void main(String[] args) {
        
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader bf = new BufferedReader(isr);
            
            String entradaTeclado = null;
            
            System.out.print("Introduce los números a ordenar a través del teclado y separados por un espacio: \n");
            while((entradaTeclado = bf.readLine()) != null) {
                String datos[] = entradaTeclado.split(" ");
                int numeros[] = new int[datos.length];
                
                for (int i = 0; i < numeros.length; i++) {
                    numeros[i] = Integer.parseInt(datos[i]);
                }
                
                Arrays.sort(numeros);
                
                System.out.println("A continuación, se muestran ordenados los números introducidos: ");
                for(int i = 0; i < numeros.length; i++) {
                    System.out.print(numeros[i] + " ");
                }
                System.out.println(" ");
            }
        } catch (IOException ex) {
            Logger.getLogger(OrdenarNumeros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
