package co.edu.sena.programming.capitulo09;

import java.util.Random;

public class Main {
    private Random random;

    public Main() {
        random = new Random();
    }

    /**
     * Devuelve un número entero entre 0 y 9.
     */
    public int nextNumber() {
        int i = random.nextInt(20);

        // Si el cálculo del número fuese más complejo incluyendo un assert
        // podemos asegurar en tiempo de desarrollo en esta postcondición
        // el valor generado por este método.
        // La línea de código anterior según el contrato del método debería ser:
        // int i = random.nextInt(10);
        // para que esto siva toca habilitar la maquina virtual con -ea o -enableassertions

        assert i >= 0 && i < 10: String.format("El número devuelto no cumple la postcondición (%d)", i);
        return i;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.nextNumber());
    }
}
