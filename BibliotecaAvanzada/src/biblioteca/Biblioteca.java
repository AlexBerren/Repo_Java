package biblioteca;


import java.util.LinkedList;
import java.util.TreeMap;

public class Biblioteca {
	
	TreeMap<Integer, Libro> todosLosLibros;
	LinkedList<Usuario> usuarios;
	
	public Biblioteca(){
		todosLosLibros = new TreeMap<Integer, Libro>();
		usuarios = new LinkedList<>();
	}
	
	
	public LinkedList<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void addUsuario(Usuario usuario) {
		usuarios.add(usuario);
		
	}
	
	public void removeUsuario(String nombre) {
		
			for (Usuario usuario : usuarios) {
				if (nombre.equalsIgnoreCase(usuario.getNombre())) {
					usuarios.remove(usuario);
					break;
				}else {
				System.out.println("No existe ese Usuario");
			}
			}	
	} 
	
	public void showUsuarios() {
		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
	}
	
	public void showLibros() {
		for (Libro libro : todosLosLibros.values()) {
			System.out.println(libro);
		}
	}
	
	public void addLibro(Libro libro) {
		todosLosLibros.put(libro.getIsbn(), libro);
		
	}
	
	public void removeLibro(int isbn) {
	
		for (Libro libro : todosLosLibros.values()) {
			if (isbn == libro.getIsbn()) {
				todosLosLibros.remove(isbn, libro);
			}else {
			System.out.println("No existe ese Libro");
		}
		}	
		
	} 
	public void devolverelLibro(String titulo, String nombreUsuario) {
		for (Libro libro : todosLosLibros.values()) {
			if (titulo.equalsIgnoreCase(libro.getTitulo())) {
				for (Usuario usuario : usuarios) {
					libro.setUsuarioConElLibro(null);
				}
				break;
			}else {
			System.out.println("No existe ese titulo");
		}
		}
	}
	public void alquilarelLibro(String titulo, String nombreUsuario) {
		for (Libro libro : todosLosLibros.values()) {
			if (titulo.equalsIgnoreCase(libro.getTitulo())) {
				for (Usuario usuario : usuarios) {
					if (nombreUsuario.equalsIgnoreCase(usuario.getNombre())) {
						libro.setUsuarioConElLibro(usuario);
						usuario.addLibroPrestado(libro);
					}
				}
				break;
			}else {
			System.out.println("No existe ese titulo");
		}
		}
	}
	
	public void mostrarPrestamos(String nombreUsuario) {
		
				for (Usuario usuario : usuarios) {
					if (nombreUsuario.equalsIgnoreCase(usuario.getNombre())) {
						System.out.println(usuario.getLibrosPrestados());
					}
				
			}
		
	}
	

	@Override
	public String toString() {
		return "Biblioteca [todosLosLibros=" + todosLosLibros + ",\n usuarios=" + usuarios + "]\n";
	}
		
}
