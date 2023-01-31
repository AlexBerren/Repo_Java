package figuras;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

//Instanciar y probar objetos de cada clase. 
//Crear un array de figuras del tamaño que desees y guarda en él las figuras creadas.
//Recorrer el array mostrando los datos de cada figura.
//Contar cuántos polígonos y cuántos rectángulos se han creado.

		//crear un array normal
		//Figuras[] figuras=new Figuras[4];
		//figuras[0]=rectangulo1;
		
		//otra forma pero este tipo de array lo tienes que declarar
		//despues de crear los objetos
		//Figuras[]figuras= {circulo1,hexagono1,etc..};
		

		Rectangulo rectangulo1 = new Rectangulo("rojo", 4,7, 5 );
		System.out.println(rectangulo1);
		
		Triangulo triangulo1 = new Triangulo("verde", 3, 10.3, 28.4);
		System.out.println(triangulo1);
		
		Hexagono hexagono1 = new Hexagono("azul", 6, 90.7, 10.2);
		System.out.println(hexagono1);
		
		Circulo circulo1 = new Circulo("rosa", 40.2);
		System.out.println(circulo1);
		
		ArrayList<Figuras> array1 = new ArrayList<Figuras>();
		array1.add(circulo1);
		array1.add(hexagono1);
		array1.add(rectangulo1);
		array1.add(triangulo1);
	
		//instanceof te permite diferenciar entre clases de tipo hijo
		int numPoligonos=0;
		int numRectangulos=0;
		for (Figuras figuras : array1) {
			System.out.println(figuras);
			if (figuras instanceof Poligono) {
				numPoligonos++;
				
			}
			if (figuras instanceof Rectangulo) {
				numRectangulos++;
				
			}
			
		}
		for (Figuras figuras : array1) {
			if (figuras instanceof Circulo) {
				System.out.println(((Circulo) figuras).getRadio());
			}
		}
		System.out.println("poligono: "+numPoligonos+"rectangulos: "+numRectangulos);
	}

}
