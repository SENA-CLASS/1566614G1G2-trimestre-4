package co.edu.sena.programming.capitulo09;

public class Ejemplo03 {
    public static void main(String[] args) {
        int a= 10;
        int b=0;
        try {
            division(a,b);
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }



    }


    public static float division(int a, int b){
        if(b==0){
            throw new ArithmeticException("dividio por cero") ;
        }
        return a/b;
    }
}
