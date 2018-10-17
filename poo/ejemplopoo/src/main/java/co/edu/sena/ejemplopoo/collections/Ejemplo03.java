package co.edu.sena.ejemplopoo.collections;

import java.util.Collections;

public class Ejemplo03 {
    public static void main(String[] args) {
        Salon salon = new Salon(5);
        salon.agregarPupitre(new Pupitre(1));
        salon.agregarPupitre(new Pupitre(2));
        salon.agregarPupitre(new Pupitre(5));
        salon.agregarPupitre(new Pupitre(5));
        salon.agregarPupitre(new Pupitre(7));
        salon.agregarPupitre(new Pupitre(8));
        salon.agregarPupitre(new Pupitre(6));

        salon.mostrarPupitres();

        salon.eliminarPupitre(new Pupitre(5));

        System.out.println("----------------");
        salon.mostrarPupitres();


    }
}
