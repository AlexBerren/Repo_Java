package mensajeria;

import java.util.ArrayList;

public class Mensajeria {
	
	private ArrayList<Envio> envios;
	private ArrayList<Mensajero> mensajeros;
	
	public Mensajeria() {
		envios=new ArrayList<Envio>();
		mensajeros=new ArrayList<Mensajero>();
	}

	public void altaMensajero(Mensajero mensajero) {
		mensajeros.add(mensajero);
	}
	
	public void bajaMensajero(Mensajero mensajero) {
		if (!mensajero.tieneEnvios()) {
			mensajeros.remove(mensajero);
		}
	}
	
	public void altaEnvio(Envio envio) {
		envios.add(envio);
	}
	
	public void asignarEnvio(Envio envio) {
		for (Mensajero mensajero: mensajeros) {
			if (mensajero.getEstado()==TipoEstadoMensajero.LIBRE) {				
				mensajero.asignarEnvio(envio);
				envio.setEstado(TipoEstadoEnvio.ASIGNADO);
				if (mensajero.numEnviosAsignados()==mensajero.getNumMaxEnvios()) {
					mensajero.setEstado(TipoEstadoMensajero.OCUPADO);
				}
				envio.setMensajero(mensajero);
				break;
			}
		}
	}
	
	public Envio obtenerEnvioPorCodigo(int codigo) {
		Envio envio=null;
		for (Envio e: envios)
			if (e.getCodigo()==codigo) {
				envio=e;
				break;
			}			
		return envio;
		
	}
	
	public void asignarEnvioPorCodigo(int codigo) {
		Envio e=obtenerEnvioPorCodigo(codigo);
		asignarEnvio(e);
	}
	
	/**
	 * precondicion: El estado de la envio sea entregado
	 * @param codigo
	 */
	public void entregaEnvio(int codigo) {
		Envio envio=obtenerEnvioPorCodigo(codigo);
		if (envio!=null) {
			envio.setEstado(TipoEstadoEnvio.ENTREGADO);
		}
		Mensajero mensajero=envio.getMensajero();
		mensajero.eliminarEnvio(envio);
		if (mensajero.getEstado()==TipoEstadoMensajero.OCUPADO) {
			mensajero.setEstado(TipoEstadoMensajero.LIBRE);
		}
			
		
	}
	
	/**
	 * Precondicion: El estado es EnEspera o TERMINADO
	 * @param envio
	 */
	public void bajaEnvio(Envio envio) {
		if (envio.getEstado()==TipoEstadoEnvio.ENTREGADO)
			envios.remove(envio);
	}
	
	public ArrayList<Envio> listaEnviosEnEspera() {
		ArrayList<Envio> enviosEnEspera=new ArrayList<Envio>();
		
		for (Envio e: envios) {
			if (e.getEstado()==TipoEstadoEnvio.EN_ESPERA) {
				enviosEnEspera.add(e);
			}
		}
		return enviosEnEspera;
	}
	
	public String toString() {
		String resultado;
		resultado="\tEnvios\n";
		for(Envio e: envios)
			resultado+=e;
		resultado+="\tMensajero\n";
		for (Mensajero m: mensajeros)
			resultado+=m;
		
		return resultado;
	}
	
}
