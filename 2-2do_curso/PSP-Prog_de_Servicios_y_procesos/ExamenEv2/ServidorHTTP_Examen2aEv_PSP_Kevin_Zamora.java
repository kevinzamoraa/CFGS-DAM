// Source code is decompiled from a .class file using FernFlower decompiler.
package PaquetePrincipal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class ServidorHTTP { // Definimos la clase de nuestro servidor HTTP
    ServidorHTTP() { } // Creamos un constructor de clase vacio
 
    public static void main(String[] args) throws IOException, Exception { // Definimos el programa principal y 
        // controlamos las posibles excepciones, en este caso la excepción de los datos de entrada y de salida y otra 
        // excepción genérica para controlar el resto de errores posibles
 
       ServerSocket socServidor = new ServerSocket(8066); // Definimos el puerto permitido para recibir peticiones
       imprimeDisponible(); // Imprimimos las diferentes opciones permitidad por pantalla/consola
 
       while(true) { // Creamos un bucle infinito mediante el cual nos notificará cada petición que vaya procesando
          Socket socCliente = socServidor.accept();
          System.out.println("Atendiendo al cliente ");
          procesaPeticion(socCliente);
          socCliente.close();
          System.out.println("cliente atendido");
       }
    }
 
    private static void procesaPeticion(Socket socketCliente) throws IOException { // Creamos el método para 
        // procesar y controlar las diferentes peticiones que reciba nuestro servidor HTTP
        // Definimos el método de entrada
       InputStreamReader inSR = new InputStreamReader(socketCliente.getInputStream()); 
       // Inicializamos el 'buffer' o memoria temporal donde se irán guardando los diferentes datos introducidos 
       // a través de la consola o terminal
       BufferedReader bufLeer = new BufferedReader(inSR);
       // Imprime el texto predefinido
       PrintWriter printWriter = new PrintWriter(socketCliente.getOutputStream(), true);
       // Leemos la petición introducida a través del teclado
       String peticion = bufLeer.readLine();
       // Eliminamos los posibles espacios que pueda contener
       peticion = peticion.replaceAll(" ", "");
       if (peticion.startsWith("GET")) { // Creamos un condicional IF para averiguar de qué clase de 
        // petición se trata y asegurarse de que resulta accesible y está permitida
        // Extraemos la petición introducida, resultando la última parte de la dirección URL completa
          peticion = peticion.substring(3, peticion.lastIndexOf("HTTP"));
          String html;
          if (peticion.length() != 0 && !peticion.equals("/")) {
            // Página de Inscripción
             if (peticion.equals("/inscripcion")) {
                // Construimos la estructura HTML a mostrar
                html = "<html><head><title>Inscripción</title></head><body><h1>" + 
                "Inscripción – En proceso de construcción</h1></body></html>";
                // Cabeceras definidas
                printWriter.println("HTTP/1.1 200 OK"); // Linea de estado
                printWriter.println("Content-Type:text/html;charset=UTF-8"); // Tipo de contenido
                printWriter.println("Content-Length: " + html.length() + "1"); // Longitud del contenido
                printWriter.println("\n");
                // Imprimimos la página HTML por pantalla
                printWriter.println(html);
             } else { // Página de error cuando no se puede procesar la petición introducida
                // Construimos la estructura HTML a mostrar
                html = "<html><head><title>noEncontrado</title></head><body>"
                + "<h1>¡ERROR! Página no encontrada</h1>" 
                + "<p>Mensaje de error: La página que solicitaste no existe en nuestro servidor</p></body></html>";
                // Cabeceras definidas
                printWriter.println("HTTP/1.1 404 Not Found"); // Linea de estado
                printWriter.println("Content-Type:text/html;charset=UTF-8"); // Tipo de contenido
                printWriter.println("Content-Length: " + html.length() + "1"); // Longitud del contenido
                printWriter.println("\n");
                // Imprimimos la página HTML por pantalla
                printWriter.println(html);
             }
          } else {
             // Página principal
             html = "<html><head><title>Inicio</title></head><body><h1>¡Bienvenido!</h1>"
             + "<p>Bienvenido a mi web</p></body></html>";
             // Cabeceras definidas
             printWriter.println("HTTP/1.1 200 OK"); // Linea de estado
             printWriter.println("Content-Type:text/html;charset=UTF-8"); // Tipo de contenido
             printWriter.println("Content-Length: " + html.length() + "1"); // Longitud del contenido
             printWriter.println("\n");
             // Imprimimos la página HTML por pantalla
             printWriter.println(html);
          }
       }
 
    }
 
    private static void imprimeDisponible() {
       System.out.println("El Servidor WEB se está ejecutando y permanece a la escucha por el puerto 8066.\n"
       + "Escribe en la barra de direcciones de tu explorador preferido:\n\n"
       + "http://localhost:8066\n para solicitar la página de bienvenida\n\n"
       + "http://localhost:8066/inscripcion\n para solicitar una página de Inscripción,\n\n"
       + "http://localhost:8066/q\n para simular un error");
    }
 }
 