package mensajeria;

public class Paquete extends Envio{

	private double peso;
	
	public Paquete(String fecha, 
			String direccionOrigen,
			String direccionDestino,
			double precio,
			double peso) {
		super(fecha,direccionOrigen, direccionDestino, precio);
		this.peso=peso;
	}
	
	public double calcularPrecio() {
		return peso*super.calcularPrecio();
	}
	
	public String toString() {
		return super.toString()+"Peso:"+peso+"\n";
	}
}
