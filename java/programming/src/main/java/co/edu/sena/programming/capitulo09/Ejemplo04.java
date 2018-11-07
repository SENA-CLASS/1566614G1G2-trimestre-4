package co.edu.sena.programming.capitulo09;

public class Ejemplo04 {
    public static void main(String[] args) {
        try {


            throw new MiException("este es mi nueva exception");
        }catch (MiException e){
            System.out.println(e.getMessage());
        }

    }
}
