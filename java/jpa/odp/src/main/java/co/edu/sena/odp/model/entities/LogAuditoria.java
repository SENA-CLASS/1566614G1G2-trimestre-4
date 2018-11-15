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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "log_auditoria")
@NamedQueries({
    @NamedQuery(name = "LogAuditoria.findAll", query = "SELECT l FROM LogAuditoria l")
    , @NamedQuery(name = "LogAuditoria.findByIdLog", query = "SELECT l FROM LogAuditoria l WHERE l.idLog = :idLog")
    , @NamedQuery(name = "LogAuditoria.findByLevel", query = "SELECT l FROM LogAuditoria l WHERE l.level = :level")
    , @NamedQuery(name = "LogAuditoria.findByLogName", query = "SELECT l FROM LogAuditoria l WHERE l.logName = :logName")
    , @NamedQuery(name = "LogAuditoria.findByFecha", query = "SELECT l FROM LogAuditoria l WHERE l.fecha = :fecha")
    , @NamedQuery(name = "LogAuditoria.findByUsuario", query = "SELECT l FROM LogAuditoria l WHERE l.usuario = :usuario")})
public class LogAuditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_log", nullable = false)
    private Long idLog;
    @Column(name = "level", length = 15)
    private String level;
    @Column(name = "log_name", length = 256)
    private String logName;
    @Lob
    @Column(name = "mensage", length = 65535)
    private String mensage;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "usuario", length = 100)
    private String usuario;

    public LogAuditoria() {
    }

    public LogAuditoria(Long idLog) {
        this.idLog = idLog;
    }

    public Long getIdLog() {
        return idLog;
    }

    public void setIdLog(Long idLog) {
        this.idLog = idLog;
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

    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLog != null ? idLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogAuditoria)) {
            return false;
        }
        LogAuditoria other = (LogAuditoria) object;
        if ((this.idLog == null && other.idLog != null) || (this.idLog != null && !this.idLog.equals(other.idLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.LogAuditoria[ idLog=" + idLog + " ]";
    }
    
}
