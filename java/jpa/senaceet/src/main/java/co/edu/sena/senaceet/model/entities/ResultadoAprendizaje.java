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
@Table(name = "resultado_aprendizaje", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"codigo_resultado", "id_competencia"})})
@NamedQueries({
    @NamedQuery(name = "ResultadoAprendizaje.findAll", query = "SELECT r FROM ResultadoAprendizaje r"),
    @NamedQuery(name = "ResultadoAprendizaje.findById", query = "SELECT r FROM ResultadoAprendizaje r WHERE r.id = :id"),
    @NamedQuery(name = "ResultadoAprendizaje.findByCodigoResultado", query = "SELECT r FROM ResultadoAprendizaje r WHERE r.codigoResultado = :codigoResultado"),
    @NamedQuery(name = "ResultadoAprendizaje.findByDescripcion", query = "SELECT r FROM ResultadoAprendizaje r WHERE r.descripcion = :descripcion")})
public class ResultadoAprendizaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "codigo_resultado", nullable = false, length = 40)
    private String codigoResultado;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 1000)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResultadoAprendizaje", fetch = FetchType.LAZY)
    private Collection<PlaneacionTrimestre> planeacionTrimestreCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResultadoAprendizaje", fetch = FetchType.LAZY)
    private Collection<ResultadosVistos> resultadosVistosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResultadoAprendizaje", fetch = FetchType.LAZY)
    private Collection<DisponibilidadResultados> disponibilidadResultadosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResultadoAprendizaje", fetch = FetchType.LAZY)
    private Collection<LimitacionAmbiente> limitacionAmbienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResultadoAprendizaje", fetch = FetchType.LAZY)
    private Collection<ItemLista> itemListaCollection;
    @JoinColumn(name = "id_competencia", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Competencia idCompetencia;

    public ResultadoAprendizaje() {
    }

    public ResultadoAprendizaje(Integer id) {
        this.id = id;
    }

    public ResultadoAprendizaje(Integer id, String codigoResultado, String descripcion) {
        this.id = id;
        this.codigoResultado = codigoResultado;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoResultado() {
        return codigoResultado;
    }

    public void setCodigoResultado(String codigoResultado) {
        this.codigoResultado = codigoResultado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<PlaneacionTrimestre> getPlaneacionTrimestreCollection() {
        return planeacionTrimestreCollection;
    }

    public void setPlaneacionTrimestreCollection(Collection<PlaneacionTrimestre> planeacionTrimestreCollection) {
        this.planeacionTrimestreCollection = planeacionTrimestreCollection;
    }

    public Collection<ResultadosVistos> getResultadosVistosCollection() {
        return resultadosVistosCollection;
    }

    public void setResultadosVistosCollection(Collection<ResultadosVistos> resultadosVistosCollection) {
        this.resultadosVistosCollection = resultadosVistosCollection;
    }

    public Collection<DisponibilidadResultados> getDisponibilidadResultadosCollection() {
        return disponibilidadResultadosCollection;
    }

    public void setDisponibilidadResultadosCollection(Collection<DisponibilidadResultados> disponibilidadResultadosCollection) {
        this.disponibilidadResultadosCollection = disponibilidadResultadosCollection;
    }

    public Collection<LimitacionAmbiente> getLimitacionAmbienteCollection() {
        return limitacionAmbienteCollection;
    }

    public void setLimitacionAmbienteCollection(Collection<LimitacionAmbiente> limitacionAmbienteCollection) {
        this.limitacionAmbienteCollection = limitacionAmbienteCollection;
    }

    public Collection<ItemLista> getItemListaCollection() {
        return itemListaCollection;
    }

    public void setItemListaCollection(Collection<ItemLista> itemListaCollection) {
        this.itemListaCollection = itemListaCollection;
    }

    public Competencia getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(Competencia idCompetencia) {
        this.idCompetencia = idCompetencia;
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
        if (!(object instanceof ResultadoAprendizaje)) {
            return false;
        }
        ResultadoAprendizaje other = (ResultadoAprendizaje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.ResultadoAprendizaje[ id=" + id + " ]";
    }
    
}
