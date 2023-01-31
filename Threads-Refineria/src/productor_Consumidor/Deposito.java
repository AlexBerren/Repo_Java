package productor_Consumidor;

public class Deposito {
    private double litrosDep;
    private boolean lleno = false;


    public synchronized double llenarCamion(int n)  {
    	
        while (!lleno) {
        try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
        System.out.println("Camión " + n + " llena: " + litrosDep + " L.");
        lleno = false;
        notify();
        return litrosDep;
    }

    public synchronized void rellenarDeposito(double litros) {
        while (lleno){
            try {
    			wait();
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	  }

          System.out.println("Productor llena con => " + litros + " L.");
    	  litrosDep = litros;
    	  lleno = true;
    	  notify();
    }
}