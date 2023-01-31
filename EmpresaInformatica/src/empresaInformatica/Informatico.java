package empresaInformatica;

import java.util.ArrayList;

import java.util.ArrayList;

public abstract class Informatico implements Aumentar{

    private int numero;
    private String nombre;
    private String registroPersonal;
    private double sueldoBase;
    private ArrayList<Proyecto>proyectosAsignados;
    private static int contador=0;


    public Informatico(String nombre, double sueldoBase) {
        this.numero = contador;
        contador++;
        this.nombre = nombre;
        this.proyectosAsignados=new ArrayList<>();
        this.sueldoBase = sueldoBase;

        if (this instanceof Programador ){
           this.registroPersonal="PROG"+numero;
        }
        if(this instanceof  Responsable){
           this.registroPersonal="RESP"+numero;
        }
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegistroPersonal() {
        return registroPersonal;
    }

    public void setRegistroPersonal(String registroPersonal) {
        this.registroPersonal = registroPersonal;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public ArrayList<Proyecto> getProyectosAsignados() {
        return proyectosAsignados;
    }

    public void setProyectosAsignados(ArrayList<Proyecto> proyectosAsignados) {
        this.proyectosAsignados = proyectosAsignados;
    }

        public abstract double calcularSueldo( );

    @Override
    public String toString() {
        return "Informatico{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", registroPersonal='" + registroPersonal + '\'' +
                ", sueldoBase=" + sueldoBase +
                ", proyectosAsignados=" + proyectosAsignados +
                '}';
    }
    @Override
    public void aumentarSueldo(int valor) {
        this.sueldoBase=sueldoBase+valor;


    }
    public int totalHoras(){
        int totalhoras=0;
        for (int i=0; i<proyectosAsignados.size();i++){

            totalhoras=totalhoras+proyectosAsignados.get(i).getHoras();


        }
        return  totalhoras;
    }
}