package co.edu.sena.fundamentals.capitulo06;

public class Ejemplo01 {
    public static void main(String[] args) {
        String texto = "HOLA";
        System.out.println(texto.toLowerCase());

        String texto2 = " sadfasd ";
        System.out.println(texto2.trim());

        String texto3 = texto2.substring(4);
        System.out.println(texto3);

        String nombre= "hernando enrique moreno moreno";
        System.out.println(nombre.endsWith("re"));

        String[] nombres = nombre.split(" ");

        for (int i = 0; i <nombres.length ; i++) {
            System.out.println(nombres[i]);
        }

    }
}
