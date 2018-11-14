package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the actividad database table.
 * 
 */
@Entity
@Table(name="actividad")
@NamedQuery(name="Actividad.findAll", query="SELECT a FROM Actividad a")
public class Actividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="nombre_actividad", nullable=false, length=400)
	private String nombreActividad;

	@Column(name="numero_actividad", nullable=false)
	private int numeroActividad;

	//bi-directional many-to-one association to Fase
	@ManyToOne
	@JoinColumn(name="id_fase", nullable=false)
	private Fase fase;

	//bi-directional many-to-one association to ActividadPlaneacion
	@OneToMany(mappedBy="actividad")
	private List<ActividadPlaneacion> actividadPlaneacions;

	public Actividad() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreActividad() {
		return this.nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public int getNumeroActividad() {
		return this.numeroActividad;
	}

	public void setNumeroActividad(int numeroActividad) {
		this.numeroActividad = numeroActividad;
	}

	public Fase getFase() {
		return this.fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public List<ActividadPlaneacion> getActividadPlaneacions() {
		return this.actividadPlaneacions;
	}

	public void setActividadPlaneacions(List<ActividadPlaneacion> actividadPlaneacions) {
		this.actividadPlaneacions = actividadPlaneacions;
	}

	public ActividadPlaneacion addActividadPlaneacion(ActividadPlaneacion actividadPlaneacion) {
		getActividadPlaneacions().add(actividadPlaneacion);
		actividadPlaneacion.setActividad(this);

		return actividadPlaneacion;
	}

	public ActividadPlaneacion removeActividadPlaneacion(ActividadPlaneacion actividadPlaneacion) {
		getActividadPlaneacions().remove(actividadPlaneacion);
		actividadPlaneacion.setActividad(null);

		return actividadPlaneacion;
	}

}