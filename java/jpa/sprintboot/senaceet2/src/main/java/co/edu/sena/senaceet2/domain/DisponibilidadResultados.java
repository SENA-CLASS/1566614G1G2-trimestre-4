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
@Table(name = "disponibilidad_resultados", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"anio", "id_instructor", "id_resultado_aprendizaje"})})
@NamedQueries({
    @NamedQuery(name = "DisponibilidadResultados.findAll", query = "SELECT d FROM DisponibilidadResultados d")})
public class DisponibilidadResultados implements Serializable {

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
    @JoinColumn(name = "id_instructor", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Instructor idInstructor;
    @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ResultadoAprendizaje idResultadoAprendizaje;

    public DisponibilidadResultados() {
    }

    public DisponibilidadResultados(Integer id) {
        this.id = id;
    }

    public DisponibilidadResultados(Integer id, Date anio) {
        this.id = id;
        this.anio = anio;
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

    public Instructor getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Instructor idInstructor) {
        this.idInstructor = idInstructor;
    }

    public ResultadoAprendizaje getIdResultadoAprendizaje() {
        return idResultadoAprendizaje;
    }

    public void setIdResultadoAprendizaje(ResultadoAprendizaje idResultadoAprendizaje) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
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
        if (!(object instanceof DisponibilidadResultados)) {
            return false;
        }
        DisponibilidadResultados other = (DisponibilidadResultados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.DisponibilidadResultados[ id=" + id + " ]";
    }
    
}
