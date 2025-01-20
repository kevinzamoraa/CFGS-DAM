package Ejercicio2;

import java.sql.*;

public class JdbcConsultas {

    private static final String URL = "jdbc:mysql://localhost:3306/tienda";
    private static final String USER = "root";
    private static final String PASSWORD = "Root1234";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conexión establecida correctamente.");

            // 1. Consulta: Obtener todos los usuarios
            getAllUsers(connection);

            // 2. Consulta: Pedidos de un usuario específico
            getUserOrders(connection, 1); 
            
            // 3. Inserción: Añadir un nuevo pedido
            addOrder(connection, 1, "Tablet", 1, "2025-01-12");

            // 4. Inserción: Añadir un nuevo usuario
            int newUserId = addUser(connection, "Carlos López", "carlos.lopez@example.com");

            // 5. Borrado: Eliminar el último usuario añadido
            deleteUser(connection, newUserId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 1. Obtener todos los usuarios
    private static void getAllUsers(Connection connection) throws SQLException {
        String query = "SELECT * FROM usuarios";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Usuarios:");
            while (rs.next()) {
                System.out.printf("ID: %d, Nombre: %s, Email: %s%n",
                        rs.getInt("id"), rs.getString("nombre"), rs.getString("email"));
            }
        } catch (SQLException se) {
            System.out.println("SQL Excepcion " + se);
        }
    }

    // 2. Obtener pedidos de un usuario específico
    private static void getUserOrders(Connection connection, int userId) throws SQLException {
        String query = "SELECT * FROM pedidos WHERE usuario_id = " + userId;
        try{
            Statement stmt = connection.createStatement(); 
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Pedidos del usuario con ID " + userId + ":");
            while (rs.next()) {
                System.out.printf("Pedido ID: %d, Producto: %s, Cantidad: %d, Fecha: %s%n",
                        rs.getInt("id"), rs.getString("producto"), rs.getInt("cantidad"), rs.getDate("fecha"));
            }
        }catch (SQLException se) {
            System.out.println("SQL Excepcion " + se);
        }
    }

    // 3. Añadir un nuevo usuario
    private static int addUser(Connection connection, String nombre, String email) throws SQLException {
        String query = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";
        try{
            
            PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS); // indicamos que después de ejecutar esta consulta, que la base de datos devuelva la clave generada (ID).
            pstmt.setString(1, nombre);
            pstmt.setString(2, email);
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Usuario añadido correctamente.");
                // devolvemos la clave generada por la base de datos del auto incremental ID para utilizar en el último apartado
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }
        }catch (SQLException se) {
            System.out.println("SQL Excepcion " + se);
        }
        return -1; // devolvemos -1 si no se pudo insertar el usuario
    }

    // 4. Añadir un nuevo pedido
    private static void addOrder(Connection connection, int userId, String producto, int cantidad, String fecha) throws SQLException {
        String query = "INSERT INTO pedidos (usuario_id, producto, cantidad, fecha) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, userId);
            pstmt.setString(2, producto);
            pstmt.setInt(3, cantidad);
            pstmt.setDate(4, Date.valueOf(fecha));
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Pedido añadido correctamente.");
            }
        }catch (SQLException se) {
            System.out.println("SQL Excepcion " + se);
        }
    }

    // 5. Eliminar un usuario
    private static void deleteUser(Connection connection, int userId) throws SQLException {
        String query = "DELETE FROM usuarios WHERE id = ?";
        try{
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, userId);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Usuario eliminado correctamente.");
            } else {
                System.out.println("No se encontró un usuario con el ID especificado.");
            }
        }catch (SQLException se) {
            System.out.println("SQL Excepcion " + se);
        }
    }

}
