package co.edu.sena.ejemplopoo.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Ejemplo05 {
    public static void main(String[] args) {
        Queue<Integer> cola = new ArrayDeque<>();
        ((ArrayDeque<Integer>) cola).addLast(2);
        ((ArrayDeque<Integer>) cola).addLast(5);
        ((ArrayDeque<Integer>) cola).addLast(6);
        ((ArrayDeque<Integer>) cola).addLast(7);
        ((ArrayDeque<Integer>) cola).addLast(8);

        ((ArrayDeque<Integer>) cola).removeFirst();

        for (Integer i:cola
             ) {
            System.out.println(i);
        }

        ArrayList

    }
}
