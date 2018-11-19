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

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "log_errores")
@NamedQueries({
    @NamedQuery(name = "LogErrores.findAll", query = "SELECT l FROM LogErrores l"),
    @NamedQuery(name = "LogErrores.findById", query = "SELECT l FROM LogErrores l WHERE l.id = :id"),
    @NamedQuery(name = "LogErrores.findByLevel", query = "SELECT l FROM LogErrores l WHERE l.level = :level"),
    @NamedQuery(name = "LogErrores.findByLogName", query = "SELECT l FROM LogErrores l WHERE l.logName = :logName"),
    @NamedQuery(name = "LogErrores.findByMensaje", query = "SELECT l FROM LogErrores l WHERE l.mensaje = :mensaje"),
    @NamedQuery(name = "LogErrores.findByFecha", query = "SELECT l FROM LogErrores l WHERE l.fecha = :fecha")})
public class LogErrores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "level", nullable = false, length = 400)
    private String level;
    @Basic(optional = false)
    @Column(name = "log_name", nullable = false, length = 400)
    private String logName;
    @Basic(optional = false)
    @Column(name = "mensaje", nullable = false, length = 400)
    private String mensaje;
    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;

    public LogErrores() {
    }

    public LogErrores(Integer id) {
        this.id = id;
    }

    public LogErrores(Integer id, String level, String logName, String mensaje, Date fecha) {
        this.id = id;
        this.level = level;
        this.logName = logName;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        if (!(object instanceof LogErrores)) {
            return false;
        }
        LogErrores other = (LogErrores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.LogErrores[ id=" + id + " ]";
    }
    
}
