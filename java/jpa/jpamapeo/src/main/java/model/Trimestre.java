package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the trimestre database table.
 * 
 */
@Entity
@Table(name="trimestre")
@NamedQuery(name="Trimestre.findAll", query="SELECT t FROM Trimestre t")
public class Trimestre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="nombre_trimestre", nullable=false, length=40)
	private String nombreTrimestre;

	//bi-directional many-to-one association to FichaHasTrimestre
	@OneToMany(mappedBy="trimestre")
	private List<FichaHasTrimestre> fichaHasTrimestres;

	//bi-directional many-to-one association to PlaneacionTrimestre
	@OneToMany(mappedBy="trimestre")
	private List<PlaneacionTrimestre> planeacionTrimestres;

	//bi-directional many-to-one association to Jornada
	@ManyToOne
	@JoinColumn(name="id_jornada", nullable=false)
	private Jornada jornada;

	//bi-directional many-to-one association to NivelFormacion
	@ManyToOne
	@JoinColumn(name="id_nivel_formacion", nullable=false)
	private NivelFormacion nivelFormacion;

	public Trimestre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreTrimestre() {
		return this.nombreTrimestre;
	}

	public void setNombreTrimestre(String nombreTrimestre) {
		this.nombreTrimestre = nombreTrimestre;
	}

	public List<FichaHasTrimestre> getFichaHasTrimestres() {
		return this.fichaHasTrimestres;
	}

	public void setFichaHasTrimestres(List<FichaHasTrimestre> fichaHasTrimestres) {
		this.fichaHasTrimestres = fichaHasTrimestres;
	}

	public FichaHasTrimestre addFichaHasTrimestre(FichaHasTrimestre fichaHasTrimestre) {
		getFichaHasTrimestres().add(fichaHasTrimestre);
		fichaHasTrimestre.setTrimestre(this);

		return fichaHasTrimestre;
	}

	public FichaHasTrimestre removeFichaHasTrimestre(FichaHasTrimestre fichaHasTrimestre) {
		getFichaHasTrimestres().remove(fichaHasTrimestre);
		fichaHasTrimestre.setTrimestre(null);

		return fichaHasTrimestre;
	}

	public List<PlaneacionTrimestre> getPlaneacionTrimestres() {
		return this.planeacionTrimestres;
	}

	public void setPlaneacionTrimestres(List<PlaneacionTrimestre> planeacionTrimestres) {
		this.planeacionTrimestres = planeacionTrimestres;
	}

	public PlaneacionTrimestre addPlaneacionTrimestre(PlaneacionTrimestre planeacionTrimestre) {
		getPlaneacionTrimestres().add(planeacionTrimestre);
		planeacionTrimestre.setTrimestre(this);

		return planeacionTrimestre;
	}

	public PlaneacionTrimestre removePlaneacionTrimestre(PlaneacionTrimestre planeacionTrimestre) {
		getPlaneacionTrimestres().remove(planeacionTrimestre);
		planeacionTrimestre.setTrimestre(null);

		return planeacionTrimestre;
	}

	public Jornada getJornada() {
		return this.jornada;
	}

	public void setJornada(Jornada jornada) {
		this.jornada = jornada;
	}

	public NivelFormacion getNivelFormacion() {
		return this.nivelFormacion;
	}

	public void setNivelFormacion(NivelFormacion nivelFormacion) {
		this.nivelFormacion = nivelFormacion;
	}

}