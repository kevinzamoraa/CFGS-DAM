
package com.mycompany.correccion;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX extends DefaultHandler{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try {
            File archivo = new File("LIBROS.XML");
            
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
        System.out.println(" ---- LIBROS.XML ----");
    }
    
    
@Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (!"bib".equals(qName)){
            System.out.println(qName+" " + localName.toUpperCase());
        }
        if (attributes.getLength() > 0) {
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println(attributes.getQName(i) + ": " + attributes.getValue(i));
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contenido = new String(ch, start, length).trim();
        if (!contenido.isEmpty()) {
            System.out.println("  "+contenido);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("precio".equals(qName)){
            System.out.println("");
        }
    }
    
}
