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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "ficha")
@NamedQueries({
    @NamedQuery(name = "Ficha.findAll", query = "SELECT f FROM Ficha f")
    , @NamedQuery(name = "Ficha.findByNumeroFicha", query = "SELECT f FROM Ficha f WHERE f.numeroFicha = :numeroFicha")
    , @NamedQuery(name = "Ficha.findByEstado", query = "SELECT f FROM Ficha f WHERE f.estado = :estado")})
public class Ficha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "numero_ficha", nullable = false, length = 50)
    private String numeroFicha;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 40)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ficha", fetch = FetchType.LAZY)
    private Collection<GrupoProyecto> grupoProyectoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ficha1", fetch = FetchType.LAZY)
    private Collection<InstructorFicha> instructorFichaCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ficha1", fetch = FetchType.LAZY)
    private FichaHasLista fichaHasLista;
    @JoinColumn(name = "jornada_nombre", referencedColumnName = "nombre", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Jornada jornadaNombre;
    @JoinColumn(name = "programa_codigo_version", referencedColumnName = "codigo_version", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Programa programaCodigoVersion;

    public Ficha() {
    }

    public Ficha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public Ficha(String numeroFicha, String estado) {
        this.numeroFicha = numeroFicha;
        this.estado = estado;
    }

    public String getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Collection<GrupoProyecto> getGrupoProyectoCollection() {
        return grupoProyectoCollection;
    }

    public void setGrupoProyectoCollection(Collection<GrupoProyecto> grupoProyectoCollection) {
        this.grupoProyectoCollection = grupoProyectoCollection;
    }

    public Collection<InstructorFicha> getInstructorFichaCollection() {
        return instructorFichaCollection;
    }

    public void setInstructorFichaCollection(Collection<InstructorFicha> instructorFichaCollection) {
        this.instructorFichaCollection = instructorFichaCollection;
    }

    public FichaHasLista getFichaHasLista() {
        return fichaHasLista;
    }

    public void setFichaHasLista(FichaHasLista fichaHasLista) {
        this.fichaHasLista = fichaHasLista;
    }

    public Jornada getJornadaNombre() {
        return jornadaNombre;
    }

    public void setJornadaNombre(Jornada jornadaNombre) {
        this.jornadaNombre = jornadaNombre;
    }

    public Programa getProgramaCodigoVersion() {
        return programaCodigoVersion;
    }

    public void setProgramaCodigoVersion(Programa programaCodigoVersion) {
        this.programaCodigoVersion = programaCodigoVersion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroFicha != null ? numeroFicha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ficha)) {
            return false;
        }
        Ficha other = (Ficha) object;
        if ((this.numeroFicha == null && other.numeroFicha != null) || (this.numeroFicha != null && !this.numeroFicha.equals(other.numeroFicha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.Ficha[ numeroFicha=" + numeroFicha + " ]";
    }
    
}
