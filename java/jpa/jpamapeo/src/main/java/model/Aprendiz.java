package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aprendiz database table.
 * 
 */
@Entity
@Table(name="aprendiz")
@NamedQuery(name="Aprendiz.findAll", query="SELECT a FROM Aprendiz a")
public class Aprendiz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente", nullable=false)
	private Cliente cliente;

	//bi-directional many-to-one association to EstadoFormacion
	@ManyToOne
	@JoinColumn(name="id_estado_formacion", nullable=false)
	private EstadoFormacion estadoFormacion;

	//bi-directional many-to-one association to Ficha
	@ManyToOne
	@JoinColumn(name="id_ficha", nullable=false)
	private Ficha ficha;

	//bi-directional many-to-one association to IntegrantesGrupo
	@OneToMany(mappedBy="aprendiz")
	private List<IntegrantesGrupo> integrantesGrupos;

	public Aprendiz() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public EstadoFormacion getEstadoFormacion() {
		return this.estadoFormacion;
	}

	public void setEstadoFormacion(EstadoFormacion estadoFormacion) {
		this.estadoFormacion = estadoFormacion;
	}

	public Ficha getFicha() {
		return this.ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

	public List<IntegrantesGrupo> getIntegrantesGrupos() {
		return this.integrantesGrupos;
	}

	public void setIntegrantesGrupos(List<IntegrantesGrupo> integrantesGrupos) {
		this.integrantesGrupos = integrantesGrupos;
	}

	public IntegrantesGrupo addIntegrantesGrupo(IntegrantesGrupo integrantesGrupo) {
		getIntegrantesGrupos().add(integrantesGrupo);
		integrantesGrupo.setAprendiz(this);

		return integrantesGrupo;
	}

	public IntegrantesGrupo removeIntegrantesGrupo(IntegrantesGrupo integrantesGrupo) {
		getIntegrantesGrupos().remove(integrantesGrupo);
		integrantesGrupo.setAprendiz(null);

		return integrantesGrupo;
	}

}