package co.edu.sena.programming.capitulo07.colecciones.hashset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ejemplo03 {
    public static void main(String[] args) {
        List<Carro> carroList = new ArrayList<>();
        carroList.add(new Carro("123", "mazda", "blanco"));
        carroList.add(new Carro("124", "mazda", "rojo"));
        carroList.add(new Carro("abc145", "mazda", "negro"));
        carroList.add(new Carro("agr567", "mazda", "azul"));
        carroList.add(new Carro("aet589", "mazda", "blanco con negro"));
        carroList.add(new Carro("atp888", "mazda", "amarillo"));

        for (Carro c:carroList) {
            System.out.println(c.toString());
        }

        System.out.println("----------------------");

        // ordenarmiento por comparator
        Collections.sort(carroList, new Comparator<Carro>() {
            @Override
            public int compare(Carro o1, Carro o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });

        for (Carro c:carroList) {
            System.out.println(c.toString());
        }





    }
}
