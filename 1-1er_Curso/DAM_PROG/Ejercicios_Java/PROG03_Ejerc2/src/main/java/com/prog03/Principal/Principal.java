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
        
        System.out.println("\n ---- OPERACIONES CON EL RECTÁNGULO 1 ----");
        
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
        // El anterior bucle IF manifiesta una reberbenación y repite su función una segunda vez antes de finalizar. La forma de solucionar el problema, averiguando su causa, consiste en proceder a depurar dicho programa, durante su ejecución, introduciendo puntos de interrupcción donde sean necesarios. Para ello y siendo que hemos modificado el nombre del paquete y de la clase inicializadxs por defecto, habría que cambiar el "shocket" de ejecución y dirigir dichos procesos hacia su nueva ubicación; me gustaría hacerlo,ya que creo recordar que no era nada complicado, aunque últimamente mi mente no funciona muy allá. Disculpa.
        
        System.out.println("\n ---- OPERACIONES CON EL RECTÁNGULO 2 ----");
        
        System.out.println("\n Características rectángulo 2: ");
        System.out.println("Base: " + rectangulo2.getBase() + " cm | Altura: " + rectangulo2.getAltura() + " cm");
        
        System.out.println("\n Calculo del área del rectángulo 2: ");
        base = rectangulo2.getBase();
        altura = rectangulo2.getAltura();
        area = rectangulo2.getArea(base, altura);
        System.out.println("Área: " + area + " cm cuadrados");
        
        System.out.println("\n Conversión del resultado del área del rectángulo 2 a cadena de texto");
        areaToText = rectangulo2.toString(area);
        System.out.println(areaToText + " cm cuadrados");
        
        System.out.println("\n ¿El Rectángulo 2 es cuadrado?");
        isSquare = rectangulo2.isCuadrado();
        if (isSquare) {
            System.out.println("Es un cuadrado");
        } else {
            System.out.println("No es un cuadrado");
        }
        
    }
    
}
