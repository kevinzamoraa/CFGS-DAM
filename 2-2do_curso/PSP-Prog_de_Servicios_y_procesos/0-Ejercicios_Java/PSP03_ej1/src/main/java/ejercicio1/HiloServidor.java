/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kzdesigner
 */
public class HiloServidor extends Thread {

    private Socket sc;
    
    public HiloServidor(Socket sc) {
        this.sc = sc;
    }
    
    public void run() {
    
        System.out.println("Cliente conectado");
        DataInputStream in = null;
        DataOutputStream out = null;
        
        try {
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            
            int numAleatorio = generarNumeroAleatorio(0,100);
            int numUsuario;
            
            
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    private int generarNumeroAleatorio(int min, int max) {
        int num = (int) (Math.random()*(max - min + 1) + (min));
        return num;
    }
    
}