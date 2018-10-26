package co.edu.sena.fundamentals.capitulo10;

import java.util.Collections;

public class Ejemplo01 {

    public static final int CONSTANTE =5;

    public static void main(String[] args) {

        Ejemplo01.suma(3,6);

        System.out.println(CONSTANTE);

        double pi = Math.PI;
        


    }


    public static int suma(int a, int b){
        return a+b;
    }

    public static int suma(int a, int b, int c){
        return a+b+c;
    }

    public static int suma(int a, int c, float t){
        return a+(int)t+c;
    }
}
