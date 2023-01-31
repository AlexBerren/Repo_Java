package practica;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Empleados implements Serializable {

	private static final long serialVersionUID = 1L;
	private static int auxCod = 1;
	private int codemp;
	private String nomemp;
	private String diremp;
	private float salemp;
	private float commemp;

	public Empleados(String nomemp, String diremp, float salemp, float commemp) {
		super();
		this.codemp = auxCod;
		auxCod++;
		this.nomemp = nomemp;
		this.diremp = diremp;
		this.salemp = salemp;
		this.commemp = commemp;
	}

	public int getCodemp() {
		return codemp;
	}

	public void setCodemp(int codemp) {
		this.codemp = codemp;
	}

	public String getNomemp() {
		return nomemp;
	}

	public void setNomemp(String nomemp) {
		this.nomemp = nomemp;
	}

	public String getDiremp() {
		return diremp;
	}

	public void setDiremp(String diremp) {
		this.diremp = diremp;
	}

	public float getSalemp() {
		return salemp;
	}

	public void setSalemp(float salemp) {
		this.salemp = salemp;
	}

	public float getCommemp() {
		return commemp;
	}

	public void setCommemp(float commemp) {
		this.commemp = commemp;
	}



	public static File generarFichero() throws Exception{
		Empleados empleado1 = new Empleados("Juan", "Calle Inventada 1", 11, 111);
		Empleados empleado2 = new Empleados("Tony", "Calle Inventada 2", 22, 222);
		Empleados empleado3 = new Empleados("Adrian", "Calle Inventada 3", 33, 333);
		Empleados empleado4 = new Empleados("Julian", "Calle Inventada 4", 44, 444);
		Empleados empleado5 = new Empleados("Julio", "Calle Inventada 5", 55, 555);

		File fichero = new File("Empleados.dat");
		// System.out.println(fichero.getAbsolutePath());
		
	

		try {

			FileOutputStream fos = new FileOutputStream(fichero);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(empleado1);
			oos.writeObject(empleado2);
			oos.writeObject(empleado3);
			oos.writeObject(empleado4);
			oos.writeObject(empleado5);

			fos.close();
			oos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return fichero;
	}
	
	public static RandomAccessFile crearRAF(File fichero) throws Exception {
		 
		ArrayList<Empleados> listaEmpleados = Empleados.comprobarArchivo(fichero);
			
			

	            RandomAccessFile raf = new RandomAccessFile("FicheroRAF.dat", "rw");
	            
	            for(Empleados e: listaEmpleados){
	                
	                raf.writeInt(e.getCodemp());
	                
	                StringBuffer sb = new StringBuffer(e.getNomemp());
	                sb.setLength(20);
	                
	                raf.writeChars(sb.toString());
	                
	                sb = new StringBuffer(e.getDiremp());
	                sb.setLength(20);
	                
	                raf.writeChars(sb.toString());
	                
	                raf.writeFloat(e.getSalemp());
	                raf.writeFloat(e.getCommemp());
	                
	            }
	            
	            
	            raf.close();
	            
	            return raf;
	}

	public static File cambiarDatos(File fichero) throws Exception {
		FileInputStream fis = new FileInputStream(fichero);
		ObjectInputStream dis = new ObjectInputStream(fis);

		Empleados ayuda;
		ArrayList<Empleados> listaEmpleados = new ArrayList<Empleados>();

		try {
			ayuda = (Empleados) dis.readObject();
			while (true) {
				listaEmpleados.add(ayuda);
				ayuda = (Empleados) dis.readObject();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Se ha impreso de forma correcta.");
		} catch (EOFException e) {
			System.out.println("Se ha impreso de forma correcta.");
		} catch (IOException e) {
			System.out.println("Este es el error.");
		} finally {
			fis.close();
			dis.close();
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Dime el codigo del empleado a modificar");
		int codUsuario = sc.nextInt();
		if (codUsuario < 1 | codUsuario > 5) {
			while (codUsuario < 1 | codUsuario > 5) {
				System.out.println("No existe el empleado, dime un codigo valido");
				codUsuario = sc.nextInt();
			}

		}
		Empleados ayuda2 = null;
		Empleados empleadoAntiguo = null;
		for (Empleados empleados : listaEmpleados) {
			if (codUsuario == empleados.getCodemp()) {
				empleadoAntiguo = empleados;
				System.out.println("Los datos antiguos son : \n" + empleados);

				ayuda2 = empleados;

			}
		}
		listaEmpleados.remove(empleadoAntiguo);
		System.out.println("Dime el nuevo nombre");
		ayuda2.setNomemp(sc.next());
		System.out.println("Dime el nuevo salario");
		ayuda2.setSalemp(sc.nextInt());
		System.out.println("Dime la nueva direccion");
		ayuda2.setDiremp(sc.next());
		System.out.println("Dime la nueva comision");
		ayuda2.setCommemp(sc.nextInt());

		System.out.println("Los datos nuevos son : \n" + ayuda2);

		listaEmpleados.add(ayuda2);
		// System.out.println(listaEmpleados);

		if (fichero.exists()) {
			fichero.delete();
			fichero = new File("Empleados.dat");
		}

		FileOutputStream introducirOtraVez = new FileOutputStream(fichero);
		ObjectOutputStream introducirObjetoOtraVEz = new ObjectOutputStream(introducirOtraVez);

		for (Empleados empleados2 : listaEmpleados) {
			ayuda = empleados2;
			introducirObjetoOtraVEz.writeObject(ayuda);
		}
		introducirObjetoOtraVEz.close();
		introducirOtraVez.close();
		sc.close();
		return fichero;

	}
	public static ArrayList<Empleados> comprobarArchivo(File fichero) throws Exception {
		FileInputStream aaa = new FileInputStream(fichero);
		ObjectInputStream bbb = new ObjectInputStream(aaa);

		Empleados ayuda3;
		ArrayList<Empleados> listaEmpleadosN = new ArrayList<Empleados>();

		try {
			ayuda3 = (Empleados) bbb.readObject();
			while (true) {
				listaEmpleadosN.add(ayuda3);
				ayuda3 = (Empleados) bbb.readObject();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Se ha impreso de forma correcta.");
		} catch (EOFException e) {
			System.out.println("Se ha impreso de forma correcta.");
		} catch (IOException e) {
			System.out.println("Este es el error.");
		} finally {

			aaa.close();
			bbb.close();
		}

		return listaEmpleadosN;

	}
	
	@Override
	public String toString() {
		return "Empleados [codemp=" + codemp + ", nomemp=" + nomemp + ", diremp=" + diremp + ", salemp=" + salemp
				+ ", commemp=" + commemp + "]\n";
	}

}
