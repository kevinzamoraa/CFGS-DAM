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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Pasajero {
    
    private int num;
    private String codVuelo;
    private String tipoPlaza;
    private String fumador;
    
}
