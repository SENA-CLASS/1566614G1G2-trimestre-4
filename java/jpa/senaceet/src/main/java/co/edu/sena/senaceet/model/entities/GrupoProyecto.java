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
@Table(name = "grupo_proyecto", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_ficha", "numero_grupo"})})
@NamedQueries({
    @NamedQuery(name = "GrupoProyecto.findAll", query = "SELECT g FROM GrupoProyecto g"),
    @NamedQuery(name = "GrupoProyecto.findById", query = "SELECT g FROM GrupoProyecto g WHERE g.id = :id"),
    @NamedQuery(name = "GrupoProyecto.findByNumeroGrupo", query = "SELECT g FROM GrupoProyecto g WHERE g.numeroGrupo = :numeroGrupo"),
    @NamedQuery(name = "GrupoProyecto.findByNombreProyecto", query = "SELECT g FROM GrupoProyecto g WHERE g.nombreProyecto = :nombreProyecto"),
    @NamedQuery(name = "GrupoProyecto.findByEstado", query = "SELECT g FROM GrupoProyecto g WHERE g.estado = :estado")})
public class GrupoProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numero_grupo", nullable = false)
    private int numeroGrupo;
    @Basic(optional = false)
    @Column(name = "nombre_proyecto", nullable = false, length = 300)
    private String nombreProyecto;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 40)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrupoProyecto", fetch = FetchType.LAZY)
    private Collection<IntegrantesGrupo> integrantesGrupoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrupoProyecto", fetch = FetchType.LAZY)
    private Collection<ObservacionGeneral> observacionGeneralCollection;
    @JoinColumn(name = "id_ficha", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ficha idFicha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrupoProyecto", fetch = FetchType.LAZY)
    private Collection<RespuestaGrupo> respuestaGrupoCollection;

    public GrupoProyecto() {
    }

    public GrupoProyecto(Integer id) {
        this.id = id;
    }

    public GrupoProyecto(Integer id, int numeroGrupo, String nombreProyecto, String estado) {
        this.id = id;
        this.numeroGrupo = numeroGrupo;
        this.nombreProyecto = nombreProyecto;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumeroGrupo() {
        return numeroGrupo;
    }

    public void setNumeroGrupo(int numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Collection<IntegrantesGrupo> getIntegrantesGrupoCollection() {
        return integrantesGrupoCollection;
    }

    public void setIntegrantesGrupoCollection(Collection<IntegrantesGrupo> integrantesGrupoCollection) {
        this.integrantesGrupoCollection = integrantesGrupoCollection;
    }

    public Collection<ObservacionGeneral> getObservacionGeneralCollection() {
        return observacionGeneralCollection;
    }

    public void setObservacionGeneralCollection(Collection<ObservacionGeneral> observacionGeneralCollection) {
        this.observacionGeneralCollection = observacionGeneralCollection;
    }

    public Ficha getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(Ficha idFicha) {
        this.idFicha = idFicha;
    }

    public Collection<RespuestaGrupo> getRespuestaGrupoCollection() {
        return respuestaGrupoCollection;
    }

    public void setRespuestaGrupoCollection(Collection<RespuestaGrupo> respuestaGrupoCollection) {
        this.respuestaGrupoCollection = respuestaGrupoCollection;
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
        if (!(object instanceof GrupoProyecto)) {
            return false;
        }
        GrupoProyecto other = (GrupoProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.GrupoProyecto[ id=" + id + " ]";
    }
    
}
