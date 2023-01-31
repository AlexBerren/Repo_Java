package formularioLibro;

public class Libro implements Comparable<Libro> {

	private String codigo;
	private String titulo;
	
	
	public Libro(String codigo, String titulo) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public boolean equals(Libro l) {
		if (l==null) {
			return false;
		}else {
			return l.getCodigo().equals(codigo);
		}
	}
	
	public int hashCode() {
		return codigo.hashCode();
	}

	@Override
	public int compareTo(Libro o) {
		return -o.getCodigo().compareTo(codigo);
	}
	
	
	
}
