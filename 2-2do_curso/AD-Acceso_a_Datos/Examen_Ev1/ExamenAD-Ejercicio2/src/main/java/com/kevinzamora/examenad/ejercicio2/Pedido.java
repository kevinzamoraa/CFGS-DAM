/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kevinzamora.examenad.ejercicio2;

import java.util.Date;
import lombok.*;

/**
 *
 * @author Kevin
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Pedido {
    int id;
    int usuarioId;
    String producto;
    int cantidad;
    Date fecha;
}
