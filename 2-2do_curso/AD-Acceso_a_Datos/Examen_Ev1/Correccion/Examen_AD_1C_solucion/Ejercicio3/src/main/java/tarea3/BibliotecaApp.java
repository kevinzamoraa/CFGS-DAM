package tarea3;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        mostrarLibrosDisponibles();
        insertarPrestamo(2, "Pedro Ramírez");
        borrarPrestamo(2);
    }

    // Mostrar los libros disponibles
    public static void mostrarLibrosDisponibles() {
        try (Session session = NewHibernateUtil.getSessionFactory().openSession()) {
            Query<Libros> query = session.createQuery("FROM Libros WHERE disponible = true", Libros.class);
            List<Libros> libros = query.list();
            for (Libros libro : libros) {
                System.out.printf("ID Libro: %d, Título: %s, Autor: %s, Año: %d%n",
                        libro.getIdLibro(), libro.getTitulo(), libro.getAutor(), libro.getAnioPublicacion());
            }
        }
    }

    // Insertar un préstamo
    public static void insertarPrestamo(int idLibro, String nombreUsuario) {
        try (Session session = NewHibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            // Obtener el libro por su ID
            Libros libro = session.get(Libros.class, idLibro);
            if (libro != null && libro.isDisponible()) {
                libro.setDisponible(false); // Cambiar el estado del libro

                Prestamos prestamo = new Prestamos();
                prestamo.setLibro(libro); // Asociar el objeto libro al préstamo
                prestamo.setNombreUsuario(nombreUsuario);
                prestamo.setFechaPrestamo(LocalDate.now());

                session.save(prestamo); // Guardar el préstamo
                session.update(libro); // Actualizar el estado del libro

                System.out.println("Préstamo registrado con éxito.");
            } else {
                System.out.println("El libro no está disponible o no existe.");
            }

            tx.commit();
        }
    }

    // Borrar un préstamo
    public static void borrarPrestamo(int idPrestamo) {
        try (Session session = NewHibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            Prestamos prestamo = session.get(Prestamos.class, idPrestamo);
            if (prestamo != null) {
                Libros libro = prestamo.getLibro(); // Obtener el objeto relacionado
                if (libro != null) {
                    libro.setDisponible(true); // Cambiar el estado a disponible
                    session.update(libro); // Actualizar en la base de datos
                }
                session.delete(prestamo); // Eliminar el préstamo

                System.out.println("Préstamo eliminado con éxito.");
            } else {
                System.out.println("No se encontró el préstamo.");
            }

            tx.commit();
        }
    }
}
