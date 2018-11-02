package co.edu.sena.programming.capitulo07.colecciones.hashset;

import java.util.Objects;

public class Ubicacion {
    private String nobmre;
    private String urlFoto;
    private String descripcion;

    public Ubicacion(String nobmre, String urlFoto, String descripcion) {
        this.nobmre = nobmre;
        this.urlFoto = urlFoto;
        this.descripcion = descripcion;
    }

    public String getNobmre() {
        return nobmre;
    }

    public void setNobmre(String nobmre) {
        this.nobmre = nobmre;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ubicacion ubicacion = (Ubicacion) o;
        return Objects.equals(nobmre, ubicacion.nobmre) &&
                Objects.equals(urlFoto, ubicacion.urlFoto) &&
                Objects.equals(descripcion, ubicacion.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nobmre, urlFoto, descripcion);
    }

    @Override
    public String toString() {
        return "Ubicacion{" +
                "nobmre='" + nobmre + '\'' +
                ", urlFoto='" + urlFoto + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
