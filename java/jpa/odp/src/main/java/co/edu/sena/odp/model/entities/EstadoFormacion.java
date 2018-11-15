/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.odp.model.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "estado_formacion")
@NamedQueries({
    @NamedQuery(name = "EstadoFormacion.findAll", query = "SELECT e FROM EstadoFormacion e")
    , @NamedQuery(name = "EstadoFormacion.findByIdEstado", query = "SELECT e FROM EstadoFormacion e WHERE e.idEstado = :idEstado")
    , @NamedQuery(name = "EstadoFormacion.findByEstado", query = "SELECT e FROM EstadoFormacion e WHERE e.estado = :estado")})
public class EstadoFormacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_estado", nullable = false, length = 45)
    private String idEstado;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false)
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado", fetch = FetchType.LAZY)
    private Collection<Aprendiz> aprendizCollection;

    public EstadoFormacion() {
    }

    public EstadoFormacion(String idEstado) {
        this.idEstado = idEstado;
    }

    public EstadoFormacion(String idEstado, boolean estado) {
        this.idEstado = idEstado;
        this.estado = estado;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Collection<Aprendiz> getAprendizCollection() {
        return aprendizCollection;
    }

    public void setAprendizCollection(Collection<Aprendiz> aprendizCollection) {
        this.aprendizCollection = aprendizCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoFormacion)) {
            return false;
        }
        EstadoFormacion other = (EstadoFormacion) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.EstadoFormacion[ idEstado=" + idEstado + " ]";
    }
    
}
