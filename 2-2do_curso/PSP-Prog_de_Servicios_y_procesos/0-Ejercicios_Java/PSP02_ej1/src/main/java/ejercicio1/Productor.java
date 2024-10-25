/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import java.util.logging.*;

/**
 *
 * @author kzdesigner
 */
public class Productor extends Thread {
    
    private Buffer buffer;
    private final String letters = "abcdefghijklmnopqrstuvwxyz";
    private int produced;
    private final int LIMIT = 15;
    
    public Productor(Buffer buffer) {
        this.produced = 0;
        this.buffer = buffer;
    }
    
    public void run() {
    
        while (produced < LIMIT) {
        
            try {
                char c = letters.charAt((int) (Math.random() * letters.length()));
                buffer.producir(c);
                produced++;
                System.out.println("Depositado el caracter " + c + " del 'buffer'");
                sleep ((long) (Math.random() * 4000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
    }
    
}
