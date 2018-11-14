package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the jornada database table.
 * 
 */
@Entity
@Table(name="jornada")
@NamedQuery(name="Jornada.findAll", query="SELECT j FROM Jornada j")
public class Jornada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=40)
	private String descripcion;

	@Column(nullable=false, length=40)
	private String estado;

	@Column(name="imagen_url", length=400)
	private String imagenUrl;

	@Column(name="nombre_jornada", nullable=false, length=40)
	private String nombreJornada;

	@Column(name="sigla_jornada", nullable=false, length=20)
	private String siglaJornada;

	//bi-directional many-to-one association to DisponibilidadHoraria
	@OneToMany(mappedBy="jornada")
	private List<DisponibilidadHoraria> disponibilidadHorarias;

	//bi-directional many-to-one association to Trimestre
	@OneToMany(mappedBy="jornada")
	private List<Trimestre> trimestres;

	public Jornada() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getImagenUrl() {
		return this.imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

	public String getNombreJornada() {
		return this.nombreJornada;
	}

	public void setNombreJornada(String nombreJornada) {
		this.nombreJornada = nombreJornada;
	}

	public String getSiglaJornada() {
		return this.siglaJornada;
	}

	public void setSiglaJornada(String siglaJornada) {
		this.siglaJornada = siglaJornada;
	}

	public List<DisponibilidadHoraria> getDisponibilidadHorarias() {
		return this.disponibilidadHorarias;
	}

	public void setDisponibilidadHorarias(List<DisponibilidadHoraria> disponibilidadHorarias) {
		this.disponibilidadHorarias = disponibilidadHorarias;
	}

	public DisponibilidadHoraria addDisponibilidadHoraria(DisponibilidadHoraria disponibilidadHoraria) {
		getDisponibilidadHorarias().add(disponibilidadHoraria);
		disponibilidadHoraria.setJornada(this);

		return disponibilidadHoraria;
	}

	public DisponibilidadHoraria removeDisponibilidadHoraria(DisponibilidadHoraria disponibilidadHoraria) {
		getDisponibilidadHorarias().remove(disponibilidadHoraria);
		disponibilidadHoraria.setJornada(null);

		return disponibilidadHoraria;
	}

	public List<Trimestre> getTrimestres() {
		return this.trimestres;
	}

	public void setTrimestres(List<Trimestre> trimestres) {
		this.trimestres = trimestres;
	}

	public Trimestre addTrimestre(Trimestre trimestre) {
		getTrimestres().add(trimestre);
		trimestre.setJornada(this);

		return trimestre;
	}

	public Trimestre removeTrimestre(Trimestre trimestre) {
		getTrimestres().remove(trimestre);
		trimestre.setJornada(null);

		return trimestre;
	}

}