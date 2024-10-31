/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
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
    
    @Override
    public void run() {
    
        System.out.println("Cliente conectado");
        DataInputStream in = null;
        DataOutputStream out = null;
        try {
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            
            String ruta = in.readUTF();
            
            File f = new File(ruta);
            
            if(f.exists()) {
                out.writeBoolean(true);
                
                BufferedReader br = new BufferedReader(new FileReader(ruta));
                
                String linea = "";
                String contenido = "";
                
                while((linea = br.readLine()) != null) {
                    contenido += linea;
                }
                
                br.close();
                
                byte[] contenidoFichero = contenido.getBytes();
                
                out.writeInt(contenidoFichero.length);
                
                for (int i = 0; i < contenidoFichero.length; i++) {
                    out.writeByte(contenidoFichero[i]);
                }
                
                sc.close();
                
            } else {
                out.writeBoolean(false);
            }
            
            sc.close();
            System.out.println("Cliente desconectado");
            
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
