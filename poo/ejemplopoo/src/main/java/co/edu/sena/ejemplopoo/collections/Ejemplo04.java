package co.edu.sena.ejemplopoo.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Ejemplo04 {
    public static void main(String[] args) {
        // ejemplo de pila
        Stack<Integer> pila = new Stack<>();
        pila.push(100);
        pila.push(1000);
        pila.push(500);
        pila.push(500);
        pila.push(50);
        pila.push(50);

        pila.pop();
        pila.pop();
        for (Integer i:pila
             ) {
            System.out.println(i);
        }

        System.out.println("el elemento que esta en el top: "+pila.peek());



    }
}
