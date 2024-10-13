/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.kevinzamora.Ejercicio2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kzdesigner
 */
public class Lenguaje {

    public static void main(String[] args) {

        String letras = "abcdefghijklmnopqrstuvwxyz";
        String nombreFichero;
        FileLock bloqueo = null;

        if (args.length == 2) {
            try {
                int numLineas = Integer.parseInt(args[0]);
                String osName = System.getProperty("os.name");

                if (osName.toUpperCase().contains("WIN")) {
                    nombreFichero = args[1].replace("\\", "\\\\");
                } else {
                    nombreFichero = args[1];
                }

                File archivo = new File(nombreFichero);

                if (!archivo.exists()) {

                    archivo.createNewFile();

                }

                RandomAccessFile raf = new RandomAccessFile(archivo, "rwd");
                
                bloqueo = raf.getChannel().lock();
                
                raf.seek(archivo.length());
                
                for (int i = 0; i < numLineas; i++) {
                
                    String linea = "";
                    int numCaracteres = generarNumeroAleatorio(1, 10);
                    
                    for (int j = 0; j < numCaracteres; i++) {
                        linea += letras.charAt(generarNumeroAleatorio(0, letras.length() - 1));
                    }
                    
                    raf.writeChars(linea + "\n");
                
                }
                
                bloqueo.release();
                bloqueo = null;
                raf.close();
                
            } catch (IOException ex) {
                Logger.getLogger(Lenguaje.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("El programa debe tener dos parámetros");
        }

    }
    
    public static int generarNumeroAleatorio(int min, int max) {
        int num = (int) (Math.random()*(max - min + 1) + (min));
        return num;
    }
    
}
