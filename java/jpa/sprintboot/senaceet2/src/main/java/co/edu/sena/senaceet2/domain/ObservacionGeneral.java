/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.senaceet2.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "observacion_general", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_observacion", "id_grupo_proyecto"})})
@NamedQueries({
    @NamedQuery(name = "ObservacionGeneral.findAll", query = "SELECT o FROM ObservacionGeneral o")})
public class ObservacionGeneral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_observacion", nullable = false)
    private int idObservacion;
    @Basic(optional = false)
    @Column(name = "observacion", nullable = false, length = 500)
    private String observacion;
    @Basic(optional = false)
    @Column(name = "jurado", nullable = false, length = 500)
    private String jurado;
    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "id_grupo_proyecto", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GrupoProyecto idGrupoProyecto;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;

    public ObservacionGeneral() {
    }

    public ObservacionGeneral(Integer id) {
        this.id = id;
    }

    public ObservacionGeneral(Integer id, int idObservacion, String observacion, String jurado, Date fecha) {
        this.id = id;
        this.idObservacion = idObservacion;
        this.observacion = observacion;
        this.jurado = jurado;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdObservacion() {
        return idObservacion;
    }

    public void setIdObservacion(int idObservacion) {
        this.idObservacion = idObservacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getJurado() {
        return jurado;
    }

    public void setJurado(String jurado) {
        this.jurado = jurado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public GrupoProyecto getIdGrupoProyecto() {
        return idGrupoProyecto;
    }

    public void setIdGrupoProyecto(GrupoProyecto idGrupoProyecto) {
        this.idGrupoProyecto = idGrupoProyecto;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof ObservacionGeneral)) {
            return false;
        }
        ObservacionGeneral other = (ObservacionGeneral) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.ObservacionGeneral[ id=" + id + " ]";
    }
    
}
