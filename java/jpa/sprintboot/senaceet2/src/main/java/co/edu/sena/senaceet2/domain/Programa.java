/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.senaceet2.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "programa", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"codigo", "version"})})
@NamedQueries({
    @NamedQuery(name = "Programa.findAll", query = "SELECT p FROM Programa p")})
public class Programa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "codigo", nullable = false, length = 50)
    private String codigo;
    @Basic(optional = false)
    @Column(name = "version", nullable = false, length = 40)
    private String version;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 500)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "sigla", nullable = false, length = 40)
    private String sigla;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 40)
    private String estado;
    @JoinColumn(name = "id_nivel_formacion", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private NivelFormacion idNivelFormacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrograma", fetch = FetchType.LAZY)
    private Collection<Ficha> fichaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrograma", fetch = FetchType.LAZY)
    private Collection<Competencia> competenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrograma", fetch = FetchType.LAZY)
    private Collection<ListaChequeo> listaChequeoCollection;

    public Programa() {
    }

    public Programa(Integer id) {
        this.id = id;
    }

    public Programa(Integer id, String codigo, String version, String nombre, String sigla, String estado) {
        this.id = id;
        this.codigo = codigo;
        this.version = version;
        this.nombre = nombre;
        this.sigla = sigla;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public NivelFormacion getIdNivelFormacion() {
        return idNivelFormacion;
    }

    public void setIdNivelFormacion(NivelFormacion idNivelFormacion) {
        this.idNivelFormacion = idNivelFormacion;
    }

    public Collection<Ficha> getFichaCollection() {
        return fichaCollection;
    }

    public void setFichaCollection(Collection<Ficha> fichaCollection) {
        this.fichaCollection = fichaCollection;
    }

    public Collection<Competencia> getCompetenciaCollection() {
        return competenciaCollection;
    }

    public void setCompetenciaCollection(Collection<Competencia> competenciaCollection) {
        this.competenciaCollection = competenciaCollection;
    }

    public Collection<ListaChequeo> getListaChequeoCollection() {
        return listaChequeoCollection;
    }

    public void setListaChequeoCollection(Collection<ListaChequeo> listaChequeoCollection) {
        this.listaChequeoCollection = listaChequeoCollection;
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
        if (!(object instanceof Programa)) {
            return false;
        }
        Programa other = (Programa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.Programa[ id=" + id + " ]";
    }
    
}
