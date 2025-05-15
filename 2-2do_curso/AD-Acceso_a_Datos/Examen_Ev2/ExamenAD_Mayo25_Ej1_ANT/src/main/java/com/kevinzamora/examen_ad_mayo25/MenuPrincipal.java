<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kevinzamora.examen_ad_mayo25;

import com.kevinzamora.examen_ad_mayo25.Profesor;
import com.kevinzamora.examen_ad_mayo25.Curso;

import com.db4o .Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.io.File;
import java.util.Scanner;
import javax.management.Query;

/**
 *
 * @author Kevin Zamora
 */
public class MenuPrincipal {

    public void crearBaseDatos() {

        try {
            // código para crear el método que crea la base de datos
            File fichero = new File("DBProfesorCurso");
            fichero.delete();
            ObjectContainer baseDatos = Db4oEmbedded.openFile("DBProfesorCurso");
            baseDatos.store(new Profesor("Laura", 10, 45, new Curso("Matemáticas", 30)));
            baseDatos.store(new Profesor("Carlos", 5, 38, new Curso("Historia", 25)));
            baseDatos.store(new Profesor("Ana", 15, 50, null));
            baseDatos.store(new Profesor("Pedro", 2, 29, new Curso("Biología", 20)));
            baseDatos.store(new Profesor("Marta", 7, 41, new Curso("Física", 28)));
            baseDatos.store(new Profesor("Sergio", 3, 35, null));
            baseDatos.store(new Profesor("Lucía", 12, 48, new Curso("Química", 32)));
            baseDatos.close();
            System.out.println("\nBase de datos creada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al crear la base de datos: " + e.getMessage());
        }

    }

    public void visualizarTodos() {
        try{
            baseDatos = Db4oEmbedded.openFile("DBProfesorCurso");
            ObjectSet<Profesor> resultado = baseDatos.query(Profesor.class);

            for (Profesor profesor : resultado) {
                System.out.println(profesor.toString());
            }
        } catch (Exception e) {
            System.err.println("Error durante la consulta: " + e.getMessage());
        } finally {
            if (baseDatos != null) {
                baseDatos.close();
            }
        }
    }

    public void visualizarMayores40() {
        ObjectContainer baseDatos = null;
        try {
            baseDatos = Db4oEmbedded.openFile("DBProfesorCurso");
            Query query = baseDatos.query();
            query.constrain(Profesor.class);
            query.descend("edad").constrain(40).greater();
            ObjectSet<Profesor> resultado = query.execute();

            for (Profesor profesor : resultado) {
                System.out.println(profesor.toString());
            }
        } catch (Exception e) {
            System.err.println("Error durante la consulta: " + e.getMessage());
        } finally {
            if (baseDatos != null) {
                baseDatos.close();
            }
        }
    }

    public void modificarAntiguedadAna() {
        ObjectContainer baseDatos = null;
        try {
            baseDatos = Db4oEmbedded.openFile("DBProfesorCurso");
            Query query = baseDatos.query();
            query.constrain(Profesor.class);
            query.descend("nombre").constrain("Ana");
            ObjectSet<Profesor> resultado = query.execute();

            if (!resultado.isEmpty()) {
                Profesor ana = resultado.get(0);
                ana.setEdad(ana.getEdad() + 1);
                baseDatos.store(ana);
                System.out.println("La antiguedad de Ana ha sido modificada "
                        + "correctamente y se ha incrementado en una unidad.");
            } else {
                System.out.println("No se encontró a Ana.");
            }
        } catch (Exception e) {
            System.err.println("Error durante la consulta: " + e.getMessage());
        } finally {
            if (baseDatos != null) {
                baseDatos.close();
            }
        }
    }

