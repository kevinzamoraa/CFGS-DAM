/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.kevinzamora.psp06_tarea;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author kzdesigner
 */
public class PSP06Tarea {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        
        String nombreUsuario;
        do {
            System.out.println("Introduce el nombre del usuario (8 letras minúsculas)");
            nombreUsuario = scanner.next();
            
            if(!validarNombreUsuario(nombreUsuario)) {
                System.out.println("¡Error! El nombre del usuario debe tener 8 letras minúsculas");
            }
        } while (!validarNombreUsuario(nombreUsuario));
        
        String nombreFichero;
        do {
            System.out.println("Introduce el nombre del fichero (8 caracteres y 3 caracteres de extensión)");
            nombreFichero = scanner.next();
            
            if(!validarNombreFichero(nombreFichero)) {
                System.out.println("¡Error! El nombre del fichero debe tener 8 caracteres y 3 caracteres de extensión");
            }
        } while (!validarNombreFichero(nombreFichero));
        
        try {
            leerFichero(nombreFichero);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public static boolean validarNombreUsuario(String nombreUsuario) {
        return nombreUsuario.matches("[a-z]{8}");
    }
    
    public static boolean validarNombreFichero(String nombreFichero) {
        return nombreFichero.matches("[a-zA-Z0-9]{8}\\.[a-zA-Z0-9]{3}");
    }
    
    public static void leerFichero(String nombreFichero) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
        
        String linea;
        while ( (linea = br.readLine()) != null ) {
            System.out.println(linea);
        }
        
    }
    
}
