package com.mycompany.correccion;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOM {

    public static void leerXMLDOM(String Fichero) throws Exception {

        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("EMPLEADOS.xml");

            // Normalizar el documento
            document.getDocumentElement().normalize();

            // Obtener todos los elementos "Empleado"
            NodeList listaEmpleados = document.getElementsByTagName("Empleado");

            // Recorrer la lista de empleados
            for (int i = 0; i < listaEmpleados.getLength(); i++) {
                Node nodo = listaEmpleados.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;

                    // Obtener nombre y salario
                    String nombre = elemento.getElementsByTagName("NOMBRE").item(0).getTextContent();
                    String salario = elemento.getElementsByTagName("SALARIO").item(0).getTextContent();

                    // Mostrar información
                    System.out.println("Nombre: " + nombre + ", Salario: " + salario);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n------------ FIN LEER DOM --------------");

    }

    public static void main(String[] args) {

        try {

            leerXMLDOM("EMPLEADOS.xml"); // Lee en DOM

        } catch (Exception LEERDOMe) {

            System.out.println(LEERDOMe);

        }

    }

}
