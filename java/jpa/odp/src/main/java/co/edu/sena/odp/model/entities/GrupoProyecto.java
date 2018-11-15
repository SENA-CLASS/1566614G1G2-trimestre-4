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
@Table(name = "grupo_proyecto")
@NamedQueries({
    @NamedQuery(name = "GrupoProyecto.findAll", query = "SELECT g FROM GrupoProyecto g")
    , @NamedQuery(name = "GrupoProyecto.findByNumeroFicha", query = "SELECT g FROM GrupoProyecto g WHERE g.grupoProyectoPK.numeroFicha = :numeroFicha")
    , @NamedQuery(name = "GrupoProyecto.findByCodigo", query = "SELECT g FROM GrupoProyecto g WHERE g.grupoProyectoPK.codigo = :codigo")
    , @NamedQuery(name = "GrupoProyecto.findByNombreProyecto", query = "SELECT g FROM GrupoProyecto g WHERE g.nombreProyecto = :nombreProyecto")
    , @NamedQuery(name = "GrupoProyecto.findByEstadoGrupo", query = "SELECT g FROM GrupoProyecto g WHERE g.estadoGrupo = :estadoGrupo")})
public class GrupoProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GrupoProyectoPK grupoProyectoPK;
    @Basic(optional = false)
    @Column(name = "nombre_proyecto", nullable = false, length = 500)
    private String nombreProyecto;
    @Basic(optional = false)
    @Column(name = "estado_grupo", nullable = false, length = 20)
    private String estadoGrupo;
    @JoinColumn(name = "numero_ficha", referencedColumnName = "numero_ficha", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ficha ficha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoProyecto", fetch = FetchType.LAZY)
    private Collection<Aprendiz> aprendizCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoProyecto", fetch = FetchType.LAZY)
    private Collection<RespuestaGrupo> respuestaGrupoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoProyecto", fetch = FetchType.LAZY)
    private Collection<ObservacionGeneral> observacionGeneralCollection;

    public GrupoProyecto() {
    }

    public GrupoProyecto(GrupoProyectoPK grupoProyectoPK) {
        this.grupoProyectoPK = grupoProyectoPK;
    }

    public GrupoProyecto(GrupoProyectoPK grupoProyectoPK, String nombreProyecto, String estadoGrupo) {
        this.grupoProyectoPK = grupoProyectoPK;
        this.nombreProyecto = nombreProyecto;
        this.estadoGrupo = estadoGrupo;
    }

    public GrupoProyecto(String numeroFicha, int codigo) {
        this.grupoProyectoPK = new GrupoProyectoPK(numeroFicha, codigo);
    }

    public GrupoProyectoPK getGrupoProyectoPK() {
        return grupoProyectoPK;
    }

    public void setGrupoProyectoPK(GrupoProyectoPK grupoProyectoPK) {
        this.grupoProyectoPK = grupoProyectoPK;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getEstadoGrupo() {
        return estadoGrupo;
    }

    public void setEstadoGrupo(String estadoGrupo) {
        this.estadoGrupo = estadoGrupo;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public Collection<Aprendiz> getAprendizCollection() {
        return aprendizCollection;
    }

    public void setAprendizCollection(Collection<Aprendiz> aprendizCollection) {
        this.aprendizCollection = aprendizCollection;
    }

    public Collection<RespuestaGrupo> getRespuestaGrupoCollection() {
        return respuestaGrupoCollection;
    }

    public void setRespuestaGrupoCollection(Collection<RespuestaGrupo> respuestaGrupoCollection) {
        this.respuestaGrupoCollection = respuestaGrupoCollection;
    }

    public Collection<ObservacionGeneral> getObservacionGeneralCollection() {
        return observacionGeneralCollection;
    }

    public void setObservacionGeneralCollection(Collection<ObservacionGeneral> observacionGeneralCollection) {
        this.observacionGeneralCollection = observacionGeneralCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupoProyectoPK != null ? grupoProyectoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoProyecto)) {
            return false;
        }
        GrupoProyecto other = (GrupoProyecto) object;
        if ((this.grupoProyectoPK == null && other.grupoProyectoPK != null) || (this.grupoProyectoPK != null && !this.grupoProyectoPK.equals(other.grupoProyectoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.GrupoProyecto[ grupoProyectoPK=" + grupoProyectoPK + " ]";
    }
    
}
