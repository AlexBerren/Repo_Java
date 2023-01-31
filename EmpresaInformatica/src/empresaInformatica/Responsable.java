package empresaInformatica;

public class Responsable extends Informatico {
    private int productividad;

    public Responsable( String nombre, double sueldoBase,  int productividad) {
        super( nombre,  sueldoBase );
        this.productividad = productividad;

    }

    public double calcularSueldo() {
        double sueldoTotal=0;
            sueldoTotal=getSueldoBase()+productividad;
        return sueldoTotal;
    }

    public int getProductividad() {
        return productividad;
    }

    public void setProductividad(int productividad) {
        this.productividad = productividad;
    }
}