package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the limitacion_ambiente database table.
 * 
 */
@Entity
@Table(name="limitacion_ambiente")
@NamedQuery(name="LimitacionAmbiente.findAll", query="SELECT l FROM LimitacionAmbiente l")
public class LimitacionAmbiente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to Ambiente
	@ManyToOne
	@JoinColumn(name="id_ambiente", nullable=false)
	private Ambiente ambiente;

	//bi-directional many-to-one association to ResultadoAprendizaje
	@ManyToOne
	@JoinColumn(name="id_resultado_aprendizaje", nullable=false)
	private ResultadoAprendizaje resultadoAprendizaje;

	public LimitacionAmbiente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ambiente getAmbiente() {
		return this.ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public ResultadoAprendizaje getResultadoAprendizaje() {
		return this.resultadoAprendizaje;
	}

	public void setResultadoAprendizaje(ResultadoAprendizaje resultadoAprendizaje) {
		this.resultadoAprendizaje = resultadoAprendizaje;
	}

}