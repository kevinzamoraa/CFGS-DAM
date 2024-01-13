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
        
        char cx = '\u000F';
        char cy = '\u0001';
        int z = cx-cy;
        
        
        // Programa para Vista en Consola
        
        System.out.println("\n ---- Conversiones entre enteros y coma flotante ----");
        System.out.println("Producto de int por float: j= i*x = " + j);
        System.out.println("Producto de float por double: dz=dx * y = " + dz);
        
        System.out.println("\n ---- Operaciones con byte ----");
        System.out.println("byte: 5 - 2 = " + bz);
        System.out.println("byte -128 - 1 = " + (byte)(bx - 1));
        System.out.println("(int)(-128 - 1) = " + (bx - by));
        
        System.out.println("\n ---- Operaciones con short ----");
        System.out.println("short: 10 - 1 = " + sz);
        // Variables recolocadas para ajustarse al orden de las operaciones y en base a la obtención de la respuesta requerida
        sx = 32767;
        sy = 1;
        sz = (short) (sx+sy);
        System.out.println("short 32767 + 1 = " + sz);
        
        System.out.println("\n ---- Operaciones con char ----");
        System.out.println("char: - = " + z);
        // Variables recolocadas para ajustarse al orden de las operaciones y en base a la obtención de la respuesta requerida
        z = cx-1;
        cx = '\uFFFF';
        System.out.println("char(0x000f) - 1 = " + z);
        z = cx;
        System.out.println("(int)() = " + z);
        sx = (short) cx;
        
        sx = -32768;
        cx = (char) sx;
        z = sx;
        sx = -1;
        System.out.println("(short)() = " + sx);
        cx = (char) sx;
        System.out.println("-32768 short-char-int = " + z*sx);
        z = cx;
        System.out.println("-1 short-char-int = " + z);
        
    }
}
