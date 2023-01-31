package biblioteca;

import java.util.LinkedList;

public class Usuario {
	
	private  String dni;
	private String nombre;
	private String mail;
	private int telefono;
	private String Domicilio;
	private LinkedList<Libro> librosPrestados;
	
	public Usuario(String dni, String nombre, String mail, int telefono, String domicilio) {

		this.dni = dni;
		this.nombre = nombre;
		this.mail = mail;
		this.telefono = telefono;
		Domicilio = domicilio;
		this.librosPrestados = new LinkedList<Libro>();
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDomicilio() {
		return Domicilio;
	}
	public void setDomicilio(String domicilio) {
		Domicilio = domicilio;
	}
	public LinkedList<Libro> getLibrosPrestados() {
		return librosPrestados;
	}
	
	public void addLibroPrestado(Libro libro) {
		librosPrestados.add(libro);
	}
	
	public void removeLibroPrestado(Libro libro) {
		librosPrestados.remove(libro);
	} 
	
	public void setLibrosPrestados(LinkedList<Libro> librosPrestados) {
		this.librosPrestados = librosPrestados;
	}
	
	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", nombre=" + nombre + ", mail=" + mail + ", telefono=" + telefono
				+ ", Domicilio=" + Domicilio + "]";
	}
}
