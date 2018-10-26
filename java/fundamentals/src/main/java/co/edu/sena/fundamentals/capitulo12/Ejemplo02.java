package co.edu.sena.fundamentals.capitulo12;

public class Ejemplo02 {
    public static void main(String[] args) throws Exception {
        try {
            Clase1 clase1 = new Clase1();
            clase1.metodoClase1();

        }catch (Exception  e){
            System.err.println(e.getMessage());
        }

        System.out.println("adsfasdfasd");

    }
}
