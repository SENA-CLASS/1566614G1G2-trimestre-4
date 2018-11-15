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
public class RaePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codigo", nullable = false, length = 40)
    private String codigo;
    @Basic(optional = false)
    @Column(name = "competencia_codigo", nullable = false, length = 15)
    private String competenciaCodigo;
    @Basic(optional = false)
    @Column(name = "programa_codigo_version", nullable = false, length = 30)
    private String programaCodigoVersion;

    public RaePK() {
    }

    public RaePK(String codigo, String competenciaCodigo, String programaCodigoVersion) {
        this.codigo = codigo;
        this.competenciaCodigo = competenciaCodigo;
        this.programaCodigoVersion = programaCodigoVersion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCompetenciaCodigo() {
        return competenciaCodigo;
    }

    public void setCompetenciaCodigo(String competenciaCodigo) {
        this.competenciaCodigo = competenciaCodigo;
    }

    public String getProgramaCodigoVersion() {
        return programaCodigoVersion;
    }

    public void setProgramaCodigoVersion(String programaCodigoVersion) {
        this.programaCodigoVersion = programaCodigoVersion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        hash += (competenciaCodigo != null ? competenciaCodigo.hashCode() : 0);
        hash += (programaCodigoVersion != null ? programaCodigoVersion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RaePK)) {
            return false;
        }
        RaePK other = (RaePK) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        if ((this.competenciaCodigo == null && other.competenciaCodigo != null) || (this.competenciaCodigo != null && !this.competenciaCodigo.equals(other.competenciaCodigo))) {
            return false;
        }
        if ((this.programaCodigoVersion == null && other.programaCodigoVersion != null) || (this.programaCodigoVersion != null && !this.programaCodigoVersion.equals(other.programaCodigoVersion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.RaePK[ codigo=" + codigo + ", competenciaCodigo=" + competenciaCodigo + ", programaCodigoVersion=" + programaCodigoVersion + " ]";
    }
    
}
