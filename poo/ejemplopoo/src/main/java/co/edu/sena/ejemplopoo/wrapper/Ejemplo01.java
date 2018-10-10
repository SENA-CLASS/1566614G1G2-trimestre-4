package co.edu.sena.ejemplopoo.wrapper;

public class Ejemplo01 {
    public static void main(String[] args) {


        // primitivos
        //enteros
        byte enteroMuyCorto;
        short enteroCorto;
        int entero;
        long enteroLargo;
        // reales
        float real;
        double realLargo;

        //logico
        boolean logico;

        // caracter
        char caaracter;


        // wrappers
        //enteros
        Byte enterMuyCortoWrapper;
        Short enteroCortoWrapper;
        Integer enteroWrapper;
        Long enteroLargoWrapper;
        //reales
        Float realWrapper;
        Double realLargorapper;
        // logico
        Boolean logicoWrapper;
        //caracter
        Character caracterWrapper;


        String numero = "1232.5565";

        float numero1 = Float.parseFloat(numero);

        System.out.println(numero1);
        System.out.println(Integer.MAX_VALUE);

        int num5 = 10;

        Integer num5Wrapper = (Integer)num5;//Boxing

        int num6 = (int)num5Wrapper; // unboxing

        // java se 7

        Integer num6Wrapper = num6; // autoboxing



    }
}
