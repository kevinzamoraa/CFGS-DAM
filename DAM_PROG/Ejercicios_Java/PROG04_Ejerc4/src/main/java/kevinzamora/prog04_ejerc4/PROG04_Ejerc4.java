/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kevinzamora.prog04_ejerc4;

import java.util.Scanner;

/**
 *
 * @author kzdesigner
 */
public class PROG04_Ejerc4 {

    public int numInt = 5;
    public int numMax = 10;
    public int numIntReq = 0;
    
    public static void main(String[] args) {
        
        PROG04_Ejerc4 myClass = new PROG04_Ejerc4();
        myClass.loadMainPage();
        
    }

    public void loadMainPage() {
        
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("\n BIENVENID@S AL JUEGO 'ADIVINA QUÉ PIENSO' \n");
        System.out.println("¿¡EMPEZAMOS EL JUEGO!? \n");
        System.out.println("OPCIONES: \n 1. CONFIGURACIÓN \n 2. JUGAR \n 3. SALIR \n");
        System.out.println("SELECCIONA LA OPCIÓN DESEADA (Introduce un número):");
        
        
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("HAS SELECCIONADO LA OPCIÓN 1: CONFIGURACIÓN \n");
                System.out.println("INTRODUCE EL NÚMERO DE INTENTOS PERMITIDOS (nº entero):");
                numInt = scanner.nextInt();
                System.out.println("INTRODUCE EL NÚMERO MÁXIMO PERMITIDO A ADIVINAR: ");
                numMax = scanner.nextInt();
                System.out.println("LA CONFIGURACIÓN HA SIDO GUARDADA CORRECTAMENTE");
                loadMainPage();
                break;
            case 2:
                System.out.println("HAS SELECCIONADO LA OPCIÓN 2: JUGAR");
                System.out.println("¡¡¡VAMOS ALLÁ...!!! \n");
                int numOculto = (int)Math.floor(Math.random()*numMax+1); 
                //genera un número aleatorio entre 0 y el número máximo introducido, ambos incluidos.
                System.out.println("EL NÚMERO OCULTO HA SIDO GENERADO CON ÉXITO... ¿ACEPTAS EL DESAFIO? \n");
                System.out.println("NÚMERO DE INTENTOS: " + numInt + "\n");
                             
                int numIntroducido = 0;
                while (numOculto != numIntroducido ) {
                    System.out.println("INTRODUCE UN NÚMERO CANDIDATO (Nº ENTERO):");
                    numIntroducido = scanner.nextInt();
                    numInt--;
                    numIntReq++;
                    if (numIntroducido == numOculto) { 
                        System.out.println("¡¡¡HAS GANADO!!! HAS NECESITADO " + numIntReq + " INTENTOS \n"); 
                        System.out.println("THE END");
                        loadMainPage();
                        break;
                    } else if (numInt <= 0) {
                        System.out.println("¡PERDISTE! INTENTOS CONSUMIDOS");
                        loadMainPage();
                        break;
                    } else {
                        System.out.println("NO HA HABIDO SUERTE...\n ¡MUCHA SUERTE!\n Y PRUEBA OTRA VEZ");
                        if (numOculto < numIntroducido) {
                            System.out.println("EL NÚMERO OCULTO ES MENOR \n");
                        }
                    }
                } 
                break;
            case 3:
                System.out.println("HAS SELECCIONADO LA OPCIÓN 3: SALIR");
                System.out.println("¡¡¡HASTA PRONTO!!!");
                break;
            default:
                System.out.println("OPCIÓN INCORRECTA. HASTA PRONTO! ");
        }
        
    }
}
