package co.edu.sena.programming.capitulo07.colecciones.hashset;

import java.util.*;

public class Ejemplo01 {
    public static void main(String[] args) {
        Cliente c2 = new Cliente();
        c2.setTipoDocumento("CC");
        c2.setNumeroDocumento("123");
        c2.setNombre("pedro");

        Cliente c3 = new Cliente();
        c3.setTipoDocumento("CC");
        c3.setNumeroDocumento("127");
        c3.setNombre("juena");

        Set<Cliente> conjunto = new HashSet<>();
        conjunto.add(c2);
        conjunto.add(c3);
        conjunto.add(c3);
        conjunto.add(c3);
        conjunto.add(c3);

        for (Cliente c:conjunto) {
            System.out.println(c.toString());
        }

        System.out.println("--------------------------");

        Set<Cliente> conjunto2 = new TreeSet<>();
        conjunto2.add(c2);
        conjunto2.add(c3);
        conjunto2.add(c3);
        conjunto2.add(c3);
        conjunto2.add(c3);

        for (Cliente c:conjunto2) {
            System.out.println(c.toString());
        }

        System.out.println("ArrayLIst");

        List<Cliente> lista = new ArrayList<>();
        lista.add(c2);
        lista.add(c3);
        lista.add(c3);
        lista.add(c3);
        lista.add(c3);

        for (Cliente c:lista) {
            System.out.println(c);
        }
        System.out.println("----------------------");

        Queue<Cliente> cola = new ArrayDeque<>();
        ((ArrayDeque<Cliente>) cola).push(c2);
        ((ArrayDeque<Cliente>) cola).push(c3);
        ((ArrayDeque<Cliente>) cola).push(c3);
        ((ArrayDeque<Cliente>) cola).push(c3);
        ((ArrayDeque<Cliente>) cola).removeLast();

        for (Cliente c: cola) {
            System.out.println(c.toString());
        }






    }
}
