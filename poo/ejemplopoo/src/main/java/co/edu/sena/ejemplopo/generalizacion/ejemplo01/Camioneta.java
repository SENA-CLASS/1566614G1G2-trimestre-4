package co.edu.sena.ejemplopo.generalizacion.ejemplo01;

public class Camioneta extends Carro {
    @Override
    public void prender() {
        System.out.println("prende con un boton");
    }

    @Override
    public void apagar() {
        System.out.println("apagar con un boton");
    }
}
