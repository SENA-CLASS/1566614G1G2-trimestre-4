package co.edu.sena.programming.capitulo07;

public class MetodoGenerico {
    public static void main(String[] args) {
        Integer []arreglo1 = {1,2,3,4,5,6,7,8,9};

        MetodoGenerico.imprimirArreglo(arreglo1);

        String []arreglo2 = {"asd","gdfg","jgh","ghj","ert","ert",""};
        MetodoGenerico.imprimirArreglo(arreglo2);


        Pair<Integer, String> pair1 = new Pair<>();
        pair1.setKey(1);
        pair1.setValue("pedrito");

        Pair<Integer, String> pair2 = new Pair<>();
        pair2.setKey(2);
        pair2.setValue("juantio");

        System.out.println(MetodoGenerico.compare(pair1,pair2));
    }

    public static <E> void imprimirArreglo(E[] arreglo){
        for (E e : arreglo)
            System.out.print(e + " ");
        System.out.println();
    }

    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }

}
