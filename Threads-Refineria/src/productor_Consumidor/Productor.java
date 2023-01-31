package productor_Consumidor;

public class Productor extends Thread {

    private Deposito dep;

    public Productor(Deposito dep){
        this.dep = dep;
    }

    public void run(){
        for(int i = 1; i<=15; i++){
            Double litros = Math.floor(Math.random()*1000);
            dep.rellenarDeposito(litros);
            try {
                sleep(100);
            } catch (InterruptedException e) { 
                
            }
        }
    }
   
}