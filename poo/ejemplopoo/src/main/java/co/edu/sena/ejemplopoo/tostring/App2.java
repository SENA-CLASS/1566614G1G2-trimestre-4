package co.edu.sena.ejemplopoo.tostring;

import java.util.ArrayList;

public class App2 {
    public static void main(String[] args) {
        Sala sala = new Sala();
        sala.setSillas(100);
        sala.setPantalla("4D sony");

        Sala sala2 = new Sala();
        sala2.setSillas(100);
        sala2.setPantalla("4D panasonic");

        Cine cine = new Cine();
        cine.setEmpresa("Cine Colombia");
        cine.setDireccion("avenida siempre viva");
        cine.setId(1);
        cine.setSalaList(new ArrayList<>());// incializar el arreglo lista collection
        cine.getSalaList().add(sala);
        cine.getSalaList().add(sala2);
        sala.setCine(cine);
        sala2.setCine(cine);

        System.out.println(cine);

        System.out.println(cine.getDireccion());
        System.out.println(cine.getId());
        System.out.println(cine.getEmpresa());

        for (Sala salita:cine.getSalaList()
             ) {
            System.out.println(sala.getSillas());
            System.out.println(sala.getPantalla());
        }

    }
}
