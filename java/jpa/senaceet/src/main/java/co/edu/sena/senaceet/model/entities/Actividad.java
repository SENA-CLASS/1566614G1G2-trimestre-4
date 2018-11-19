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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "actividad", uniqueConstraints = {
    @UniqueConstraint(name = "UNQ_actividad",columnNames = {"id_fase", "numero_actividad"})})
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a"),
    @NamedQuery(name = "Actividad.findById", query = "SELECT a FROM Actividad a WHERE a.id = :id"),
    @NamedQuery(name = "Actividad.findByNumeroActividad", query = "SELECT a FROM Actividad a WHERE a.numeroActividad = :numeroActividad"),
    @NamedQuery(name = "Actividad.findByNombreActividad", query = "SELECT a FROM Actividad a WHERE a.nombreActividad = :nombreActividad")})
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numero_actividad", nullable = false)
    private int numeroActividad;
    @Basic(optional = false)
    @Column(name = "nombre_actividad", nullable = false, length = 400)
    private String nombreActividad;
    @JoinColumn(name = "id_fase", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Fase idFase;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActividad", fetch = FetchType.LAZY)
    private Collection<ActividadPlaneacion> actividadPlaneacionCollection;

    public Actividad() {
    }

    public Actividad(Integer id) {
        this.id = id;
    }

    public Actividad(Integer id, int numeroActividad, String nombreActividad) {
        this.id = id;
        this.numeroActividad = numeroActividad;
        this.nombreActividad = nombreActividad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumeroActividad() {
        return numeroActividad;
    }

    public void setNumeroActividad(int numeroActividad) {
        this.numeroActividad = numeroActividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public Fase getIdFase() {
        return idFase;
    }

    public void setIdFase(Fase idFase) {
        this.idFase = idFase;
    }

    public Collection<ActividadPlaneacion> getActividadPlaneacionCollection() {
        return actividadPlaneacionCollection;
    }

    public void setActividadPlaneacionCollection(Collection<ActividadPlaneacion> actividadPlaneacionCollection) {
        this.actividadPlaneacionCollection = actividadPlaneacionCollection;
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
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.Actividad[ id=" + id + " ]";
    }
    
}
