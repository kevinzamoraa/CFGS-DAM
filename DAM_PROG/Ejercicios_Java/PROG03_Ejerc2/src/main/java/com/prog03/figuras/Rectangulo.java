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
    float base;
    float altura;
    
    // Inicialización de variables / Constructores
    public Rectangulo() {
        base = 0;
        altura = 0;
    }
    
    public Rectangulo(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }
    
    // Métodos 'Getter' y 'Setter'
    public float getBase() {
        return base;
    }
    
    public float getAltura() {
        return altura;
    }
    
    public void setBase(float base) {
        this.base = base;
    }
    
    public void setAltura(float altura) {
        this.altura = altura;
    }
    
    // Métodos de la clase
    public float getArea(float base, float altura) {
        float area = base * altura;
        return area;
    }
    
    public String toString(float result) {
        String toText = Float.toString(result);
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

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
    
    
}
