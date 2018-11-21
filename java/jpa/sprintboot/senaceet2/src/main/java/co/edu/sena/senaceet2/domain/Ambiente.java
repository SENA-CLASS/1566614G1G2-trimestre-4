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
@Table(name = "ambiente", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_sede", "numero_ambiente"})})
@NamedQueries({
    @NamedQuery(name = "Ambiente.findAll", query = "SELECT a FROM Ambiente a")})
public class Ambiente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numero_ambiente", nullable = false, length = 50)
    private String numeroAmbiente;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 1000)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 40)
    private String estado;
    @Basic(optional = false)
    @Column(name = "limitacion", nullable = false, length = 40)
    private String limitacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAmbiente", fetch = FetchType.LAZY)
    private Collection<Horario> horarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAmbiente", fetch = FetchType.LAZY)
    private Collection<LimitacionAmbiente> limitacionAmbienteCollection;
    @JoinColumn(name = "id_sede", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sede idSede;
    @JoinColumn(name = "id_tipo_ambiente", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoAmbiente idTipoAmbiente;

    public Ambiente() {
    }

    public Ambiente(Integer id) {
        this.id = id;
    }

    public Ambiente(Integer id, String numeroAmbiente, String descripcion, String estado, String limitacion) {
        this.id = id;
        this.numeroAmbiente = numeroAmbiente;
        this.descripcion = descripcion;
        this.estado = estado;
        this.limitacion = limitacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroAmbiente() {
        return numeroAmbiente;
    }

    public void setNumeroAmbiente(String numeroAmbiente) {
        this.numeroAmbiente = numeroAmbiente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLimitacion() {
        return limitacion;
    }

    public void setLimitacion(String limitacion) {
        this.limitacion = limitacion;
    }

    public Collection<Horario> getHorarioCollection() {
        return horarioCollection;
    }

    public void setHorarioCollection(Collection<Horario> horarioCollection) {
        this.horarioCollection = horarioCollection;
    }

    public Collection<LimitacionAmbiente> getLimitacionAmbienteCollection() {
        return limitacionAmbienteCollection;
    }

    public void setLimitacionAmbienteCollection(Collection<LimitacionAmbiente> limitacionAmbienteCollection) {
        this.limitacionAmbienteCollection = limitacionAmbienteCollection;
    }

    public Sede getIdSede() {
        return idSede;
    }

    public void setIdSede(Sede idSede) {
        this.idSede = idSede;
    }

    public TipoAmbiente getIdTipoAmbiente() {
        return idTipoAmbiente;
    }

    public void setIdTipoAmbiente(TipoAmbiente idTipoAmbiente) {
        this.idTipoAmbiente = idTipoAmbiente;
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
        if (!(object instanceof Ambiente)) {
            return false;
        }
        Ambiente other = (Ambiente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.Ambiente[ id=" + id + " ]";
    }
    
}
