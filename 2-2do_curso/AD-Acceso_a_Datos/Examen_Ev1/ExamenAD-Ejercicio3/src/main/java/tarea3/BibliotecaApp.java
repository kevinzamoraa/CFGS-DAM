package tarea3;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class BibliotecaApp {
    
    public static void main(String[] args) {

        BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
        List<Libros> libros = bibliotecaDAO.listLibrosDisponibles();

        // llamar a los 3 métodos parcialmente implementados
        mostrarLibrosDisponibles(libros);
        insertarPrestamo(10, "Kevin", bibliotecaDAO);
        System.out.println("Se ha introducido un préstamo con éxito");
        
    }

    // Mostrar los libros disponibles
    public static void mostrarLibrosDisponibles(List<Libros> libros) {

        // Implementa la lógica para mostrar los libros disponibles.
        System.out.println("Lista de prestamos:");
        for (Libros l : libros) {
            if (l.isDisponible() == true) {
                System.out.println(l.getIdLibro() + " - Título: " + l.getTitulo() 
                        + ", Autor: " + l.getAutor() + ", Año de publicación: " 
                        + l.getAnioPublicacion());
            }
        }
        // Debes realizar una consulta usando HQL para obtener todos los libros donde 'disponible = true'.

    }

    // Insertar un préstamo
    public static void insertarPrestamo(int idLibro, String nombre, BibliotecaDAO bibliotecaDAO) {
        // Implementa la lógica para registrar un préstamo.
        // Recuerda:
        // 1. Verificar si el libro existe y está disponible.
        // 2. Cambiar el estado del libro a 'no disponible'.
        // 3. Guardar el préstamo en la base de datos.
        Prestamos prestamo = new Prestamos();
        Libros libro = bibliotecaDAO.encuentraLibro(idLibro); 
        if (libro.isDisponible()) {
            libro.setDisponible(false);
            bibliotecaDAO.insertPrestamo(prestamo);
            bibliotecaDAO.insertLibro(libro);
        }
        
        System.out.println("El nuevo prestamo se ha guardado correctamente");

    }

    // Borrar un préstamo
    public static void borrarPrestamo(BibliotecaDAO bibliotecaDAO, int idPrestamo) {
        // Implementa la lógica para eliminar un préstamo.
        // Recuerda:
        // 1. Obtener el préstamo por su ID.
        Prestamos prestamo = bibliotecaDAO.encuentraPrestamo(idPrestamo);
        // 2. Cambiar el estado del libro a 'disponible'.
        Libros libro = bibliotecaDAO.encuentraLibro(prestamo.getLibro().getIdLibro());
        if (libro.isDisponible() == false) {
            libro.setDisponible(true);
            bibliotecaDAO.insertLibro(libro);
        }
        // 3. Eliminar el préstamo de la base de datos.
        bibliotecaDAO.deletePrestamo(prestamo.getIdPrestamo()); // Borramos el usuario creado previamente
        System.out.println("Se ha borrado el prestamo creado durante la prueba de inserción");

    }
}
