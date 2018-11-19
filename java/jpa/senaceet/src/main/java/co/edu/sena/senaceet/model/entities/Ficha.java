/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.senaceet.model.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "ficha", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_programa", "numero_ficha"})})
@NamedQueries({
    @NamedQuery(name = "Ficha.findAll", query = "SELECT f FROM Ficha f"),
    @NamedQuery(name = "Ficha.findById", query = "SELECT f FROM Ficha f WHERE f.id = :id"),
    @NamedQuery(name = "Ficha.findByNumeroFicha", query = "SELECT f FROM Ficha f WHERE f.numeroFicha = :numeroFicha"),
    @NamedQuery(name = "Ficha.findByFechaInicio", query = "SELECT f FROM Ficha f WHERE f.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Ficha.findByFechaFin", query = "SELECT f FROM Ficha f WHERE f.fechaFin = :fechaFin"),
    @NamedQuery(name = "Ficha.findByRuta", query = "SELECT f FROM Ficha f WHERE f.ruta = :ruta")})
public class Ficha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numero_ficha", nullable = false, length = 100)
    private String numeroFicha;
    @Basic(optional = false)
    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "fecha_fin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @Column(name = "ruta", nullable = false, length = 40)
    private String ruta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFicha", fetch = FetchType.LAZY)
    private Collection<FichaHasTrimestre> fichaHasTrimestreCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFicha", fetch = FetchType.LAZY)
    private Collection<ListaFicha> listaFichaCollection;
    @JoinColumn(name = "id_estado_ficha", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoFicha idEstadoFicha;
    @JoinColumn(name = "id_programa", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Programa idPrograma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFicha", fetch = FetchType.LAZY)
    private Collection<GrupoProyecto> grupoProyectoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFicha", fetch = FetchType.LAZY)
    private Collection<Aprendiz> aprendizCollection;

    public Ficha() {
    }

    public Ficha(Integer id) {
        this.id = id;
    }

    public Ficha(Integer id, String numeroFicha, Date fechaInicio, Date fechaFin, String ruta) {
        this.id = id;
        this.numeroFicha = numeroFicha;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ruta = ruta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Collection<FichaHasTrimestre> getFichaHasTrimestreCollection() {
        return fichaHasTrimestreCollection;
    }

    public void setFichaHasTrimestreCollection(Collection<FichaHasTrimestre> fichaHasTrimestreCollection) {
        this.fichaHasTrimestreCollection = fichaHasTrimestreCollection;
    }

    public Collection<ListaFicha> getListaFichaCollection() {
        return listaFichaCollection;
    }

    public void setListaFichaCollection(Collection<ListaFicha> listaFichaCollection) {
        this.listaFichaCollection = listaFichaCollection;
    }

    public EstadoFicha getIdEstadoFicha() {
        return idEstadoFicha;
    }

    public void setIdEstadoFicha(EstadoFicha idEstadoFicha) {
        this.idEstadoFicha = idEstadoFicha;
    }

    public Programa getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Programa idPrograma) {
        this.idPrograma = idPrograma;
    }

    public Collection<GrupoProyecto> getGrupoProyectoCollection() {
        return grupoProyectoCollection;
    }

    public void setGrupoProyectoCollection(Collection<GrupoProyecto> grupoProyectoCollection) {
        this.grupoProyectoCollection = grupoProyectoCollection;
    }

    public Collection<Aprendiz> getAprendizCollection() {
        return aprendizCollection;
    }

    public void setAprendizCollection(Collection<Aprendiz> aprendizCollection) {
        this.aprendizCollection = aprendizCollection;
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
        if (!(object instanceof Ficha)) {
            return false;
        }
        Ficha other = (Ficha) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.Ficha[ id=" + id + " ]";
    }
    
}
