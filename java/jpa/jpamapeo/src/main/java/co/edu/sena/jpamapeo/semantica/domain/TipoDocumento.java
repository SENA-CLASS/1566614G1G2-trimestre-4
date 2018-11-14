package co.edu.sena.jpamapeo.semantica.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tipo_documento")
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "documento", length = 50)
    private String documento;
    @Column(name= "descripcion", nullable = false, length = 200)
    private String descripcion;
    @Column(name="estado", nullable = false)
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
