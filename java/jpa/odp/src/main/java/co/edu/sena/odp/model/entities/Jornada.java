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
@Table(name = "jornada")
@NamedQueries({
    @NamedQuery(name = "Jornada.findAll", query = "SELECT j FROM Jornada j")
    , @NamedQuery(name = "Jornada.findByNombre", query = "SELECT j FROM Jornada j WHERE j.nombre = :nombre")
    , @NamedQuery(name = "Jornada.findByEstado", query = "SELECT j FROM Jornada j WHERE j.estado = :estado")
    , @NamedQuery(name = "Jornada.findByDescripcion", query = "SELECT j FROM Jornada j WHERE j.descripcion = :descripcion")})
public class Jornada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 40)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false)
    private boolean estado;
    @Column(name = "descripcion", length = 200)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jornada", fetch = FetchType.LAZY)
    private Collection<Trimestre> trimestreCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jornadaNombre", fetch = FetchType.LAZY)
    private Collection<Ficha> fichaCollection;

    public Jornada() {
    }

    public Jornada(String nombre) {
        this.nombre = nombre;
    }

    public Jornada(String nombre, boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<Trimestre> getTrimestreCollection() {
        return trimestreCollection;
    }

    public void setTrimestreCollection(Collection<Trimestre> trimestreCollection) {
        this.trimestreCollection = trimestreCollection;
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
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jornada)) {
            return false;
        }
        Jornada other = (Jornada) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.Jornada[ nombre=" + nombre + " ]";
    }
    
}
