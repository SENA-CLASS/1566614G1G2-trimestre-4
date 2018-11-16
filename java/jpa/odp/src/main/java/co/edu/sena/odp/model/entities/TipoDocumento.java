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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "tipo_documento")
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t")
    , @NamedQuery(name = "TipoDocumento.findByDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.documento = :documento")
    , @NamedQuery(name = "TipoDocumento.findByLikeDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.documento LIKE :documento")
    , @NamedQuery(name = "TipoDocumento.findByDescripcion", query = "SELECT t FROM TipoDocumento t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TipoDocumento.findByLikeDescripcion", query = "SELECT t FROM TipoDocumento t WHERE t.descripcion LIKE :descripcion")
    , @NamedQuery(name = "TipoDocumento.findByEstado", query = "SELECT t FROM TipoDocumento t WHERE t.estado = :estado")
    , @NamedQuery(name = "TipoDocumento.updatePimaryKey", query = "UPDATE TipoDocumento t SET t.documento = :documentoNuevo WHERE t.documento = :documentoViejo")})
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "documento", nullable = false, length = 50)
    private String documento;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false)
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumento1", fetch = FetchType.LAZY)
    private Collection<Cliente> clienteCollection;

    public TipoDocumento() {
    }

    public TipoDocumento(String documento) {
        this.documento = documento;
    }

    public TipoDocumento(String documento, String descripcion, boolean estado) {
        this.documento = documento;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
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
        hash += (documento != null ? documento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.documento == null && other.documento != null) || (this.documento != null && !this.documento.equals(other.documento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.TipoDocumento[ documento=" + documento + " ]";
    }
    
}
