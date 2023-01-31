package productor_Consumidor;

public class Refineria {
    public static void main(String[] args) {
        Deposito deposito = new Deposito();
        
        Productor llenar = new Productor(deposito);

        Camion c1 = new Camion(deposito, 1);
        Camion c2 = new Camion(deposito, 2);
        Camion c3 = new Camion(deposito, 3);

        llenar.start();
        c1.start();
        c2.start();
        c3.start();
    }
}