package empresaInformatica;

import java.util.LinkedList;
import java.util.TreeMap;

public class Empresa {
    private TreeMap<String,Informatico>listaPersonal;
    private LinkedList<Proyecto>listaProyectos;

    public TreeMap<String, Informatico> getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(TreeMap<String, Informatico> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    public LinkedList<Proyecto> getListaProyectos() {
        return listaProyectos;
    }

    public void setListaProyectos(LinkedList<Proyecto> listaProyectos) {
        this.listaProyectos = listaProyectos;
    }

    public Empresa() {
        this.listaPersonal = listaPersonal;
        this.listaProyectos = listaProyectos;





    }
}

