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
public class TrimestrePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_trimestre", nullable = false, length = 20)
    private String idTrimestre;
    @Basic(optional = false)
    @Column(name = "jornada_nombre", nullable = false, length = 40)
    private String jornadaNombre;

    public TrimestrePK() {
    }

    public TrimestrePK(String idTrimestre, String jornadaNombre) {
        this.idTrimestre = idTrimestre;
        this.jornadaNombre = jornadaNombre;
    }

    public String getIdTrimestre() {
        return idTrimestre;
    }

    public void setIdTrimestre(String idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    public String getJornadaNombre() {
        return jornadaNombre;
    }

    public void setJornadaNombre(String jornadaNombre) {
        this.jornadaNombre = jornadaNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrimestre != null ? idTrimestre.hashCode() : 0);
        hash += (jornadaNombre != null ? jornadaNombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrimestrePK)) {
            return false;
        }
        TrimestrePK other = (TrimestrePK) object;
        if ((this.idTrimestre == null && other.idTrimestre != null) || (this.idTrimestre != null && !this.idTrimestre.equals(other.idTrimestre))) {
            return false;
        }
        if ((this.jornadaNombre == null && other.jornadaNombre != null) || (this.jornadaNombre != null && !this.jornadaNombre.equals(other.jornadaNombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.TrimestrePK[ idTrimestre=" + idTrimestre + ", jornadaNombre=" + jornadaNombre + " ]";
    }
    
}
