package ejercicio2;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.RandomAccessFile;
import java.io.IOException;

public class CrearXMLDesdeDAT {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("EMPLEADOS.DAT", "r")) {
            // Preparar el documento XML
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            // Elemento raíz
            Element rootElement = doc.createElement("Empleados");
            doc.appendChild(rootElement);

            while (file.getFilePointer() < file.length()) {
                // Leer datos del fichero
                int codigo = file.readInt();
                String nombre = file.readUTF().trim();
                String direccion = file.readUTF().trim();
                float salario = file.readFloat();
                float comision = file.readFloat();

                // Crear elementos XML
                Element empleado = doc.createElement("Empleado");

                Element cod = doc.createElement("Codigo");
                cod.appendChild(doc.createTextNode(String.valueOf(codigo)));
                empleado.appendChild(cod);

                Element nom = doc.createElement("Nombre");
                nom.appendChild(doc.createTextNode(nombre));
                empleado.appendChild(nom);

                Element dir = doc.createElement("Direccion");
                dir.appendChild(doc.createTextNode(direccion));
                empleado.appendChild(dir);

                Element sal = doc.createElement("Salario");
                sal.appendChild(doc.createTextNode(String.valueOf(salario)));
                empleado.appendChild(sal);

                Element com = doc.createElement("Comision");
                com.appendChild(doc.createTextNode(String.valueOf(comision)));
                empleado.appendChild(com);

                rootElement.appendChild(empleado);
            }

            // Escribir el contenido en un fichero XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("EMPLEADOS.XML");
            transformer.transform(source, result);

            System.out.println("Fichero EMPLEADOS.XML creado con éxito.");
        } catch (IOException | ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
