package co.edu.sena.ejemplopoo.collections;

import java.util.Objects;

public class Llave {
    private int puerta;

    public Llave(int puerta) {
        this.puerta = puerta;
    }

    public int getPuerta() {
        return puerta;
    }

    public void setPuerta(int puerta) {
        this.puerta = puerta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Llave llave = (Llave) o;
        return puerta == llave.puerta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(puerta);
    }
}
