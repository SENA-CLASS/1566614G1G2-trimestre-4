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
@Table(name = "tipo_ambiente", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"tipo"})})
@NamedQueries({
    @NamedQuery(name = "TipoAmbiente.findAll", query = "SELECT t FROM TipoAmbiente t"),
    @NamedQuery(name = "TipoAmbiente.findById", query = "SELECT t FROM TipoAmbiente t WHERE t.id = :id"),
    @NamedQuery(name = "TipoAmbiente.findByTipo", query = "SELECT t FROM TipoAmbiente t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "TipoAmbiente.findByDescripcion", query = "SELECT t FROM TipoAmbiente t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoAmbiente.findByEstado", query = "SELECT t FROM TipoAmbiente t WHERE t.estado = :estado")})
public class TipoAmbiente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tipo", nullable = false, length = 40)
    private String tipo;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 40)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoAmbiente", fetch = FetchType.LAZY)
    private Collection<Ambiente> ambienteCollection;

    public TipoAmbiente() {
    }

    public TipoAmbiente(Integer id) {
        this.id = id;
    }

    public TipoAmbiente(Integer id, String tipo, String descripcion, String estado) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Collection<Ambiente> getAmbienteCollection() {
        return ambienteCollection;
    }

    public void setAmbienteCollection(Collection<Ambiente> ambienteCollection) {
        this.ambienteCollection = ambienteCollection;
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
        if (!(object instanceof TipoAmbiente)) {
            return false;
        }
        TipoAmbiente other = (TipoAmbiente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.TipoAmbiente[ id=" + id + " ]";
    }
    
}
