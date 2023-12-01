/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.prog03.figuras;

/**
 *
 * @author kzdesigner
 */
public class Rectangulo {
    
    // Declaración de variables
    double base;
    double altura;
    
    // Inicialización de variables / Constructores
    public Rectangulo() {
        base = 0;
        altura = 0;
    }
    
    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    
    // Métodos 'Getter' y 'Setter'
    public double getBase() {
        return base;
    }
    
    public double getAltura() {
        return altura;
    }
    
    public void setBase(double base) {
        this.base = base;
    }
    
    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    // Métodos de la clase
    public double getArea(double base, double altura) {
        double area = base * altura;
        return area;
    }
    
    public String toString(Double result) {
        String toText = Double.toString(result);
        return toText;
    }
    
    public boolean isCuadrado() {
        boolean isSquare = false;
        if (base == altura) {
            System.out.println("Es un cuadrado");
            isSquare = true;
            return isSquare;
        } 
        else {
            System.out.println("No es un cuadrado");
            isSquare = false;
            return isSquare;
        }
    }    
}
