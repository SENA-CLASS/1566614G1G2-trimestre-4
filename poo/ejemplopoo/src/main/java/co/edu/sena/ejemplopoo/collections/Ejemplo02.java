package co.edu.sena.ejemplopoo.collections;

public class Ejemplo02 {
    public static void main(String[] args) {

        Llavero llavero1 = new Llavero(5);
        llavero1.agregarLlave(new Llave(305));
        llavero1.agregarLlave(new Llave(302));
        llavero1.agregarLlave(new Llave(403));
        llavero1.agregarLlave(new Llave(403));
        llavero1.agregarLlave(new Llave(208));
        llavero1.agregarLlave(new Llave(110));

        llavero1.mostarLLaves();

        llavero1.eliminarPrimerLlave(new Llave(705));
        System.out.println("--------------------");
        llavero1.mostarLLaves();


    }
}
