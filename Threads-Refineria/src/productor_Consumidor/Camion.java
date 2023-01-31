package productor_Consumidor;

public class Camion extends Thread {

    private Deposito dep;
    private int n;
    private double litros;
    
    public Camion (Deposito dep, int n){
        this.dep = dep;
        this.n = n;
    }
    
    public void run(){
        double lTotales = 0;
        for(int i = 0; i < 5; i++){
            litros = dep.llenarCamion(n);
            lTotales += litros;
        }
        System.out.println("Camión " + n + " => Volumen Total Recogido = " + lTotales + " Litros" +" Operación carga finalizada");
    }
}

