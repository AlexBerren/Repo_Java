package figuras;

public class Hexagono extends Poligono {

	private double lado;
	private double apotema;
	
	public Hexagono () {
		this.lado=0;
		this.apotema=0;
	}
	
	public Hexagono(String color, int numLados, double lado, double apotema) {
		super(color, numLados);
		this.lado=lado;
		this.apotema=apotema;
	}
	
	public double perimetro () {
		return this.lado*6;
	}
	
	public double area() {
		return perimetro()*this.apotema/2;
	}
	
	public double getLado() {
		return lado;
	}
	public void setLado(double lado) {
		this.lado = lado;
	}
	public double getApotema() {
		return apotema;
	}
	public void setApotema(double apotema) {
		this.apotema = apotema;
	}

	public String toString() {
		return "Soy una figura de color: "+super.toString()+ ". "+"Además soy un polígono y un hexagono con 6 lados: Mi área es "+area()+"y mi perímetro es "+perimetro();
	}
	
	
	
}
