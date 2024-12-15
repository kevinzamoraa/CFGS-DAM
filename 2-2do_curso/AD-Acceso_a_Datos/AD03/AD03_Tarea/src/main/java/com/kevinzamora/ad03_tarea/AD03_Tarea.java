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
                // 1. Mostrar pasajeros
                List<Pasajero> pasajeros = flightDatabaseOperationsObj.obtenerPasajeros(conn);
                System.out.println("Información de pasajeros:");
                pasajeros.forEach(System.out::println);

                // 2. Mostrar vuelos
                List<Vuelo> vuelos = flightDatabaseOperationsObj.obtenerVuelos(conn);
                System.out.println("\nInformación de vuelos:");
                vuelos.forEach(System.out::println);

                // 3. Ver pasajeros de un vuelo específico
                String codigoVuelo = "SP-DC-438";
                List<Pasajero> pasajerosVuelo = flightDatabaseOperationsObj.obtenerPasajerosPorVuelo(conn, codigoVuelo);
                System.out.println("\nPasajeros del vuelo " + codigoVuelo + ":");
                pasajerosVuelo.forEach(System.out::println);

                // 4. Insertar un vuelo
                flightDatabaseOperationsObj.insertarVuelo(conn, "FR-PR-5000", "21/05/99 15:30", "Madrid",
                        "Paris", 30, 120, 90, 60);
                System.out.println("Se ha insertado el nuevo vuelo");
                // 5. Insertar un pasajero
                flightDatabaseOperationsObj.insertarPasajero(conn,144,"FR-PR-5000", "TU", "NO");
                System.out.println("Se ha insertado un pasajero en el nuevo vuelo");System.out.println("Se ha insertado el nuevo vuelo");

                // 6. Modificar pasajeros de un vuelo
                flightDatabaseOperationsObj.modificarPasajerosVuelo(conn, "IB-SP-4567");
                System.out.println("\nSe ha modificado los pasajeros del vuelo IB-SP-4567");

                // 7. Modificar destino de un vuelo
                String codigoVueloModificado = "IB-BA-46DC";
                String nuevoDestino = "Tokio";
                flightDatabaseOperationsObj.modificarDestinoVuelo(conn, codigoVueloModificado, nuevoDestino);
                System.out.println("\nSe ha modificado el destino del vuelo IB-BA-46DC");


                // 8. Eliminar un vuelo (Para comprobar que funcionan los ejercicios 4 y 5 se debería comentar la llamada al método siguiente)
                String codigoVueloEliminar = "FR-PR-5000";
                flightDatabaseOperationsObj.eliminarVuelo(conn, codigoVueloEliminar);
                System.out.println("\nSe ha eliminado el vuelo FR-PR-5000");


            } finally {
                // Cerrar la conexión
                DatabaseConnection.closeConnection(conn);
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }

        
    }
}
