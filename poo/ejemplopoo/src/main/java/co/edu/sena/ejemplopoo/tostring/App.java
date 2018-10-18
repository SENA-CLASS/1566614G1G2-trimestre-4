package co.edu.sena.ejemplopoo.tostring;

public class App {
    public static void main(String[] args) {
        Vaca vaca = new Vaca();
        vaca.setColor("blanca");
        vaca.setRaza("cebú");

        System.out.println(vaca.getRaza());
        System.out.println(vaca.getColor());


        System.out.println(vaca.toString());

    }
}
