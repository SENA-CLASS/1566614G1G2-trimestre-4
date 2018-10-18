package co.edu.sena.ejemplopo.generalizacion.ejemplo01;

public class Deportivo extends Carro {
    @Override
    public void prender() {
        System.out.println("con una llave");
    }

    @Override
    public void apagar() {
        System.out.println("con llave");
    }
}
