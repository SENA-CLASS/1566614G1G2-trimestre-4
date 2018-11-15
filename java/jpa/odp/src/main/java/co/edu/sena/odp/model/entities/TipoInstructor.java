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
@Table(name = "tipo_instructor")
@NamedQueries({
    @NamedQuery(name = "TipoInstructor.findAll", query = "SELECT t FROM TipoInstructor t")
    , @NamedQuery(name = "TipoInstructor.findByModalidad", query = "SELECT t FROM TipoInstructor t WHERE t.modalidad = :modalidad")
    , @NamedQuery(name = "TipoInstructor.findByEstado", query = "SELECT t FROM TipoInstructor t WHERE t.estado = :estado")})
public class TipoInstructor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "modalidad", nullable = false, length = 30)
    private String modalidad;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false)
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoInstructor1", fetch = FetchType.LAZY)
    private Collection<InstructorHasTrimestre> instructorHasTrimestreCollection;

    public TipoInstructor() {
    }

    public TipoInstructor(String modalidad) {
        this.modalidad = modalidad;
    }

    public TipoInstructor(String modalidad, boolean estado) {
        this.modalidad = modalidad;
        this.estado = estado;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Collection<InstructorHasTrimestre> getInstructorHasTrimestreCollection() {
        return instructorHasTrimestreCollection;
    }

    public void setInstructorHasTrimestreCollection(Collection<InstructorHasTrimestre> instructorHasTrimestreCollection) {
        this.instructorHasTrimestreCollection = instructorHasTrimestreCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modalidad != null ? modalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoInstructor)) {
            return false;
        }
        TipoInstructor other = (TipoInstructor) object;
        if ((this.modalidad == null && other.modalidad != null) || (this.modalidad != null && !this.modalidad.equals(other.modalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.TipoInstructor[ modalidad=" + modalidad + " ]";
    }
    
}
