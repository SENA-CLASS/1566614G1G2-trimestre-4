package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the version_horario database table.
 * 
 */
@Entity
@Table(name="version_horario")
@NamedQuery(name="VersionHorario.findAll", query="SELECT v FROM VersionHorario v")
public class VersionHorario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=40)
	private String estado;

	@Column(name="numero_version", nullable=false, length=40)
	private String numeroVersion;

	//bi-directional many-to-one association to Horario
	@OneToMany(mappedBy="versionHorario")
	private List<Horario> horarios;

	//bi-directional many-to-one association to TrimestreVigente
	@ManyToOne
	@JoinColumn(name="id_trimestre_vigente", nullable=false)
	private TrimestreVigente trimestreVigente;

	public VersionHorario() {
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

	public String getNumeroVersion() {
		return this.numeroVersion;
	}

	public void setNumeroVersion(String numeroVersion) {
		this.numeroVersion = numeroVersion;
	}

	public List<Horario> getHorarios() {
		return this.horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public Horario addHorario(Horario horario) {
		getHorarios().add(horario);
		horario.setVersionHorario(this);

		return horario;
	}

	public Horario removeHorario(Horario horario) {
		getHorarios().remove(horario);
		horario.setVersionHorario(null);

		return horario;
	}

	public TrimestreVigente getTrimestreVigente() {
		return this.trimestreVigente;
	}

	public void setTrimestreVigente(TrimestreVigente trimestreVigente) {
		this.trimestreVigente = trimestreVigente;
	}

}