package figuras;
import java.math.*;
public class Circulo extends Figuras {

	private double radio;
	
	public Circulo() {
		this.radio=0;
	}
	
	public Circulo(String color, double radio) {
		super(color);
		this.radio=radio;
	}
	

	public double getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio=radio;
	}
	
	public double area() {
		return Math.PI*Math.pow(radio, 2);
	}
	
	public double perimetro() {
		return 2*Math.PI*this.radio;
	}
	
	public String toString () {
		return "Soy una figura de color: "+super.toString()+ ". "+"Además soy una figura y un circulo con 0 lados: Mi área es "+area()+" y mi perímetro es "+perimetro();
	}
	
}
