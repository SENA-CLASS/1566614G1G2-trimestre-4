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
@Table(name = "instructor", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_cliente"})})
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i")})
public class Instructor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstructor", fetch = FetchType.LAZY)
    private Collection<Horario> horarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstructor", fetch = FetchType.LAZY)
    private Collection<DisponibilidadHoraria> disponibilidadHorariaCollection;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente idCliente;
    @JoinColumn(name = "id_vinculacion", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vinculacion idVinculacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstructor", fetch = FetchType.LAZY)
    private Collection<DisponibilidadResultados> disponibilidadResultadosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstructor", fetch = FetchType.LAZY)
    private Collection<EspecialidadInstructor> especialidadInstructorCollection;

    public Instructor() {
    }

    public Instructor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<Horario> getHorarioCollection() {
        return horarioCollection;
    }

    public void setHorarioCollection(Collection<Horario> horarioCollection) {
        this.horarioCollection = horarioCollection;
    }

    public Collection<DisponibilidadHoraria> getDisponibilidadHorariaCollection() {
        return disponibilidadHorariaCollection;
    }

    public void setDisponibilidadHorariaCollection(Collection<DisponibilidadHoraria> disponibilidadHorariaCollection) {
        this.disponibilidadHorariaCollection = disponibilidadHorariaCollection;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Vinculacion getIdVinculacion() {
        return idVinculacion;
    }

    public void setIdVinculacion(Vinculacion idVinculacion) {
        this.idVinculacion = idVinculacion;
    }

    public Collection<DisponibilidadResultados> getDisponibilidadResultadosCollection() {
        return disponibilidadResultadosCollection;
    }

    public void setDisponibilidadResultadosCollection(Collection<DisponibilidadResultados> disponibilidadResultadosCollection) {
        this.disponibilidadResultadosCollection = disponibilidadResultadosCollection;
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
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.Instructor[ id=" + id + " ]";
    }
    
}
