/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kevinzamora.prog02_ejerc6;

/**
 *
 * @author kzdesigner
 */
public class PROG02_Ejerc6 {

    enum razasPerro {
        Mastín,
        Terrier,
        Bulldog,
        Pekines,
        Caniche,
        Galgo
    }
    
    enum var1 {
        AporTODAS,
        TúPUEDES
    }
    
    enum var2 {
        TúPUEDES,
        AporTODAS
    }
    
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        
        System.out.print("Razas de Perro: \n\n");
        for (razasPerro raza : razasPerro.values()) {
            System.out.println(raza);
        }
        
        System.out.print("\n\n Valores Enum 'Var1' \n\n");
        for (var1 mensaje : var1.values()) {
            System.out.println(mensaje);
        }
        
        System.out.print("\n\n Valores Enum 'Var2' \n\n");
        for (var2 mensaje : var2.values()) {
            System.out.println(mensaje);
        }
        
        System.out.print("\n\n Valores Enum 'razasPerro' \n\n");
        for (razasPerro posicionRaza : razasPerro.values()) {
            System.out.println(posicionRaza);
            System.out.println("Está en la posición " + posicionRaza.ordinal() + " de la colección.");
        }
    }
}
