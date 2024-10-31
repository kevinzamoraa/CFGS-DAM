/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import ejercicio2.HiloServidor;
import ejercicio2.Cliente;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kzdesigner
 */
public class Servidor {
    
    public static void main(String[] args) {
    
        try {
            ServerSocket servidor = new ServerSocket(1500);
            System.out.println("Se ha iniciado el servidor");
            
            while(true) {
            
                Socket sc = servidor.accept();
                
                HiloServidor hs = new HiloServidor(sc);
                hs.start();
            
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
