package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the especialidad database table.
 * 
 */
@Entity
@Table(name="especialidad")
@NamedQuery(name="Especialidad.findAll", query="SELECT e FROM Especialidad e")
public class Especialidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=40)
	private String estado;

	@Column(name="nombre_especialidad", nullable=false, length=40)
	private String nombreEspecialidad;

	@Column(name="url_logo", length=400)
	private String urlLogo;

	//bi-directional many-to-one association to EspecialidadInstructor
	@OneToMany(mappedBy="especialidad")
	private List<EspecialidadInstructor> especialidadInstructors;

	public Especialidad() {
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

	public String getNombreEspecialidad() {
		return this.nombreEspecialidad;
	}

	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.nombreEspecialidad = nombreEspecialidad;
	}

	public String getUrlLogo() {
		return this.urlLogo;
	}

	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}

	public List<EspecialidadInstructor> getEspecialidadInstructors() {
		return this.especialidadInstructors;
	}

	public void setEspecialidadInstructors(List<EspecialidadInstructor> especialidadInstructors) {
		this.especialidadInstructors = especialidadInstructors;
	}

	public EspecialidadInstructor addEspecialidadInstructor(EspecialidadInstructor especialidadInstructor) {
		getEspecialidadInstructors().add(especialidadInstructor);
		especialidadInstructor.setEspecialidad(this);

		return especialidadInstructor;
	}

	public EspecialidadInstructor removeEspecialidadInstructor(EspecialidadInstructor especialidadInstructor) {
		getEspecialidadInstructors().remove(especialidadInstructor);
		especialidadInstructor.setEspecialidad(null);

		return especialidadInstructor;
	}

}