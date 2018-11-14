package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the servidor_correo_electronico database table.
 * 
 */
@Entity
@Table(name="servidor_correo_electronico")
@NamedQuery(name="ServidorCorreoElectronico.findAll", query="SELECT s FROM ServidorCorreoElectronico s")
public class ServidorCorreoElectronico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="asunto_mensaje", nullable=false, length=100)
	private String asuntoMensaje;

	@Column(nullable=false, length=40)
	private String correo;

	@Column(nullable=false, length=1000)
	private String mensaje;

	@Column(nullable=false, length=300)
	private String password;

	@Column(name="smtop_start_tls_enable", nullable=false)
	private int smtopStartTlsEnable;

	@Column(name="smtp_authentication", nullable=false)
	private int smtpAuthentication;

	@Column(name="smtp_host", nullable=false, length=40)
	private String smtpHost;

	@Column(name="smtp_port", nullable=false)
	private int smtpPort;

	public ServidorCorreoElectronico() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAsuntoMensaje() {
		return this.asuntoMensaje;
	}

	public void setAsuntoMensaje(String asuntoMensaje) {
		this.asuntoMensaje = asuntoMensaje;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSmtopStartTlsEnable() {
		return this.smtopStartTlsEnable;
	}

	public void setSmtopStartTlsEnable(int smtopStartTlsEnable) {
		this.smtopStartTlsEnable = smtopStartTlsEnable;
	}

	public int getSmtpAuthentication() {
		return this.smtpAuthentication;
	}

	public void setSmtpAuthentication(int smtpAuthentication) {
		this.smtpAuthentication = smtpAuthentication;
	}

	public String getSmtpHost() {
		return this.smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public int getSmtpPort() {
		return this.smtpPort;
	}

	public void setSmtpPort(int smtpPort) {
		this.smtpPort = smtpPort;
	}

}