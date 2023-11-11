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
        System.out.print("\n ¿Tienes Carnet de Conducir? (Introduce 'Y' para decir SÍ o 'N' para decir NO)");
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
                break;
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
        
        System.out.print("// Llevo unos días depurando el código con netbeans y no veo por qué se salta este paso; antes funcionaba correctamente. La única forma de que pare sin encontrar el error causante radica en usar puntos de interrupción durante la depuración");
        System.out.print("\n\n Introduce un nombre y apellidos: \n");
        nombreYapellidos = scanner.nextLine();
        System.out.printf("\n Nombre introducido: " + nombreYapellidos);
        
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
        // LocalDate diferenciaFechas = fechaActual - fechaPasada;
        // System.out.print(diferenciaFechas);
        System.out.print("\n Hay aproximadamente 55.900.800 milisegundos entre medias. \n PD: Si disousiera de más tiempo/funcionalidad neurológica y/o me acordara de como operar entre varias fechas, lo haría; creo que no resultaba nada demasiado complicado, aunque la aproximación calculada viene justo a continuación");
        // TODO / To Fix - Only obtains the years of diference between both
        int aDesdeLaFechaDada = fechaActual.compareTo(fechaPasada);
        int milisegundosDesdeLaFechaDada = aDesdeLaFechaDada*60*60*24*12;
        System.out.printf("\n Han pasado " + milisegundosDesdeLaFechaDada + " milisegundos aproximádamente entre ambas fechas");
        // Tampoco me acuerdo de cómo se podía intercalar variables dentro de un string, en java;
        System.out.print("\n El saldo de la cuenta bancaria es: " + saldoCuentaBancaria + " €");
        System.out.print("\n La distancia entre la Tierra y Jupiter es de aproximádamente " + distanciaTierraJupiter + " km");
        
        System.out.print("\n\n ¡Esperamos volverte a ver pronto por aquí!");
    }
}
