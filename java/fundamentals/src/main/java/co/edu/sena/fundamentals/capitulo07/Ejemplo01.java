package co.edu.sena.fundamentals.capitulo07;

public class Ejemplo01 {
    public static void main(String[] args) {
        String texto = "hola";
        System.out.println(texto.equals("mama"));

        String hello1 = "hello";
        String hello12 = ("hello");
        String hello3 = new String("hello");

        System.out.println(hello1.equals(hello12) || hello1.equals(hello3));


        boolean a = true;
        boolean b = false;
        System.out.println("tabla de lal verdad del xor");
        System.out.println(a+ "^"+a+"="+(a ^ a));
        System.out.println(a+ "^"+b+"="+(a ^ b));
        System.out.println(b+ "^"+a+"="+(b ^ a));
        System.out.println(b+ "^"+b+"="+(b ^ b));

        // ternario
        System.out.println(a == b ? "son giuales": "no son iguales");

        if(a==b){
            System.out.println("son iguales");
        }else{
            System.out.println("no son iguales");
        }

        if(true){

        }else if(true){

        }

        if(true){

        }else{
            if(true){

            }
        }

        // switch
        String opcion ="HOLA";
        switch (opcion){
            case "HOLA":
            case "hola":
                System.out.println("escribió hola");
                break;
            case "mama":
            case "MAMA":
                System.out.println("escribió mama");
                break;
                default:
                    System.out.println("no reconozco esta palabra");
        }

    }
}
