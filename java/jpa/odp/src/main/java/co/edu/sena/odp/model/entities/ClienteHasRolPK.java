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
public class ClienteHasRolPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "tipo_documento", nullable = false, length = 50)
    private String tipoDocumento;
    @Basic(optional = false)
    @Column(name = "numero_documento", nullable = false, length = 50)
    private String numeroDocumento;
    @Basic(optional = false)
    @Column(name = "rol", nullable = false, length = 40)
    private String rol;

    public ClienteHasRolPK() {
    }

    public ClienteHasRolPK(String tipoDocumento, String numeroDocumento, String rol) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.rol = rol;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoDocumento != null ? tipoDocumento.hashCode() : 0);
        hash += (numeroDocumento != null ? numeroDocumento.hashCode() : 0);
        hash += (rol != null ? rol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteHasRolPK)) {
            return false;
        }
        ClienteHasRolPK other = (ClienteHasRolPK) object;
        if ((this.tipoDocumento == null && other.tipoDocumento != null) || (this.tipoDocumento != null && !this.tipoDocumento.equals(other.tipoDocumento))) {
            return false;
        }
        if ((this.numeroDocumento == null && other.numeroDocumento != null) || (this.numeroDocumento != null && !this.numeroDocumento.equals(other.numeroDocumento))) {
            return false;
        }
        if ((this.rol == null && other.rol != null) || (this.rol != null && !this.rol.equals(other.rol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.ClienteHasRolPK[ tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento + ", rol=" + rol + " ]";
    }
    
}
