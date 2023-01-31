package biblioteca;

public class Libro {
	
	private int isbn;
	private String titulo;
	private String autor;
	private String genero;
	private String portada;
	private String sinopsis;
	private int ejemplares;
	private Usuario usuarioConElLibro;
	private String fechaPrestamo;

	public Libro(int isbn, String titulo, String autor, String genero, String portada, String sinopsis, int ejemplares, String fechaPrestamo) {

		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.portada = portada;
		this.sinopsis = sinopsis;
		this.ejemplares = ejemplares;
		this.usuarioConElLibro =null;
		this.fechaPrestamo= fechaPrestamo;
	}

	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getPortada() {
		return portada;
	}
	public void setPortada(String portada) {
		this.portada = portada;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public int getEjemplares() {
		return ejemplares;
	}
	public void setEjemplares(int ejemplares) {
		this.ejemplares = ejemplares;
	}
	public Usuario getUsuarioConElLibro() {
		return usuarioConElLibro;
	}
	public void setUsuarioConElLibro(Usuario usuarioConElLibro) {
		this.usuarioConElLibro = usuarioConElLibro;
	}
	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", genero=" + genero + ", portada="
				+ portada + ", sinopsis=" + sinopsis + ", ejemplares=" + ejemplares + ", usuarioConElLibro="
				+ usuarioConElLibro + ", fechaPrestamo=" + fechaPrestamo + "]";
	}

	public String getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	
	public void añadirUsuarioAlLibro(Usuario usuario) {
		setUsuarioConElLibro(usuario);
	}
	
}


