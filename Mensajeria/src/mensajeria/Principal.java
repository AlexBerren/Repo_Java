package mensajeria;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mensajeria mensajeria=new Mensajeria();
		Mensajero mensajero1=new Mensajero("Paco Gonzalez",1000);
		mensajeria.altaMensajero(mensajero1);
		
		Mensajero mensajero2=new Mensajero("Luis Gomez",1000);
		mensajeria.altaMensajero(mensajero2);
		
		Mensajero mensajero3=new Mensajero("Juan Garcia",1000);
		mensajeria.altaMensajero(mensajero3);
		
		Carta carta1=new Carta("16-02-2022","Madrid","Murcia",10);
		mensajeria.altaEnvio(carta1);
		Carta carta2=new Carta("18-02-2022","Madrid","Barcelona",20);
		mensajeria.altaEnvio(carta2);
		Carta carta3=new Carta("20-02-2022","Cuenca","Valencia",20);
		mensajeria.altaEnvio(carta3);
		Paquete paquete1=new Paquete("20-02-2022","Cuenca","Valencia",20,5);
		mensajeria.altaEnvio(paquete1);
		Paquete paquete2=new Paquete("22-02-2022","Valladolid","Valencia",10,2);
		mensajeria.altaEnvio(paquete2);
		
		mensajeria.asignarEnvioPorCodigo(carta1.getCodigo());
		mensajeria.asignarEnvioPorCodigo(carta2.getCodigo());
		mensajeria.asignarEnvioPorCodigo(carta3.getCodigo());
		mensajeria.asignarEnvioPorCodigo(paquete1.getCodigo());
		mensajeria.asignarEnvioPorCodigo(paquete2.getCodigo());
		
		System.out.println(mensajeria);
		
		System.out.println("Envios entregados");
		mensajeria.entregaEnvio(1);
		mensajeria.entregaEnvio(5);
		
		System.out.println(mensajeria);

		System.out.println("Borrar envios");
		Envio envioBorrar=mensajeria.obtenerEnvioPorCodigo(1);
		if (envioBorrar!=null)
			mensajeria.bajaEnvio(envioBorrar);
		envioBorrar=mensajeria.obtenerEnvioPorCodigo(2);
		if (envioBorrar!=null)
			mensajeria.bajaEnvio(envioBorrar);
		System.out.println(mensajeria);
		
		System.out.println("Envios en espera");
		paquete2.setEstado(TipoEstadoEnvio.EN_ESPERA);
		ArrayList<Envio> enviosEspera=mensajeria.listaEnviosEnEspera();
		for (Envio e: enviosEspera)
			System.out.println(e);
		
		System.out.println("Baja mensajero");
		mensajeria.bajaMensajero(mensajero1);
		mensajeria.bajaMensajero(mensajero3);
		System.out.println(mensajeria);
		
	}

}
