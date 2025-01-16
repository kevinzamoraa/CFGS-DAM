/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.kevinzamora.examenad.ejercicio2;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Kevin
 */
public class ExamenADEjercicio2 {
    
    public static void main(String[] args) {
        
        OperacionesTienda operacionesTiendaObj = new OperacionesTienda();
        
        try {
            // Obtener conexión a la base de datos
            Connection conn = DatabaseConnection.getConnection();
            
            // Ejecutar las operaciones
            try {

                // 1. Mostrar usuarios
                List<Usuario> usuarios = operacionesTiendaObj.obtenerUsuarios(conn);
                System.out.println("\nUsuarios:");
                usuarios.forEach(System.out::println);

                // 2. Ver pedidos de un usuario específico
                String emailUsuario = "juan.perez@example.com";
                List<Pedido> pedidosUsuario = operacionesTiendaObj.obtenerPedidosPorUsuario(conn, emailUsuario);
                System.out.println("\nPedidos del usuario " + emailUsuario + ":");
                pedidosUsuario.forEach(System.out::println);
                
                // 3. Insertar un pedido
                // operacionesTiendaObj.insertarPedido(conn, 5, 1, "Ordenador", 3, LocalDate.of(2025,1,1));
                // System.out.println("Se ha insertado un pedido en el nuevo usuario");System.out.println("Se ha insertado el nuevo usuario");

                // 4. Insertar un usuario
                operacionesTiendaObj.insertarUsuario(conn, "Kevin", "contactaconkev@gmail.com");
                System.out.println("Se ha insertado el nuevo usuario");
                
                // 8. Eliminar un usuario
                String emailUsuarioEliminar = "contactaconkev@gmail.com";
                operacionesTiendaObj.eliminarUsuario(conn, emailUsuarioEliminar);
                System.out.println("\nSe ha eliminado el usuario con correo electronico " + emailUsuarioEliminar);

            } finally {
                // Cerrar la conexión
                DatabaseConnection.closeConnection(conn);
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
    }      
}
