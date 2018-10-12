package co.edu.sena.ejemplopoo.anidadas.estaticas.acoplamiento;

public class App {
    public static void main(String[] args) {
        InterfaceClase1 objetoClase1 = new Clase1();
        InterfaceClase2 objetoClase2 = Clase1.getClase2();
        InterfaceClase3 objetoClase3 = Clase1.Clase2.getClase3();
    }
}
