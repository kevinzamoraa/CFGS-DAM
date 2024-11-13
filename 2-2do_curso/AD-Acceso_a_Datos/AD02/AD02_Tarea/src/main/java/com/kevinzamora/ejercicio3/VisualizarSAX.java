package com.kevinzamora.ejercicio3;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class VisualizarSAX {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean titulo = false;
                boolean autor = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("Titulo")) {
                        titulo = true;
                    }
                    if (qName.equalsIgnoreCase("Autor")) {
                        autor = true;
                    }
                }

                public void characters(char ch[], int start, int length) throws SAXException {
                    if (titulo) {
                        System.out.println("Título : " + new String(ch, start, length));
                        titulo = false;
                    }
                    if (autor) {
                        System.out.println("Autor : " + new String(ch, start, length));
                        autor = false;
                    }
                }
            };

            saxParser.parse("libros.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
