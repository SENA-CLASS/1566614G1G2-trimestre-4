package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vinculacion database table.
 * 
 */
@Entity
@Table(name="vinculacion")
@NamedQuery(name="Vinculacion.findAll", query="SELECT v FROM Vinculacion v")
public class Vinculacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=40)
	private String estado;

	@Column(nullable=false)
	private int horas;

	@Column(name="tipo_vinculacion", nullable=false, length=40)
	private String tipoVinculacion;

	//bi-directional many-to-one association to Instructor
	@OneToMany(mappedBy="vinculacion")
	private List<Instructor> instructors;

	public Vinculacion() {
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

	public int getHoras() {
		return this.horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public String getTipoVinculacion() {
		return this.tipoVinculacion;
	}

	public void setTipoVinculacion(String tipoVinculacion) {
		this.tipoVinculacion = tipoVinculacion;
	}

	public List<Instructor> getInstructors() {
		return this.instructors;
	}

	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}

	public Instructor addInstructor(Instructor instructor) {
		getInstructors().add(instructor);
		instructor.setVinculacion(this);

		return instructor;
	}

	public Instructor removeInstructor(Instructor instructor) {
		getInstructors().remove(instructor);
		instructor.setVinculacion(null);

		return instructor;
	}

}