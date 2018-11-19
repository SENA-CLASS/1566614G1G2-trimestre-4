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
@Table(name = "jornada", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"sigla_jornada"}),
    @UniqueConstraint(columnNames = {"nombre_jornada"})})
@NamedQueries({
    @NamedQuery(name = "Jornada.findAll", query = "SELECT j FROM Jornada j"),
    @NamedQuery(name = "Jornada.findById", query = "SELECT j FROM Jornada j WHERE j.id = :id"),
    @NamedQuery(name = "Jornada.findBySiglaJornada", query = "SELECT j FROM Jornada j WHERE j.siglaJornada = :siglaJornada"),
    @NamedQuery(name = "Jornada.findByNombreJornada", query = "SELECT j FROM Jornada j WHERE j.nombreJornada = :nombreJornada"),
    @NamedQuery(name = "Jornada.findByDescripcion", query = "SELECT j FROM Jornada j WHERE j.descripcion = :descripcion"),
    @NamedQuery(name = "Jornada.findByImagenUrl", query = "SELECT j FROM Jornada j WHERE j.imagenUrl = :imagenUrl"),
    @NamedQuery(name = "Jornada.findByEstado", query = "SELECT j FROM Jornada j WHERE j.estado = :estado")})
public class Jornada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "sigla_jornada", nullable = false, length = 20)
    private String siglaJornada;
    @Basic(optional = false)
    @Column(name = "nombre_jornada", nullable = false, length = 40)
    private String nombreJornada;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 40)
    private String descripcion;
    @Column(name = "imagen_url", length = 400)
    private String imagenUrl;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 40)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJornada", fetch = FetchType.LAZY)
    private Collection<Trimestre> trimestreCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJornada", fetch = FetchType.LAZY)
    private Collection<DisponibilidadHoraria> disponibilidadHorariaCollection;

    public Jornada() {
    }

    public Jornada(Integer id) {
        this.id = id;
    }

    public Jornada(Integer id, String siglaJornada, String nombreJornada, String descripcion, String estado) {
        this.id = id;
        this.siglaJornada = siglaJornada;
        this.nombreJornada = nombreJornada;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSiglaJornada() {
        return siglaJornada;
    }

    public void setSiglaJornada(String siglaJornada) {
        this.siglaJornada = siglaJornada;
    }

    public String getNombreJornada() {
        return nombreJornada;
    }

    public void setNombreJornada(String nombreJornada) {
        this.nombreJornada = nombreJornada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Collection<Trimestre> getTrimestreCollection() {
        return trimestreCollection;
    }

    public void setTrimestreCollection(Collection<Trimestre> trimestreCollection) {
        this.trimestreCollection = trimestreCollection;
    }

    public Collection<DisponibilidadHoraria> getDisponibilidadHorariaCollection() {
        return disponibilidadHorariaCollection;
    }

    public void setDisponibilidadHorariaCollection(Collection<DisponibilidadHoraria> disponibilidadHorariaCollection) {
        this.disponibilidadHorariaCollection = disponibilidadHorariaCollection;
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
        if (!(object instanceof Jornada)) {
            return false;
        }
        Jornada other = (Jornada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.Jornada[ id=" + id + " ]";
    }
    
}
