/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.kevinzamora.psp06_tarea;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kzdesigner // Kevin Zamora Amela
 */
public class PSP06Tarea {

    /**
     * Método 'main'/principal donde se aloja el proceso de entrada/recogida de datos 
     * mediante el terminal de comandos.
     */
    public static void main(String[] args) {

        try {

            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");

            String nombreUsuario;
            do {
                System.out.println("Introduce el nombre del usuario (8 letras minúsculas)");
                nombreUsuario = scanner.next().trim();

                if (!validarNombreUsuario(nombreUsuario)) {
                    System.out.println("¡Error! El nombre del usuario debe tener 8 letras minúsculas");
                    escribirLog("¡Error! El nombre del usuario debe tener un formato válido: " + nombreUsuario);
                }
            } while (!validarNombreUsuario(nombreUsuario));

            escribirLog("Usuario ingresado correctamente: " + nombreUsuario);

            String nombreFichero;
            do {
                System.out.println("Introduce el nombre del fichero (8 caracteres y 3 caracteres de extensión)");
                nombreFichero = scanner.next().trim();

                if (!validarNombreFichero(nombreFichero)) {
                    System.out.println("¡Error! El nombre del fichero debe tener 8 caracteres y 3 caracteres de extensión");
                    escribirLog("¡Error! El nombre del fichero debe tener un formato válido: " + nombreFichero);
                }
            } while (!validarNombreFichero(nombreFichero));
            
            escribirLog("Fichero ingresado correctamente: " + nombreFichero);

            leerFichero(nombreFichero);

        } catch (IOException ex) {
            Logger.getLogger(PSP06Tarea.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Método creado para validar que el nombre de usuario introducido cumple con los requisitos requeridos.
     * En nuestro caso, dicha cadena de texto debe estar compuesta por ocho carácteres alfanuméricos en minúsculas.
     * @param nombreUsuario
     * @return nombreUsuario.matches("[a-z]{8}");
     */
    public static boolean validarNombreUsuario(String nombreUsuario) {
        return nombreUsuario.matches("[a-z]{8}");
    }

    /**
     * Método creado para validar que el nombre de fichero introducido cumple con los requisitos requeridos.
     * En nuestro caso, dicha cadena de texto debe estar compuesta por ocho carácteres alfanuméricos en minúsculas,
     * un punto y tres carácteres alfanuméricos más, representando a la extensión del archivo.
     * @param nombreFichero
     * @return nombreFichero.matches("[a-zA-Z0-9]{8}\\.[a-zA-Z0-9]{3}");
     */
    public static boolean validarNombreFichero(String nombreFichero) {
        return nombreFichero.matches("[a-zA-Z0-9]{8}\\.[a-zA-Z0-9]{3}");
    }

    /**
     * Método creado para leer el fichero con el nombre introducido mediante consola de comandos, si este existe.
     * @param nombreFichero
     */
    public static void leerFichero(String nombreFichero) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(nombreFichero));

        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }

    }

    /**
     * Método creado para escribir cada uno de los eventos ocurridos durante la ejecución del programa
     * en un log/registro.
     * @param mensaje
     */
    private static void escribirLog(String mensaje) throws IOException {

        try (PrintWriter pw = new PrintWriter(new FileWriter("registro.log", true))) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatoFecha = LocalDateTime.now().format(formato);

            pw.println("(" + formatoFecha + ")" + mensaje);
        }

    }

}
