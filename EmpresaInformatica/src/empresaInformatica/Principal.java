package empresaInformatica;


import java.io.*;
import java.util.*;


public class Principal {

    public static void main(String[] args) throws IOException {


        Empresa empresa = new Empresa();
        Scanner sc = new Scanner(System.in);
        File fichero = new File("EjemploListas.txt");

        if (!fichero.exists()) {
            TreeMap<String, Informatico> listaPersonal = new TreeMap<>();
            LinkedList<Proyecto> listaProyectos = new LinkedList<>();
            listaProyectos.add(new Proyecto("proyecto1", 12, 1000));
            listaProyectos.add(new Proyecto("proyecto2", 3, 1200));
            listaProyectos.add(new Proyecto("proyecto3", 2, 1200));
            listaPersonal.put("PROG1", new Programador("Prog1", 1200));
            listaPersonal.put("PROG2", new Programador("Prog2", 1500));
            listaPersonal.put("PROG3", new Programador("Prog3", 1800));
            listaPersonal.put("RESP1", new Responsable("Resp1", 1800, 500));
            listaPersonal.put("RESP2", new Responsable("Resp2", 800, 700));
            listaPersonal.put("RESP3", new Responsable("Resp3", 2800, 1000));
            empresa.setListaPersonal(listaPersonal);
            empresa.setListaProyectos(listaProyectos);
        } else {
            TreeMap<String, Informatico> listaPersonal = new TreeMap<>();
            LinkedList<Proyecto> listaProyectos = new LinkedList<>();
            empresa.setListaProyectos(listaProyectos);
            empresa.setListaPersonal(listaPersonal);


            BufferedReader br = new BufferedReader(new FileReader(fichero));
            String cad = br.readLine();
            while (cad != null) {
                String[] cadenaCompleta = cad.split(";");

                if (cad.contains("PROG")) {
                    cadenaCompleta[3].replace("\\[","");
                    cadenaCompleta[3].replace("\\]","");
                    String [] contenido=cadenaCompleta[3].split(", ");
                    ArrayList<Proyecto>proyectos= new ArrayList<>();
                    for (int i = 0; i <contenido.length ; i++) {
                        String [] texto;
                       texto=contenido[i].split("-");
                        Proyecto proyecto= new Proyecto(texto[0],Integer.valueOf(texto[1]),Integer.valueOf(texto[2]));
                        proyectos.add(proyecto);

                    }

                    Programador programador = new Programador(cadenaCompleta[1], Double.valueOf(cadenaCompleta[2]));
                    programador.setProyectosAsignados(proyectos);
                    empresa.getListaPersonal().put(programador.getRegistroPersonal(),programador);


                } else if (cad.contains("RESP")) {
                    cadenaCompleta[3].replace("\\[","");
                    cadenaCompleta[3].replace("\\]","");
                    String [] contenido=cadenaCompleta[4].split(", ");
                    ArrayList<Proyecto>proyectos= new ArrayList<>();
                    for (int i = 0; i <contenido.length ; i++) {
                        String [] texto;
                        texto=contenido[i].split("-");
                        Proyecto proyecto= new Proyecto(texto[0],Integer.valueOf(texto[1]),Integer.valueOf(texto[2]));
                        proyectos.add(proyecto);

                    }
                    Responsable responsableDeProyecto = new Responsable((cadenaCompleta[0]), Double.valueOf(cadenaCompleta[2]), Integer.valueOf(cadenaCompleta[1]));
                    responsableDeProyecto.setProyectosAsignados(proyectos);
                    empresa.getListaPersonal().put(responsableDeProyecto.getRegistroPersonal(),responsableDeProyecto);
                } else {
                    Proyecto proyecto = new Proyecto(cadenaCompleta[2], Integer.valueOf(cadenaCompleta[0]), Integer.valueOf(cadenaCompleta[1]));
                    empresa.getListaProyectos().push(proyecto);
                }




                cad = br.readLine();

            }


        }


        int opcion=0;

        while (opcion <= 5) {
            System.out.println("Introduce un numero del 1 al 5");
            opcion=sc.nextInt();
            if (opcion == 1) {
                System.out.println("Introduce si la persona a añadir esa programador(1) o responsable(2)");
                int tipo = sc.nextInt();
                if (tipo == 1) {
                    System.out.println("Dame un nombre");

                    String nombre = sc.next();
                    System.out.println("Dame el sueldo");
                    int sueldo = sc.nextInt();
                    Programador programador = new Programador(nombre, sueldo);
                    empresa.getListaPersonal().put(programador.getRegistroPersonal(), programador);

                } else if (tipo == 2) {
                    System.out.println("Dame un nombre");

                    String nombre = sc.next();
                    System.out.println("Dame el sueldo");
                    int sueldo = sc.nextInt();
                    System.out.println("Dame un numero de productividad");
                    int productividad = sc.nextInt();
                    Responsable responsable = new Responsable(nombre, sueldo, productividad);
                    empresa.getListaPersonal().put(responsable.getRegistroPersonal(), responsable);
                } else {
                    System.out.println("Opcion incorrecta");
                }


            } else if (opcion == 2) {
                System.out.println("Introduce un registro Personal");
                String registroPersonal = sc.next();

                Informatico empleado = empresa.getListaPersonal().get(registroPersonal);
                if (empleado != null) {

                    ArrayList<Proyecto> asignados = new ArrayList<>();

                    for (int i = 0; i < empresa.getListaProyectos().size(); i++) {
                        if((empleado.totalHoras() + empresa.getListaProyectos().get(i).getHoras()) < 1000) {

                            empleado.getProyectosAsignados().add(empresa.getListaProyectos().get(i));

                            asignados.add(empresa.getListaProyectos().get(i));
                        }

                    }
                    for (int i = 0; i < asignados.size(); i++) {
                        empresa.getListaProyectos().remove(asignados.get(i));

                    }

                } else {

                    System.out.println("Introduce otro registro");

                }

            } else if (opcion == 3) {
                for (Map.Entry<String,Informatico>informatico:empresa.getListaPersonal().entrySet()) {
                    if (informatico.getValue() instanceof Responsable) {
                        System.out.println
                                (String.valueOf(informatico.getValue().getSueldoBase())+" "+ informatico.getValue().getProyectosAsignados().toString());

                    }
                }
            } else if (opcion == 4) {

                Collections.sort(empresa.getListaProyectos());
                for (Proyecto proyecto:empresa.getListaProyectos()){
                    System.out.println(proyecto.toString());
                }

            } else if (opcion == 5) {
                BufferedWriter bf = new BufferedWriter(new FileWriter(fichero));
                for (Map.Entry<String, Informatico> informatico : empresa.getListaPersonal().entrySet()) {

                    if (informatico.getValue() instanceof Responsable) {
                        Responsable responsableDeProyecto = (Responsable) informatico.getValue();
                        bf.write(responsableDeProyecto.getNombre() + ";" + responsableDeProyecto.getProductividad() + ";" + responsableDeProyecto.getSueldoBase() + ";" + responsableDeProyecto.getRegistroPersonal()+";"+responsableDeProyecto.getProyectosAsignados());
                        bf.newLine();

                    } else if (informatico.getValue() instanceof Programador) {
                        Programador programador = (Programador) informatico.getValue();
                        bf.write(programador.getRegistroPersonal() + ";" + programador.getNombre() + ";"  + programador.getSueldoBase() + ";" + programador.getProyectosAsignados());
                        bf.newLine();
                    }
                }
                for (Proyecto proyecto : empresa.getListaProyectos()) {
                    bf.write(proyecto.getHoras() + ";" + proyecto.getCoste() + ";" + proyecto.getNombreProyecto());
                    bf.newLine();
                }
                bf.close();


            }
        }
        sc.close();
    }


}


