/*
 * Click nbfs://nbhost/SystemFileSystem/Tlibrolates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea3;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Kevin
 */
public class BibliotecaDAO {
    
    public void insertPrestamo(Prestamos prestamo) {
        Transaction transaction = null;
        try (Session session = NewHibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            try {
                session.save(prestamo);
            } catch (Exception e) {
                System.out.println("Se ha producido el siguiente error al guardar: " + e);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void insertLibro(Libros libro) {
        Transaction transaction = null;
        try (Session session = NewHibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            try {
                session.save(libro);
            } catch (Exception e) {
                System.out.println("Se ha producido el siguiente error al guardar: " + e);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Libros> listLibrosDisponibles() {
        try (Session session = NewHibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Libros", Libros.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    public Prestamos encuentraPrestamo(int id) {
        try (Session session = NewHibernateUtil.getSessionFactory().openSession()) {
            String sqlQuery = "FROM prestamos WHERE id = " + id;
            return session.createQuery(sqlQuery, Prestamos.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new Prestamos();
        }
    }
    
    public Libros encuentraLibro(int id) {
        try (Session session = NewHibernateUtil.getSessionFactory().openSession()) {
            String sqlQuery = "FROM libros WHERE id = " + id;
            return session.createQuery(sqlQuery, Libros.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new Libros();
        }
    }
    
    public void deletePrestamo(int idPrestamo) {
        Transaction transaction = null;
        try (Session session = NewHibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Prestamos prestamo = session.get(Prestamos.class, idPrestamo);
            if (prestamo != null) {
                session.delete(idPrestamo);
                transaction.commit();
            } else {
                transaction.rollback();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
