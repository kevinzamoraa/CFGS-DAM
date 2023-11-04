/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kevinzamora.prog02_ejerc1;

import java.time.LocalDate;

/**
 *
 * @author kzdesigner
 */
public class PROG02_Ejerc1 {

    public static void main(String[] args) {
        // System.out.println("Hello World!"); // It's default message
        
        int valorMaximo = 5000;
        boolean carnetConducir = false;
        String yearMonth = "Un mes cualquiera";
        String nombreYapellidos = "";
        String[] sexo = {"V", "M"};
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaPasada = LocalDate.of(1970, 01, 01);
        float saldoCuentaBancaria = 0;
        float distanciaTierraJupiter = (float) 595.77;
        
        System.out.print("Valor máximo: " + valorMaximo);
        System.out.printf("¿Tiene Carnet de Conducir: ?" + carnetConducir);
        System.out.print("Mes del año: " + yearMonth);
        System.out.printf("Introduce un nuevo mes del año: ");
        yearMonth = System.console().readLine();
        System.out.printf("Nuevo mes del año: " + yearMonth);
        System.out.print("Introduce tu Sexo (V/M): ");
        String sexoIntroducido = System.console().readLine();
        if (null == sexoIntroducido) {
            System.out.printf("El sexo introducido no se encuentra en nuestra base de datos");
        } else switch (sexoIntroducido) {
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
    }
}
