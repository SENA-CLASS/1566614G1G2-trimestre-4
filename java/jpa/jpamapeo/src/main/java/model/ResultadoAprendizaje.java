package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the resultado_aprendizaje database table.
 * 
 */
@Entity
@Table(name="resultado_aprendizaje")
@NamedQuery(name="ResultadoAprendizaje.findAll", query="SELECT r FROM ResultadoAprendizaje r")
public class ResultadoAprendizaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="codigo_resultado", nullable=false, length=40)
	private String codigoResultado;

	@Column(nullable=false, length=1000)
	private String descripcion;

	//bi-directional many-to-one association to DisponibilidadResultado
	@OneToMany(mappedBy="resultadoAprendizaje")
	private List<DisponibilidadResultado> disponibilidadResultados;

	//bi-directional many-to-one association to ItemLista
	@OneToMany(mappedBy="resultadoAprendizaje")
	private List<ItemLista> itemListas;

	//bi-directional many-to-one association to LimitacionAmbiente
	@OneToMany(mappedBy="resultadoAprendizaje")
	private List<LimitacionAmbiente> limitacionAmbientes;

	//bi-directional many-to-one association to PlaneacionTrimestre
	@OneToMany(mappedBy="resultadoAprendizaje")
	private List<PlaneacionTrimestre> planeacionTrimestres;

	//bi-directional many-to-one association to Competencia
	@ManyToOne
	@JoinColumn(name="id_competencia", nullable=false)
	private Competencia competencia;

	//bi-directional many-to-one association to ResultadosVisto
	@OneToMany(mappedBy="resultadoAprendizaje")
	private List<ResultadosVisto> resultadosVistos;

	public ResultadoAprendizaje() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigoResultado() {
		return this.codigoResultado;
	}

	public void setCodigoResultado(String codigoResultado) {
		this.codigoResultado = codigoResultado;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<DisponibilidadResultado> getDisponibilidadResultados() {
		return this.disponibilidadResultados;
	}

	public void setDisponibilidadResultados(List<DisponibilidadResultado> disponibilidadResultados) {
		this.disponibilidadResultados = disponibilidadResultados;
	}

	public DisponibilidadResultado addDisponibilidadResultado(DisponibilidadResultado disponibilidadResultado) {
		getDisponibilidadResultados().add(disponibilidadResultado);
		disponibilidadResultado.setResultadoAprendizaje(this);

		return disponibilidadResultado;
	}

	public DisponibilidadResultado removeDisponibilidadResultado(DisponibilidadResultado disponibilidadResultado) {
		getDisponibilidadResultados().remove(disponibilidadResultado);
		disponibilidadResultado.setResultadoAprendizaje(null);

		return disponibilidadResultado;
	}

	public List<ItemLista> getItemListas() {
		return this.itemListas;
	}

	public void setItemListas(List<ItemLista> itemListas) {
		this.itemListas = itemListas;
	}

	public ItemLista addItemLista(ItemLista itemLista) {
		getItemListas().add(itemLista);
		itemLista.setResultadoAprendizaje(this);

		return itemLista;
	}

	public ItemLista removeItemLista(ItemLista itemLista) {
		getItemListas().remove(itemLista);
		itemLista.setResultadoAprendizaje(null);

		return itemLista;
	}

	public List<LimitacionAmbiente> getLimitacionAmbientes() {
		return this.limitacionAmbientes;
	}

	public void setLimitacionAmbientes(List<LimitacionAmbiente> limitacionAmbientes) {
		this.limitacionAmbientes = limitacionAmbientes;
	}

	public LimitacionAmbiente addLimitacionAmbiente(LimitacionAmbiente limitacionAmbiente) {
		getLimitacionAmbientes().add(limitacionAmbiente);
		limitacionAmbiente.setResultadoAprendizaje(this);

		return limitacionAmbiente;
	}

	public LimitacionAmbiente removeLimitacionAmbiente(LimitacionAmbiente limitacionAmbiente) {
		getLimitacionAmbientes().remove(limitacionAmbiente);
		limitacionAmbiente.setResultadoAprendizaje(null);

		return limitacionAmbiente;
	}

	public List<PlaneacionTrimestre> getPlaneacionTrimestres() {
		return this.planeacionTrimestres;
	}

	public void setPlaneacionTrimestres(List<PlaneacionTrimestre> planeacionTrimestres) {
		this.planeacionTrimestres = planeacionTrimestres;
	}

	public PlaneacionTrimestre addPlaneacionTrimestre(PlaneacionTrimestre planeacionTrimestre) {
		getPlaneacionTrimestres().add(planeacionTrimestre);
		planeacionTrimestre.setResultadoAprendizaje(this);

		return planeacionTrimestre;
	}

	public PlaneacionTrimestre removePlaneacionTrimestre(PlaneacionTrimestre planeacionTrimestre) {
		getPlaneacionTrimestres().remove(planeacionTrimestre);
		planeacionTrimestre.setResultadoAprendizaje(null);

		return planeacionTrimestre;
	}

	public Competencia getCompetencia() {
		return this.competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}

	public List<ResultadosVisto> getResultadosVistos() {
		return this.resultadosVistos;
	}

	public void setResultadosVistos(List<ResultadosVisto> resultadosVistos) {
		this.resultadosVistos = resultadosVistos;
	}

	public ResultadosVisto addResultadosVisto(ResultadosVisto resultadosVisto) {
		getResultadosVistos().add(resultadosVisto);
		resultadosVisto.setResultadoAprendizaje(this);

		return resultadosVisto;
	}

	public ResultadosVisto removeResultadosVisto(ResultadosVisto resultadosVisto) {
		getResultadosVistos().remove(resultadosVisto);
		resultadosVisto.setResultadoAprendizaje(null);

		return resultadosVisto;
	}

}