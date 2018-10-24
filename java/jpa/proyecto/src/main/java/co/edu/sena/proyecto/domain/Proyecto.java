package co.edu.sena.proyecto.domain;

import java.util.Collection;

public class Proyecto extends GenericEntity {
    private String codigo;
    private String nombre;
    private String estado;
    private Collection<Fase> faseCollection;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Collection<Fase> getFaseCollection() {
        return faseCollection;
    }

    public void setFaseCollection(Collection<Fase> faseCollection) {
        this.faseCollection = faseCollection;
    }
}
