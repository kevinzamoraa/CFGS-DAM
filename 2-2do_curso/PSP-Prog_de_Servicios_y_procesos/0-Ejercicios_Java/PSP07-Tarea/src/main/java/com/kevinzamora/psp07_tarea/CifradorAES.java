/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.kevinzamora.psp07_tarea;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author kzdesigner
 */
/**
 * Clase que maneja las operaciones de cifrado/descifrado usando AES
 */
public class CifradorAES {
    
    private static final String ALGORITMO = "AES";
private static final String TRANSFORMACION = "AES/ECB/PKCS5Padding";
    private static final int TAMANO_CLAVE = 128; // bits
    
    /**
     * Genera una clave AES a partir de un usuario y contraseña
     * @param usuario Nombre de usuario
     * @param password Contraseña
     * @return Clave generada
     */
    
    private static SecretKeySpec generarClave(String usuario, String password) {
    try {
        String semilla = usuario + password;
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] clave = sha.digest(semilla.getBytes(StandardCharsets.UTF_8));
        
        // Solo usamos los primeros 128 bits (16 bytes) para AES
        byte[] claveAES = new byte[16];
        System.arraycopy(clave, 0, claveAES, 0, 16);
        
        return new SecretKeySpec(claveAES, "AES");
    } catch (Exception e) {
        throw new RuntimeException("Error al generar la clave", e);
    }
}
    
    /**
     * Cifra un texto usando AES
     * @param texto Texto a cifrar
     * @param usuario Usuario para generar la clave
     * @param password Password para generar la clave
     * @return Datos cifrados
     */
    public static byte[] cifrar(String texto, String usuario, String password) {
        try {
            SecretKeySpec clave = generarClave(usuario, password);
            Cipher cipher = Cipher.getInstance(TRANSFORMACION);
            cipher.init(Cipher.ENCRYPT_MODE, clave);
            
            return cipher.doFinal(texto.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new RuntimeException("Error al cifrar", e);
        }
    }
    
    /**
     * Descifra datos previamente cifrados
     * @param datos Datos cifrados
     * @param usuario Usuario usado para generar la clave
     * @param password Password usada para generar la clave
     * @return Texto descifrado
     */
    public static String descifrar(byte[] datos, String usuario, String password) {
        try {
            SecretKeySpec clave = generarClave(usuario, password);
            Cipher cipher = Cipher.getInstance(TRANSFORMACION);
            cipher.init(Cipher.DECRYPT_MODE, clave);
            
            return new String(cipher.doFinal(datos), StandardCharsets.UTF_8);
        } catch (Exception e) {
            // throw new RuntimeException("Error al descifrar", e);
            e.printStackTrace(); // Imprime el error original
            throw new RuntimeException("Error al descifrar", e);
        }
    }
    
    /**
     * Guarda datos cifrados en un archivo
     * @param datos Datos cifrados
     * @param rutaArchivo Ruta del archivo
     */
    public static void guardarDatos(byte[] datos, String rutaArchivo) {
        try (FileOutputStream fos = new FileOutputStream(rutaArchivo)) {
            fos.write(datos);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el archivo", e);
        }
    }
    
    /**
     * Lee datos cifrados desde un archivo
     * @param rutaArchivo Ruta del archivo
     * @return Datos leídos
     */
    public static byte[] leerDatos(String rutaArchivo) {
        try (FileInputStream fis = new FileInputStream(rutaArchivo)) {
            byte[] datos = fis.readAllBytes();
            return datos;
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo", e);
        }
    }

    public static void main(String[] args) {
        String usuario = "tu_usuario";
        String password = "tu_contraseña";
        String textoOriginal = "Este es un mensaje secreto";
        
        // Ciframos el texto
        byte[] datosCifrados = cifrar(textoOriginal, usuario, password);
        
        // Guardamos en fichero.cifrado
        guardarDatos(datosCifrados, "fichero.cifrado");
        
        // Leemos y desciframos
        byte[] datosLeidos = leerDatos("fichero.cifrado");
        String textoDescifrado = descifrar(datosLeidos, usuario, password);
        
        System.out.println("Texto original: " + textoOriginal);
        System.out.println("Texto cifrado: " + datosCifrados.toString());
        System.out.println("Texto descifrado: " + textoDescifrado);
    }
}

