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
@Table(name = "planeacion_trimestre", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_resultado_aprendizaje", "id_trimestre", "id_planeacion"})})
@NamedQueries({
    @NamedQuery(name = "PlaneacionTrimestre.findAll", query = "SELECT p FROM PlaneacionTrimestre p"),
    @NamedQuery(name = "PlaneacionTrimestre.findById", query = "SELECT p FROM PlaneacionTrimestre p WHERE p.id = :id")})
public class PlaneacionTrimestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "id_planeacion", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Planeacion idPlaneacion;
    @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ResultadoAprendizaje idResultadoAprendizaje;
    @JoinColumn(name = "id_trimestre", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Trimestre idTrimestre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlaneacionTrimestre", fetch = FetchType.LAZY)
    private Collection<ActividadPlaneacion> actividadPlaneacionCollection;

    public PlaneacionTrimestre() {
    }

    public PlaneacionTrimestre(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Planeacion getIdPlaneacion() {
        return idPlaneacion;
    }

    public void setIdPlaneacion(Planeacion idPlaneacion) {
        this.idPlaneacion = idPlaneacion;
    }

    public ResultadoAprendizaje getIdResultadoAprendizaje() {
        return idResultadoAprendizaje;
    }

    public void setIdResultadoAprendizaje(ResultadoAprendizaje idResultadoAprendizaje) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
    }

    public Trimestre getIdTrimestre() {
        return idTrimestre;
    }

    public void setIdTrimestre(Trimestre idTrimestre) {
        this.idTrimestre = idTrimestre;
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
        if (!(object instanceof PlaneacionTrimestre)) {
            return false;
        }
        PlaneacionTrimestre other = (PlaneacionTrimestre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.PlaneacionTrimestre[ id=" + id + " ]";
    }
    
}
