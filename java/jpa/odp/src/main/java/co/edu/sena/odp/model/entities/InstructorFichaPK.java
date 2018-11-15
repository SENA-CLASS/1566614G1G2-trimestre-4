/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.odp.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Enrique
 */
@Embeddable
public class InstructorFichaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "tipo_documento", nullable = false, length = 50)
    private String tipoDocumento;
    @Basic(optional = false)
    @Column(name = "numero_documento", nullable = false, length = 50)
    private String numeroDocumento;
    @Basic(optional = false)
    @Column(name = "ficha", nullable = false, length = 50)
    private String ficha;

    public InstructorFichaPK() {
    }

    public InstructorFichaPK(String tipoDocumento, String numeroDocumento, String ficha) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.ficha = ficha;
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

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoDocumento != null ? tipoDocumento.hashCode() : 0);
        hash += (numeroDocumento != null ? numeroDocumento.hashCode() : 0);
        hash += (ficha != null ? ficha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstructorFichaPK)) {
            return false;
        }
        InstructorFichaPK other = (InstructorFichaPK) object;
        if ((this.tipoDocumento == null && other.tipoDocumento != null) || (this.tipoDocumento != null && !this.tipoDocumento.equals(other.tipoDocumento))) {
            return false;
        }
        if ((this.numeroDocumento == null && other.numeroDocumento != null) || (this.numeroDocumento != null && !this.numeroDocumento.equals(other.numeroDocumento))) {
            return false;
        }
        if ((this.ficha == null && other.ficha != null) || (this.ficha != null && !this.ficha.equals(other.ficha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.InstructorFichaPK[ tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento + ", ficha=" + ficha + " ]";
    }
    
}
