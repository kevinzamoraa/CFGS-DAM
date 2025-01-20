package com.mycompany.correccion;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX extends DefaultHandler {

    boolean esNombre = false;
    boolean esSalario = false;

    public static void main(String[] args) {

        try {
            File archivo = new File("EMPLEADOS.XML");

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            SAX handler = new SAX();
            saxParser.parse(archivo, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println(" ---- EMPLEADOS.XML ----");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Detectar inicio de etiquetas NOMBRE y SALARIO
        if (qName.equalsIgnoreCase("NOMBRE")) {
            esNombre = true;
        } else if (qName.equalsIgnoreCase("SALARIO")) {
            esSalario = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Leer contenido de las etiquetas
        if (esNombre) {
            System.out.print("Nombre: " + new String(ch, start, length));
            esNombre = false;
        } else if (esSalario) {
            System.out.println(", Salario: " + new String(ch, start, length));
            esSalario = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // a ver qué pongo
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("---- Fin del documento ----");
    }

}
