/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.senaceet2.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "trimestre_vigente", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"anio", "trimestre_programado"})})
public class TrimestreVigente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "anio", nullable = false)
    private int anio;
    @Basic(optional = false)
    @Column(name = "trimestre_programado", nullable = false)
    private int trimestreProgramado;
    @Basic(optional = false)
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;
    @Basic(optional = false)
    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 40)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrimestreVigente", fetch = FetchType.LAZY)
    private Collection<VersionHorario> versionHorarioCollection;

    public TrimestreVigente() {
    }

    public TrimestreVigente(Integer id) {
        this.id = id;
    }

    public TrimestreVigente(Integer id, int anio, int trimestreProgramado, LocalDate fechaInicio, LocalDate fechaFin, String estado) {
        this.id = id;
        this.anio = anio;
        this.trimestreProgramado = trimestreProgramado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getTrimestreProgramado() {
        return trimestreProgramado;
    }

    public void setTrimestreProgramado(int trimestreProgramado) {
        this.trimestreProgramado = trimestreProgramado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Collection<VersionHorario> getVersionHorarioCollection() {
        return versionHorarioCollection;
    }

    public void setVersionHorarioCollection(Collection<VersionHorario> versionHorarioCollection) {
        this.versionHorarioCollection = versionHorarioCollection;
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
        if (!(object instanceof TrimestreVigente)) {
            return false;
        }
        TrimestreVigente other = (TrimestreVigente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.TrimestreVigente[ id=" + id + " ]";
    }
    
}
