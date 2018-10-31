package co.edu.sena.programming.capitulo05.enumeration;

public class Ejemplo01 {
    public static void main(String[] args) {
        Computador c = new Computador();
        c.setEstado(EstadosComputador.PRENDIDO);
        System.out.println(c.getEstado());


        c.setEstado2(10);
    }
}
