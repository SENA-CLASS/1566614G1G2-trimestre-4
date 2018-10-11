package co.edu.sena.ejemplopoo.anidadas.noestaticasacoplamiento;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        InterfaceClase1 objetoClase1 = new Clase1();
        InterfaceClase2 objetoClase2 = objetoClase1.getClase2();
        InterfaceClase3 objetoClase3 = objetoClase2.getClase3();



    }
}
