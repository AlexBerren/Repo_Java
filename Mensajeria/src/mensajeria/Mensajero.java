package mensajeria;

import java.util.ArrayList;

public class Mensajero {
	
	private static int incremento=0;
	
	private int codigo;
	private String nombre;
	private double sueldo;
	private TipoEstadoMensajero estado;
	private int numMaxEnvios;
	private ArrayList<Envio> envios;

	
	public Mensajero() {
		incremento++;
		codigo=incremento;
		estado=TipoEstadoMensajero.LIBRE;
		numMaxEnvios=3;
		envios=new ArrayList<Envio>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Mensajero(String nombre, double sueldo) {
		this();
		this.nombre=nombre;
		this.sueldo=sueldo;
	}


	public TipoEstadoMensajero getEstado() {
		return estado;
	}

	public void setEstado(TipoEstadoMensajero estado) {
		this.estado = estado;
	}
	
	public void asignarEnvio(Envio envio) {
		envios.add(envio);
	}
	
	public int numEnviosAsignados() {
		return envios.size();
	}

	public int getNumMaxEnvios() {
		return numMaxEnvios;
	}

	public void setNumMaxEnvios(int numMaxEnvios) {
		this.numMaxEnvios = numMaxEnvios;
	}
	
	public void eliminarEnvio(Envio envio) {
		envios.remove(envio);
	}
	
	public String toString() {
		String resultado= "\nCodigo Mensajero:"+codigo+"\n"+
				"Nombre:"+nombre+"\n"+
				"Sueldo:"+sueldo+"\n"+
				"Estado:"+estado+"\n"+
				"Num Max. Envios:"+numMaxEnvios+"\n";
		for(Envio e: envios)
			resultado+=e;
		
		return resultado;
	}
	
	public boolean tieneEnvios() {
		return envios.size()>0?true:false;
	}
	
}
