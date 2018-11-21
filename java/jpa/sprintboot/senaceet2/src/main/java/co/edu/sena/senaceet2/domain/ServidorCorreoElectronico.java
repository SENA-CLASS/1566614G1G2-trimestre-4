/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.senaceet2.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "servidor_correo_electronico", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"correo"})})
@NamedQueries({
    @NamedQuery(name = "ServidorCorreoElectronico.findAll", query = "SELECT s FROM ServidorCorreoElectronico s")})
public class ServidorCorreoElectronico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "correo", nullable = false, length = 40)
    private String correo;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 300)
    private String password;
    @Basic(optional = false)
    @Column(name = "smtp_host", nullable = false, length = 40)
    private String smtpHost;
    @Basic(optional = false)
    @Column(name = "smtp_port", nullable = false)
    private int smtpPort;
    @Basic(optional = false)
    @Column(name = "smtop_start_tls_enable", nullable = false)
    private int smtopStartTlsEnable;
    @Basic(optional = false)
    @Column(name = "smtp_authentication", nullable = false)
    private int smtpAuthentication;
    @Basic(optional = false)
    @Column(name = "asunto_mensaje", nullable = false, length = 100)
    private String asuntoMensaje;
    @Basic(optional = false)
    @Column(name = "mensaje", nullable = false, length = 1000)
    private String mensaje;

    public ServidorCorreoElectronico() {
    }

    public ServidorCorreoElectronico(Integer id) {
        this.id = id;
    }

    public ServidorCorreoElectronico(Integer id, String correo, String password, String smtpHost, int smtpPort, int smtopStartTlsEnable, int smtpAuthentication, String asuntoMensaje, String mensaje) {
        this.id = id;
        this.correo = correo;
        this.password = password;
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
        this.smtopStartTlsEnable = smtopStartTlsEnable;
        this.smtpAuthentication = smtpAuthentication;
        this.asuntoMensaje = asuntoMensaje;
        this.mensaje = mensaje;
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

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public int getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(int smtpPort) {
        this.smtpPort = smtpPort;
    }

    public int getSmtopStartTlsEnable() {
        return smtopStartTlsEnable;
    }

    public void setSmtopStartTlsEnable(int smtopStartTlsEnable) {
        this.smtopStartTlsEnable = smtopStartTlsEnable;
    }

    public int getSmtpAuthentication() {
        return smtpAuthentication;
    }

    public void setSmtpAuthentication(int smtpAuthentication) {
        this.smtpAuthentication = smtpAuthentication;
    }

    public String getAsuntoMensaje() {
        return asuntoMensaje;
    }

    public void setAsuntoMensaje(String asuntoMensaje) {
        this.asuntoMensaje = asuntoMensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
        if (!(object instanceof ServidorCorreoElectronico)) {
            return false;
        }
        ServidorCorreoElectronico other = (ServidorCorreoElectronico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.ServidorCorreoElectronico[ id=" + id + " ]";
    }
    
}
