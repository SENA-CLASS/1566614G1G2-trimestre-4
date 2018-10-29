package co.edu.sena.programming.capitulo03;

public class Ejemplo01 {
    public static void main(String... args) {
        Perro p = new Perro(1, "firulais");

        Perro p2 = new Perro(p.getId(), "rin tin tin");

        System.out.println(calcular(1, 2, 3, 4, 5, 6, 7));

    }

    public static int calcular(int... a) {
        int suma = 0;
        for (int i = 0; i < a.length; i++) {
            suma += a[i];
        }
        return suma;
    }
}
