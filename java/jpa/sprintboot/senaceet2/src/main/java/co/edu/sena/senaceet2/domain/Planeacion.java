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
@Table(name = "planeacion", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"codigo_planeacion"})})
@NamedQueries({
    @NamedQuery(name = "Planeacion.findAll", query = "SELECT p FROM Planeacion p")})
public class Planeacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "codigo_planeacion", nullable = false, length = 50)
    private String codigoPlaneacion;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 40)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlaneacion", fetch = FetchType.LAZY)
    private Collection<PlaneacionTrimestre> planeacionTrimestreCollection;

    public Planeacion() {
    }

    public Planeacion(Integer id) {
        this.id = id;
    }

    public Planeacion(Integer id, String codigoPlaneacion, String estado) {
        this.id = id;
        this.codigoPlaneacion = codigoPlaneacion;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoPlaneacion() {
        return codigoPlaneacion;
    }

    public void setCodigoPlaneacion(String codigoPlaneacion) {
        this.codigoPlaneacion = codigoPlaneacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Collection<PlaneacionTrimestre> getPlaneacionTrimestreCollection() {
        return planeacionTrimestreCollection;
    }

    public void setPlaneacionTrimestreCollection(Collection<PlaneacionTrimestre> planeacionTrimestreCollection) {
        this.planeacionTrimestreCollection = planeacionTrimestreCollection;
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
        if (!(object instanceof Planeacion)) {
            return false;
        }
        Planeacion other = (Planeacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.Planeacion[ id=" + id + " ]";
    }
    
}
