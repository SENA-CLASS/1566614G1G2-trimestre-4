package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the observacion_general database table.
 * 
 */
@Entity
@Table(name="observacion_general")
@NamedQuery(name="ObservacionGeneral.findAll", query="SELECT o FROM ObservacionGeneral o")
public class ObservacionGeneral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date fecha;

	@Column(name="id_observacion", nullable=false)
	private int idObservacion;

	@Column(nullable=false, length=500)
	private String jurado;

	@Column(nullable=false, length=500)
	private String observacion;

	//bi-directional many-to-one association to GrupoProyecto
	@ManyToOne
	@JoinColumn(name="id_grupo_proyecto", nullable=false)
	private GrupoProyecto grupoProyecto;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario", nullable=false)
	private Usuario usuario;

	public ObservacionGeneral() {
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

	public int getIdObservacion() {
		return this.idObservacion;
	}

	public void setIdObservacion(int idObservacion) {
		this.idObservacion = idObservacion;
	}

	public String getJurado() {
		return this.jurado;
	}

	public void setJurado(String jurado) {
		this.jurado = jurado;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public GrupoProyecto getGrupoProyecto() {
		return this.grupoProyecto;
	}

	public void setGrupoProyecto(GrupoProyecto grupoProyecto) {
		this.grupoProyecto = grupoProyecto;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}