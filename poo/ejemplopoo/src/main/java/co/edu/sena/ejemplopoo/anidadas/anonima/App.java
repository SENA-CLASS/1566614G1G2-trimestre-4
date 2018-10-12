package co.edu.sena.ejemplopoo.anidadas.anonima;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {
        InterfaceCarro carro = new InterfaceCarro() {// clase contenida anomina
            public void frenar() {
                System.out.println("frene");
            }

            public void prender() {
                System.out.println("rummm");
            }

            public void acelerar() {
                System.out.println("rum rum");
            }
        };
        carro.acelerar();
        carro.frenar();
        carro.prender();

        InterfaceCarro carro2 = new InterfaceCarro() {
            public void frenar() {
                System.out.println("frenando");
            }

            public void prender() {
                System.out.println("encendido");
            }

            public void acelerar() {
                System.out.println("aumento la velocidad");
            }
        };


        System.out.println(carro);
        System.out.println(carro2);

        List<Carro> lista = new ArrayList<>();
        lista.add(new Carro("abc-124","mazda"));
        lista.add(new Carro("abc-127","hyundai"));
        lista.add(new Carro("abc-124","chevrolet"));
        lista.add(new Carro("abc-345","mazda"));
        lista.add(new Carro("abc-667","ford"));
        lista.add(new Carro("abc-098","audi"));
        System.out.println(lista.getClass().getCanonicalName());
        Collections.sort(lista, new Comparator<Carro>() {
            public int compare(Carro o1, Carro o2) {
                return o1.getMarca().compareTo(o2.getMarca());
            }
        });

        for (Carro c: lista
        ) {
            System.out.println(c.getMarca());
        }


        List<String> arreglo = new ArrayList<>();
        arreglo.add("pedro");
        arreglo.add("sandra");
        arreglo.add("michael");
        arreglo.add("alejandro");
        arreglo.add("andres");

        Collections.sort(arreglo, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (String k: arreglo) {
            System.out.println(k);
        }




    }
}
