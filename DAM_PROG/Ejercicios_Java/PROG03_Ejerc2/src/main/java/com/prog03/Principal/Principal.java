/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog03.Principal;

import com.prog03.figuras.Rectangulo;

/**
 *
 * @author kzdesigner
 */
public class Principal {
    
    public static void main(String[] args) {
        System.out.println("BIENVENIDXS AL EJ.2 DE LA PRÁCTICA PROGO3:");
        
        Rectangulo rectangleObj = new Rectangulo();
        
        Rectangulo rectangulo1 = new Rectangulo(3, 4);
        Rectangulo rectangulo2 = new Rectangulo(3.5, 3.5);
        
        System.out.println("\n Características rectángulo 1: ");
        System.out.println("Base: " + rectangulo1.getBase() + " cm | Altura: " + rectangulo1.getAltura() + " cm");
        
        System.out.println("\n Características rectángulo 2: ");
        System.out.println("Base: " + rectangulo1.getBase() + " cm | Altura: " + rectangulo1.getAltura() + " cm");
        
        System.out.println("\n Calculo del área del rectángulo 1: ");
        double base = rectangulo1.getBase();
        double altura = rectangulo1.getAltura();
        double area = rectangulo1.getArea(base, altura);
        System.out.println("Área: " + area + " cm cuadrados");
        
        System.out.println("\n Conversión del resultado del área del rectángulo 1 a cadena de texto");
        String areaToText = rectangulo1.toString(area);
        System.out.println(areaToText + " cm cuadrados");
        
        System.out.println("\n ¿El Rectángulo 1 es cuadrado?");
        boolean isSquare = rectangulo1.isCuadrado();
        if (isSquare) {
            System.out.println("Es un cuadrado");
        } else {
            System.out.println("No es un cuadrado");
        }
    
    }
    
}
