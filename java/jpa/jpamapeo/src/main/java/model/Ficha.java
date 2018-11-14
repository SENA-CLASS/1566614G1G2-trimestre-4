package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ficha database table.
 * 
 */
@Entity
@Table(name="ficha")
@NamedQuery(name="Ficha.findAll", query="SELECT f FROM Ficha f")
public class Ficha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin", nullable=false)
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio", nullable=false)
	private Date fechaInicio;

	@Column(name="numero_ficha", nullable=false, length=100)
	private String numeroFicha;

	@Column(nullable=false, length=40)
	private String ruta;

	//bi-directional many-to-one association to Aprendiz
	@OneToMany(mappedBy="ficha")
	private List<Aprendiz> aprendizs;

	//bi-directional many-to-one association to EstadoFicha
	@ManyToOne
	@JoinColumn(name="id_estado_ficha", nullable=false)
	private EstadoFicha estadoFicha;

	//bi-directional many-to-one association to Programa
	@ManyToOne
	@JoinColumn(name="id_programa", nullable=false)
	private Programa programa;

	//bi-directional many-to-one association to FichaHasTrimestre
	@OneToMany(mappedBy="ficha")
	private List<FichaHasTrimestre> fichaHasTrimestres;

	//bi-directional many-to-one association to GrupoProyecto
	@OneToMany(mappedBy="ficha")
	private List<GrupoProyecto> grupoProyectos;

	//bi-directional many-to-one association to ListaFicha
	@OneToMany(mappedBy="ficha")
	private List<ListaFicha> listaFichas;

	public Ficha() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getNumeroFicha() {
		return this.numeroFicha;
	}

	public void setNumeroFicha(String numeroFicha) {
		this.numeroFicha = numeroFicha;
	}

	public String getRuta() {
		return this.ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public List<Aprendiz> getAprendizs() {
		return this.aprendizs;
	}

	public void setAprendizs(List<Aprendiz> aprendizs) {
		this.aprendizs = aprendizs;
	}

	public Aprendiz addAprendiz(Aprendiz aprendiz) {
		getAprendizs().add(aprendiz);
		aprendiz.setFicha(this);

		return aprendiz;
	}

	public Aprendiz removeAprendiz(Aprendiz aprendiz) {
		getAprendizs().remove(aprendiz);
		aprendiz.setFicha(null);

		return aprendiz;
	}

	public EstadoFicha getEstadoFicha() {
		return this.estadoFicha;
	}

	public void setEstadoFicha(EstadoFicha estadoFicha) {
		this.estadoFicha = estadoFicha;
	}

	public Programa getPrograma() {
		return this.programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public List<FichaHasTrimestre> getFichaHasTrimestres() {
		return this.fichaHasTrimestres;
	}

	public void setFichaHasTrimestres(List<FichaHasTrimestre> fichaHasTrimestres) {
		this.fichaHasTrimestres = fichaHasTrimestres;
	}

	public FichaHasTrimestre addFichaHasTrimestre(FichaHasTrimestre fichaHasTrimestre) {
		getFichaHasTrimestres().add(fichaHasTrimestre);
		fichaHasTrimestre.setFicha(this);

		return fichaHasTrimestre;
	}

	public FichaHasTrimestre removeFichaHasTrimestre(FichaHasTrimestre fichaHasTrimestre) {
		getFichaHasTrimestres().remove(fichaHasTrimestre);
		fichaHasTrimestre.setFicha(null);

		return fichaHasTrimestre;
	}

	public List<GrupoProyecto> getGrupoProyectos() {
		return this.grupoProyectos;
	}

	public void setGrupoProyectos(List<GrupoProyecto> grupoProyectos) {
		this.grupoProyectos = grupoProyectos;
	}

	public GrupoProyecto addGrupoProyecto(GrupoProyecto grupoProyecto) {
		getGrupoProyectos().add(grupoProyecto);
		grupoProyecto.setFicha(this);

		return grupoProyecto;
	}

	public GrupoProyecto removeGrupoProyecto(GrupoProyecto grupoProyecto) {
		getGrupoProyectos().remove(grupoProyecto);
		grupoProyecto.setFicha(null);

		return grupoProyecto;
	}

	public List<ListaFicha> getListaFichas() {
		return this.listaFichas;
	}

	public void setListaFichas(List<ListaFicha> listaFichas) {
		this.listaFichas = listaFichas;
	}

	public ListaFicha addListaFicha(ListaFicha listaFicha) {
		getListaFichas().add(listaFicha);
		listaFicha.setFicha(this);

		return listaFicha;
	}

	public ListaFicha removeListaFicha(ListaFicha listaFicha) {
		getListaFichas().remove(listaFicha);
		listaFicha.setFicha(null);

		return listaFicha;
	}

}