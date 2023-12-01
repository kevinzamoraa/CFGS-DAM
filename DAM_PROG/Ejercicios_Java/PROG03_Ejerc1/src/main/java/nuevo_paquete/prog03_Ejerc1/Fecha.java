/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nuevo_paquete.prog03_Ejerc1;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

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
    String monthToString;
    
    //public Locale loc = new Locale("es", "ES");
    //DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, loc);
    
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
    
    public Fecha (enumMes mes) {
        System.out.println("La fecha es: " + year);
        String month = mes.toString().toLowerCase();
        toString(this.day, monthToString, this.year);
        isSummer(month.toUpperCase());
    }
    
    public LocalDateTime Fecha (int dia, int mes, int anio) {
        LocalDateTime resultDate = LocalDateTime.of(anio, mes, dia, 0, 00);
        //DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //String formatedResultDate = resultDate.format(myFormatObj);
        //System.out.println(formatedResultDate);
        System.out.println("La fecha contiente el año " + anio);
        monthToString = monthIntToString(mes);
        toString(dia, monthToString, anio);
        isSummer(monthToString.toUpperCase());
        return resultDate;
    }
    
    public String monthIntToString(int month){
        switch (month) {
            case 1:
                monthToString = "enero";
                return monthToString;
            case 2:
                monthToString = "febrero";
                return monthToString;
            case 3:
                monthToString = "marzo";
                return monthToString;
            case 4:
                monthToString = "abril";
                return monthToString;
            case 5:
                monthToString = "mayo";
                return monthToString;
            case 6:
                monthToString = "junio";
                return monthToString;
            case 7:
                monthToString = "julio";
                return monthToString;
            case 8:
                monthToString = "agosto";
                return monthToString;
            case 9:
                monthToString = "septiembre";
                return monthToString;
            case 10:
                monthToString = "octubre";
                return monthToString;
            case 11:
                monthToString = "noviembre";
                return monthToString;
            case 12:
                monthToString = "diciembre";
                return monthToString;
            default:
                monthToString = "Mes no válido";
                return "";
        }
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
                System.out.println("¿¡No es verano!?");
                this.isSummer = false;
                break;
        }
    }
    
    public String toString(int day, String month, int year) {
        String fechaFormateada = day + " de " + month + " del " + year;
        System.out.println(fechaFormateada);
        return fechaFormateada;
    }
}
