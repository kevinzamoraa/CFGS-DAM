package com.kevinzamora.ejercicio2_1;

import java.io.RandomAccessFile;
import java.io.IOException;

public class CrearFicheroEmpleados {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("EMPLEADOS.DAT", "rw")) {
            // Datos de ejemplo de los empleados
            int[] codigo = {1, 2, 3, 4, 5};
            String[] nombre = {"Juan", "Ana", "Luis", "Marta", "Carlos"};
            String[] direccion = {"Calle A", "Calle B", "Calle C", "Calle D", "Calle E"};
            float[] salario = {1000.0f, 1200.5f, 1100.0f, 1300.0f, 1500.0f};
            float[] comision = {150.0f, 200.0f, 180.0f, 220.0f, 250.0f};

            for (int i = 0; i < codigo.length; i++) {
                file.writeInt(codigo[i]);
                file.writeUTF(nombre[i]);
                file.writeUTF(direccion[i]);
                file.writeFloat(salario[i]);
                file.writeFloat(comision[i]);
            }
            System.out.println("Fichero EMPLEADOS.DAT creado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