    public void borrarProfAntiguedadMenor5Anos() {
        ObjectContainer baseDatos = null;
        try {
            baseDatos = Db4oEmbedded.openFile("DBProfesorCurso");
            Query query = baseDatos.query();
            query.constrain(Profesor.class);
            query.descend("antiguedadEnEscuela").constrain(5).smaller();
            ObjectSet<Profesor> resultado = query.execute();

        for (Profesor jefe : resultado) {
            baseDatos.delete(jefe);
        }

        System.out.println("Los profesores con menos de 5 años han sido eliminados.");
        } catch (Exception e) {
            System.err.println("Error durante la consulta: " + e.getMessage());
        } finally {
            if (baseDatos != null) {
                baseDatos.close();
            }
        }
    }

    public void visualizarProfCursosMas25Horas() {
        ObjectContainer baseDatos = null;
        try {
            baseDatos = Db4oEmbedded.openFile("DBProfesorCurso");

            Query query = baseDatos.query();
            query.constrain(Profesor.class);
            query.descend("curso").descend("horas").constrain(25).greater();

            ObjectSet<Profesor> resultado = query.execute();

            for (Profesor profesor : resultado) {
                System.out.println(profesor.toString());
            }

        } catch (Exception e) {
            System.err.println("Error durante la consulta: " + e.getMessage());
        } finally {
            if (baseDatos != null) {
                baseDatos.close();
            }
        }
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Crear base de datos");
            System.out.println("2. Visualizar todos los profesores y sus cursos");
            System.out.println("3. Visualizar profesores mayores de 40 años");
            System.out.println("4. Incrementar la antigüedad de Ana en 1 año");
            System.out.println("5. Eliminar profesores que tengan menos de 5 años de antigüedad");
            System.out.println("6. Visualizar los profesores que impartan cursos de más de 25 horas");
            System.out.println("7. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 ->
                    crearBaseDatos();
                case 2 ->
                    visualizarTodos();
                case 3 ->
                    visualizarMayores40();
                case 4 ->
                    modificarAntiguedadAna();
                case 5 -> 
                    borrarProfAntiguedadMenor5Anos();
                case 6 -> 
                    visualizarProfCursosMas25Horas();
                case 7 -> {
                    continuar = false;
                    System.out.println("¡Gracias por usar el sistema!");
                }
                default ->
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.mostrarMenu();
    }

}
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kevinzamora.examen_ad_mayo25;

import com.kevinzamora.examen_ad_mayo25.Profesor;
import com.kevinzamora.examen_ad_mayo25.Curso;

import com.db4o .Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.io.File;
import java.util.Scanner;
import javax.management.Query;

/**
 *
 * @author Kevin Zamora
 */
public class MenuPrincipal {

    public void crearBaseDatos() {

        try {
            // código para crear el método que crea la base de datos
            File fichero = new File("DBProfesorCurso");
            fichero.delete();
            ObjectContainer baseDatos = Db4oEmbedded.openFile("DBProfesorCurso");
            baseDatos.store(new Profesor("Laura", 10, 45, new Curso("Matemáticas", 30)));
            baseDatos.store(new Profesor("Carlos", 5, 38, new Curso("Historia", 25)));
            baseDatos.store(new Profesor("Ana", 15, 50, null));
            baseDatos.store(new Profesor("Pedro", 2, 29, new Curso("Biología", 20)));
            baseDatos.store(new Profesor("Marta", 7, 41, new Curso("Física", 28)));
            baseDatos.store(new Profesor("Sergio", 3, 35, null));
            baseDatos.store(new Profesor("Lucía", 12, 48, new Curso("Química", 32)));
            baseDatos.close();
            System.out.println("\nBase de datos creada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al crear la base de datos: " + e.getMessage());
        }

    }

    public void visualizarTodos() {
        try{
            baseDatos = Db4oEmbedded.openFile("DBProfesorCurso");
            ObjectSet<Profesor> resultado = baseDatos.query(Profesor.class);

            for (Profesor profesor : resultado) {
                System.out.println(profesor.toString());
            }
        } catch (Exception e) {
            System.err.println("Error durante la consulta: " + e.getMessage());
        } finally {
            if (baseDatos != null) {
                baseDatos.close();
            }
        }
    }

