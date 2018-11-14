package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the especialidad_instructor database table.
 * 
 */
@Entity
@Table(name="especialidad_instructor")
@NamedQuery(name="EspecialidadInstructor.findAll", query="SELECT e FROM EspecialidadInstructor e")
public class EspecialidadInstructor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to Especialidad
	@ManyToOne
	@JoinColumn(name="id_especialidad", nullable=false)
	private Especialidad especialidad;

	//bi-directional many-to-one association to Instructor
	@ManyToOne
	@JoinColumn(name="id_instructor", nullable=false)
	private Instructor instructor;

	public EspecialidadInstructor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Especialidad getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Instructor getInstructor() {
		return this.instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

}