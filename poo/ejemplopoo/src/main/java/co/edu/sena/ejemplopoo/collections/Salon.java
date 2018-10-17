package co.edu.sena.ejemplopoo.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Salon {
    private List<Pupitre> pupitres;
    private int cantidadMaxima;

    public Salon(int cantidadMaxima) {
        this.pupitres = new ArrayList<>();
        this.cantidadMaxima = cantidadMaxima;
    }

    public void agregarPupitre(Pupitre pupitre) {
        if (this.pupitres.size() < this.cantidadMaxima)
            this.pupitres.add(pupitre);
        else
            System.out.println("a este salon no le caben mas pupitres");
    }

    public void eliminarPupitre(Pupitre pupitre){
        this.pupitres.removeIf(p -> p.equals(pupitre));
    }

    public void eliminarPrimerPupitre(Pupitre pupitre) {
        this.pupitres.remove(pupitre);
    }

    public void mostrarPupitres(){
        for (Pupitre p:this.pupitres
             ) {
            System.out.println(p.getNumero());
        }
    }
}
