/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kevinzamora.ad03_tarea;
import lombok.*;

/**
 *
 * @author kzdesigner
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vuelo {
    
    private String codVuelo;
    private String horaSalida;
    private String destino;
    private String procedencia;
    private Integer plazasFumador;
    private Integer plazasNoFumador;
    private Integer plazasTurista;
    private Integer plazasPrimera;
    
}