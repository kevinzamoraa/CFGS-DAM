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
public class Buffer {
    
    private char[] buffer;
    private int next;
    private boolean itsFullFilled;
    private boolean itsEmpty;
    
    public Buffer(int tamanio) {
    
        this.buffer = new char[tamanio];
        this.next = 0;
        this.itsFullFilled = false;
        this.itsEmpty = true;
        
    }
    
    public synchronized char consumir() {
    
        while (this.itsEmpty) {
        
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
                           
        }
        
        this.next--;
        this.itsFullFilled = false;
            
        if (this.next == 0) {
            this.itsEmpty = true;   
        }
        
        notifyAll();
        
        return this.buffer[this.next];
            
    }
    
    public synchronized void producir(char c) {
    
        while (this.itsFullFilled) {
        
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
        this.buffer[this.next] = c;
        
        this.next++;
        this.itsEmpty = false;
        
        if(this.next == this.buffer.length) {
            this.itsFullFilled = true;
        }
        
        notifyAll();
        
    }
    
}
