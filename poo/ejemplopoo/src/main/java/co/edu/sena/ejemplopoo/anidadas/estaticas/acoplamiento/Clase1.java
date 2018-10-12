package co.edu.sena.ejemplopoo.anidadas.estaticas.acoplamiento;

public class Clase1 implements InterfaceClase1 {

    public static InterfaceClase2 getClase2() {
        return new Clase1.Clase2();
    }

    public static class Clase2 implements InterfaceClase2{

        public static InterfaceClase3 getClase3() {
            return new Clase2.Clase3();
        }

        public static class Clase3 implements InterfaceClase3{

        }
    }
}
