package kevinzamora.prog07_tarea;

import java.util.Scanner;

public class Main {
    
    CCuenta cuenta1 = new CCuenta("Antonio López","1000-2365-85-1230456789",2500,0);
    
    double saldoActual;
    
    /**Se ejecuta una vez ha sido llamada la clase en cuestión y puede ser 
     * usada para ejecutar/lanzar las funciones deseadas en el inicio
     * @param args Modificadores opcionales
     **/
    public static void main(String[] args) {
        
        Main mainObj = new Main();
        mainObj.menuIntroducirNum();

    }
    
    /**
     * Función/Método auxiliar que muestra por pantalla el mensaje de bienvenida a 
     * nuestra aplicación y un método de entrada para que podamos 
     * definir el valor de la variable 'cantidad', la cual resulta necesaria 
     * para poder operar sobre la cuenta en cuestión
     **/
    public void menuIntroducirNum() {
        System.out.println("GESTIÓN DE CUENTA BANCARIA: \n");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduce la cantidad a ingresar/retirar: ");
        float cantidad = scanner.nextFloat();
        
        operativa_cuenta(cantidad);

    }
    
    /**
     * Función/Método contenedora de la funcionalidad requerida para poder 
     * ingresar/retirar efectivo de la cuenta seleccionada
     * @param cantidad Devuelve el valor de la variable 'cantidad'
     **/
    public void operativa_cuenta(float cantidad) {
        saldoActual = cuenta1.estado();
//        System.out.println("El saldo actual es "+ saldoActual );
        
        try {saldoActual = cuenta1.estado();
        System.out.println("El saldo actual es "+ saldoActual );
                cuenta1.retirar(2300);
            } catch (Exception e) {
                System.out.print("Fallo al retirar");
            }
            try {
                System.out.println("Ingreso en cuenta");
                cuenta1.ingresar(695);
            } catch (Exception e) {
                System.out.print("Fallo al ingresar");
        }
    }
}
