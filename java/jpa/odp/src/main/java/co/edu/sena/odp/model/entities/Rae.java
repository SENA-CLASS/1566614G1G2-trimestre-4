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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
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
@Table(name = "rae")
@NamedQueries({
    @NamedQuery(name = "Rae.findAll", query = "SELECT r FROM Rae r")
    , @NamedQuery(name = "Rae.findByCodigo", query = "SELECT r FROM Rae r WHERE r.raePK.codigo = :codigo")
    , @NamedQuery(name = "Rae.findByCompetenciaCodigo", query = "SELECT r FROM Rae r WHERE r.raePK.competenciaCodigo = :competenciaCodigo")
    , @NamedQuery(name = "Rae.findByProgramaCodigoVersion", query = "SELECT r FROM Rae r WHERE r.raePK.programaCodigoVersion = :programaCodigoVersion")})
public class Rae implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RaePK raePK;
    @Basic(optional = false)
    @Lob
    @Column(name = "denominacion", nullable = false, length = 65535)
    private String denominacion;
    @JoinTable(name = "rae_has_trimestre", joinColumns = {
        @JoinColumn(name = "rae_codigo", referencedColumnName = "codigo", nullable = false)
        , @JoinColumn(name = "competencia_codigo", referencedColumnName = "competencia_codigo", nullable = false)
        , @JoinColumn(name = "programa_codigo_version", referencedColumnName = "programa_codigo_version", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_trimestre", referencedColumnName = "id_trimestre", nullable = false)
        , @JoinColumn(name = "jornada", referencedColumnName = "jornada_nombre", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Trimestre> trimestreCollection;
    @JoinColumns({
        @JoinColumn(name = "competencia_codigo", referencedColumnName = "codigo", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "programa_codigo_version", referencedColumnName = "programa_codigo_version", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Competencia competencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rae", fetch = FetchType.LAZY)
    private Collection<ItemChecker> itemCheckerCollection;

    public Rae() {
    }

    public Rae(RaePK raePK) {
        this.raePK = raePK;
    }

    public Rae(RaePK raePK, String denominacion) {
        this.raePK = raePK;
        this.denominacion = denominacion;
    }

    public Rae(String codigo, String competenciaCodigo, String programaCodigoVersion) {
        this.raePK = new RaePK(codigo, competenciaCodigo, programaCodigoVersion);
    }

    public RaePK getRaePK() {
        return raePK;
    }

    public void setRaePK(RaePK raePK) {
        this.raePK = raePK;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public Collection<Trimestre> getTrimestreCollection() {
        return trimestreCollection;
    }

    public void setTrimestreCollection(Collection<Trimestre> trimestreCollection) {
        this.trimestreCollection = trimestreCollection;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public Collection<ItemChecker> getItemCheckerCollection() {
        return itemCheckerCollection;
    }

    public void setItemCheckerCollection(Collection<ItemChecker> itemCheckerCollection) {
        this.itemCheckerCollection = itemCheckerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (raePK != null ? raePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rae)) {
            return false;
        }
        Rae other = (Rae) object;
        if ((this.raePK == null && other.raePK != null) || (this.raePK != null && !this.raePK.equals(other.raePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.Rae[ raePK=" + raePK + " ]";
    }
    
}
