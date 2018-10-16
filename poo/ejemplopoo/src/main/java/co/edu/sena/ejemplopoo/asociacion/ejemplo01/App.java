package co.edu.sena.ejemplopoo.asociacion.ejemplo01;

public class App {
    public static void main(String[] args) {
        Caballo caballo = new Caballo(new Cerebro(), new Corazon());// composición
        System.out.println(caballo);
        System.out.println(caballo.getCerebro());
        System.out.println(caballo.getCorazon());
        System.out.println(caballo.getSilla());
        Silla silla = new Silla();
        caballo.setSilla(silla);
        System.out.println(caballo.getSilla());
        caballo.getCerebro().setCaballo(caballo);
        System.out.println(caballo.getCerebro().getCaballo());


    }
}
