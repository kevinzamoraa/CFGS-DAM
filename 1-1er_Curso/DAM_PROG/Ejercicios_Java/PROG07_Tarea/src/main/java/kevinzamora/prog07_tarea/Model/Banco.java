/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kevinzamora.prog07_tarea.Model;

import java.util.ArrayList;
import java.util.Scanner;
//import kevinzamora.prog07_tarea.Controler.Imprimible;

/**
 *
 * @author kzdesigner
 */
public class Banco /*implements Imprimible*/ {
    CuentaBancaria cuentaObj = new CuentaBancaria() {};
    ArrayList<CuentaBancaria> listaCuentas = new ArrayList<CuentaBancaria>();
    ArrayList<CuentaAhorro> listaCuentasAhorro = new ArrayList<CuentaAhorro>();
    ArrayList<CuentaCorrientePersonal> listaCuentaCPersonal = 
            new ArrayList<CuentaCorrientePersonal>();
    ArrayList<CuentaCorrienteEmpresa> listaCuentaCEmpresa = 
            new ArrayList<CuentaCorrienteEmpresa>();
    ArrayList<String> listaEntidades = new ArrayList<String>();
    String entidad1 = "Caixabank";
    String entidad2 = "Banc Sabadell";
    String entidad3 = "Mediolanum";
    CuentaBancaria nuevaCuenta;
    CuentaBancaria cuentaSeleccionada;
    String numCuentaIntroducido;
    
    // Declaración de variables de lectura o de entrada
    Scanner scanner = new Scanner(System.in);
    
    // Métodos -> Operaciones con cuentas
    // Crear una cuenta nueva
    private boolean abrirCuenta() {
        System.out.println("Introduce el nombre del/de la titular: ");
        String nombre = scanner.nextLine();
        System.out.println("Introduce el/los apellidos del/de la titular: ");
        String apellidos = scanner.nextLine();
        System.out.println("Introduce el DNI del/de la titular: ");
        String DNI = scanner.nextLine();
        Persona nuevxTitular = new Persona(nombre, apellidos, DNI);
        System.out.println("Selecciona el tipo de cuenta deseada: \n "
                + "1. Cuenta de Ahorro \n "
                + "2. Cuenta Corriente Personal \n "
                + "3. Cuenta Corriente Empresa ");
        int tipoCuentaIndicado = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el saldo de la nueva cuenta: ");
        Double nuevoSaldoCuenta = Double.parseDouble(scanner.nextLine());
        System.out.println("Introduce el número de cuenta: ");
        String numCuenta = scanner.nextLine();
        System.out.println(numCuenta);
        String tipoCuenta;
        switch (tipoCuentaIndicado) {
            case 1:
                System.out.println("Estás creando una cuenta de ahorro!? \n "
                        + "Si es así, introduce el tipo de interés de la "
                        + "remuneración: ");
                double tipoInteresRemuneracion = Double.parseDouble(scanner.nextLine());
                System.out.println("El tipo de interés ha sido leido correctamente.");
                CuentaAhorro nuevaCuentaAhorro = new CuentaAhorro(nuevxTitular,
                        nuevoSaldoCuenta, numCuenta, tipoInteresRemuneracion);
                tipoCuenta = "cuentaAhorro";
                nuevaCuenta = new CuentaBancaria(nuevxTitular, nuevoSaldoCuenta, 
                        numCuenta, tipoCuenta);
                listaCuentas.add(nuevaCuenta);
                listaCuentasAhorro.add(nuevaCuentaAhorro);
                return true;
            case 2:
                System.out.println("Estás creando una cuenta corriente personal. \n "
                        + "Si es así, introduce el importe de la comisión de "
                        + "mantenimiento: ");
                double comisionMantenimiento = Double.parseDouble(scanner.nextLine());
                System.out.println("La comisión de mantenimiento ha sido leido correctamente.");
                listaEntidades.add(entidad1);
                listaEntidades.add(entidad2);
                listaEntidades.add(entidad3);
                CuentaCorrientePersonal nuevaCuentaCPersonal = 
                        new CuentaCorrientePersonal(nuevxTitular, nuevoSaldoCuenta, numCuenta,  
                                 listaEntidades, comisionMantenimiento);
                tipoCuenta = "cuentaCorrientePersonal";
                nuevaCuenta = new CuentaBancaria(nuevxTitular, nuevoSaldoCuenta, 
                                numCuenta, tipoCuenta);
                listaCuentas.add(nuevaCuenta);
                listaCuentaCPersonal.add(nuevaCuentaCPersonal);
                return true;
            case 3:
                System.out.println("Estás creando una cuenta corriente de empresa!? \n "
                        + "Si es así, introduce el valor máximo de descubierto "
                        + "introducido: ");
                double nivelMaximoDescubiertoPermitido = 
                        Double.parseDouble(scanner.nextLine());
                System.out.println("El valor del máximo descubierto permitido ha sido "
                        + "leido correctamente. \n");
                System.out.println("Introduce el tipo de interés por descubrimiento: ");
                double tipoInteresPorDescubrimiento = 
                        Double.parseDouble(scanner.nextLine());
                listaEntidades.add(entidad1);
                listaEntidades.add(entidad2);
                listaEntidades.add(entidad3);
                System.out.println("El valor del máximo descubierto permitido ha sido "
                        + "leido correctamente. \n");
                System.out.println("Introduce el valor de la comisión fija por "
                        + "cada descubierto: ");
                double comisionFijaPorDescubierto = 
                        Double.parseDouble(scanner.nextLine());
                System.out.println("El valor del máximo descubierto permitido ha sido "
                        + "leido correctamente.");
                CuentaCorrienteEmpresa nuevaCuentaCEmpresa = 
                        new CuentaCorrienteEmpresa(nuevxTitular, nuevoSaldoCuenta, 
                                numCuenta, listaEntidades, comisionFijaPorDescubierto, 
                                tipoInteresPorDescubrimiento, 
                                nivelMaximoDescubiertoPermitido);
                tipoCuenta = "cuentaCorrienteEmpresa";
                nuevaCuenta = new CuentaBancaria(nuevxTitular, nuevoSaldoCuenta, 
                                numCuenta, tipoCuenta);
                listaCuentas.add(nuevaCuenta);
                listaCuentaCEmpresa.add(nuevaCuentaCEmpresa);
                return true;
            default:
                System.out.println("Se ha producido un pequeño error en tiempo de "
                        + "ejecución. Por favor, inténtelo de nuevo más tarde");
                break;
        }
        return false;
    }
    
