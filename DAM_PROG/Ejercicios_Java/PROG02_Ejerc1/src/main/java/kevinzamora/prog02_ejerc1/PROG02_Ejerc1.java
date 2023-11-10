/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kevinzamora.prog02_ejerc1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author kzdesigner
 */
public class PROG02_Ejerc1 {

    public static void main(String[] args) {
        // System.out.println("Hello World!"); // It's default message
        
        // Declaración e inicialización de variables principales
        int valorMaximo = 5000;
        boolean carnetConducir = false;
        String yearMonth = "Un mes cualquiera";
        int numYearMonth;
        String nombreYapellidos;
        String[] sexo = {"V", "M"};
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaPasada = LocalDate.of(1970, 01, 01);
        float saldoCuentaBancaria = 1;
        float distanciaTierraJupiter = (float) 595.77;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Valor máximo: " + valorMaximo);
        System.out.print("¿Tienes Carnet de Conducir? (Introduce 'Y' para decir SÍ o 'N' para decir NO)");
        String tieneCarnet = scanner.nextLine();
        switch (tieneCarnet) {
            case "Y":
                System.out.print("El/La empleadx tiene carnet de conducir \n");
                break;
            case "N":
                System.out.printf("El/La trabajador/a NO tiene carnet de conducir \n");
                break;
            default:
                System.out.print("El valor introducido no es válido \n");
        }
        
        System.out.print("\n Mes del año por defecto: " + yearMonth);
        System.out.printf("\n Introduce un mes del año (formato: texto): \n");
        yearMonth = scanner.nextLine();
        System.out.print("Has introducido el més:" + yearMonth);
        System.out.printf("\n Introduce el mismo mes del año (formato: numérico): \n");
        numYearMonth = scanner.nextInt();
        switch (numYearMonth) {
            case 1:
                System.out.print("Has elegido el número referente a ENERO");
                break;
            case 2:
                System.out.print("Has elegido el número referente a FEBRERO");
                break;
            case 3:
                System.out.print("Has elegido el número referente a MARZO");
                break;
            case 4:
                System.out.print("Has elegido el número referente a ABRIL");
                break;
            case 5:
                System.out.print("Has elegido el número referente a MAYO");
                break;
            case 6:
                System.out.print("Has elegido el número referente a JUNIO");
                break;
            case 7:
                System.out.print("Has elegido el número referente a JULIO");
                break;
            case 8:
                System.out.print("Has elegido el número referente a AGOSTO");
                break;
            case 9:
                System.out.print("Has elegido el número referente a SEPTIEMBRE");
                break;
            case 10:
                System.out.print("Has elegido el número referente a OCTUBRE");
                break;
            case 11:
                System.out.print("Has elegido el número referente a NOVIEMBRE");
                break;
            case 12:
                System.out.print("Has elegido el número referente a DICIEMBRE");
                break;
            default:
                System.out.print("El número introducido no corresponde a ningún mes de nuestro calendario");
                break;
        }
        
        System.out.print("\n Introduce un nombre y apellidos: ");
        nombreYapellidos = scanner.nextLine();
        System.out.println("Nombre introducido: " + nombreYapellidos);
        
        System.out.print("\n Introduce tu Sexo (V/M): ");
        String sexoIntroducido = scanner.nextLine();
        switch (sexoIntroducido) {
           case "V":
               System.out.printf("Tu genero es 'Varón'");
               break;
           case "M":
               System.out.print("Tu genero es 'Mujer'");
               break;
           default:
               System.out.printf("El sexo introducido no se encuentra en nuestra base de datos");
               break;
        }
        
        System.out.print("\n Fecha actual: " + fechaActual);
        System.out.print("\n Fecha de referéncia: " + fechaPasada.format(DateTimeFormatter.ISO_DATE));
        
        // TODO / To Fix - Only obtains the years of diference between both
        int milisegundosDesdeLaFechaDada = fechaActual.compareTo(fechaPasada);
        System.out.println("Han pasado " + milisegundosDesdeLaFechaDada + "milisegundos entre ambas fechas");
    }
}
