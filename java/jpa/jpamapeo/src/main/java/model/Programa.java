package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the programa database table.
 * 
 */
@Entity
@Table(name="programa")
@NamedQuery(name="Programa.findAll", query="SELECT p FROM Programa p")
public class Programa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=50)
	private String codigo;

	@Column(nullable=false, length=40)
	private String estado;

	@Column(nullable=false, length=500)
	private String nombre;

	@Column(nullable=false, length=40)
	private String sigla;

	@Column(nullable=false, length=40)
	private String version;

	//bi-directional many-to-one association to Competencia
	@OneToMany(mappedBy="programa")
	private List<Competencia> competencias;

	//bi-directional many-to-one association to Ficha
	@OneToMany(mappedBy="programa")
	private List<Ficha> fichas;

	//bi-directional many-to-one association to ListaChequeo
	@OneToMany(mappedBy="programa")
	private List<ListaChequeo> listaChequeos;

	//bi-directional many-to-one association to NivelFormacion
	@ManyToOne
	@JoinColumn(name="id_nivel_formacion", nullable=false)
	private NivelFormacion nivelFormacion;

	public Programa() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<Competencia> getCompetencias() {
		return this.competencias;
	}

	public void setCompetencias(List<Competencia> competencias) {
		this.competencias = competencias;
	}

	public Competencia addCompetencia(Competencia competencia) {
		getCompetencias().add(competencia);
		competencia.setPrograma(this);

		return competencia;
	}

	public Competencia removeCompetencia(Competencia competencia) {
		getCompetencias().remove(competencia);
		competencia.setPrograma(null);

		return competencia;
	}

	public List<Ficha> getFichas() {
		return this.fichas;
	}

	public void setFichas(List<Ficha> fichas) {
		this.fichas = fichas;
	}

	public Ficha addFicha(Ficha ficha) {
		getFichas().add(ficha);
		ficha.setPrograma(this);

		return ficha;
	}

	public Ficha removeFicha(Ficha ficha) {
		getFichas().remove(ficha);
		ficha.setPrograma(null);

		return ficha;
	}

	public List<ListaChequeo> getListaChequeos() {
		return this.listaChequeos;
	}

	public void setListaChequeos(List<ListaChequeo> listaChequeos) {
		this.listaChequeos = listaChequeos;
	}

	public ListaChequeo addListaChequeo(ListaChequeo listaChequeo) {
		getListaChequeos().add(listaChequeo);
		listaChequeo.setPrograma(this);

		return listaChequeo;
	}

	public ListaChequeo removeListaChequeo(ListaChequeo listaChequeo) {
		getListaChequeos().remove(listaChequeo);
		listaChequeo.setPrograma(null);

		return listaChequeo;
	}

	public NivelFormacion getNivelFormacion() {
		return this.nivelFormacion;
	}

	public void setNivelFormacion(NivelFormacion nivelFormacion) {
		this.nivelFormacion = nivelFormacion;
	}

}