    private void listadoCuentas() {
        for (CuentaBancaria cuenta : listaCuentas) {
            System.out.println(cuenta);
        }
    }
    
    private void informacionCuenta() {
        System.out.println("OBTENER TODOS LOS DATOS DE LA CUENTA INTRODUCIDA: \n");
        System.out.println("Introduce el número de cuenta a buscar: ");
        numCuentaIntroducido = scanner.nextLine();
        boolean numCuentaDetectado = false;
        if (numCuentaIntroducido != null) {
            numCuentaDetectado = true;
        } else {
            numCuentaDetectado = false;
        }
        if (numCuentaDetectado) {
//            System.out.println("Nº de Cuenta introducido: " + numCuentaIntroducido);
            for (CuentaBancaria cuenta : listaCuentas) {
                if ((cuenta.numCuenta.toLowerCase()).equalsIgnoreCase(numCuentaIntroducido)) {
//                    System.out.println("Estoy dentro del primer if");
                    if ((cuenta.tipoCuenta).equalsIgnoreCase("cuentaAhorro")) {
                        for (CuentaAhorro cuentaAhorro : listaCuentasAhorro) {
                            if (((cuentaAhorro.numCuenta).toLowerCase()).equals(numCuentaIntroducido.toLowerCase())) {
                                System.out.println("Se ha encontrado una cuenta: \n "
                                        + cuentaAhorro.toString() + "\n ");
                                cuentaSeleccionada = cuenta;
                            }
                        }
                    } else if ((cuenta.tipoCuenta).equalsIgnoreCase("cuentaCorrientePersonal")) {
                        for (CuentaCorrientePersonal cuentaCorrientePersonal : listaCuentaCPersonal) {
                            if (((cuentaCorrientePersonal.numCuenta).toLowerCase()).equals(numCuentaIntroducido.toLowerCase())) {
                                System.out.println("Se ha encontrado una cuenta: \n "
                                        + cuentaCorrientePersonal.toString() + "\n ");
                                cuentaSeleccionada = cuenta;
                            }
                        }
                    } else if ((cuenta.tipoCuenta).equalsIgnoreCase("cuentaCorrienteEmpresa")) {
                        for (CuentaCorrienteEmpresa cuentaCorrienteEmpresa : listaCuentaCEmpresa) {
                            if (((cuentaCorrienteEmpresa.numCuenta).toLowerCase()).equals(numCuentaIntroducido.toLowerCase())) {
                                System.out.println("Se ha encontrado una cuenta: \n "
                                        + cuentaCorrienteEmpresa.toString() + "\n ");
                                cuentaSeleccionada = cuenta;
                            }
                        }
                    } else {
                        System.out.println("No se ha conseguido entrar en los IF anidados");
                    }
                } else {
                    System.out.println("No se ha encontrado ninguna cuenta con ese identificador");
                }
            }
        } else {System.out.println("No se ha detectado ningún número de cuenta válido");}
    }
    
