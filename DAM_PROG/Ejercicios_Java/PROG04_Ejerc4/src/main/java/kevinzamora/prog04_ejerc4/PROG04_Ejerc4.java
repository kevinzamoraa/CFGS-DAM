/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kevinzamora.prog04_ejerc4;

import java.util.Scanner;

/**
 *
 * @author kzdesigner // Autor y nombre del equipo de Kevin Zamora Amela
 */
// Clase contenedora de la resolución del ejercicio 4 de la tarea PROG04
public class PROG04_Ejerc4 {
    
    /* Declaración e inicialización de las variables que requieren persistencia entre cada una de 
    las pantallas de nuestro juego de consola de comandos. Tal y como se indica en el enunciado del 
    ejercicio, la variable numInt presentará el valor 5 por defecto y la variable numMax tendrá un
    valor predefinido de 10 */
    public int numInt = 5;
    public int numMax = 10;
    public int numIntReq = 0;
    
    public static void main(String[] args) {
        
        // Llamamos/Ejecutamos tras el inicio, la función contenedora de todo nuestro juego 
        PROG04_Ejerc4 myClass = new PROG04_Ejerc4();
        myClass.loadMainPage();
        
    }

    public void loadMainPage() {
        
        // Declaramos e inicializamos nuestro lector del teclado
        Scanner scanner = new Scanner(System.in);
        
        // Mostramos los mensajes explicativos oportunos y necesarios
        System.out.println("\n BIENVENID@S AL JUEGO 'ADIVINA QUÉ PIENSO' \n");
        System.out.println("¿¡EMPEZAMOS EL JUEGO!? \n");
        // Indicamos las diferentes opciones disponibles en nuestro juego
        System.out.println("OPCIONES: \n 1. CONFIGURACIÓN \n 2. JUGAR \n 3. SALIR \n");
        // Solicitamos y posteriormente leemos vía teclado la opción seleccionada
        System.out.println("SELECCIONA LA OPCIÓN DESEADA (Introduce un número):");
        
        // Definimos la variable que almacenará la opción seleccionada/elegida del menú principal
        int option = scanner.nextInt();
        switch (option) {
            case 1: /* Este caso hace referencia a la pantalla de CONFIGURACIÓN tal y como se indica 
                en el enunciado. En esta pantalla/vista secundaria se nos pedirá configurar los valores
                referentes al número de intentos y al número máximo de posibilidades a adivinar*/
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
                // Genera un número aleatorio entre 0 y el número máximo introducido, ambos incluidos.
                System.out.println("EL NÚMERO OCULTO HA SIDO GENERADO CON ÉXITO... ¿ACEPTAS EL DESAFIO? \n");
                // Aquí se muestra el número de intentos configurado o preconfigurado
                System.out.println("NÚMERO DE INTENTOS: " + numInt + "\n");
                             
                int numIntroducido = 0;
                while (numOculto != numIntroducido ) { // Mientras no acertemos el nº oculto, el bucle se repite
                    // Se nos pide introducir un número vía teclado
                    System.out.println("INTRODUCE UN NÚMERO CANDIDATO (Nº ENTERO):");
                    numIntroducido = scanner.nextInt();
                    /* Tras su lectura y guardado en una variable, se decrementa el número de intentos restantes 
                    y se incrementa el nº de intentos requeridos para la adivinación de nuestro número oculto
                    generado aleatoriamente */
                    numInt--;
                    numIntReq++;
                    if (numIntroducido == numOculto) { /* Realizamos la comparación entre el número introducido y
                        nuestro número oculto, dando la respuesta pertinente en cada uno de los supuestos posibles */
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
                // Configuramos la opción 'salir' para abandonar nuestro/a juego/aplicación
                System.out.println("HAS SELECCIONADO LA OPCIÓN 3: SALIR");
                System.out.println("¡¡¡HASTA PRONTO!!!");
                break;
            default: /* Añadimos una opción por defecto, para que no se rompa e interrumpa el funcionamiento 
                de nuestro programa en caso de introducir una opción no considerada explícitamente */
                System.out.println("OPCIÓN INCORRECTA. HASTA PRONTO! ");
        }
        
    }
}
