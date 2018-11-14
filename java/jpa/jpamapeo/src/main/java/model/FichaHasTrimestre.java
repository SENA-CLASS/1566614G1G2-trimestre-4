package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ficha_has_trimestre database table.
 * 
 */
@Entity
@Table(name="ficha_has_trimestre")
@NamedQuery(name="FichaHasTrimestre.findAll", query="SELECT f FROM FichaHasTrimestre f")
public class FichaHasTrimestre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to Ficha
	@ManyToOne
	@JoinColumn(name="id_ficha", nullable=false)
	private Ficha ficha;

	//bi-directional many-to-one association to Trimestre
	@ManyToOne
	@JoinColumn(name="id_trimestre", nullable=false)
	private Trimestre trimestre;

	//bi-directional many-to-one association to Horario
	@OneToMany(mappedBy="fichaHasTrimestre")
	private List<Horario> horarios;

	//bi-directional many-to-one association to ResultadosVisto
	@OneToMany(mappedBy="fichaHasTrimestre")
	private List<ResultadosVisto> resultadosVistos;

	public FichaHasTrimestre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ficha getFicha() {
		return this.ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

	public Trimestre getTrimestre() {
		return this.trimestre;
	}

	public void setTrimestre(Trimestre trimestre) {
		this.trimestre = trimestre;
	}

	public List<Horario> getHorarios() {
		return this.horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public Horario addHorario(Horario horario) {
		getHorarios().add(horario);
		horario.setFichaHasTrimestre(this);

		return horario;
	}

	public Horario removeHorario(Horario horario) {
		getHorarios().remove(horario);
		horario.setFichaHasTrimestre(null);

		return horario;
	}

	public List<ResultadosVisto> getResultadosVistos() {
		return this.resultadosVistos;
	}

	public void setResultadosVistos(List<ResultadosVisto> resultadosVistos) {
		this.resultadosVistos = resultadosVistos;
	}

	public ResultadosVisto addResultadosVisto(ResultadosVisto resultadosVisto) {
		getResultadosVistos().add(resultadosVisto);
		resultadosVisto.setFichaHasTrimestre(this);

		return resultadosVisto;
	}

	public ResultadosVisto removeResultadosVisto(ResultadosVisto resultadosVisto) {
		getResultadosVistos().remove(resultadosVisto);
		resultadosVisto.setFichaHasTrimestre(null);

		return resultadosVisto;
	}

}