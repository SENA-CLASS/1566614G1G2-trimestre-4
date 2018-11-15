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
import javax.persistence.JoinColumns;
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
@Table(name = "instructor_ficha")
@NamedQueries({
    @NamedQuery(name = "InstructorFicha.findAll", query = "SELECT i FROM InstructorFicha i")
    , @NamedQuery(name = "InstructorFicha.findByTipoDocumento", query = "SELECT i FROM InstructorFicha i WHERE i.instructorFichaPK.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "InstructorFicha.findByNumeroDocumento", query = "SELECT i FROM InstructorFicha i WHERE i.instructorFichaPK.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "InstructorFicha.findByFicha", query = "SELECT i FROM InstructorFicha i WHERE i.instructorFichaPK.ficha = :ficha")})
public class InstructorFicha implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InstructorFichaPK instructorFichaPK;
    @JoinColumns({
        @JoinColumn(name = "tipo_documento", referencedColumnName = "tipo_documento", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "numero_documento", referencedColumnName = "numero_documento", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente cliente;
    @JoinColumn(name = "ficha", referencedColumnName = "numero_ficha", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ficha ficha1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructorFicha", fetch = FetchType.LAZY)
    private Collection<InstructorHasTrimestre> instructorHasTrimestreCollection;

    public InstructorFicha() {
    }

    public InstructorFicha(InstructorFichaPK instructorFichaPK) {
        this.instructorFichaPK = instructorFichaPK;
    }

    public InstructorFicha(String tipoDocumento, String numeroDocumento, String ficha) {
        this.instructorFichaPK = new InstructorFichaPK(tipoDocumento, numeroDocumento, ficha);
    }

    public InstructorFichaPK getInstructorFichaPK() {
        return instructorFichaPK;
    }

    public void setInstructorFichaPK(InstructorFichaPK instructorFichaPK) {
        this.instructorFichaPK = instructorFichaPK;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Ficha getFicha1() {
        return ficha1;
    }

    public void setFicha1(Ficha ficha1) {
        this.ficha1 = ficha1;
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
        hash += (instructorFichaPK != null ? instructorFichaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstructorFicha)) {
            return false;
        }
        InstructorFicha other = (InstructorFicha) object;
        if ((this.instructorFichaPK == null && other.instructorFichaPK != null) || (this.instructorFichaPK != null && !this.instructorFichaPK.equals(other.instructorFichaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.InstructorFicha[ instructorFichaPK=" + instructorFichaPK + " ]";
    }
    
}
