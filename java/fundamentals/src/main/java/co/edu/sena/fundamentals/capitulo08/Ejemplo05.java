package co.edu.sena.fundamentals.capitulo08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Ejemplo05 {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(1);
        lista.add(1);
        lista.add(1);

        for (Integer i:lista) {
            System.out.println(i);
        }



        List<Celular> celulares = new ArrayList<>();
        celulares.add(new Celular());
        celulares.add(new Celular());
        celulares.add(new Celular());
        celulares.add(new Celular());
        celulares.add(new Celular());
        celulares.add(new Celular());

        for (Celular i: celulares) {
            System.out.println(i);
        }







        ArrayList<Integer> lista2 = new ArrayList<Integer>();// es correcto pero ideal interface en la izq
    }
}
