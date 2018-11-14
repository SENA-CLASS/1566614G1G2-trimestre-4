package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the planeacion_trimestre database table.
 * 
 */
@Entity
@Table(name="planeacion_trimestre")
@NamedQuery(name="PlaneacionTrimestre.findAll", query="SELECT p FROM PlaneacionTrimestre p")
public class PlaneacionTrimestre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to ActividadPlaneacion
	@OneToMany(mappedBy="planeacionTrimestre")
	private List<ActividadPlaneacion> actividadPlaneacions;

	//bi-directional many-to-one association to Planeacion
	@ManyToOne
	@JoinColumn(name="id_planeacion", nullable=false)
	private Planeacion planeacion;

	//bi-directional many-to-one association to ResultadoAprendizaje
	@ManyToOne
	@JoinColumn(name="id_resultado_aprendizaje", nullable=false)
	private ResultadoAprendizaje resultadoAprendizaje;

	//bi-directional many-to-one association to Trimestre
	@ManyToOne
	@JoinColumn(name="id_trimestre", nullable=false)
	private Trimestre trimestre;

	public PlaneacionTrimestre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ActividadPlaneacion> getActividadPlaneacions() {
		return this.actividadPlaneacions;
	}

	public void setActividadPlaneacions(List<ActividadPlaneacion> actividadPlaneacions) {
		this.actividadPlaneacions = actividadPlaneacions;
	}

	public ActividadPlaneacion addActividadPlaneacion(ActividadPlaneacion actividadPlaneacion) {
		getActividadPlaneacions().add(actividadPlaneacion);
		actividadPlaneacion.setPlaneacionTrimestre(this);

		return actividadPlaneacion;
	}

	public ActividadPlaneacion removeActividadPlaneacion(ActividadPlaneacion actividadPlaneacion) {
		getActividadPlaneacions().remove(actividadPlaneacion);
		actividadPlaneacion.setPlaneacionTrimestre(null);

		return actividadPlaneacion;
	}

	public Planeacion getPlaneacion() {
		return this.planeacion;
	}

	public void setPlaneacion(Planeacion planeacion) {
		this.planeacion = planeacion;
	}

	public ResultadoAprendizaje getResultadoAprendizaje() {
		return this.resultadoAprendizaje;
	}

	public void setResultadoAprendizaje(ResultadoAprendizaje resultadoAprendizaje) {
		this.resultadoAprendizaje = resultadoAprendizaje;
	}

	public Trimestre getTrimestre() {
		return this.trimestre;
	}

	public void setTrimestre(Trimestre trimestre) {
		this.trimestre = trimestre;
	}

}