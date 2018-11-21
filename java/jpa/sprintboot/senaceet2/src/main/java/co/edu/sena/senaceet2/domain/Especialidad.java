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
@Table(name = "especialidad", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre_especialidad"})})
@NamedQueries({
    @NamedQuery(name = "Especialidad.findAll", query = "SELECT e FROM Especialidad e")})
public class Especialidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre_especialidad", nullable = false, length = 40)
    private String nombreEspecialidad;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 40)
    private String estado;
    @Column(name = "url_logo", length = 400)
    private String urlLogo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEspecialidad", fetch = FetchType.LAZY)
    private Collection<EspecialidadInstructor> especialidadInstructorCollection;

    public Especialidad() {
    }

    public Especialidad(Integer id) {
        this.id = id;
    }

    public Especialidad(Integer id, String nombreEspecialidad, String estado) {
        this.id = id;
        this.nombreEspecialidad = nombreEspecialidad;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public Collection<EspecialidadInstructor> getEspecialidadInstructorCollection() {
        return especialidadInstructorCollection;
    }

    public void setEspecialidadInstructorCollection(Collection<EspecialidadInstructor> especialidadInstructorCollection) {
        this.especialidadInstructorCollection = especialidadInstructorCollection;
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
        if (!(object instanceof Especialidad)) {
            return false;
        }
        Especialidad other = (Especialidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.Especialidad[ id=" + id + " ]";
    }
    
}
