package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the horario database table.
 * 
 */
@Entity
@Table(name="horario")
@NamedQuery(name="Horario.findAll", query="SELECT h FROM Horario h")
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="hora_fin", nullable=false)
	private Time horaFin;

	@Column(name="hora_inicio", nullable=false)
	private Time horaInicio;

	//bi-directional many-to-one association to Ambiente
	@ManyToOne
	@JoinColumn(name="id_ambiente", nullable=false)
	private Ambiente ambiente;

	//bi-directional many-to-one association to Dia
	@ManyToOne
	@JoinColumn(name="id_dia", nullable=false)
	private Dia dia;

	//bi-directional many-to-one association to FichaHasTrimestre
	@ManyToOne
	@JoinColumn(name="id_ficha_has_trimestre", nullable=false)
	private FichaHasTrimestre fichaHasTrimestre;

	//bi-directional many-to-one association to Instructor
	@ManyToOne
	@JoinColumn(name="id_instructor", nullable=false)
	private Instructor instructor;

	//bi-directional many-to-one association to Modalidad
	@ManyToOne
	@JoinColumn(name="id_modalidad", nullable=false)
	private Modalidad modalidad;

	//bi-directional many-to-one association to VersionHorario
	@ManyToOne
	@JoinColumn(name="id_version_horario", nullable=false)
	private VersionHorario versionHorario;

	public Horario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Ambiente getAmbiente() {
		return this.ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public Dia getDia() {
		return this.dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public FichaHasTrimestre getFichaHasTrimestre() {
		return this.fichaHasTrimestre;
	}

	public void setFichaHasTrimestre(FichaHasTrimestre fichaHasTrimestre) {
		this.fichaHasTrimestre = fichaHasTrimestre;
	}

	public Instructor getInstructor() {
		return this.instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Modalidad getModalidad() {
		return this.modalidad;
	}

	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}

	public VersionHorario getVersionHorario() {
		return this.versionHorario;
	}

	public void setVersionHorario(VersionHorario versionHorario) {
		this.versionHorario = versionHorario;
	}

}