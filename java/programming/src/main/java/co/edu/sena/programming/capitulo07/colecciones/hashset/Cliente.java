package co.edu.sena.programming.capitulo07.colecciones.hashset;

import java.util.Objects;

public class Cliente implements Comparable<Cliente> {
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombre;

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(tipoDocumento, cliente.tipoDocumento) &&
                Objects.equals(numeroDocumento, cliente.numeroDocumento) &&
                Objects.equals(nombre, cliente.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoDocumento, numeroDocumento, nombre);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "tipoDocumento='" + tipoDocumento + '\'' +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public int compareTo(Cliente o) {
        return this.numeroDocumento.compareTo(o.numeroDocumento);
    }
}
