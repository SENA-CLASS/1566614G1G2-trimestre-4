package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dia database table.
 * 
 */
@Entity
@Table(name="dia")
@NamedQuery(name="Dia.findAll", query="SELECT d FROM Dia d")
public class Dia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=40)
	private String estado;

	@Column(name="nombre_dia", nullable=false, length=40)
	private String nombreDia;

	//bi-directional many-to-one association to DisponibilidadHoraria
	@OneToMany(mappedBy="dia")
	private List<DisponibilidadHoraria> disponibilidadHorarias;

	//bi-directional many-to-one association to Horario
	@OneToMany(mappedBy="dia")
	private List<Horario> horarios;

	public Dia() {
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

	public String getNombreDia() {
		return this.nombreDia;
	}

	public void setNombreDia(String nombreDia) {
		this.nombreDia = nombreDia;
	}

	public List<DisponibilidadHoraria> getDisponibilidadHorarias() {
		return this.disponibilidadHorarias;
	}

	public void setDisponibilidadHorarias(List<DisponibilidadHoraria> disponibilidadHorarias) {
		this.disponibilidadHorarias = disponibilidadHorarias;
	}

	public DisponibilidadHoraria addDisponibilidadHoraria(DisponibilidadHoraria disponibilidadHoraria) {
		getDisponibilidadHorarias().add(disponibilidadHoraria);
		disponibilidadHoraria.setDia(this);

		return disponibilidadHoraria;
	}

	public DisponibilidadHoraria removeDisponibilidadHoraria(DisponibilidadHoraria disponibilidadHoraria) {
		getDisponibilidadHorarias().remove(disponibilidadHoraria);
		disponibilidadHoraria.setDia(null);

		return disponibilidadHoraria;
	}

	public List<Horario> getHorarios() {
		return this.horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public Horario addHorario(Horario horario) {
		getHorarios().add(horario);
		horario.setDia(this);

		return horario;
	}

	public Horario removeHorario(Horario horario) {
		getHorarios().remove(horario);
		horario.setDia(null);

		return horario;
	}

}