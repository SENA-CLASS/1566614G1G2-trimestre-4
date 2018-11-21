/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.senaceet2.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "actividad", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_fase", "numero_actividad"})})
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
