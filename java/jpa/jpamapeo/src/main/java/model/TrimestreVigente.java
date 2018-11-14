package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the trimestre_vigente database table.
 * 
 */
@Entity
@Table(name="trimestre_vigente")
@NamedQuery(name="TrimestreVigente.findAll", query="SELECT t FROM TrimestreVigente t")
public class TrimestreVigente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date anio;

	@Column(nullable=false, length=40)
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin", nullable=false)
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio", nullable=false)
	private Date fechaInicio;

	@Column(name="trimestre_programado", nullable=false)
	private int trimestreProgramado;

	//bi-directional many-to-one association to VersionHorario
	@OneToMany(mappedBy="trimestreVigente")
	private List<VersionHorario> versionHorarios;

	public TrimestreVigente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAnio() {
		return this.anio;
	}

	public void setAnio(Date anio) {
		this.anio = anio;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getTrimestreProgramado() {
		return this.trimestreProgramado;
	}

	public void setTrimestreProgramado(int trimestreProgramado) {
		this.trimestreProgramado = trimestreProgramado;
	}

	public List<VersionHorario> getVersionHorarios() {
		return this.versionHorarios;
	}

	public void setVersionHorarios(List<VersionHorario> versionHorarios) {
		this.versionHorarios = versionHorarios;
	}

	public VersionHorario addVersionHorario(VersionHorario versionHorario) {
		getVersionHorarios().add(versionHorario);
		versionHorario.setTrimestreVigente(this);

		return versionHorario;
	}

	public VersionHorario removeVersionHorario(VersionHorario versionHorario) {
		getVersionHorarios().remove(versionHorario);
		versionHorario.setTrimestreVigente(null);

		return versionHorario;
	}

}