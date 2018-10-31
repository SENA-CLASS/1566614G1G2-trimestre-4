package co.edu.sena.programming.capitulo05.singleton;

public class Producto {
    private static  Producto intancia = new Producto();

    private Producto() {

    }

    public static Producto getIntancia(){
        return intancia;
    }
}
