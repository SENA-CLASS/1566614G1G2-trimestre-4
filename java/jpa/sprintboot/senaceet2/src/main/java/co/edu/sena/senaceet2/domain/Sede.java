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
@Table(name = "sede", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre_sede"})})
@NamedQueries({
    @NamedQuery(name = "Sede.findAll", query = "SELECT s FROM Sede s")})
public class Sede implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre_sede", nullable = false, length = 50)
    private String nombreSede;
    @Basic(optional = false)
    @Column(name = "direccion", nullable = false, length = 400)
    private String direccion;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 40)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSede", fetch = FetchType.LAZY)
    private Collection<Ambiente> ambienteCollection;

    public Sede() {
    }

    public Sede(Integer id) {
        this.id = id;
    }

    public Sede(Integer id, String nombreSede, String direccion, String estado) {
        this.id = id;
        this.nombreSede = nombreSede;
        this.direccion = direccion;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Collection<Ambiente> getAmbienteCollection() {
        return ambienteCollection;
    }

    public void setAmbienteCollection(Collection<Ambiente> ambienteCollection) {
        this.ambienteCollection = ambienteCollection;
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
        if (!(object instanceof Sede)) {
            return false;
        }
        Sede other = (Sede) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.Sede[ id=" + id + " ]";
    }
    
}
