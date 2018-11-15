/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.odp.model.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "trimestre")
@NamedQueries({
    @NamedQuery(name = "Trimestre.findAll", query = "SELECT t FROM Trimestre t")
    , @NamedQuery(name = "Trimestre.findByIdTrimestre", query = "SELECT t FROM Trimestre t WHERE t.trimestrePK.idTrimestre = :idTrimestre")
    , @NamedQuery(name = "Trimestre.findByJornadaNombre", query = "SELECT t FROM Trimestre t WHERE t.trimestrePK.jornadaNombre = :jornadaNombre")})
public class Trimestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrimestrePK trimestrePK;
    @ManyToMany(mappedBy = "trimestreCollection", fetch = FetchType.LAZY)
    private Collection<Rae> raeCollection;
    @JoinColumn(name = "jornada_nombre", referencedColumnName = "nombre", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Jornada jornada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trimestre", fetch = FetchType.LAZY)
    private Collection<InstructorHasTrimestre> instructorHasTrimestreCollection;

    public Trimestre() {
    }

    public Trimestre(TrimestrePK trimestrePK) {
        this.trimestrePK = trimestrePK;
    }

    public Trimestre(String idTrimestre, String jornadaNombre) {
        this.trimestrePK = new TrimestrePK(idTrimestre, jornadaNombre);
    }

    public TrimestrePK getTrimestrePK() {
        return trimestrePK;
    }

    public void setTrimestrePK(TrimestrePK trimestrePK) {
        this.trimestrePK = trimestrePK;
    }

    public Collection<Rae> getRaeCollection() {
        return raeCollection;
    }

    public void setRaeCollection(Collection<Rae> raeCollection) {
        this.raeCollection = raeCollection;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
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
        hash += (trimestrePK != null ? trimestrePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trimestre)) {
            return false;
        }
        Trimestre other = (Trimestre) object;
        if ((this.trimestrePK == null && other.trimestrePK != null) || (this.trimestrePK != null && !this.trimestrePK.equals(other.trimestrePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.Trimestre[ trimestrePK=" + trimestrePK + " ]";
    }
    
}
