package empresaInformatica;
import java.util.Collections;

public class Proyecto implements Aumentar , Comparable<Proyecto> {
    private String nombreProyecto;
    private int horas;
    private int coste;


    @Override
    public void aumentarSueldo(int valor) {
        this.coste=coste+valor;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    @Override
    public int compareTo(Proyecto o) {
        int salida = 0;
        if (o.getCoste() == this.coste) {
            if (o.getHoras() == this.horas) {
                salida=0;

            }
            else if(o.getHoras()>this.horas){
                salida=1;

            }
            else if(o.getHoras()<this.horas){
                salida=-1;

            }

        } else if (o.getCoste() > this.coste) {
            salida=1;

        } else {
            salida=-1;

        }
        return salida;
    }

    public Proyecto(String nombreProyecto, int horas, int coste) {
        this.nombreProyecto = nombreProyecto;
        this.horas = horas;
        this.coste = coste;
    }

    @Override
    public String toString() {
        return
                  nombreProyecto + "-"+ horas +"-" + coste ;
    }

	
}