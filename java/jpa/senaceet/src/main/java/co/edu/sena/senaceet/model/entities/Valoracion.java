/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.senaceet.model.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "valoracion", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"tipo_valoracion"})})
@NamedQueries({
    @NamedQuery(name = "Valoracion.findAll", query = "SELECT v FROM Valoracion v"),
    @NamedQuery(name = "Valoracion.findById", query = "SELECT v FROM Valoracion v WHERE v.id = :id"),
    @NamedQuery(name = "Valoracion.findByTipoValoracion", query = "SELECT v FROM Valoracion v WHERE v.tipoValoracion = :tipoValoracion"),
    @NamedQuery(name = "Valoracion.findByEstado", query = "SELECT v FROM Valoracion v WHERE v.estado = :estado")})
public class Valoracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tipo_valoracion", nullable = false, length = 50)
    private String tipoValoracion;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 40)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idValoracion", fetch = FetchType.LAZY)
    private Collection<RespuestaGrupo> respuestaGrupoCollection;

    public Valoracion() {
    }

    public Valoracion(Integer id) {
        this.id = id;
    }

    public Valoracion(Integer id, String tipoValoracion, String estado) {
        this.id = id;
        this.tipoValoracion = tipoValoracion;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoValoracion() {
        return tipoValoracion;
    }

    public void setTipoValoracion(String tipoValoracion) {
        this.tipoValoracion = tipoValoracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Collection<RespuestaGrupo> getRespuestaGrupoCollection() {
        return respuestaGrupoCollection;
    }

    public void setRespuestaGrupoCollection(Collection<RespuestaGrupo> respuestaGrupoCollection) {
        this.respuestaGrupoCollection = respuestaGrupoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valoracion)) {
            return false;
        }
        Valoracion other = (Valoracion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.Valoracion[ id=" + id + " ]";
    }
    
}
