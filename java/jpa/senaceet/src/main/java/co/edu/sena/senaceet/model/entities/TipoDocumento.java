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
@Table(name = "tipo_documento", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"sigla"})})
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t"),
    @NamedQuery(name = "TipoDocumento.findById", query = "SELECT t FROM TipoDocumento t WHERE t.id = :id"),
    @NamedQuery(name = "TipoDocumento.findBySigla", query = "SELECT t FROM TipoDocumento t WHERE t.sigla = :sigla"),
    @NamedQuery(name = "TipoDocumento.findByNombreDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.nombreDocumento = :nombreDocumento"),
    @NamedQuery(name = "TipoDocumento.findByEstado", query = "SELECT t FROM TipoDocumento t WHERE t.estado = :estado")})
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "sigla", nullable = false, length = 10)
    private String sigla;
    @Basic(optional = false)
    @Column(name = "nombre_documento", nullable = false, length = 100)
    private String nombreDocumento;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 40)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDocumento", fetch = FetchType.LAZY)
    private Collection<Cliente> clienteCollection;

    public TipoDocumento() {
    }

    public TipoDocumento(Integer id) {
        this.id = id;
    }

    public TipoDocumento(Integer id, String sigla, String nombreDocumento, String estado) {
        this.id = id;
        this.sigla = sigla;
        this.nombreDocumento = nombreDocumento;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
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
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.TipoDocumento[ id=" + id + " ]";
    }
    
}
