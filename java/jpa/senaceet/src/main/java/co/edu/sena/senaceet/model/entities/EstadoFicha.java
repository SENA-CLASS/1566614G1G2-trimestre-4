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
@Table(name = "estado_ficha", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre_estado"})})
@NamedQueries({
    @NamedQuery(name = "EstadoFicha.findAll", query = "SELECT e FROM EstadoFicha e"),
    @NamedQuery(name = "EstadoFicha.findById", query = "SELECT e FROM EstadoFicha e WHERE e.id = :id"),
    @NamedQuery(name = "EstadoFicha.findByNombreEstado", query = "SELECT e FROM EstadoFicha e WHERE e.nombreEstado = :nombreEstado"),
    @NamedQuery(name = "EstadoFicha.findByEstado", query = "SELECT e FROM EstadoFicha e WHERE e.estado = :estado")})
public class EstadoFicha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre_estado", nullable = false)
    private int nombreEstado;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false)
    private short estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoFicha", fetch = FetchType.LAZY)
    private Collection<Ficha> fichaCollection;

    public EstadoFicha() {
    }

    public EstadoFicha(Integer id) {
        this.id = id;
    }

    public EstadoFicha(Integer id, int nombreEstado, short estado) {
        this.id = id;
        this.nombreEstado = nombreEstado;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(int nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public Collection<Ficha> getFichaCollection() {
        return fichaCollection;
    }

    public void setFichaCollection(Collection<Ficha> fichaCollection) {
        this.fichaCollection = fichaCollection;
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
        if (!(object instanceof EstadoFicha)) {
            return false;
        }
        EstadoFicha other = (EstadoFicha) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.EstadoFicha[ id=" + id + " ]";
    }
    
}
