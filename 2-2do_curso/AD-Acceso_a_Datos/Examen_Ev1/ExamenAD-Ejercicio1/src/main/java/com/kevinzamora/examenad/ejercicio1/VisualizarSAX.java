/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kevinzamora.examenad.ejercicio1;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Kevin
 */
public class VisualizarSAX {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean nombre = false;
                boolean salario = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("Nombre")) {
                        nombre = true;
                    }
                    if (qName.equalsIgnoreCase("Salario")) {
                        salario = true;
                    }
                }

                public void characters(char ch[], int start, int length) throws SAXException {
                    if (nombre) {
                        System.out.println("Nombre : " + new String(ch, start, length));
                        nombre = false;
                    }
                    if (salario) {
                        System.out.println("Salario : " + new String(ch, start, length));
                        salario = false;
                    }
                }
            };

            saxParser.parse("EMPLEADOS.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
