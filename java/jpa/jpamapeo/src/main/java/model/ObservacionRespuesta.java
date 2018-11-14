package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the observacion_respuesta database table.
 * 
 */
@Entity
@Table(name="observacion_respuesta")
@NamedQuery(name="ObservacionRespuesta.findAll", query="SELECT o FROM ObservacionRespuesta o")
public class ObservacionRespuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date fecha;

	@Column(nullable=false, length=255)
	private String jurados;

	@Column(name="numero_observacion", nullable=false)
	private int numeroObservacion;

	@Column(nullable=false, length=255)
	private String obsevacion;

	//bi-directional many-to-one association to RespuestaGrupo
	@ManyToOne
	@JoinColumn(name="id_respuesta_grupo", nullable=false)
	private RespuestaGrupo respuestaGrupo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario", nullable=false)
	private Usuario usuario;

	public ObservacionRespuesta() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getJurados() {
		return this.jurados;
	}

	public void setJurados(String jurados) {
		this.jurados = jurados;
	}

	public int getNumeroObservacion() {
		return this.numeroObservacion;
	}

	public void setNumeroObservacion(int numeroObservacion) {
		this.numeroObservacion = numeroObservacion;
	}

	public String getObsevacion() {
		return this.obsevacion;
	}

	public void setObsevacion(String obsevacion) {
		this.obsevacion = obsevacion;
	}

	public RespuestaGrupo getRespuestaGrupo() {
		return this.respuestaGrupo;
	}

	public void setRespuestaGrupo(RespuestaGrupo respuestaGrupo) {
		this.respuestaGrupo = respuestaGrupo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}