    public void visualizarMayores40() {
        ObjectContainer baseDatos = null;
        try {
            baseDatos = Db4oEmbedded.openFile("DBProfesorCurso");
            Query query = baseDatos.query();
            query.constrain(Profesor.class);
            query.descend("edad").constrain(40).greater();
            ObjectSet<Profesor> resultado = query.execute();

            for (Profesor profesor : resultado) {
                System.out.println(profesor.toString());
            }
        } catch (Exception e) {
            System.err.println("Error durante la consulta: " + e.getMessage());
        } finally {
            if (baseDatos != null) {
                baseDatos.close();
            }
        }
    }

    public void modificarAntiguedadAna() {
        ObjectContainer baseDatos = null;
        try {
            baseDatos = Db4oEmbedded.openFile("DBProfesorCurso");
            Query query = baseDatos.query();
            query.constrain(Profesor.class);
            query.descend("nombre").constrain("Ana");
            ObjectSet<Profesor> resultado = query.execute();

            if (!resultado.isEmpty()) {
                Profesor ana = resultado.get(0);
                ana.setEdad(ana.getEdad() + 1);
                baseDatos.store(ana);
                System.out.println("La antiguedad de Ana ha sido modificada "
                        + "correctamente y se ha incrementado en una unidad.");
            } else {
                System.out.println("No se encontró a Ana.");
            }
        } catch (Exception e) {
            System.err.println("Error durante la consulta: " + e.getMessage());
        } finally {
            if (baseDatos != null) {
                baseDatos.close();
            }
        }
    }

    public void borrarProfAntiguedadMenor5Anos() {
        ObjectContainer baseDatos = null;
        try {
            baseDatos = Db4oEmbedded.openFile("DBProfesorCurso");
            Query query = baseDatos.query();
            query.constrain(Profesor.class);
            query.descend("antiguedadEnEscuela").constrain(5).smaller();
            ObjectSet<Profesor> resultado = query.execute();

        for (Profesor jefe : resultado) {
            baseDatos.delete(jefe);
        }

        System.out.println("Los profesores con menos de 5 años han sido eliminados.");
        } catch (Exception e) {
            System.err.println("Error durante la consulta: " + e.getMessage());
        } finally {
            if (baseDatos != null) {
                baseDatos.close();
            }
        }
    }

    public void visualizarProfCursosMas25Horas() {
        ObjectContainer baseDatos = null;
        try {
            baseDatos = Db4oEmbedded.openFile("DBProfesorCurso");

            Query query = baseDatos.query();
            query.constrain(Profesor.class);
            query.descend("curso").descend("horas").constrain(25).greater();

            ObjectSet<Profesor> resultado = query.execute();

            for (Profesor profesor : resultado) {
                System.out.println(profesor.toString());
            }

        } catch (Exception e) {
            System.err.println("Error durante la consulta: " + e.getMessage());
        } finally {
            if (baseDatos != null) {
                baseDatos.close();
            }
        }
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Crear base de datos");
            System.out.println("2. Visualizar todos los profesores y sus cursos");
            System.out.println("3. Visualizar profesores mayores de 40 años");
            System.out.println("4. Incrementar la antigüedad de Ana en 1 año");
            System.out.println("5. Eliminar profesores que tengan menos de 5 años de antigüedad");
            System.out.println("6. Visualizar los profesores que impartan cursos de más de 25 horas");
            System.out.println("7. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 ->
                    crearBaseDatos();
                case 2 ->
                    visualizarTodos();
                case 3 ->
                    visualizarMayores40();
                case 4 ->
                    modificarAntiguedadAna();
                case 5 -> 
                    borrarProfAntiguedadMenor5Anos();
                case 6 -> 
                    visualizarProfCursosMas25Horas();
                case 7 -> {
                    continuar = false;
                    System.out.println("¡Gracias por usar el sistema!");
                }
                default ->
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.mostrarMenu();
    }

}
>>>>>>> 4edd254b066f20d2eed74d2b2d2c4cc239e38875
