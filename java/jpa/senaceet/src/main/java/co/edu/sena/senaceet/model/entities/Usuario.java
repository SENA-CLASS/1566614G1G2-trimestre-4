/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.senaceet.model.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "usuario", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_cliente"}),
    @UniqueConstraint(columnNames = {"correo"})})
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password"),
    @NamedQuery(name = "Usuario.findByFechaTerminacion", query = "SELECT u FROM Usuario u WHERE u.fechaTerminacion = :fechaTerminacion"),
    @NamedQuery(name = "Usuario.findByUrlFoto", query = "SELECT u FROM Usuario u WHERE u.urlFoto = :urlFoto")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "correo", nullable = false, length = 100)
    private String correo;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Basic(optional = false)
    @Column(name = "fecha_terminacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaTerminacion;
    @Column(name = "url_foto", length = 255)
    private String urlFoto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private Collection<ObservacionRespuesta> observacionRespuestaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private Collection<ObservacionGeneral> observacionGeneralCollection;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente idCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private Collection<LogAuditoria> logAuditoriaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private Collection<LogErrores> logErroresCollection;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String correo, String password, Date fechaTerminacion) {
        this.id = id;
        this.correo = correo;
        this.password = password;
        this.fechaTerminacion = fechaTerminacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setFechaTerminacion(Date fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public Collection<ObservacionRespuesta> getObservacionRespuestaCollection() {
        return observacionRespuestaCollection;
    }

    public void setObservacionRespuestaCollection(Collection<ObservacionRespuesta> observacionRespuestaCollection) {
        this.observacionRespuestaCollection = observacionRespuestaCollection;
    }

    public Collection<ObservacionGeneral> getObservacionGeneralCollection() {
        return observacionGeneralCollection;
    }

    public void setObservacionGeneralCollection(Collection<ObservacionGeneral> observacionGeneralCollection) {
        this.observacionGeneralCollection = observacionGeneralCollection;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Collection<LogAuditoria> getLogAuditoriaCollection() {
        return logAuditoriaCollection;
    }

    public void setLogAuditoriaCollection(Collection<LogAuditoria> logAuditoriaCollection) {
        this.logAuditoriaCollection = logAuditoriaCollection;
    }

    public Collection<LogErrores> getLogErroresCollection() {
        return logErroresCollection;
    }

    public void setLogErroresCollection(Collection<LogErrores> logErroresCollection) {
        this.logErroresCollection = logErroresCollection;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.Usuario[ id=" + id + " ]";
    }
    
}
