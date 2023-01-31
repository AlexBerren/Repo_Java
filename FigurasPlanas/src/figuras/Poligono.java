package figuras;

public abstract class Poligono extends Figuras {

	protected int numLados;

	public Poligono () {
		this.numLados=0;
	}
	
	public Poligono(String color, int numLados) {
		super(color);
		this.numLados=numLados;
	}
	
	public int getNumLados() {
		return numLados;
	}

	public void setNumLados(int numLados) {
		this.numLados = numLados;
	}
	
//	public String toString() {
//		return super.toString()+numLados;
//	}
//	
}
