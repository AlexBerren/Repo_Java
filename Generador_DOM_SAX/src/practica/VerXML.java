package practica;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class VerXML {
	public static void verXML(){
		try {
			File archivo = new File("Empleados.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document documento = builder.parse(archivo);
			documento.getDocumentElement().normalize();
			System.out.println("Elemento raiz:" + documento.getDocumentElement().getNodeName());
			NodeList contactos = documento.getElementsByTagName("Empleado");
			for (int i = 0; i < contactos.getLength(); i++) {
				Node contacto = contactos.item(i);
				if (contacto.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) contacto;
					System.out.println("Codigo:" + element.getElementsByTagName("Codigo").item(0).getTextContent());
					System.out.println("Nombre:" + element.getElementsByTagName("Nombre").item(0).getTextContent());
					System.out
							.println("Direccion:" + element.getElementsByTagName("Direccion").item(0).getTextContent());
					System.out.println("Salario:" + element.getElementsByTagName("Salario").item(0).getTextContent());
					System.out.println(
							"Comision:" + element.getElementsByTagName("Comision").item(0).getTextContent() + "\n");
				}
			}

		} catch (ParserConfigurationException | SAXException | IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
