package co.edu.sena.ejemplopoo.anidadas.noestaticas;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Clase1 objetoClase1 = new Clase1();
        Clase1.Clase2 objetoClase2 = objetoClase1.new Clase2();
        Clase1.Clase2.Clase3 objetoClase3 = objetoClase2.new Clase3();

        System.out.println(objetoClase1);
        System.out.println(objetoClase2);
        System.out.println(objetoClase3);
    }
}
