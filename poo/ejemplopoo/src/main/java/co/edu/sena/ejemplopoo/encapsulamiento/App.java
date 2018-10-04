package co.edu.sena.ejemplopoo.encapsulamiento;

public class App {
    public static void main(String[] args) {
        Computador computador = new Computador();
        computador.setMarca("acer");


        System.out.println(computador.getMarca());
    }
}
