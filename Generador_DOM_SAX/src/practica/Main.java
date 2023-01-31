package practica;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws Exception{
    	
    	File fichero =Empleados.generarFichero();
    	
    	//Comprobacion escritura empleado
        //ArrayList<Empleados> comprobarArchivo = Empleados.comprobarArchivo(fichero);
        //System.out.println("La lista es:  "+comprobarArchivo);
    	
    	File fichero2 =Empleados.cambiarDatos(fichero);
    	
        //Comprobacion escritura empleado editado
        //ArrayList<Empleados> comprobarArchivo = Empleados.comprobarArchivo(fichero);
        //System.out.println("La lista es:  "+comprobarArchivo);
    	RandomAccessFile ficheroRAF = Empleados.crearRAF(fichero);
    	
    	GenerarXMLConDOM_RAF.crearXML(ficheroRAF);
    	VerXML.verXML();    	

        
		
    }

}
