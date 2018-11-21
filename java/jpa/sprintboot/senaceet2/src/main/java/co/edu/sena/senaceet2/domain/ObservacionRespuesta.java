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
@Table(name = "observacion_respuesta", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_respuesta_grupo", "numero_observacion"})})
@NamedQueries({
    @NamedQuery(name = "ObservacionRespuesta.findAll", query = "SELECT o FROM ObservacionRespuesta o")})
public class ObservacionRespuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numero_observacion", nullable = false)
    private int numeroObservacion;
    @Basic(optional = false)
    @Column(name = "obsevacion", nullable = false, length = 255)
    private String obsevacion;
    @Basic(optional = false)
    @Column(name = "jurados", nullable = false, length = 255)
    private String jurados;
    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "id_respuesta_grupo", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RespuestaGrupo idRespuestaGrupo;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;

    public ObservacionRespuesta() {
    }

    public ObservacionRespuesta(Integer id) {
        this.id = id;
    }

    public ObservacionRespuesta(Integer id, int numeroObservacion, String obsevacion, String jurados, Date fecha) {
        this.id = id;
        this.numeroObservacion = numeroObservacion;
        this.obsevacion = obsevacion;
        this.jurados = jurados;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumeroObservacion() {
        return numeroObservacion;
    }

    public void setNumeroObservacion(int numeroObservacion) {
        this.numeroObservacion = numeroObservacion;
    }

    public String getObsevacion() {
        return obsevacion;
    }

    public void setObsevacion(String obsevacion) {
        this.obsevacion = obsevacion;
    }

    public String getJurados() {
        return jurados;
    }

    public void setJurados(String jurados) {
        this.jurados = jurados;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public RespuestaGrupo getIdRespuestaGrupo() {
        return idRespuestaGrupo;
    }

    public void setIdRespuestaGrupo(RespuestaGrupo idRespuestaGrupo) {
        this.idRespuestaGrupo = idRespuestaGrupo;
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
        if (!(object instanceof ObservacionRespuesta)) {
            return false;
        }
        ObservacionRespuesta other = (ObservacionRespuesta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.ObservacionRespuesta[ id=" + id + " ]";
    }
    
}
