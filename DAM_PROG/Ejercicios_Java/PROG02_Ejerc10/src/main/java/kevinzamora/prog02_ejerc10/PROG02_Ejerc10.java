/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kevinzamora.prog02_ejerc10;

/**
 *
 * @author kzdesigner
 */
public class PROG02_Ejerc10 {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        
        // Declaración de variables y operaciones entre ellas
        
        float x = 4.5f;
        float y = 3.0f;
        int i = 2;
        int j = (int) (i*x);
        double dx = 2.0d;
        double dz = dx*y;
        byte bx = 5;
        byte by = 2;
        byte bz = (byte) (bx-by);
        bx = -128;
        by = 1;
        
        short sx = 5;
        short sy = 2;
        short sz = (short) (sx-sy);
        sx = 32767;
        sy = 1;
        sz = (short) (sx+sy);
        char cx = '\u000F';
        char cy = '\u0001';
        int z = cx-cy;
        z = cx-1;
        cx = '\uFFFF';
        z = cx;
        sx = (short) cx;
        sx = -32768;
        cx = (char) sx;
        z = sx;
        sx = -1;
        cx = (char) sx;
        z = cx;
        
        
        
    }
}
