package co.edu.sena.programming.capitulo04;

public class App {
    public static void main(String[] args) {
        Clase01 c1 = new Clase01();
        System.out.println(c1.getId());
        Clase02 c2 = new Clase02();
        System.out.println(c2.getId());

        Clase01 c3 =new Clase02();
        System.out.println(c3.getId());


    }
}
