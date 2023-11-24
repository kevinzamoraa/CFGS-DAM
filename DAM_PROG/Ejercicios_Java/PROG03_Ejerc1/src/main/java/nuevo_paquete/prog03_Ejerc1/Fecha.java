/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nuevo_paquete.prog03_Ejerc1;

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
    private int year;
    
    //////  MÉTODOS 'GETTERS'  //////
    
    public int getDay() {
        return day;
    }
    
    public enumMes getMonth() {
        return month;
    }
    
    public int getYear() {
        return year;
    }
    
    //////  MÉTODOS 'SETTERS'  //////
    
    public void setDay(int day) {
        this.day = day;
    }
    
    public void setMonth(enumMes month) {
        this.month = month;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    //////  CONSTRUCTORES  //////

    /**
     *
     * @param mes
     */
    
    public Fecha () {}
    
    public Fecha (enumMes mes) {
    
    }
    
    public Fecha (int dia, enumMes mes, int anio) {
    
    }
    
}
