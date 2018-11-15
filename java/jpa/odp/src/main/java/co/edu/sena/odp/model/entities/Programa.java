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
@Table(name = "programa")
@NamedQueries({
    @NamedQuery(name = "Programa.findAll", query = "SELECT p FROM Programa p")
    , @NamedQuery(name = "Programa.findByCodigoVersion", query = "SELECT p FROM Programa p WHERE p.codigoVersion = :codigoVersion")
    , @NamedQuery(name = "Programa.findByEstado", query = "SELECT p FROM Programa p WHERE p.estado = :estado")
    , @NamedQuery(name = "Programa.findByNombre", query = "SELECT p FROM Programa p WHERE p.nombre = :nombre")})
public class Programa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo_version", nullable = false, length = 30)
    private String codigoVersion;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 20)
    private String estado;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programa", fetch = FetchType.LAZY)
    private Collection<Competencia> competenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programaCodigoVersion", fetch = FetchType.LAZY)
    private Collection<ListaChequeo> listaChequeoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programaCodigoVersion", fetch = FetchType.LAZY)
    private Collection<Ficha> fichaCollection;

    public Programa() {
    }

    public Programa(String codigoVersion) {
        this.codigoVersion = codigoVersion;
    }

    public Programa(String codigoVersion, String estado, String nombre) {
        this.codigoVersion = codigoVersion;
        this.estado = estado;
        this.nombre = nombre;
    }

    public String getCodigoVersion() {
        return codigoVersion;
    }

    public void setCodigoVersion(String codigoVersion) {
        this.codigoVersion = codigoVersion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Competencia> getCompetenciaCollection() {
        return competenciaCollection;
    }

    public void setCompetenciaCollection(Collection<Competencia> competenciaCollection) {
        this.competenciaCollection = competenciaCollection;
    }

    public Collection<ListaChequeo> getListaChequeoCollection() {
        return listaChequeoCollection;
    }

    public void setListaChequeoCollection(Collection<ListaChequeo> listaChequeoCollection) {
        this.listaChequeoCollection = listaChequeoCollection;
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
        hash += (codigoVersion != null ? codigoVersion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programa)) {
            return false;
        }
        Programa other = (Programa) object;
        if ((this.codigoVersion == null && other.codigoVersion != null) || (this.codigoVersion != null && !this.codigoVersion.equals(other.codigoVersion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.Programa[ codigoVersion=" + codigoVersion + " ]";
    }
    
}
