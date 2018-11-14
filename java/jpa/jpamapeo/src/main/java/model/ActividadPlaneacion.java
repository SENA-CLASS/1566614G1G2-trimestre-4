package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the actividad_planeacion database table.
 * 
 */
@Entity
@Table(name="actividad_planeacion")
@NamedQuery(name="ActividadPlaneacion.findAll", query="SELECT a FROM ActividadPlaneacion a")
public class ActividadPlaneacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to Actividad
	@ManyToOne
	@JoinColumn(name="id_actividad", nullable=false)
	private Actividad actividad;

	//bi-directional many-to-one association to PlaneacionTrimestre
	@ManyToOne
	@JoinColumn(name="id_planeacion_trimestre", nullable=false)
	private PlaneacionTrimestre planeacionTrimestre;

	public ActividadPlaneacion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Actividad getActividad() {
		return this.actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public PlaneacionTrimestre getPlaneacionTrimestre() {
		return this.planeacionTrimestre;
	}

	public void setPlaneacionTrimestre(PlaneacionTrimestre planeacionTrimestre) {
		this.planeacionTrimestre = planeacionTrimestre;
	}

}