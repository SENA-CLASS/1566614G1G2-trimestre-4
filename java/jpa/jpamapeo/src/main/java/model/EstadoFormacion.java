package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado_formacion database table.
 * 
 */
@Entity
@Table(name="estado_formacion")
@NamedQuery(name="EstadoFormacion.findAll", query="SELECT e FROM EstadoFormacion e")
public class EstadoFormacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=40)
	private String estado;

	@Column(name="nombre_estado", nullable=false, length=40)
	private String nombreEstado;

	//bi-directional many-to-one association to Aprendiz
	@OneToMany(mappedBy="estadoFormacion")
	private List<Aprendiz> aprendizs;

	public EstadoFormacion() {
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

	public String getNombreEstado() {
		return this.nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public List<Aprendiz> getAprendizs() {
		return this.aprendizs;
	}

	public void setAprendizs(List<Aprendiz> aprendizs) {
		this.aprendizs = aprendizs;
	}

	public Aprendiz addAprendiz(Aprendiz aprendiz) {
		getAprendizs().add(aprendiz);
		aprendiz.setEstadoFormacion(this);

		return aprendiz;
	}

	public Aprendiz removeAprendiz(Aprendiz aprendiz) {
		getAprendizs().remove(aprendiz);
		aprendiz.setEstadoFormacion(null);

		return aprendiz;
	}

}