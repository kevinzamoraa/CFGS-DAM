/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kevinzamora.prog03_ejerc1;

import java.util.Scanner;
import nuevo_paquete.prog03_Ejerc1.Fecha;

/**
 *
 * @author kzdesigner
 */
public class PROG03_Ejerc1 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        
        Fecha fechaObj = new Fecha();
        
        int introducedDay;
        String introducedMonth;
        int introducedMonthInt;
        int introducedYear;
               
        System.out.println("Introduce el día elegido (Número Entero):");
        introducedDay = scanner.nextInt();
        fechaObj.setDay(introducedDay);
        System.out.println("\n Elige un mes contenido en la siguiente lista (escríbelo exactamente igual)");
        fechaObj.getPrintedMonths();
        System.out.println("\n Introduce el mes deseado (Escribe el nombre de un mes)");
        introducedMonth = scanner2.nextLine();
        fechaObj.setMonth(introducedMonth);
        System.out.println("\n Introduce el año deseado (número entero de 4 digitos)");
        introducedYear = scanner.nextInt();
        fechaObj.setYear(introducedYear);
        
        fechaObj.isSummer(introducedMonth);
        System.out.println("El valor de la variable 'isSummer' de tipo 'boolean', es: " + fechaObj.getIsSummer());
        
        System.out.println("\n La fecha introducida es: ");
        switch (introducedMonth) {
            case "ENERO":
                introducedMonthInt = 1;
                break;
            case "FEBRERO":
                introducedMonthInt = 2;
                break;
            case "MARZO":
                introducedMonthInt = 3;
                break;
            case "ABRIL":
                introducedMonthInt = 4;
                break;
            case "MAYO":
                introducedMonthInt = 5;
                break;
            case "JUNIO":
                introducedMonthInt = 6;
                break;
            case "JULIO":
                introducedMonthInt = 7;
                break;
            case "AGOSTO":
                introducedMonthInt = 8;
                break;
            case "SEPTIEMBRE":
                introducedMonthInt = 9;
                break;
            case "OCTUBRE":
                introducedMonthInt = 10;
                break;
            case "NOVIEMBRE":
                introducedMonthInt = 11;
                break;
            case "DICIEMBRE":
                introducedMonthInt = 12;
                break;
            default:
                introducedMonthInt = 0;
                break;
        }
        fechaObj.Fecha(introducedDay, introducedMonthInt, introducedYear);
        
    }
}
