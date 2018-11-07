package co.edu.sena.programming.capitulo09;

import javax.imageio.stream.FileImageInputStream;

public class Ejemplo {
    public static void main(String[] args) {

        int a=5;
        int b=0;
            try {
                System.out.println(a / b);

            }catch (ArithmeticException e){
                System.err.println(e.getMessage());
            }
        System.out.println("la division se hizo con exito");

    }
}
