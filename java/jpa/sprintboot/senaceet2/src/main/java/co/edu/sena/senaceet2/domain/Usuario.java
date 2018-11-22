/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.senaceet2.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "usuario", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_cliente"}),
    @UniqueConstraint(columnNames = {"correo"})})
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
    //@Temporal(TemporalType.DATE)
    private LocalDate fechaTerminacion;
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

    public Usuario(Integer id, String correo, String password, LocalDate fechaTerminacion) {
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

    public LocalDate getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setFechaTerminacion(LocalDate fechaTerminacion) {
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
