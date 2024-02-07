/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kevinzamora.prog06_tarea_util;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import kevinzamora.prog06_tarea.Concesionario;
import kevinzamora.prog06_tarea.Vehiculo;

/**
 *
 * @author kzdesigner // Autor y nombre del equipo de Kevin Zamora Amela
 */
public class Validacion {

    private static final Pattern REGEXP = Pattern.compile("[0-9]{8}[A-Z]");
    private static final String DIGITO_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
    private static final String[] INVALIDOS = new String[]{"00000000T", "00000001R", "99999999R"};

    public boolean comprobarFechaMatriculacion(LocalDate fechaMatriculacionIntroducida) {
        if (LocalDate.now().compareTo(fechaMatriculacionIntroducida) > 0) {
            System.out.println("LA FECHA INTRODUCIDA ES CORRECTA, ES ANTERIOR AL MOMENTO ACTUAL \n");
            return true;
        } else {
            System.out.println("LA FECHA INTRODUCIDA ES INCORRECTA. ACTUALÍCELA PARA CONTINUAR \n");
            return false;
        }
    }

    public boolean comprobarKilometros(int kmsIntroducidos) {
        if (kmsIntroducidos > 0) {
            System.out.println("OK: LOS KILOMETROS INTRODUCIDOS SON MAYORES "
                    + "QUE CERO \n");
            return true;
        } else {
            System.out.println("KILÓMETROS INCORRECTOS. "
                    + "MODIFÍQUELOS PARA CONTINUAR \n");
            return false;
        }
    }

    public boolean comprobarDni(String dniIntroducido) {
        boolean seemsCorrect = Arrays.binarySearch(INVALIDOS, dniIntroducido) < 0 // (1)
	    && REGEXP.matcher(dniIntroducido).matches() // (2)
        && dniIntroducido.charAt(8) == 
                DIGITO_CONTROL.charAt(Integer.parseInt(
                        dniIntroducido.substring(0, 8)) % 23); // (3)
        if (seemsCorrect) {System.out.println("EL DNI INTRODUCIDO PRESENTA "
                + "UN FORMATO CORRECTO \n"); return true;} else {System.out.println("EL DNI PRESENTA "
                        + "UN FORMATO INCORRECTO. ACTUALÍCELO PARA CONTINUAR \n"); return false;}
    }
    
    public boolean comprobarMatricula(String matriculaIntroducida) {
        if (matriculaIntroducida.toUpperCase().matches("^[0-9]{4}[A-Z]{3}$")) {
            // if (matriculaIntroducida.toUpperCase().matches("NNNNLLL") { // Patrón propuesto    
            System.out.println("Matrícula válida \n");
            return true;
        } else {
            System.out.println("Matrícula inválida \n");
            return false;
        }
    }
    
    public boolean comprobarActualizacionKms(int kms, Vehiculo vehiculoSeleccionado) {
        if(kms > vehiculoSeleccionado.getNumKilometros()) {
            System.out.println("SE PUEDEN ACTUALIZAR EL Nº DE KILÓMETROS POR EL NUEVO VALOR: " 
                    + kms); return true; } else { System.out.println("NO SE PERMITE RESTAR "
                            + "KILÓMETROS. ACTUALICE EL VALOR PARA CONTINUAR"); return false; }
    }
    
    public boolean comprobarMatriculaRepetida(String matriculaIntroducida, List<Vehiculo> vehiculos) {
        for (Vehiculo vehiculo : vehiculos) {
            String matriculaLeida = vehiculo.getMatricula();
            if (matriculaLeida.equals(matriculaIntroducida)) {
                System.out.println("La matrícula introducida ya existe en nuestra base de datos y "
                        + "por tanto no se puede volver a introducir");
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

}
