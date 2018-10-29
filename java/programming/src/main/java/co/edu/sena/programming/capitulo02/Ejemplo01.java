package co.edu.sena.programming.capitulo02;

public class Ejemplo01 {
    public static void main(String[] args) {
        // PRIMITIVOS
        // enteros
        System.out.println("byte");
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.BYTES+" bytes");
        System.out.println(Byte.SIZE + " bits");

        System.out.println("short");
        System.out.println(Short.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.BYTES+" bytes");
        System.out.println(Short.SIZE + " bits");

        System.out.println("int");
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.BYTES+" bytes");
        System.out.println(Integer.SIZE + " bits");

        System.out.println("long");
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.BYTES+" bytes");
        System.out.println(Long.SIZE + " bits");

        // reales
        System.out.println("float");
        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.BYTES+" bytes");
        System.out.println(Float.SIZE + " bits");

        System.out.println("double");
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.BYTES+" bytes");
        System.out.println(Double.SIZE + " bits");

        // char
        System.out.println("char");
        System.out.println((int)Character.MIN_VALUE);
        System.out.println((int)Character.MAX_VALUE);
        System.out.println(Character.MATH_SYMBOL);
        for (int i = 0; i <(int)Character.MAX_VALUE ; i++) {
            System.out.print((char)i+", ");
            if(i %50 ==0){
                System.out.println();
            }

        }

        //boolean
        System.out.println("boolean");
        System.out.println(Boolean.TRUE);
        System.out.println(Boolean.FALSE);


        boolean a = true;
    }
}
