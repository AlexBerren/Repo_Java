package mensajeria;

public class Envio {
	
	private static int incremento=0;
	private int codigo;
	private String fecha;
	private String direccionOrigen;
	private String direccionDestino;
	private TipoEstadoEnvio estado;
	private double precio;
	
	private Mensajero mensajero;
	
	public Envio() {
		incremento++;
		codigo=incremento;
		estado=TipoEstadoEnvio.EN_ESPERA;
	}
	
	public Envio(String fecha, 
			String direccionOrigen,
			String direccionDestino,
			double precio) {
		this();
		this.fecha=fecha;
		this.direccionOrigen=direccionOrigen;
		this.direccionDestino=direccionDestino;
		this.precio=precio;
	}
	
	
	public int getCodigo() {
		return codigo;
	}


	public Mensajero getMensajero() {
		return mensajero;
	}


	public void setMensajero(Mensajero mensajero) {
		this.mensajero = mensajero;
	}


	public double calcularPrecio() {
		return precio;
	}

	public TipoEstadoEnvio getEstado() {
		return estado;
	}

	public void setEstado(TipoEstadoEnvio estado) {
		this.estado = estado;
	}
	
	
	public String toString() {
		
		return "\nCodigo Envio:"+codigo+"\n"+
				"Mensajero:"+mensajero.getNombre()+"\n"+
				"Fecha:"+fecha+"\n"+
				"Origen:"+direccionOrigen+"\n"+
				"Destiono:"+direccionDestino+"\n"+
				"Estado:"+estado+"\n"+
				"Precio:"+precio+"\n";
	}
}
