package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the resultados_vistos database table.
 * 
 */
@Entity
@Table(name="resultados_vistos")
@NamedQuery(name="ResultadosVisto.findAll", query="SELECT r FROM ResultadosVisto r")
public class ResultadosVisto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to FichaHasTrimestre
	@ManyToOne
	@JoinColumn(name="id_ficha_has_trimestre", nullable=false)
	private FichaHasTrimestre fichaHasTrimestre;

	//bi-directional many-to-one association to ResultadoAprendizaje
	@ManyToOne
	@JoinColumn(name="id_resultado_aprendizaje", nullable=false)
	private ResultadoAprendizaje resultadoAprendizaje;

	public ResultadosVisto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FichaHasTrimestre getFichaHasTrimestre() {
		return this.fichaHasTrimestre;
	}

	public void setFichaHasTrimestre(FichaHasTrimestre fichaHasTrimestre) {
		this.fichaHasTrimestre = fichaHasTrimestre;
	}

	public ResultadoAprendizaje getResultadoAprendizaje() {
		return this.resultadoAprendizaje;
	}

	public void setResultadoAprendizaje(ResultadoAprendizaje resultadoAprendizaje) {
		this.resultadoAprendizaje = resultadoAprendizaje;
	}

}