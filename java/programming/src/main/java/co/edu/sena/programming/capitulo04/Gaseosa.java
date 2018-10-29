package co.edu.sena.programming.capitulo04;

import java.util.Objects;

public class Gaseosa {
    private String marca;
    private float precio;
    private String sabor;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gaseosa gaseosa = (Gaseosa) o;
        return Float.compare(gaseosa.precio, precio) == 0 &&
                Objects.equals(marca, gaseosa.marca) &&
                Objects.equals(sabor, gaseosa.sabor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, precio, sabor);
    }

    @Override
    public String toString() {
        return "Gaseosa{" +
                "marca='" + marca + '\'' +
                ", precio=" + precio +
                ", sabor='" + sabor + '\'' +
                '}';
    }
}
