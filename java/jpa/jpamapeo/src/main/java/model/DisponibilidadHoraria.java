package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the disponibilidad_horaria database table.
 * 
 */
@Entity
@Table(name="disponibilidad_horaria")
@NamedQuery(name="DisponibilidadHoraria.findAll", query="SELECT d FROM DisponibilidadHoraria d")
public class DisponibilidadHoraria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date anio;

	@Column(name="hora_fin", nullable=false)
	private Time horaFin;

	@Column(name="hora_inicio", nullable=false)
	private Time horaInicio;

	//bi-directional many-to-one association to Dia
	@ManyToOne
	@JoinColumn(name="id_dia", nullable=false)
	private Dia dia;

	//bi-directional many-to-one association to Instructor
	@ManyToOne
	@JoinColumn(name="id_instructor", nullable=false)
	private Instructor instructor;

	//bi-directional many-to-one association to Jornada
	@ManyToOne
	@JoinColumn(name="id_jornada", nullable=false)
	private Jornada jornada;

	public DisponibilidadHoraria() {
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

	public Time getHoraFin() {
		return this.horaFin;
	}

	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}

	public Time getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Dia getDia() {
		return this.dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public Instructor getInstructor() {
		return this.instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Jornada getJornada() {
		return this.jornada;
	}

	public void setJornada(Jornada jornada) {
		this.jornada = jornada;
	}

}