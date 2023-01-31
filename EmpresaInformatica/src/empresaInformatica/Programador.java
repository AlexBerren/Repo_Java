package empresaInformatica;


public class Programador extends Informatico {
    public Programador( String nombre,  double sueldoBase) {
        super( nombre,  sueldoBase);
    }

    @Override
    public double calcularSueldo( ) {
        return 0;
    }
}