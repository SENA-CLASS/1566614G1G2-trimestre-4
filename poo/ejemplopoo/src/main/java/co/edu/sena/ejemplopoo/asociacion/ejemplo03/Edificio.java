package co.edu.sena.ejemplopoo.asociacion.ejemplo03;

import java.util.Collection;

public class Edificio {
    private Collection<Apartamento> apartamentos;

    public Collection<Apartamento> getApartamentos() {
        return apartamentos;
    }

    public void setApartamentos(Collection<Apartamento> apartamentos) {
        this.apartamentos = apartamentos;
    }
}
