package co.edu.sena.fundamentals.capitulo09;

public class Ejemplo01 {
    public static void main(String[] args) {
        int a = 1;
        for (; a <= 10; ) {
            System.out.println(a);
            a++;
        }

        a = 1;
        for (; ; ) {
            System.out.println(a);
            a++;
            if (a == 10)
                break;
        }

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
                continue;
            else
                System.out.println(i);
            System.out.println("no uso el continue");
        }

        int[] arreglo = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int arr : arreglo) {
            System.out.println(arr);
        }


    }
}
