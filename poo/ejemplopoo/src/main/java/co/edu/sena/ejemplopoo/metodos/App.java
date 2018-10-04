package co.edu.sena.ejemplopoo.metodos;

public class App {
    public static void main(String[] args) {
        Tanque tanque1 = new Tanque("verde",4);
        tanque1.disparar();
        tanque1.cargar(2);
        tanque1.disparar();
        tanque1.disparar();
        tanque1.disparar();

        System.out.println(tanque1.getCantidadBalas());
        tanque1.cargar(10);
        tanque1.disparar();
        tanque1.disparar();
        tanque1.disparar();
        tanque1.disparar();
        tanque1.disparar();
        System.out.println(tanque1.getCantidadBalas());

        tanque1.disparar();


        float a = 345235423777F;

    }
}
