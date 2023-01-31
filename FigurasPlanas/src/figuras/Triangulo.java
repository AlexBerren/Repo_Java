package figuras;

public class Triangulo extends Poligono {

	private double base;
	private double altura;
	
	public Triangulo() {
		this.base=0;
		this.altura=0;
	}
	
	public Triangulo(String color, int numLados, double base, double altura) {
		super(color, numLados);
		this.base=base;
		this.altura=altura;
	}
	
	public double area() {
		return this.base*this.altura/2;
	}
	
	public double perimetro () {
		return base*3;
	}
	
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String toString() {
		return "Soy una figura de color: "+super.toString()+ ". "+"Además soy un polígono y un tringulo con 3 lados: Mi área es "+area()+" y mi perímetro es "+perimetro();
	}
	
	
	
}
