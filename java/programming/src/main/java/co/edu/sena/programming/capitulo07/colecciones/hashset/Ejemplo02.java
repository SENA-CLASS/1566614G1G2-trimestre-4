package co.edu.sena.programming.capitulo07.colecciones.hashset;

import java.util.HashMap;
import java.util.Map;

public class Ejemplo02 {
    public static void main(String[] args) {
        Map<Coordenada, Ubicacion> ubicaciones = new HashMap<>();
        ubicaciones.put(
                new Coordenada(4.6697728, 740679437.917),
                new Ubicacion("pintura tito pabon","https://lh5.googleusercontent.com/p/AF1QipPz_y11FAx7tKj1YegskcWcnS_J-VmIqmio_arb=w408-h544-k-no","pinturastitopabon.com")

        );
        ubicaciones.put(
                new Coordenada(4.6697, 74067437.917),
                new Ubicacion("pintura tito","https://lh5.googleusercontent.com/p/AF1QipPz_y11FAx7tKj1YegskcWcnS_J-VmIqmio_arb=w408-h544-k-no","pinturastitopabon.com")

        );
        ubicaciones.put(
                new Coordenada(4.6697, 74067.917),
                new Ubicacion("pintura pablo","https://lh5.googleusercontent.com/p/AF1QipPz_y11FAx7tKj1YegskcWcnS_J-VmIqmio_arb=w408-h544-k-no","pinturastitopabon.com")

        );


        for (Coordenada u:ubicaciones.keySet()) {
            System.out.println(u.getLatitud());
            System.out.println(u.getLongitud());
            System.out.println(ubicaciones.get(u).getNobmre());
        }




    }
}
