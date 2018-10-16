package co.edu.sena.ejemplopoo.asociacion.ejemplo03;

import java.util.ArrayList;
import java.util.Collection;

public class App {
	public static void main(String[] args) {
        Edificio edificio = new Edificio();
        edificio.setApartamentos((Collection)new ArrayList<>());
        edificio.getApartamentos().add(new Apartamento());
        edificio.getApartamentos().add(new Apartamento());
        edificio.getApartamentos().add(new Apartamento());
        edificio.getApartamentos().add(new Apartamento());
        edificio.getApartamentos().add(new Apartamento());
        edificio.getApartamentos().add(new Apartamento());
        edificio.getApartamentos().add(new Apartamento());
        edificio.getApartamentos().add(new Apartamento());

        for (Apartamento a:edificio.getApartamentos()
             ) {
            System.out.println(a);
        }

    }
}
