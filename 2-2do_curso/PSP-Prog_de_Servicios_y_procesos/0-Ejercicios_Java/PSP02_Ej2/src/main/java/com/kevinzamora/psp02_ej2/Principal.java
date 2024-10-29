/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ejercicio2;

/**
 *
 * @author kzdesigner
 */
public class Principal {

    public static void main(String[] args) {
        
        Mesa m = new Mesa(5);
        
        for (int i = 1; i <= 5; i++) {
            Filosofo f = new Filosofo (m, i);
            f.start();
        }
        
    }
}
