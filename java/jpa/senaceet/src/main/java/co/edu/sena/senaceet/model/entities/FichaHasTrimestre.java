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
@Table(name = "ficha_has_trimestre", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_ficha", "id_trimestre"})})
@NamedQueries({
    @NamedQuery(name = "FichaHasTrimestre.findAll", query = "SELECT f FROM FichaHasTrimestre f"),
    @NamedQuery(name = "FichaHasTrimestre.findById", query = "SELECT f FROM FichaHasTrimestre f WHERE f.id = :id")})
public class FichaHasTrimestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFichaHasTrimestre", fetch = FetchType.LAZY)
    private Collection<Horario> horarioCollection;
    @JoinColumn(name = "id_ficha", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ficha idFicha;
    @JoinColumn(name = "id_trimestre", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Trimestre idTrimestre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFichaHasTrimestre", fetch = FetchType.LAZY)
    private Collection<ResultadosVistos> resultadosVistosCollection;

    public FichaHasTrimestre() {
    }

    public FichaHasTrimestre(Integer id) {
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

    public Ficha getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(Ficha idFicha) {
        this.idFicha = idFicha;
    }

    public Trimestre getIdTrimestre() {
        return idTrimestre;
    }

    public void setIdTrimestre(Trimestre idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    public Collection<ResultadosVistos> getResultadosVistosCollection() {
        return resultadosVistosCollection;
    }

    public void setResultadosVistosCollection(Collection<ResultadosVistos> resultadosVistosCollection) {
        this.resultadosVistosCollection = resultadosVistosCollection;
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
        if (!(object instanceof FichaHasTrimestre)) {
            return false;
        }
        FichaHasTrimestre other = (FichaHasTrimestre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.FichaHasTrimestre[ id=" + id + " ]";
    }
    
}
