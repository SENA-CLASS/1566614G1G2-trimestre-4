package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the competencia database table.
 * 
 */
@Entity
@Table(name="competencia")
@NamedQuery(name="Competencia.findAll", query="SELECT c FROM Competencia c")
public class Competencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="codigo_competencia", nullable=false, length=50)
	private String codigoCompetencia;

	@Column(nullable=false, length=1000)
	private String descripcion;

	//bi-directional many-to-one association to Programa
	@ManyToOne
	@JoinColumn(name="id_programa", nullable=false)
	private Programa programa;

	//bi-directional many-to-one association to ResultadoAprendizaje
	@OneToMany(mappedBy="competencia")
	private List<ResultadoAprendizaje> resultadoAprendizajes;

	public Competencia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigoCompetencia() {
		return this.codigoCompetencia;
	}

	public void setCodigoCompetencia(String codigoCompetencia) {
		this.codigoCompetencia = codigoCompetencia;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Programa getPrograma() {
		return this.programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public List<ResultadoAprendizaje> getResultadoAprendizajes() {
		return this.resultadoAprendizajes;
	}

	public void setResultadoAprendizajes(List<ResultadoAprendizaje> resultadoAprendizajes) {
		this.resultadoAprendizajes = resultadoAprendizajes;
	}

	public ResultadoAprendizaje addResultadoAprendizaje(ResultadoAprendizaje resultadoAprendizaje) {
		getResultadoAprendizajes().add(resultadoAprendizaje);
		resultadoAprendizaje.setCompetencia(this);

		return resultadoAprendizaje;
	}

	public ResultadoAprendizaje removeResultadoAprendizaje(ResultadoAprendizaje resultadoAprendizaje) {
		getResultadoAprendizajes().remove(resultadoAprendizaje);
		resultadoAprendizaje.setCompetencia(null);

		return resultadoAprendizaje;
	}

}