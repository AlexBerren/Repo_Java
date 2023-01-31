package practica2;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GeneradorDom {
	private Document documentoXML;

	public GeneradorDom() throws Exception {
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factoria.newDocumentBuilder();
		documentoXML = builder.newDocument();
	
		Element contactos = documentoXML.createElement("Contactos");
		documentoXML.appendChild(contactos);
		
		

		// creamos contacto 1
		Element contacto = documentoXML.createElement("Contacto"); // Creamos la etiqueta Contacto
		contactos.appendChild(contacto);// Hacemos contacto hija de contactos
		contacto.setAttribute("DNI", "123456789A");// generamos atributo para contacto

		Element nombre = documentoXML.createElement("Nombre");// creamos elemento nombre
		contacto.appendChild(nombre);// Hacemos nombre hija de contacto
		nombre.appendChild(documentoXML.createTextNode("Alejandro"));// le damos el valor a node

		Element apellido = documentoXML.createElement("Apellido");
		contacto.appendChild(apellido);
		apellido.appendChild(documentoXML.createTextNode("Berrendero"));

		Element fecha = documentoXML.createElement("Fecha");
		contacto.appendChild(fecha);
		fecha.appendChild(documentoXML.createTextNode("12/12/2022"));

		Element poblacion = documentoXML.createElement("Nombre");
		contacto.appendChild(poblacion);
		poblacion.appendChild(documentoXML.createTextNode("C/Inventada 3, Madrid, Suiza"));

		// creamos contacto 2
		contacto = documentoXML.createElement("Contacto");
		contactos.appendChild(contacto);
		contacto.setAttribute("DNI", "987654321Z");

		nombre = documentoXML.createElement("Nombre");
		contacto.appendChild(nombre);
		nombre.appendChild(documentoXML.createTextNode("Alvaro"));

		apellido = documentoXML.createElement("Apellido");
		contacto.appendChild(apellido);
		apellido.appendChild(documentoXML.createTextNode("Herrero"));

		fecha = documentoXML.createElement("Fecha");
		contacto.appendChild(fecha);
		fecha.appendChild(documentoXML.createTextNode("21/12/2022"));

		poblacion = documentoXML.createElement("Nombre");
		contacto.appendChild(poblacion);
		poblacion.appendChild(documentoXML.createTextNode("C/Inventada2 4, Sevilla, Andorra"));
		
		


		// Creamos origen
		Source origen = new DOMSource(documentoXML);

		// creamos destino
		File ruta = new File("./contactos.xml");
		FileWriter fw = new FileWriter(ruta);
		PrintWriter pw = new PrintWriter(fw);
		Result resultado = new StreamResult(pw);

		// generamos XML
		TransformerFactory factoria2 = TransformerFactory.newInstance();
		Transformer trasnformer = factoria2.newTransformer();
		trasnformer.transform(origen, resultado);// nos pide origen y destino
		
		

		
		documentoXML = builder.parse(new File("contactos.xml"));

		NodeList listaContactos = documentoXML.getElementsByTagName("Contacto");

		for (int i = 0; i < listaContactos.getLength(); i++) {
			Node nodo = listaContactos.item(i);
			if (nodo.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) nodo;
				if (e.getNodeName().equals("Contacto")) {
					System.out.println("DNI" + ": " + e.getAttributes().getNamedItem("DNI").getTextContent());}
				NodeList hijos = e.getChildNodes();
				for (int j = 0; j < hijos.getLength(); j++) {
					Node hijo = hijos.item(j);
					if (hijo.getNodeName().equals("Contacto")) {
						System.out.println(e.getNodeName() + ": " + e.getAttributes().getNamedItem("DNI").getTextContent());
					} else if (hijo.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println(hijo.getNodeName() + ": " + hijo.getTextContent());
					}
				}
			}
			System.out.println("\n");
		}

		}
}

