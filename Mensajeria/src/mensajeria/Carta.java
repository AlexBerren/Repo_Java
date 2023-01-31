package mensajeria;

public class Carta extends Envio{

	public Carta(String fecha, 
			String direccionOrigen,
			String direccionDestino,
			double precio) {
		
		super(fecha,direccionOrigen, direccionDestino, precio);
	}
	
	
	public double calcularPrecio() {
		return super.calcularPrecio();
	}
	
	
}
