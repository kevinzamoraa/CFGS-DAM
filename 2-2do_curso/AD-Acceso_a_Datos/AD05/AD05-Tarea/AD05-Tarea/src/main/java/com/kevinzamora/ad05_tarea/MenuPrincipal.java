/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kevinzamora.ad05_tarea;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author kzdesigner
 */
public class MenuPrincipal {
    
    private ObjectContainer db;

    public void crearBaseDatos() {
        File fichero = new File("baseDatos");
        fichero.delete();
        
        db = Db4oEmbedded.openFile("BDJefeHijo");

        db.store(new Jefe("Ángel", 5, 53, new Hijo("Gustavo", 7)));
        db.store(new Jefe("Nieves", 3, 45, new Hijo("Iván", 3)));
        db.store(new Jefe("Jesús", 3, 5, new Hijo("Noelia", 3)));
        db.store(new Jefe("Dolores", 5,63, new Hijo("Sergio", 7)));
        db.store(new Jefe("Vicki", 3, 5, null));
        db.store(new Jefe("Fátima", 5, 63, new Hijo("Lidia", 27)));
        db.store(new Jefe("Juan Luís", 3, 5, null));
        db.store(new Jefe("Elena", 1, 42, new Hijo("David", 19)));
        db.store(new Jefe("Miguel", 20,45, new Hijo("Paula", 3)));
        db.store(new Jefe("Jesús", 19, 44, new Hijo("Rubén", 12)));

        db.close();
        System.out.println("Base de datos creada correctamente.");
    }

    public void visualizarTodos() {
        db = Db4oEmbedded.openFile("BDJefeHijo");
        ObjectSet<Jefe> resultado = db.query(Jefe.class);
        
        for (Jefe jefe : resultado) {
            System.out.println(jefe.toString());
        }
        
        db.close();
    }

    public void visualizarMayores55() {
        db = Db4oEmbedded.openFile("BDJefeHijo");
        Query query = db.query();
        query.constrain(Jefe.class);
        query.descend("edad").constrain(55).greater();
        ObjectSet<Jefe> resultado = query.execute();
        
        for (Jefe jefe : resultado) {
            System.out.println(jefe.toString());
        }
        
        db.close();
    }

    public void modificarEdadMiguel() {
        db = Db4oEmbedded.openFile("BDJefeHijo");
        Query query = db.query();
        query.constrain(Jefe.class);
        query.descend("nombre").constrain("Miguel");
        ObjectSet<Jefe> resultado = query.execute();
        
        if (!resultado.isEmpty()) {
            Jefe miguel = resultado.get(0);
            miguel.setEdad(miguel.getEdad() + 1);
            db.store(miguel);
            System.out.println("Edad de Miguel modificada correctamente y se ha "
                    + "incrementado en una unidad.");
        } else {
            System.out.println("No se encontró al jefe Miguel.");
        }
        
        db.close();
    }

    public void borrarMas6Anos() {
        db = Db4oEmbedded.openFile("BDJefeHijo");
        Query query = db.query();
        query.constrain(Jefe.class);
        query.descend("añosEmpresa").constrain(6).greater();
        ObjectSet<Jefe> resultado = query.execute();
        
        for (Jefe jefe : resultado) {
            db.delete(jefe);
        }
        
        System.out.println("Jefes con más de 6 años eliminados.");
        db.close();
    }

    public void visualizarActualizado() {
        db = Db4oEmbedded.openFile("BDJefeHijo");
        ObjectSet<Jefe> resultado = db.query(Jefe.class);
        
        for (Jefe jefe : resultado) {
            System.out.println(jefe.toString());
        }
        
        db.close();
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Crear base de datos");
            System.out.println("2. Visualizar toda la base de datos");
            System.out.println("3. Visualizar jefes mayores de 55 años");
            System.out.println("4. Modificar edad de Miguel");
            System.out.println("5. Borrar jefes con más de 6 años");
            System.out.println("6. Visualizar base de datos actualizada");
            System.out.println("7. Salir");
            
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> crearBaseDatos();
                case 2 -> visualizarTodos();
                case 3 -> visualizarMayores55();
                case 4 -> modificarEdadMiguel();
                case 5 -> borrarMas6Anos();
                case 6 -> visualizarActualizado();
                case 7 -> {
                    continuar = false;
                    System.out.println("¡Gracias por usar el sistema!");
                }
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.mostrarMenu();
    }
    
}
