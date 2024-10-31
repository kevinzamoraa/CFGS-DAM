/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kzdesigner
 */
public class Cliente {
    
    public static void main(String[] args) {
    
        try {
            
            Socket sc = new Socket("localhost", 1500);
            
            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());
            
            boolean salir = false;
            
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            
            System.out.println("Introduce la ruta del archivo a mostrar:");
            String ruta = scanner.next();
            
            out.writeUTF(ruta);
            
            boolean existe = in.readBoolean();
            
            if (existe) {
                
                int longitud = in.readInt();
                
                byte[] contenido = new byte[longitud];
                
                for (int i = 0; i < longitud; i++) {
                    contenido[i] = in.readByte();
                }
                
                String contenidoFichero = new String(contenido);
                
                System.out.println(contenidoFichero);
                
            } else {
                System.out.println("Error, no existe el fichero");
            }
            
            sc.close();
                    
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
