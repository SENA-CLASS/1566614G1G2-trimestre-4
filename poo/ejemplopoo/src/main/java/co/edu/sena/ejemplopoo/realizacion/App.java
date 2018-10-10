package co.edu.sena.ejemplopoo.realizacion;

public class App {
    public static void main(String[] args) {
        Ciego ciego = new Persona();
        System.out.println(ciego.getClass().getCanonicalName());
        ciego.caminar();
        ciego.hablar();
        ciego.tantear();
        ciego.escuchar();
        ciego.comer();
        ((Persona) ciego).ver();// este trasforme el ciego en persona

        Sordo sordo = new Persona();
        System.out.println(sordo.getClass().getCanonicalName());
        sordo.caminar();
        sordo.hablar();
        sordo.tantear();
        sordo.ver();
        ((Persona) sordo).escuchar();// ojo este ya no es una ciego es ahora una persona

    }
}
