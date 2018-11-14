package co.edu.sena.jpamapeo.semantica.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoDocumento {
    @Id
    private String documento;
    private String descripcion;
    private boolean estado;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
