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
public class InstructorHasTrimestrePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "tipo_documento", nullable = false, length = 50)
    private String tipoDocumento;
    @Basic(optional = false)
    @Column(name = "numero_documento", nullable = false, length = 50)
    private String numeroDocumento;
    @Basic(optional = false)
    @Column(name = "ficha", nullable = false, length = 50)
    private String ficha;
    @Basic(optional = false)
    @Column(name = "id_trimestre", nullable = false, length = 20)
    private String idTrimestre;
    @Basic(optional = false)
    @Column(name = "jornada", nullable = false, length = 40)
    private String jornada;
    @Basic(optional = false)
    @Column(name = "tipo_instructor", nullable = false, length = 30)
    private String tipoInstructor;

    public InstructorHasTrimestrePK() {
    }

    public InstructorHasTrimestrePK(String tipoDocumento, String numeroDocumento, String ficha, String idTrimestre, String jornada, String tipoInstructor) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.ficha = ficha;
        this.idTrimestre = idTrimestre;
        this.jornada = jornada;
        this.tipoInstructor = tipoInstructor;
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

    public String getIdTrimestre() {
        return idTrimestre;
    }

    public void setIdTrimestre(String idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getTipoInstructor() {
        return tipoInstructor;
    }

    public void setTipoInstructor(String tipoInstructor) {
        this.tipoInstructor = tipoInstructor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoDocumento != null ? tipoDocumento.hashCode() : 0);
        hash += (numeroDocumento != null ? numeroDocumento.hashCode() : 0);
        hash += (ficha != null ? ficha.hashCode() : 0);
        hash += (idTrimestre != null ? idTrimestre.hashCode() : 0);
        hash += (jornada != null ? jornada.hashCode() : 0);
        hash += (tipoInstructor != null ? tipoInstructor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstructorHasTrimestrePK)) {
            return false;
        }
        InstructorHasTrimestrePK other = (InstructorHasTrimestrePK) object;
        if ((this.tipoDocumento == null && other.tipoDocumento != null) || (this.tipoDocumento != null && !this.tipoDocumento.equals(other.tipoDocumento))) {
            return false;
        }
        if ((this.numeroDocumento == null && other.numeroDocumento != null) || (this.numeroDocumento != null && !this.numeroDocumento.equals(other.numeroDocumento))) {
            return false;
        }
        if ((this.ficha == null && other.ficha != null) || (this.ficha != null && !this.ficha.equals(other.ficha))) {
            return false;
        }
        if ((this.idTrimestre == null && other.idTrimestre != null) || (this.idTrimestre != null && !this.idTrimestre.equals(other.idTrimestre))) {
            return false;
        }
        if ((this.jornada == null && other.jornada != null) || (this.jornada != null && !this.jornada.equals(other.jornada))) {
            return false;
        }
        if ((this.tipoInstructor == null && other.tipoInstructor != null) || (this.tipoInstructor != null && !this.tipoInstructor.equals(other.tipoInstructor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.InstructorHasTrimestrePK[ tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento + ", ficha=" + ficha + ", idTrimestre=" + idTrimestre + ", jornada=" + jornada + ", tipoInstructor=" + tipoInstructor + " ]";
    }
    
}
