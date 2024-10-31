/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import ejercicio1.HiloServidor;
import ejercicio1.Cliente;
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
            ServerSocket servidor = new ServerSocket(2000);
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
