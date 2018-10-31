package co.edu.sena.programming.capitulo05.singleton;

public class App {
    public static void main(String[] args) {
        Producto p = Producto.getIntancia();
        Producto p1 = Producto.getIntancia();
        Producto p2 = Producto.getIntancia();
        Producto p3 = Producto.getIntancia();
        Producto p4 = Producto.getIntancia();
        System.out.println(p);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

    }
}
