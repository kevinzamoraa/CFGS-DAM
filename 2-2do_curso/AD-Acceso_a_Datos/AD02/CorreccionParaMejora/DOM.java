
package com.mycompany.correccion;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class DOM {

    public static void leerXMLDOM(String Fichero) throws Exception {

        File inputFile = new File(Fichero);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("libro");
        System.out.println("\n----------- COMIENZO LEER DOM --------------");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nElemento: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Año : "
                        + eElement.getAttribute("año"));

                for (int autNub = 0; autNub < eElement.getElementsByTagName("autor").getLength(); autNub++) { // Puede
                                                                                                              // haber
                                                                                                              // más de
                                                                                                              // 1
                                                                                                              // autor.

                    String autorApellido = eElement.getElementsByTagName("apellido").item(autNub).getTextContent();
                    String autorNombre = eElement.getElementsByTagName("nombre").item(autNub).getTextContent();
                    System.out.println("Autor : " + autorApellido + " , " + autorNombre);

                }

                System.out.println("Titulo : "
                        + eElement
                                .getElementsByTagName("titulo")
                                .item(0)
                                .getTextContent());
                System.out.println("Editorial : "
                        + eElement
                                .getElementsByTagName("editorial")
                                .item(0)
                                .getTextContent());
                System.out.println("Precio : "
                        + eElement
                                .getElementsByTagName("precio")
                                .item(0)
                                .getTextContent());
            }
        }

        System.out.println("\n------------ FIN LEER DOM --------------");

    }
    
    
    
    public static void main(String[] args) {
        
        try {

            leerXMLDOM("libros.xml"); // Lee en DOM

        } catch (Exception LEERDOMe) {

            System.out.println(LEERDOMe);

        }
        
    }
    
}
