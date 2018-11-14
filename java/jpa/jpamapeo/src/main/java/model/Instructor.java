package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the instructor database table.
 * 
 */
@Entity
@Table(name="instructor")
@NamedQuery(name="Instructor.findAll", query="SELECT i FROM Instructor i")
public class Instructor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to DisponibilidadHoraria
	@OneToMany(mappedBy="instructor")
	private List<DisponibilidadHoraria> disponibilidadHorarias;

	//bi-directional many-to-one association to DisponibilidadResultado
	@OneToMany(mappedBy="instructor")
	private List<DisponibilidadResultado> disponibilidadResultados;

	//bi-directional many-to-one association to EspecialidadInstructor
	@OneToMany(mappedBy="instructor")
	private List<EspecialidadInstructor> especialidadInstructors;

	//bi-directional many-to-one association to Horario
	@OneToMany(mappedBy="instructor")
	private List<Horario> horarios;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente", nullable=false)
	private Cliente cliente;

	//bi-directional many-to-one association to Vinculacion
	@ManyToOne
	@JoinColumn(name="id_vinculacion", nullable=false)
	private Vinculacion vinculacion;

	public Instructor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<DisponibilidadHoraria> getDisponibilidadHorarias() {
		return this.disponibilidadHorarias;
	}

	public void setDisponibilidadHorarias(List<DisponibilidadHoraria> disponibilidadHorarias) {
		this.disponibilidadHorarias = disponibilidadHorarias;
	}

	public DisponibilidadHoraria addDisponibilidadHoraria(DisponibilidadHoraria disponibilidadHoraria) {
		getDisponibilidadHorarias().add(disponibilidadHoraria);
		disponibilidadHoraria.setInstructor(this);

		return disponibilidadHoraria;
	}

	public DisponibilidadHoraria removeDisponibilidadHoraria(DisponibilidadHoraria disponibilidadHoraria) {
		getDisponibilidadHorarias().remove(disponibilidadHoraria);
		disponibilidadHoraria.setInstructor(null);

		return disponibilidadHoraria;
	}

	public List<DisponibilidadResultado> getDisponibilidadResultados() {
		return this.disponibilidadResultados;
	}

	public void setDisponibilidadResultados(List<DisponibilidadResultado> disponibilidadResultados) {
		this.disponibilidadResultados = disponibilidadResultados;
	}

	public DisponibilidadResultado addDisponibilidadResultado(DisponibilidadResultado disponibilidadResultado) {
		getDisponibilidadResultados().add(disponibilidadResultado);
		disponibilidadResultado.setInstructor(this);

		return disponibilidadResultado;
	}

	public DisponibilidadResultado removeDisponibilidadResultado(DisponibilidadResultado disponibilidadResultado) {
		getDisponibilidadResultados().remove(disponibilidadResultado);
		disponibilidadResultado.setInstructor(null);

		return disponibilidadResultado;
	}

	public List<EspecialidadInstructor> getEspecialidadInstructors() {
		return this.especialidadInstructors;
	}

	public void setEspecialidadInstructors(List<EspecialidadInstructor> especialidadInstructors) {
		this.especialidadInstructors = especialidadInstructors;
	}

	public EspecialidadInstructor addEspecialidadInstructor(EspecialidadInstructor especialidadInstructor) {
		getEspecialidadInstructors().add(especialidadInstructor);
		especialidadInstructor.setInstructor(this);

		return especialidadInstructor;
	}

	public EspecialidadInstructor removeEspecialidadInstructor(EspecialidadInstructor especialidadInstructor) {
		getEspecialidadInstructors().remove(especialidadInstructor);
		especialidadInstructor.setInstructor(null);

		return especialidadInstructor;
	}

	public List<Horario> getHorarios() {
		return this.horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public Horario addHorario(Horario horario) {
		getHorarios().add(horario);
		horario.setInstructor(this);

		return horario;
	}

	public Horario removeHorario(Horario horario) {
		getHorarios().remove(horario);
		horario.setInstructor(null);

		return horario;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vinculacion getVinculacion() {
		return this.vinculacion;
	}

	public void setVinculacion(Vinculacion vinculacion) {
		this.vinculacion = vinculacion;
	}

}