/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.kevinzamora.ad03_tarea;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kzdesigner
 */
public class AD03_Tarea {

    public static void main(String[] args) {
        
        FlightDatabaseOperations flightDatabaseOperationsObj = new FlightDatabaseOperations();
        
        try {
            // Obtener conexión a la base de datos
            Connection conn = DatabaseConnection.getConnection();
            
            // Ejecutar las operaciones de prueba
            try {
                // Mostrar pasajeros
                List<Pasajero> pasajeros = flightDatabaseOperationsObj.obtenerPasajeros(conn);
                System.out.println("Información de pasajeros:");
                pasajeros.forEach(System.out::println);

                // Mostrar vuelos
                List<Vuelo> vuelos = flightDatabaseOperationsObj.obtenerVuelos(conn);
                System.out.println("\nInformación de vuelos:");
                vuelos.forEach(System.out::println);

                // Ver pasajeros de un vuelo específico
                String codigoVuelo = "SP-DC-438";
                List<Pasajero> pasajerosVuelo = flightDatabaseOperationsObj.obtenerPasajerosPorVuelo(conn, codigoVuelo);
                System.out.println("\nPasajeros del vuelo " + codigoVuelo + ":");
                pasajerosVuelo.forEach(System.out::println);

                // Insertar un vuelo y un pasajero
                flightDatabaseOperationsObj.insertarVuelo(conn, "FR-PR-5000", "21/05/99 15:30", "Madrid", "Paris", 30, 120, 90, 60);
                flightDatabaseOperationsObj.insertarPasajero(conn, "FR-PR-5000", "Juan", "Pérez");

                // Modificar pasajeros de un vuelo
                flightDatabaseOperationsObj.modificarPasajerosVuelo(conn, "IB-SP-4567");

                // Modificar destino de un vuelo
                String codigoVueloModificado = "IB-BA-46DC";
                String nuevoDestino = "Tokio";
                flightDatabaseOperationsObj.modificarDestinoVuelo(conn, codigoVueloModificado, nuevoDestino);

                // Eliminar un vuelo
                String codigoVueloEliminar = "FR-PR-5000";
                flightDatabaseOperationsObj.eliminarVuelo(conn, codigoVueloEliminar);

            } finally {
                // Cerrar la conexión
                DatabaseConnection.closeConnection(conn);
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }

        
    }
}
