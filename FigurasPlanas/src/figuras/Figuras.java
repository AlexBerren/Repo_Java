package figuras;

public abstract class Figuras {

	private String color;
	
	public Figuras() {
		this.color="";
	}

	public Figuras(String color) {
		this.color=color;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString () {
		return color;
	}
	
	public abstract double perimetro();
	public abstract double area();
	
}
