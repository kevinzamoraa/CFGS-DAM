/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nuevo_paquete.prog03_Ejerc1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author kzdesigner
 */
public class Fecha {
    
    //////  DECLARACIÓN DE VARIABLES  //////
    
    private enum enumMes {
        ENERO,
        FEBRERO,
        MARZO,
        ABRIL,
        MAYO,
        JUNIO,
        JULIO,
        AGOSTO,
        SEPTIEMBRE,
        OCTUBRE,
        NOVIEMBRE,
        DICIEMBRE
    };
    
    private int day;
    private enumMes month;
    private String selectedMonth;
    private int year;
    enumMes months[] = month.values();
    boolean isSummer;
    
    //////  MÉTODOS 'GETTERS'  //////
    
    public int getDay() {
        return day;
    }
    
    public enumMes getMonth() {
        return month;
    }
    
    public void getPrintedMonths() {
        for (enumMes month: months) {
            System.out.println(month);
        }
    }
    
    public int getYear() {
        return year;
    }
    
    public boolean getIsSummer() {
        return isSummer;
    }
    
    //////  MÉTODOS 'SETTERS'  //////
    
    public void setDay(int day) {
        this.day = day;
    }
    
    public void setMonth(String month) {
        switch (month) {
            case "ENERO":
                this.selectedMonth = month;
                System.out.println("Mes seleccionado: " + month);
                break;
            case "FEBRERO":
                this.selectedMonth = month;
                System.out.println("Mes seleccionado: " + month);
                break;
            case "MARZO":
                this.selectedMonth = month;
                System.out.println("Mes seleccionado: " + month);
                break;
            case "ABRIL":
                this.selectedMonth = month;
                break;
            case "MAYO":
                this.selectedMonth = month;
                break;
            case "JUNIO":
                this.selectedMonth = month;
                break;
            case "JULIO":
                this.selectedMonth = month;
                break;
            case "AGOSTO":
                this.selectedMonth = month;
                break;
            case "SEPTIEMBRE":
                this.selectedMonth = month;
                break;
            case "OCTUBRE":
                this.selectedMonth = month;
                break;
            case "NOVIEMBRE":
                this.selectedMonth = month;
                break;
            case "DICIEMBRE":
                this.selectedMonth = month;
                break;
            default:
                System.out.println("El mes introducido no es válido");
            
        }
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    //////  CONSTRUCTORES && MÉTODOS  //////

    /**
     *
     * @param mes
     */
    
    public Fecha () {}
    
    //public Fecha (enumMes mes) {
    
    //}
    
    public void Fecha (int dia, int mes, int anio) {
        LocalDate resultDate = LocalDate.of(anio,mes,dia);
        DateTimeFormatter myFormatDateRef= DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String formattedResultDate = resultDate.format(myFormatDateRef);
        System.out.println(formattedResultDate);
    }
    
    public void isSummer(String mes){
        switch (mes) {
            case "JUNIO":
                System.out.println("¡¡¡Es Verano!!!");
                this.isSummer = true;
                break;
                
            case "JULIO":
                System.out.println("¡¡¡Es Verano!!!");
                this.isSummer = true;
                break;
            case "AGOSTO":
                System.out.println("¡¡¡Es Verano!!!");
                this.isSummer = true;
                break;
            default:
                System.out.println("¿¡Es Invierno!?");
                this.isSummer = false;
                break;
        }
    }
}
