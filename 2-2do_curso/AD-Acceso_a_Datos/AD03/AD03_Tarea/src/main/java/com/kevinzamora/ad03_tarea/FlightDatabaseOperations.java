/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kevinzamora.ad03_tarea;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kzdesigner
 */
public class FlightDatabaseOperations {

    public List<Pasajero> obtenerPasajeros(Connection conn) throws SQLException {
        List<Pasajero> pasajeros = new ArrayList<>();
        String sql = "SELECT * FROM PASAJEROS";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Pasajero p = new Pasajero(
                    rs.getInt("NUM"),
                    rs.getString("COD_VUELO"),
                    rs.getString("TIPO_PLAZA")
                );
                pasajeros.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener pasajeros: " + e.getMessage());
        }

        return pasajeros;
    }

    public List<Vuelo> obtenerVuelos(Connection conn) throws SQLException {
        List<Vuelo> vuelos = new ArrayList<>();
        String sql = "SELECT * FROM VUELOS";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Vuelo v = new Vuelo(
                    rs.getString("COD_VUELO"),
                    rs.getString("HORA_SALIDA"),
                    rs.getString("DESTINO"),
                    rs.getString("PROCEDENCIA"),
                    rs.getInt("PLAZAS_FUMADOR"),
                    rs.getInt("PLAZAS_NO_FUMADOR"),
                    rs.getInt("PLAZAS_TURISTA"),
                    rs.getInt("PLAZAS_PRIMERA")
                );
                vuelos.add(v);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener vuelos: " + e.getMessage());
        }

        return vuelos;
    }

    public List<Pasajero> obtenerPasajerosPorVuelo(Connection conn, String codigoVuelo) throws SQLException {
        List<Pasajero> pasajeros = new ArrayList<>();
        String sql = "SELECT P.* FROM PASAJEROS P JOIN VUELOS V ON P.COD_VUELO = V.COD_VUELO WHERE V.COD_VUELO = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, codigoVuelo);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Pasajero p = new Pasajero(
                        rs.getInt("ID"),
                        rs.getString("COD_VUELO"),
                        rs.getString("TIPO_PLAZA")
                    );
                    pasajeros.add(p);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener pasajeros por vuelo: " + e.getMessage());
        }

        return pasajeros;
    }

    public void insertarVuelo(Connection conn, String codigoVuelo, String horaSalida, String destino, String procedencia,
                              int plazasFumador, int plazasNoFumador, int plazasTurista, int plazasPrimera)
            throws SQLException {
        String sql = "INSERT INTO VUELOS (COD_VUELO, HORA_SALIDA, DESTINO, PROCEDENCIA, PLAZAS_FUMADOR, PLAZAS_NO_FUMADOR, PLAZAS_TURISTA, PLAZAS_PRIMERA) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, codigoVuelo);
            pstmt.setString(2, horaSalida);
            pstmt.setString(3, destino);
            pstmt.setString(4, procedencia);
            pstmt.setInt(5, plazasFumador);
            pstmt.setInt(6, plazasNoFumador);
            pstmt.setInt(7, plazasTurista);
            pstmt.setInt(8, plazasPrimera);

            pstmt.executeUpdate();
        }
    }

    public void insertarPasajero(Connection conn, String codigoVuelo, String tipoPlaza, String fumador)
            throws SQLException {
        String sql = "INSERT INTO PASAJEROS (COD_VUELO, TIPO_PLAZA, FUMADOR) VALUES (?, ?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, codigoVuelo);
            pstmt.setString(2, tipoPlaza);
            pstmt.setString(3, fumador);
            
            pstmt.executeUpdate();
        }
    }

    public void modificarPasajerosVuelo(Connection conn, String codigoVuelo) throws SQLException {
        String sql = "UPDATE VUELOS SET PLAZAS_FUMADOR = PLAZAS_NO_FUMADOR WHERE COD_VUELO = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, codigoVuelo);
            pstmt.executeUpdate();
        }
    }

    public void modificarDestinoVuelo(Connection conn, String codigoVuelo, String nuevoDestino) throws SQLException {
        String sql = "UPDATE VUELOS SET DESTINO = ? WHERE COD_VUELO = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, nuevoDestino);
            pstmt.setString(2, codigoVuelo);
            pstmt.executeUpdate();
        }
    }

    public void eliminarVuelo(Connection conn, String codigoVuelo) throws SQLException {
        String sql = "DELETE FROM VUELOS WHERE COD_VUELO = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, codigoVuelo);
            pstmt.executeUpdate();
        }
    }
}
