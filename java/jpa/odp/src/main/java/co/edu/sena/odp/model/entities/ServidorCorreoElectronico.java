/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.odp.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "servidor_correo_electronico")
@NamedQueries({
    @NamedQuery(name = "ServidorCorreoElectronico.findAll", query = "SELECT s FROM ServidorCorreoElectronico s")
    , @NamedQuery(name = "ServidorCorreoElectronico.findByCorreo", query = "SELECT s FROM ServidorCorreoElectronico s WHERE s.correo = :correo")
    , @NamedQuery(name = "ServidorCorreoElectronico.findByContrasenia", query = "SELECT s FROM ServidorCorreoElectronico s WHERE s.contrasenia = :contrasenia")
    , @NamedQuery(name = "ServidorCorreoElectronico.findBySmtpHost", query = "SELECT s FROM ServidorCorreoElectronico s WHERE s.smtpHost = :smtpHost")
    , @NamedQuery(name = "ServidorCorreoElectronico.findBySmtpPort", query = "SELECT s FROM ServidorCorreoElectronico s WHERE s.smtpPort = :smtpPort")
    , @NamedQuery(name = "ServidorCorreoElectronico.findBySmtpStartTlsEnable", query = "SELECT s FROM ServidorCorreoElectronico s WHERE s.smtpStartTlsEnable = :smtpStartTlsEnable")
    , @NamedQuery(name = "ServidorCorreoElectronico.findBySmtpAuth", query = "SELECT s FROM ServidorCorreoElectronico s WHERE s.smtpAuth = :smtpAuth")
    , @NamedQuery(name = "ServidorCorreoElectronico.findByAsuntoRecuperacion", query = "SELECT s FROM ServidorCorreoElectronico s WHERE s.asuntoRecuperacion = :asuntoRecuperacion")
    , @NamedQuery(name = "ServidorCorreoElectronico.findByMensageRecuperacion", query = "SELECT s FROM ServidorCorreoElectronico s WHERE s.mensageRecuperacion = :mensageRecuperacion")})
public class ServidorCorreoElectronico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "correo", nullable = false, length = 100)
    private String correo;
    @Basic(optional = false)
    @Column(name = "contrasenia", nullable = false, length = 64)
    private String contrasenia;
    @Basic(optional = false)
    @Column(name = "smtp_host", nullable = false, length = 60)
    private String smtpHost;
    @Basic(optional = false)
    @Column(name = "smtp_port", nullable = false)
    private int smtpPort;
    @Basic(optional = false)
    @Column(name = "smtp_start_tls_enable", nullable = false)
    private boolean smtpStartTlsEnable;
    @Basic(optional = false)
    @Column(name = "smtp_auth", nullable = false)
    private boolean smtpAuth;
    @Basic(optional = false)
    @Column(name = "asunto_recuperacion", nullable = false, length = 50)
    private String asuntoRecuperacion;
    @Basic(optional = false)
    @Column(name = "mensage_recuperacion", nullable = false, length = 200)
    private String mensageRecuperacion;

    public ServidorCorreoElectronico() {
    }

    public ServidorCorreoElectronico(String correo) {
        this.correo = correo;
    }

    public ServidorCorreoElectronico(String correo, String contrasenia, String smtpHost, int smtpPort, boolean smtpStartTlsEnable, boolean smtpAuth, String asuntoRecuperacion, String mensageRecuperacion) {
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
        this.smtpStartTlsEnable = smtpStartTlsEnable;
        this.smtpAuth = smtpAuth;
        this.asuntoRecuperacion = asuntoRecuperacion;
        this.mensageRecuperacion = mensageRecuperacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
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

    public boolean getSmtpStartTlsEnable() {
        return smtpStartTlsEnable;
    }

    public void setSmtpStartTlsEnable(boolean smtpStartTlsEnable) {
        this.smtpStartTlsEnable = smtpStartTlsEnable;
    }

    public boolean getSmtpAuth() {
        return smtpAuth;
    }

    public void setSmtpAuth(boolean smtpAuth) {
        this.smtpAuth = smtpAuth;
    }

    public String getAsuntoRecuperacion() {
        return asuntoRecuperacion;
    }

    public void setAsuntoRecuperacion(String asuntoRecuperacion) {
        this.asuntoRecuperacion = asuntoRecuperacion;
    }

    public String getMensageRecuperacion() {
        return mensageRecuperacion;
    }

    public void setMensageRecuperacion(String mensageRecuperacion) {
        this.mensageRecuperacion = mensageRecuperacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correo != null ? correo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServidorCorreoElectronico)) {
            return false;
        }
        ServidorCorreoElectronico other = (ServidorCorreoElectronico) object;
        if ((this.correo == null && other.correo != null) || (this.correo != null && !this.correo.equals(other.correo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.ServidorCorreoElectronico[ correo=" + correo + " ]";
    }
    
}
