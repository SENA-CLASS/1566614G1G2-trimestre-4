package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nivel_formacion database table.
 * 
 */
@Entity
@Table(name="nivel_formacion")
@NamedQuery(name="NivelFormacion.findAll", query="SELECT n FROM NivelFormacion n")
public class NivelFormacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=40)
	private String estado;

	@Column(nullable=false, length=20)
	private String nivel;

	//bi-directional many-to-one association to Programa
	@OneToMany(mappedBy="nivelFormacion")
	private List<Programa> programas;

	//bi-directional many-to-one association to Trimestre
	@OneToMany(mappedBy="nivelFormacion")
	private List<Trimestre> trimestres;

	public NivelFormacion() {
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

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public List<Programa> getProgramas() {
		return this.programas;
	}

	public void setProgramas(List<Programa> programas) {
		this.programas = programas;
	}

	public Programa addPrograma(Programa programa) {
		getProgramas().add(programa);
		programa.setNivelFormacion(this);

		return programa;
	}

	public Programa removePrograma(Programa programa) {
		getProgramas().remove(programa);
		programa.setNivelFormacion(null);

		return programa;
	}

	public List<Trimestre> getTrimestres() {
		return this.trimestres;
	}

	public void setTrimestres(List<Trimestre> trimestres) {
		this.trimestres = trimestres;
	}

	public Trimestre addTrimestre(Trimestre trimestre) {
		getTrimestres().add(trimestre);
		trimestre.setNivelFormacion(this);

		return trimestre;
	}

	public Trimestre removeTrimestre(Trimestre trimestre) {
		getTrimestres().remove(trimestre);
		trimestre.setNivelFormacion(null);

		return trimestre;
	}

}