package co.edu.sena.programming.capitulo05.enumation2;

public class Aprendiz {
    private String tipoDocumento;
    private String numeroDocumeto;
    private EstadoAprendiz estado;

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumeto() {
        return numeroDocumeto;
    }

    public void setNumeroDocumeto(String numeroDocumeto) {
        this.numeroDocumeto = numeroDocumeto;
    }

    public EstadoAprendiz getEstado() {
        return estado;
    }

    public void setEstado(EstadoAprendiz estado) {
        this.estado = estado;
    }
}
