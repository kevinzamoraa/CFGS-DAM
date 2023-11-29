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
        
    }
    
    public LocalDateTime Fecha (int dia, int mes, int anio) {
        LocalDateTime resultDate = LocalDateTime.of(anio, mes, dia, 0, 00);
        //DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //String formatedResultDate = resultDate.format(myFormatObj);
        //System.out.println(formatedResultDate);
        System.out.println("La fecha 2 contiente el año " + anio);
        monthToString = monthIntToString(mes);
        toString(dia, monthToString, anio);
        isSummer(monthToString.toUpperCase());
        return resultDate;
    }
    
    public String monthIntToString(int month){
        switch (month) {
            case 1:
                monthToString = "enero";
                break;
            case 2:
                monthToString = "febrero";
                break;
            case 3:
                monthToString = "marzo";
                break;
            case 4:
                monthToString = "abril";
                break;
            case 5:
                monthToString = "mayo";
                break;
            case 6:
                monthToString = "junio";
                break;
            case 7:
                monthToString = "julio";
                break;
            case 8:
                monthToString = "agosto";
                break;
            case 9:
                monthToString = "septiembre";
                break;
            case 10:
                monthToString = "octubre";
                break;
            case 11:
                monthToString = "noviembre";
                break;
            case 12:
                monthToString = "diciembre";
                break;
            default:
                monthToString = "Mes no válido";
                break;
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
