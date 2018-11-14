package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the grupo_proyecto database table.
 * 
 */
@Entity
@Table(name="grupo_proyecto")
@NamedQuery(name="GrupoProyecto.findAll", query="SELECT g FROM GrupoProyecto g")
public class GrupoProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=40)
	private String estado;

	@Column(name="nombre_proyecto", nullable=false, length=300)
	private String nombreProyecto;

	@Column(name="numero_grupo", nullable=false)
	private int numeroGrupo;

	//bi-directional many-to-one association to Ficha
	@ManyToOne
	@JoinColumn(name="id_ficha", nullable=false)
	private Ficha ficha;

	//bi-directional many-to-one association to IntegrantesGrupo
	@OneToMany(mappedBy="grupoProyecto")
	private List<IntegrantesGrupo> integrantesGrupos;

	//bi-directional many-to-one association to ObservacionGeneral
	@OneToMany(mappedBy="grupoProyecto")
	private List<ObservacionGeneral> observacionGenerals;

	//bi-directional many-to-one association to RespuestaGrupo
	@OneToMany(mappedBy="grupoProyecto")
	private List<RespuestaGrupo> respuestaGrupos;

	public GrupoProyecto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombreProyecto() {
		return this.nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public int getNumeroGrupo() {
		return this.numeroGrupo;
	}

	public void setNumeroGrupo(int numeroGrupo) {
		this.numeroGrupo = numeroGrupo;
	}

	public Ficha getFicha() {
		return this.ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

	public List<IntegrantesGrupo> getIntegrantesGrupos() {
		return this.integrantesGrupos;
	}

	public void setIntegrantesGrupos(List<IntegrantesGrupo> integrantesGrupos) {
		this.integrantesGrupos = integrantesGrupos;
	}

	public IntegrantesGrupo addIntegrantesGrupo(IntegrantesGrupo integrantesGrupo) {
		getIntegrantesGrupos().add(integrantesGrupo);
		integrantesGrupo.setGrupoProyecto(this);

		return integrantesGrupo;
	}

	public IntegrantesGrupo removeIntegrantesGrupo(IntegrantesGrupo integrantesGrupo) {
		getIntegrantesGrupos().remove(integrantesGrupo);
		integrantesGrupo.setGrupoProyecto(null);

		return integrantesGrupo;
	}

	public List<ObservacionGeneral> getObservacionGenerals() {
		return this.observacionGenerals;
	}

	public void setObservacionGenerals(List<ObservacionGeneral> observacionGenerals) {
		this.observacionGenerals = observacionGenerals;
	}

	public ObservacionGeneral addObservacionGeneral(ObservacionGeneral observacionGeneral) {
		getObservacionGenerals().add(observacionGeneral);
		observacionGeneral.setGrupoProyecto(this);

		return observacionGeneral;
	}

	public ObservacionGeneral removeObservacionGeneral(ObservacionGeneral observacionGeneral) {
		getObservacionGenerals().remove(observacionGeneral);
		observacionGeneral.setGrupoProyecto(null);

		return observacionGeneral;
	}

	public List<RespuestaGrupo> getRespuestaGrupos() {
		return this.respuestaGrupos;
	}

	public void setRespuestaGrupos(List<RespuestaGrupo> respuestaGrupos) {
		this.respuestaGrupos = respuestaGrupos;
	}

	public RespuestaGrupo addRespuestaGrupo(RespuestaGrupo respuestaGrupo) {
		getRespuestaGrupos().add(respuestaGrupo);
		respuestaGrupo.setGrupoProyecto(this);

		return respuestaGrupo;
	}

	public RespuestaGrupo removeRespuestaGrupo(RespuestaGrupo respuestaGrupo) {
		getRespuestaGrupos().remove(respuestaGrupo);
		respuestaGrupo.setGrupoProyecto(null);

		return respuestaGrupo;
	}

}