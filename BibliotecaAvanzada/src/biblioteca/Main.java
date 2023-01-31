package biblioteca;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean salir = false;			
		Biblioteca biblioteca= new Biblioteca();
		while(!salir) {

			salir = ejecutar(biblioteca);
		}
		
	}
	
	public static boolean ejecutar(Biblioteca biblioteca) {


	System.out.println("Elija su opcion:\n" +
	        "1. Alta Socio\n" +
	        "2. Baja Socio\n" +
	        "3. Alta Libro\n" +
	        "4. Baja Libro\n" +
	        "5. Prestar libro\n" +
	        "6. Devolver libro\n" +
	        "7. Consultar libros\n"+
	        "8. Consultar usuarios\n" +
	        "9. Consultar prestamos\n" +
	        "10. Mandar a fichero\n" +
	        "0. Salir\n");
	Scanner  sc = new Scanner(System.in);
	int menu = sc.nextInt();
	switch (menu) {
		case 0: 
	        System.out.println("Gracias por venir");
	        return true;
	        
		case 1: 
			Usuario usuario = altaUsuario();
			biblioteca.addUsuario(usuario);
			System.out.println(biblioteca);
			break;		
		
		case 2: 
			String nombre = bajaUsuario();
			biblioteca.removeUsuario(nombre);
			System.out.println(biblioteca);
			break;
			
		case 3: 
			Libro libro = altaLibro();
			biblioteca.addLibro(libro);
			System.out.println(biblioteca);
			break;		
		
		case 4: 
			int isbn = bajaLibro();
			biblioteca.removeLibro(isbn);
			System.out.println(biblioteca);
			break;		
		
		case 5:
			String titulo = nombreLibro();
			String nombreUsuario1 = nombreUsuario();
			biblioteca.alquilarelLibro(titulo , nombreUsuario1);
			System.out.println(biblioteca);
			
					
			break;		
		
		case 6: 
			String titulo1 = nombreLibro();
			String nombreUsuario2 = nombreUsuario();
			biblioteca.devolverelLibro(titulo1, nombreUsuario2);
			System.out.println(biblioteca);
			break;
		
		case 7: 
			biblioteca.showLibros();
			break;	

		case 8: 
			biblioteca.showUsuarios();
			break;		
		
		case 9: 
			
			String nombreUsuario3 = consultaNombreUsuario();
			biblioteca.mostrarPrestamos(nombreUsuario3);
			break;	
			
		case 10:
			
			try {
                DataInputStream dis = new DataInputStream(new FileInputStream("LIBROS.dat"));
            } catch (FileNotFoundException e) {
                System.err.println("No se ha encontrado el archivo VIP.dat");
            }
		
		default:
		
	}
	return false;
	
		}
	
	public static Usuario altaUsuario() {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Vas a dar de alta un Socio. Dime su Nombre");
		String nombreSocio = sc.next();
		
		System.out.println("Dime su dni");
		String dni = sc.next();
		
		System.out.println("Dime su mail");
		String mail = sc.next();
		
		System.out.println("Dime su telefono");
		int telefono = sc.nextInt();
	
		System.out.println("Dime su Domicilio");
		String domicilio = sc.next();
	
		return new Usuario(dni, nombreSocio, mail, telefono, domicilio);
		
	}
	
	public static String bajaUsuario() {
		System.out.println("Vas a dar de baja un Socio. Dime su Nombre");
		Scanner sc = new Scanner(System.in);
		String nombreSocio = sc.next();	
		return nombreSocio;
	}
	
	public static Libro altaLibro() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Vas a dar de alta un Libro. Dime su ISBN");
		int isbn = sc.nextInt();
		
		System.out.println("Dime su Titulo");
		String titulo = sc.next();
		
		System.out.println("Dime su genero");
		String genero = sc.next();
		
		System.out.println("Dime su autor");
		String autor = sc.next();
		
		System.out.println("Dime su portada");
		String portada = sc.next();
	
		System.out.println("Dime su sinopsis");
		String sinopsis = sc.next();
		
		System.out.println("Dime su ejemplares");
		int ejemplares = sc.nextInt();
		
		System.out.println("Dime su fecha de prestamo");
		String  fechaPrestamo = sc.next();
	
		return new Libro(isbn, titulo, autor ,genero, portada, sinopsis, ejemplares, fechaPrestamo);
	}
	
	public static int bajaLibro() {
		System.out.println("Vas a dar de baja un Libro. Dime su ISBN");
		Scanner sc = new Scanner(System.in);
		int nombreSocio = sc.nextInt();	
		return nombreSocio;
	}
	
	public static String nombreLibro() {
		System.out.println("Vas a Alquialr un Libro. Dime su Titulo");
		Scanner sc = new Scanner(System.in);
		String nombreTitulo = sc.nextLine();	
		return nombreTitulo;
		
	}
	
	public static String nombreUsuario() {
		System.out.println("Vas a Alquialr un Libro. Dime tu nombre");
		Scanner sc = new Scanner(System.in);
		String nombreUsuario = sc.nextLine();	
		return nombreUsuario;
		
	}
	
	public static String consultaNombreUsuario() {
		System.out.println("Vas a consultar tus libros alquilados. Dime tu nombre");
		Scanner sc = new Scanner(System.in);
		String nombreUsuario = sc.nextLine();	
		return nombreUsuario;
		
	}
	
}
