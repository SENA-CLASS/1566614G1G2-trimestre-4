/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.senaceet.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "cliente_has_rol", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_rol", "id_cliente"})})
@NamedQueries({
    @NamedQuery(name = "ClienteHasRol.findAll", query = "SELECT c FROM ClienteHasRol c"),
    @NamedQuery(name = "ClienteHasRol.findById", query = "SELECT c FROM ClienteHasRol c WHERE c.id = :id"),
    @NamedQuery(name = "ClienteHasRol.findByEstado", query = "SELECT c FROM ClienteHasRol c WHERE c.estado = :estado"),
    @NamedQuery(name = "ClienteHasRol.findByFechaTerminacion", query = "SELECT c FROM ClienteHasRol c WHERE c.fechaTerminacion = :fechaTerminacion")})
public class ClienteHasRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 40)
    private String estado;
    @Basic(optional = false)
    @Column(name = "fecha_terminacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaTerminacion;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente idCliente;
    @JoinColumn(name = "id_rol", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Rol idRol;

    public ClienteHasRol() {
    }

    public ClienteHasRol(Integer id) {
        this.id = id;
    }

    public ClienteHasRol(Integer id, String estado, Date fechaTerminacion) {
        this.id = id;
        this.estado = estado;
        this.fechaTerminacion = fechaTerminacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setFechaTerminacion(Date fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
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
        if (!(object instanceof ClienteHasRol)) {
            return false;
        }
        ClienteHasRol other = (ClienteHasRol) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.ClienteHasRol[ id=" + id + " ]";
    }
    
}
