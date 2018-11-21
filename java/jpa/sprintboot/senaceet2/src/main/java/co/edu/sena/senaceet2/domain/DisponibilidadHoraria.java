/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.senaceet2.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "disponibilidad_horaria", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"anio", "hora_inicio", "id_jornada", "id_instructor", "id_dia"})})
@NamedQueries({
    @NamedQuery(name = "DisponibilidadHoraria.findAll", query = "SELECT d FROM DisponibilidadHoraria d")})
public class DisponibilidadHoraria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "anio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date anio;
    @Basic(optional = false)
    @Column(name = "hora_inicio", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Basic(optional = false)
    @Column(name = "hora_fin", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @JoinColumn(name = "id_dia", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dia idDia;
    @JoinColumn(name = "id_instructor", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Instructor idInstructor;
    @JoinColumn(name = "id_jornada", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Jornada idJornada;

    public DisponibilidadHoraria() {
    }

    public DisponibilidadHoraria(Integer id) {
        this.id = id;
    }

    public DisponibilidadHoraria(Integer id, Date anio, Date horaInicio, Date horaFin) {
        this.id = id;
        this.anio = anio;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAnio() {
        return anio;
    }

    public void setAnio(Date anio) {
        this.anio = anio;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public Dia getIdDia() {
        return idDia;
    }

    public void setIdDia(Dia idDia) {
        this.idDia = idDia;
    }

    public Instructor getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Instructor idInstructor) {
        this.idInstructor = idInstructor;
    }

    public Jornada getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(Jornada idJornada) {
        this.idJornada = idJornada;
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
        if (!(object instanceof DisponibilidadHoraria)) {
            return false;
        }
        DisponibilidadHoraria other = (DisponibilidadHoraria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.DisponibilidadHoraria[ id=" + id + " ]";
    }
    
}
