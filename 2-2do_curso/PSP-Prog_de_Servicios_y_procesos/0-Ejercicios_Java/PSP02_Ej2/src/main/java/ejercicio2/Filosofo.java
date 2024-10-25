/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kzdesigner
 */
public class Filosofo extends Thread {
    
    private Mesa mesa;
    private int comensal;
    private int indiceComensal;
    
    public Filosofo(Mesa m, int comensal) {
    
        this.comensal = comensal;
        this.indiceComensal = comensal - 1;
        this.mesa = m;
    
    }
    
    public void run() {
        while(true) {
            try {
                this.pensando();
                System.out.println("Filósofo " + this.comensal + " esta hambriento");
                mesa.cogerPalillos(this.indiceComensal);
                this.comiendo();
                System.out.println("Filósofo " + this.comensal + " ha terminado "
                        + "de comer y hay palillos libres: " 
                        + this.mesa.palilloIzquierdo(this.indiceComensal) + ", " 
                        + this.mesa.palilloDerecho(this.indiceComensal)
                );
                mesa.dejarPalillos(this.indiceComensal);
            } catch (InterruptedException ex) {
                Logger.getLogger(Filosofo.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public void pensando() throws InterruptedException {
        System.out.println("Filósofo " + this.comensal + " está pensando");
        Thread.sleep(2000);
    }
    
    public void comiendo() throws InterruptedException {
        System.out.println("Filósofo " + this.comensal + " está comiendo");
        Thread.sleep(2000);
    }
    
}
