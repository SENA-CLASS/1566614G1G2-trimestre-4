package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=100)
	private String correo;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_terminacion", nullable=false)
	private Date fechaTerminacion;

	@Column(nullable=false, length=255)
	private String password;

	@Column(name="url_foto", length=255)
	private String urlFoto;

	//bi-directional many-to-one association to LogAuditoria
	@OneToMany(mappedBy="usuario")
	private List<LogAuditoria> logAuditorias;

	//bi-directional many-to-one association to LogErrore
	@OneToMany(mappedBy="usuario")
	private List<LogErrore> logErrores;

	//bi-directional many-to-one association to ObservacionGeneral
	@OneToMany(mappedBy="usuario")
	private List<ObservacionGeneral> observacionGenerals;

	//bi-directional many-to-one association to ObservacionRespuesta
	@OneToMany(mappedBy="usuario")
	private List<ObservacionRespuesta> observacionRespuestas;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente", nullable=false)
	private Cliente cliente;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaTerminacion() {
		return this.fechaTerminacion;
	}

	public void setFechaTerminacion(Date fechaTerminacion) {
		this.fechaTerminacion = fechaTerminacion;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrlFoto() {
		return this.urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public List<LogAuditoria> getLogAuditorias() {
		return this.logAuditorias;
	}

	public void setLogAuditorias(List<LogAuditoria> logAuditorias) {
		this.logAuditorias = logAuditorias;
	}

	public LogAuditoria addLogAuditoria(LogAuditoria logAuditoria) {
		getLogAuditorias().add(logAuditoria);
		logAuditoria.setUsuario(this);

		return logAuditoria;
	}

	public LogAuditoria removeLogAuditoria(LogAuditoria logAuditoria) {
		getLogAuditorias().remove(logAuditoria);
		logAuditoria.setUsuario(null);

		return logAuditoria;
	}

	public List<LogErrore> getLogErrores() {
		return this.logErrores;
	}

	public void setLogErrores(List<LogErrore> logErrores) {
		this.logErrores = logErrores;
	}

	public LogErrore addLogErrore(LogErrore logErrore) {
		getLogErrores().add(logErrore);
		logErrore.setUsuario(this);

		return logErrore;
	}

	public LogErrore removeLogErrore(LogErrore logErrore) {
		getLogErrores().remove(logErrore);
		logErrore.setUsuario(null);

		return logErrore;
	}

	public List<ObservacionGeneral> getObservacionGenerals() {
		return this.observacionGenerals;
	}

	public void setObservacionGenerals(List<ObservacionGeneral> observacionGenerals) {
		this.observacionGenerals = observacionGenerals;
	}

	public ObservacionGeneral addObservacionGeneral(ObservacionGeneral observacionGeneral) {
		getObservacionGenerals().add(observacionGeneral);
		observacionGeneral.setUsuario(this);

		return observacionGeneral;
	}

	public ObservacionGeneral removeObservacionGeneral(ObservacionGeneral observacionGeneral) {
		getObservacionGenerals().remove(observacionGeneral);
		observacionGeneral.setUsuario(null);

		return observacionGeneral;
	}

	public List<ObservacionRespuesta> getObservacionRespuestas() {
		return this.observacionRespuestas;
	}

	public void setObservacionRespuestas(List<ObservacionRespuesta> observacionRespuestas) {
		this.observacionRespuestas = observacionRespuestas;
	}

	public ObservacionRespuesta addObservacionRespuesta(ObservacionRespuesta observacionRespuesta) {
		getObservacionRespuestas().add(observacionRespuesta);
		observacionRespuesta.setUsuario(this);

		return observacionRespuesta;
	}

	public ObservacionRespuesta removeObservacionRespuesta(ObservacionRespuesta observacionRespuesta) {
		getObservacionRespuestas().remove(observacionRespuesta);
		observacionRespuesta.setUsuario(null);

		return observacionRespuesta;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}