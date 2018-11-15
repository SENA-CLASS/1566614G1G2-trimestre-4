/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.odp.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "cliente_has_rol")
@NamedQueries({
    @NamedQuery(name = "ClienteHasRol.findAll", query = "SELECT c FROM ClienteHasRol c")
    , @NamedQuery(name = "ClienteHasRol.findByTipoDocumento", query = "SELECT c FROM ClienteHasRol c WHERE c.clienteHasRolPK.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "ClienteHasRol.findByNumeroDocumento", query = "SELECT c FROM ClienteHasRol c WHERE c.clienteHasRolPK.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "ClienteHasRol.findByRol", query = "SELECT c FROM ClienteHasRol c WHERE c.clienteHasRolPK.rol = :rol")
    , @NamedQuery(name = "ClienteHasRol.findByEstado", query = "SELECT c FROM ClienteHasRol c WHERE c.estado = :estado")
    , @NamedQuery(name = "ClienteHasRol.findByFechaTerminacion", query = "SELECT c FROM ClienteHasRol c WHERE c.fechaTerminacion = :fechaTerminacion")})
public class ClienteHasRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClienteHasRolPK clienteHasRolPK;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false)
    private boolean estado;
    @Basic(optional = false)
    @Column(name = "fecha_terminacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaTerminacion;
    @JoinColumns({
        @JoinColumn(name = "tipo_documento", referencedColumnName = "tipo_documento", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "numero_documento", referencedColumnName = "numero_documento", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente cliente;
    @JoinColumn(name = "rol", referencedColumnName = "id_rol", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Rol rol1;

    public ClienteHasRol() {
    }

    public ClienteHasRol(ClienteHasRolPK clienteHasRolPK) {
        this.clienteHasRolPK = clienteHasRolPK;
    }

    public ClienteHasRol(ClienteHasRolPK clienteHasRolPK, boolean estado, Date fechaTerminacion) {
        this.clienteHasRolPK = clienteHasRolPK;
        this.estado = estado;
        this.fechaTerminacion = fechaTerminacion;
    }

    public ClienteHasRol(String tipoDocumento, String numeroDocumento, String rol) {
        this.clienteHasRolPK = new ClienteHasRolPK(tipoDocumento, numeroDocumento, rol);
    }

    public ClienteHasRolPK getClienteHasRolPK() {
        return clienteHasRolPK;
    }

    public void setClienteHasRolPK(ClienteHasRolPK clienteHasRolPK) {
        this.clienteHasRolPK = clienteHasRolPK;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setFechaTerminacion(Date fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Rol getRol1() {
        return rol1;
    }

    public void setRol1(Rol rol1) {
        this.rol1 = rol1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteHasRolPK != null ? clienteHasRolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteHasRol)) {
            return false;
        }
        ClienteHasRol other = (ClienteHasRol) object;
        if ((this.clienteHasRolPK == null && other.clienteHasRolPK != null) || (this.clienteHasRolPK != null && !this.clienteHasRolPK.equals(other.clienteHasRolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.ClienteHasRol[ clienteHasRolPK=" + clienteHasRolPK + " ]";
    }
    
}
