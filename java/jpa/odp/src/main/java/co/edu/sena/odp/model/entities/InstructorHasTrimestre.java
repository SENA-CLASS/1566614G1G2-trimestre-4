/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.odp.model.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "instructor_has_trimestre")
@NamedQueries({
    @NamedQuery(name = "InstructorHasTrimestre.findAll", query = "SELECT i FROM InstructorHasTrimestre i")
    , @NamedQuery(name = "InstructorHasTrimestre.findByTipoDocumento", query = "SELECT i FROM InstructorHasTrimestre i WHERE i.instructorHasTrimestrePK.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "InstructorHasTrimestre.findByNumeroDocumento", query = "SELECT i FROM InstructorHasTrimestre i WHERE i.instructorHasTrimestrePK.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "InstructorHasTrimestre.findByFicha", query = "SELECT i FROM InstructorHasTrimestre i WHERE i.instructorHasTrimestrePK.ficha = :ficha")
    , @NamedQuery(name = "InstructorHasTrimestre.findByIdTrimestre", query = "SELECT i FROM InstructorHasTrimestre i WHERE i.instructorHasTrimestrePK.idTrimestre = :idTrimestre")
    , @NamedQuery(name = "InstructorHasTrimestre.findByJornada", query = "SELECT i FROM InstructorHasTrimestre i WHERE i.instructorHasTrimestrePK.jornada = :jornada")
    , @NamedQuery(name = "InstructorHasTrimestre.findByTipoInstructor", query = "SELECT i FROM InstructorHasTrimestre i WHERE i.instructorHasTrimestrePK.tipoInstructor = :tipoInstructor")})
public class InstructorHasTrimestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InstructorHasTrimestrePK instructorHasTrimestrePK;
    @JoinColumns({
        @JoinColumn(name = "tipo_documento", referencedColumnName = "tipo_documento", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "numero_documento", referencedColumnName = "numero_documento", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "ficha", referencedColumnName = "ficha", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private InstructorFicha instructorFicha;
    @JoinColumn(name = "tipo_instructor", referencedColumnName = "modalidad", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoInstructor tipoInstructor1;
    @JoinColumns({
        @JoinColumn(name = "id_trimestre", referencedColumnName = "id_trimestre", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "jornada", referencedColumnName = "jornada_nombre", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Trimestre trimestre;

    public InstructorHasTrimestre() {
    }

    public InstructorHasTrimestre(InstructorHasTrimestrePK instructorHasTrimestrePK) {
        this.instructorHasTrimestrePK = instructorHasTrimestrePK;
    }

    public InstructorHasTrimestre(String tipoDocumento, String numeroDocumento, String ficha, String idTrimestre, String jornada, String tipoInstructor) {
        this.instructorHasTrimestrePK = new InstructorHasTrimestrePK(tipoDocumento, numeroDocumento, ficha, idTrimestre, jornada, tipoInstructor);
    }

    public InstructorHasTrimestrePK getInstructorHasTrimestrePK() {
        return instructorHasTrimestrePK;
    }

    public void setInstructorHasTrimestrePK(InstructorHasTrimestrePK instructorHasTrimestrePK) {
        this.instructorHasTrimestrePK = instructorHasTrimestrePK;
    }

    public InstructorFicha getInstructorFicha() {
        return instructorFicha;
    }

    public void setInstructorFicha(InstructorFicha instructorFicha) {
        this.instructorFicha = instructorFicha;
    }

    public TipoInstructor getTipoInstructor1() {
        return tipoInstructor1;
    }

    public void setTipoInstructor1(TipoInstructor tipoInstructor1) {
        this.tipoInstructor1 = tipoInstructor1;
    }

    public Trimestre getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Trimestre trimestre) {
        this.trimestre = trimestre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instructorHasTrimestrePK != null ? instructorHasTrimestrePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstructorHasTrimestre)) {
            return false;
        }
        InstructorHasTrimestre other = (InstructorHasTrimestre) object;
        if ((this.instructorHasTrimestrePK == null && other.instructorHasTrimestrePK != null) || (this.instructorHasTrimestrePK != null && !this.instructorHasTrimestrePK.equals(other.instructorHasTrimestrePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.InstructorHasTrimestre[ instructorHasTrimestrePK=" + instructorHasTrimestrePK + " ]";
    }
    
}