    /**
     * Fúnción/Método referente a y contenedor de la funcionalidad necesaria 
     * para poder ingresar efectivo en la cuenta en cuestión
     * @param cantidad Inserta la cantidad introducida/deseada
     * @exception Exception Se muestra el error "No se puede ingresar una cantidad negativa" 
     * cuando se intenta ingresar un valor inferior a 0
     **/
    public void ingresar() {
        System.out.println("Introduce la cantidad a ingresar: ");
            double cantidad = Double.parseDouble(scanner.nextLine());
                 
            if (cantidad < 0.0)
                System.out.println("No se puede ingresar una cantidad negativa");
            
        if(cuentaSeleccionada != null) {            
            for (CuentaBancaria cuenta : listaCuentas) {
                if ((cuenta.numCuenta).equals(cuentaSeleccionada.numCuenta)) {
                    double nuevoSaldo = cuenta.getSaldo() + cantidad;
                    cuenta.setSaldo(nuevoSaldo);
                    System.out.println("El saldo de su cuenta ha sido actualizado con éxito y este es: " 
                            + cuenta.getSaldo()) + "\n ";
                }
            } 
        } else {
            System.out.println("No se ha detectado ningún número de cuenta guardado en la presente sesión. \n "
                    + "Por favor, introduzca el número de cuenta en donde quiere realizar el ingreso de efectivo: ");
            numCuentaIntroducido = scanner.nextLine();
            for (CuentaBancaria cuenta : listaCuentas) {
                if ((cuenta.numCuenta).equalsIgnoreCase(numCuentaIntroducido)) {
                    cuentaSeleccionada = cuenta;
                    double nuevoSaldo = cuenta.getSaldo() + cantidad;
                    cuenta.setSaldo(nuevoSaldo);
                    System.out.println("El saldo de su cuenta ha sido actualizado con éxito y este es: " 
                            + cuenta.getSaldo() + "€ \n");
                } else { System.out.println("No se ha encontrado la cuenta donde se quiere ingresar \n"); }
            }
        }
    }
    
    /**
     * Función/Método contenedor de la funcionalidad necesaria para poder 
     * retirar cierta cantidad pasada vía parámetro del saldo disponible en la 
     * cuenta en cuestión
     * @param cantidad Inserta la cantidad introducida/deseada
     * @exception Exception Muestra un error distinto en base a dos supuestos: valor 
     * negativo y saldo insuficiente
     **/
    public void retirar() {
        System.out.println("Introduce la cantidad a retirar: ");
            double cantidad = Double.parseDouble(scanner.nextLine());
            
        if(cuentaSeleccionada != null) {            
            for (CuentaBancaria cuenta : listaCuentas) {
                if ((cuenta.numCuenta).equals(cuentaSeleccionada.numCuenta)) {
                    if (cantidad > cuenta.saldo) {
                        System.out.println("No se puede retirar el importe introducido, este excede al "
                                + "saldo disponible en la cuenta"); }
                    
                    double nuevoSaldo = cuenta.getSaldo() - cantidad;
                    cuenta.setSaldo(nuevoSaldo);
                    System.out.println("El saldo de su cuenta ha sido actualizado con éxito y este es: " 
                            + cuenta.getSaldo() + "€ \n ");
                }
            } 
        } else {
            System.out.println("No se ha detectado ningún número de cuenta guardado en la presente sesión. \n "
                    + "Por favor, introduzca el número de cuenta en donde quiere realizar el ingreso de efectivo: ");
            numCuentaIntroducido = scanner.nextLine();
            for (CuentaBancaria cuenta : listaCuentas) {
                if ((cuenta.numCuenta).equalsIgnoreCase(numCuentaIntroducido)) {
                    if (cantidad > cuenta.saldo) {
                        System.out.println("No se puede retirar el importe introducido, este excede al "
                                + "saldo disponible en la cuenta"); }
                    cuentaSeleccionada = cuenta;
                    double nuevoSaldo = cuenta.getSaldo() - cantidad;
                    cuenta.setSaldo(nuevoSaldo);
                    System.out.println("El saldo de su cuenta ha sido actualizado con éxito y este es: " 
                            + cuenta.getSaldo() + "€ \n");
                } else { System.out.println("No se ha encontrado la cuenta donde se quiere ingresar \n"); }
            }
        }
    }
    
    // MÉTODOS GETTER (FUNCIONES OPERATIVAS)
    public boolean getAbrirCuenta() {
        return abrirCuenta();
    }
    public void getListadoCuentas() {
        listadoCuentas();
    }
    public void getInformacionCuenta() {
        informacionCuenta();
    }
    public void getSaldo() {
        if (cuentaSeleccionada != null) {
            System.out.println(cuentaSeleccionada.getSaldo() + "€ de saldo disponible \n");
        } else {
            System.out.println("No se ha detectado ningún número de cuenta guardado en la presente sesión. \n "
                    + "Por favor, introduzca el número de cuenta en donde quiere realizar el ingreso de efectivo: ");
            numCuentaIntroducido = scanner.nextLine();
            for (CuentaBancaria cuenta : listaCuentas) {
                if ((cuenta.numCuenta).equalsIgnoreCase(numCuentaIntroducido)) {
                    cuentaSeleccionada = cuenta;
                    System.out.println(cuentaSeleccionada.getSaldo() + "€ de saldo disponible \n");
                } else { System.out.println("No se ha encontrado la cuenta a consultar \n"); }
            }
        }
    }
}
