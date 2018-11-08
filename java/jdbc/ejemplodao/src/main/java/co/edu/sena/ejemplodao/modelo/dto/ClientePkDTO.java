package co.edu.sena.ejemplodao.modelo.dto;

import java.util.Objects;

public class ClientePkDTO {

    private static long serialVersionUID = 43L;
    private String tipoDocumento;
    private String numeroDocumento;

    public ClientePkDTO() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientePkDTO that = (ClientePkDTO) o;
        return Objects.equals(tipoDocumento, that.tipoDocumento) &&
                Objects.equals(numeroDocumento, that.numeroDocumento);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tipoDocumento, numeroDocumento);
    }

    @Override
    public String toString() {
        return "ClientePkDTO{" +
                "tipoDocumento='" + tipoDocumento + '\'' +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                '}';
    }
}
