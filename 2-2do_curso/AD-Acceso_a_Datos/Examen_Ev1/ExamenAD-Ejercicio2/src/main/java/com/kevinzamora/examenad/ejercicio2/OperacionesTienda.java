/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kevinzamora.examenad.ejercicio2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Kevin
 */
public class OperacionesTienda {
    
    public List<Pedido> obtenerPedidos(Connection conn) throws SQLException {
        List<Pedido> pasajeros = new ArrayList<>();
        String sql = "SELECT * FROM pedidos";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Pedido p = new Pedido(
                        rs.getInt("id"),
                        rs.getInt("usuarioId"),
                        rs.getString("producto"),
                        rs.getInt("cantidad"),
                        rs.getDate("fecha")
                );
                pasajeros.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los pedidos: " + e.getMessage());
        }

        return pasajeros;
    }

    public List<Usuario> obtenerUsuarios(Connection conn) throws SQLException {
        List<Usuario> vuelos = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario v = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email")
                );
                vuelos.add(v);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los usuarios: " + e.getMessage());
        }

        return vuelos;
    }

    public List<Pedido> obtenerPedidosPorUsuario(Connection conn, String nombre) throws SQLException {
        List<Pedido> pasajeros = new ArrayList<>();
        String sql = "SELECT P.* FROM pedidos P JOIN usuarios U ON P.usuario_id = U.id WHERE U.id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Pedido p = new Pedido(
                        rs.getInt("id"),
                        rs.getInt("usuarioId"),
                        rs.getString("producto"),
                        rs.getInt("cantidad"),
                        rs.getDate("fecha")
                    );
                    pasajeros.add(p);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los pedidos por usuario: " + e.getMessage());
        }

        return pasajeros;
    }

    public void insertarUsuario(Connection conn, String nombre, String email)
            throws SQLException {
        String sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, email);

            pstmt.executeUpdate();
        }
    }

    public void insertarPedido(Connection conn, int id, int usuarioId, String producto, int cantidad, Date fecha)
            throws SQLException {
        String sql = "INSERT INTO pedidos VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.setInt(2, usuarioId);
            pstmt.setString(3, producto);
            pstmt.setInt(4, cantidad);
            pstmt.setDate(5, (java.sql.Date) fecha);

            pstmt.executeUpdate();
        }
    }

    public void eliminarUsuario(Connection conn, String email) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE email = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            pstmt.executeUpdate();
        }
    }
    
}
