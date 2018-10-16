package co.edu.sena.ejemplopoo.equalhashcode;

import java.util.Objects;

public class Esfero {
    private int id;
    private String color;
    private String marca;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Esfero esfero = (Esfero) o;
        return id == esfero.id &&
                Objects.equals(color, esfero.color) &&
                Objects.equals(marca, esfero.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color, marca);
    }
}
