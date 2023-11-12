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
        
        int total = matriculadosProgramacion + matriculadosEntornosDesarrollo + matriculadosBaseDatos;
        System.out.println(total);
        
        double porcionProgramacion = matriculadosProgramacion/total;
        float porcionEntornosDesarrollo = (matriculadosEntornosDesarrollo/total);
        float porcionBaseDatos = (matriculadosBaseDatos/total);
        
        System.out.println(porcionProgramacion);
        
        //int porcentajeProgramacion = (int) (porcionProgramacion*100);
        //int porcentajeEntornosDesarrollo = *100;
        //int porcentajeBaseDatos = *100;
        
        //DecimalFormat dfResult = new DecimalFormat("%");
        //String porProgramacionFormateado = dfResult.format(total*porcentajeProgramacion);
        //System.out.print(matriculadosProgramacion);
        //System.out.print(matriculadosEntornosDesarrollo);
        //System.out.print(matriculadosBaseDatos);

        //System.out.println(porcentajeProgramacion);
        // System.out.print("Porcentaje de estudiantes matriculadxs en Programación: " + porProgramacionFormateado);
        
    }
}
