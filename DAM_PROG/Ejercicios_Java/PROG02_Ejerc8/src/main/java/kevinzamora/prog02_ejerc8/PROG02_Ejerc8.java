/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kevinzamora.prog02_ejerc8;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author kzdesigner
 */
public class PROG02_Ejerc8 {

    public static void main(String[] args) {
        // System.out.println("Hello World!");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce el número de estudiantes matriculadxs en Programación: \n");
        int matriculadosProgramacion = scanner.nextInt();
        
        System.out.print("Introduce el número de estudiantes matriculadxs en Entornos de Desarrollo: \n");
        int matriculadosEntornosDesarrollo = scanner.nextInt();
        
        System.out.print("Introduce el número de estudiantes matriculadxs en Base de Datos: \n");
        int matriculadosBaseDatos = scanner.nextInt();
        
        double totalAlumnxs = matriculadosProgramacion + matriculadosEntornosDesarrollo + matriculadosBaseDatos;
        //System.out.println(total);
        
        double porcentajeProgramacion = matriculadosProgramacion * 100 / totalAlumnxs;
        double porcentajeEntornosDesarrollo = matriculadosEntornosDesarrollo * 100 / totalAlumnxs;
        double porcentajeBaseDatos = matriculadosBaseDatos * 100 / totalAlumnxs;
        
        //DecimalFormat dfResult = new DecimalFormat("%");
        //String porProgramacionFormateado = dfResult.format(total*porcentajeProgramacion);
        
        System.out.println("En la asignatura de programación se encuentran matriculadxs: " + matriculadosProgramacion + " alumnxs");
        System.out.println("En la asignatura de programación se encuentran matriculadxs: " + matriculadosEntornosDesarrollo + " alumnxs");;
        System.out.println("En la asignatura de programación se encuentran matriculadxs: " + matriculadosBaseDatos + " alumnxs");

        System.out.println("Porcentaje de estudiantes matriculadxs en Programación (Sin redondear a un decimal): " + porcentajeProgramacion);
        System.out.println("Porcentaje de estudiantes matriculadxs en Entornos de Desarrollo (Sin redondear a un decimal): " + porcentajeEntornosDesarrollo);
        System.out.println("Porcentaje de estudiantes matriculadxs en Base de Datos (Sin redondear a un decimal): " + porcentajeBaseDatos);
    }
}
