package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ambiente database table.
 * 
 */
@Entity
@Table(name="ambiente")
@NamedQuery(name="Ambiente.findAll", query="SELECT a FROM Ambiente a")
public class Ambiente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=1000)
	private String descripcion;

	@Column(nullable=false, length=40)
	private String estado;

	@Column(nullable=false, length=40)
	private String limitacion;

	@Column(name="numero_ambiente", nullable=false, length=50)
	private String numeroAmbiente;

	//bi-directional many-to-one association to Sede
	@ManyToOne
	@JoinColumn(name="id_sede", nullable=false)
	private Sede sede;

	//bi-directional many-to-one association to TipoAmbiente
	@ManyToOne
	@JoinColumn(name="id_tipo_ambiente", nullable=false)
	private TipoAmbiente tipoAmbiente;

	//bi-directional many-to-one association to Horario
	@OneToMany(mappedBy="ambiente")
	private List<Horario> horarios;

	//bi-directional many-to-one association to LimitacionAmbiente
	@OneToMany(mappedBy="ambiente")
	private List<LimitacionAmbiente> limitacionAmbientes;

	public Ambiente() {
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

	public String getLimitacion() {
		return this.limitacion;
	}

	public void setLimitacion(String limitacion) {
		this.limitacion = limitacion;
	}

	public String getNumeroAmbiente() {
		return this.numeroAmbiente;
	}

	public void setNumeroAmbiente(String numeroAmbiente) {
		this.numeroAmbiente = numeroAmbiente;
	}

	public Sede getSede() {
		return this.sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public TipoAmbiente getTipoAmbiente() {
		return this.tipoAmbiente;
	}

	public void setTipoAmbiente(TipoAmbiente tipoAmbiente) {
		this.tipoAmbiente = tipoAmbiente;
	}

	public List<Horario> getHorarios() {
		return this.horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public Horario addHorario(Horario horario) {
		getHorarios().add(horario);
		horario.setAmbiente(this);

		return horario;
	}

	public Horario removeHorario(Horario horario) {
		getHorarios().remove(horario);
		horario.setAmbiente(null);

		return horario;
	}

	public List<LimitacionAmbiente> getLimitacionAmbientes() {
		return this.limitacionAmbientes;
	}

	public void setLimitacionAmbientes(List<LimitacionAmbiente> limitacionAmbientes) {
		this.limitacionAmbientes = limitacionAmbientes;
	}

	public LimitacionAmbiente addLimitacionAmbiente(LimitacionAmbiente limitacionAmbiente) {
		getLimitacionAmbientes().add(limitacionAmbiente);
		limitacionAmbiente.setAmbiente(this);

		return limitacionAmbiente;
	}

	public LimitacionAmbiente removeLimitacionAmbiente(LimitacionAmbiente limitacionAmbiente) {
		getLimitacionAmbientes().remove(limitacionAmbiente);
		limitacionAmbiente.setAmbiente(null);

		return limitacionAmbiente;
	}

}