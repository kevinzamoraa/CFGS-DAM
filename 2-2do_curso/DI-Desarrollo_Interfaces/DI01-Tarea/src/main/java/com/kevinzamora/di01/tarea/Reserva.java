/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kevinzamora.di01.tarea;

import lombok.*;
import java.util.Date;

/**
 *
 * @author kzdesigner
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {
    
    private String nombreCliente;
    private String telefonoCliente;
    private Date fechaEvento;
    private String tipoEvento;
    private int numeroPersonas;
    private String tipoCocina;
    private int numeroDias;
    private boolean necesitaHabitaciones;
    
}
