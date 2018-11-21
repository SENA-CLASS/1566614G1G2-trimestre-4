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
@Table(name = "aprendiz", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_cliente", "id_ficha", "id_estado_formacion"})})
@NamedQueries({
    @NamedQuery(name = "Aprendiz.findAll", query = "SELECT a FROM Aprendiz a")})
public class Aprendiz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAprendiz", fetch = FetchType.LAZY)
    private Collection<IntegrantesGrupo> integrantesGrupoCollection;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente idCliente;
    @JoinColumn(name = "id_estado_formacion", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoFormacion idEstadoFormacion;
    @JoinColumn(name = "id_ficha", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ficha idFicha;

    public Aprendiz() {
    }

    public Aprendiz(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<IntegrantesGrupo> getIntegrantesGrupoCollection() {
        return integrantesGrupoCollection;
    }

    public void setIntegrantesGrupoCollection(Collection<IntegrantesGrupo> integrantesGrupoCollection) {
        this.integrantesGrupoCollection = integrantesGrupoCollection;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public EstadoFormacion getIdEstadoFormacion() {
        return idEstadoFormacion;
    }

    public void setIdEstadoFormacion(EstadoFormacion idEstadoFormacion) {
        this.idEstadoFormacion = idEstadoFormacion;
    }

    public Ficha getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(Ficha idFicha) {
        this.idFicha = idFicha;
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
        if (!(object instanceof Aprendiz)) {
            return false;
        }
        Aprendiz other = (Aprendiz) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.Aprendiz[ id=" + id + " ]";
    }
    
}
