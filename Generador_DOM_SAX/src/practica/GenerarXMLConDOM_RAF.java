package practica;

import java.io.File;
import java.io.RandomAccessFile;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class GenerarXMLConDOM_RAF {
	
    public static void crearXML(RandomAccessFile ficheroRAF) throws Exception {

        
        
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            DOMImplementation implementation = builder.getDOMImplementation();
                    
            Document document = implementation.createDocument(null, "Empleados", null);
            
            RandomAccessFile raf = new RandomAccessFile("FicheroRAF.dat", "rw");
            
            while(raf.getFilePointer() < raf.length()){
                
                Element empleadoElement = document.createElement("Empleado");
                
                int codigo = raf.readInt();
                
                Element codigoElement = document.createElement("Codigo");
                Text textCodigo = document.createTextNode(codigo+"");
                codigoElement.appendChild(textCodigo);
                empleadoElement.appendChild(codigoElement);
                
                String nombre = "";
                for (int i = 0; i < 20; i++) {
                    nombre += raf.readChar();
                }
                
                Element nombreElement = document.createElement("Nombre");
                Text textNombre = document.createTextNode(nombre.trim());
                nombreElement.appendChild(textNombre);
                empleadoElement.appendChild(nombreElement);
                
                String direccion = "";
                for (int i = 0; i < 20; i++) {
                    direccion += raf.readChar();
                }
                
                Element direccionElement = document.createElement("Direccion");
                Text textDireccion = document.createTextNode(direccion.trim());
                direccionElement.appendChild(textDireccion);
                empleadoElement.appendChild(direccionElement);
                
                float salario = raf.readFloat();
                
                Element salarioElement = document.createElement("Salario");
                Text textSalario = document.createTextNode(salario+"");
                salarioElement.appendChild(textSalario);
                empleadoElement.appendChild(salarioElement);
                
                float comision = raf.readFloat();
                
                Element comisionElement = document.createElement("Comision");
                Text textComision = document.createTextNode(comision+"");
                comisionElement.appendChild(textComision);
                empleadoElement.appendChild(comisionElement);
                
                document.getDocumentElement().appendChild(empleadoElement);
                
            }
                
            Source source = new DOMSource(document);
            Result result = new StreamResult(new File("Empleados.xml"));
                    
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
                     
        
    }
    
}
