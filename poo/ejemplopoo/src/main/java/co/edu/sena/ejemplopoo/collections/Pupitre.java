package co.edu.sena.ejemplopoo.collections;

import java.util.Objects;

public class Pupitre {
    private int numero;

    public Pupitre(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pupitre pupitres = (Pupitre) o;
        return numero == pupitres.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}
