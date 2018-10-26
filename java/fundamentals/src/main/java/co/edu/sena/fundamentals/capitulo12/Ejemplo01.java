package co.edu.sena.fundamentals.capitulo12;

public class Ejemplo01 {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println(Calculadora.division(4,0));

        }catch (Exception e){
            System.out.println(e.getClass().getCanonicalName());
        }finally {
            System.out.println("continua con el aplicativo");
        }

        System.out.println("paso el error");
    }


}
