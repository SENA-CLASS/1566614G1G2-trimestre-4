package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the disponibilidad_resultados database table.
 * 
 */
@Entity
@Table(name="disponibilidad_resultados")
@NamedQuery(name="DisponibilidadResultado.findAll", query="SELECT d FROM DisponibilidadResultado d")
public class DisponibilidadResultado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date anio;

	//bi-directional many-to-one association to Instructor
	@ManyToOne
	@JoinColumn(name="id_instructor", nullable=false)
	private Instructor instructor;

	//bi-directional many-to-one association to ResultadoAprendizaje
	@ManyToOne
	@JoinColumn(name="id_resultado_aprendizaje", nullable=false)
	private ResultadoAprendizaje resultadoAprendizaje;

	public DisponibilidadResultado() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAnio() {
		return this.anio;
	}

	public void setAnio(Date anio) {
		this.anio = anio;
	}

	public Instructor getInstructor() {
		return this.instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public ResultadoAprendizaje getResultadoAprendizaje() {
		return this.resultadoAprendizaje;
	}

	public void setResultadoAprendizaje(ResultadoAprendizaje resultadoAprendizaje) {
		this.resultadoAprendizaje = resultadoAprendizaje;
	}

}