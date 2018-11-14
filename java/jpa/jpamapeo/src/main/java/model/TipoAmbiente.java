package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_ambiente database table.
 * 
 */
@Entity
@Table(name="tipo_ambiente")
@NamedQuery(name="TipoAmbiente.findAll", query="SELECT t FROM TipoAmbiente t")
public class TipoAmbiente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=100)
	private String descripcion;

	@Column(nullable=false, length=40)
	private String estado;

	@Column(nullable=false, length=40)
	private String tipo;

	//bi-directional many-to-one association to Ambiente
	@OneToMany(mappedBy="tipoAmbiente")
	private List<Ambiente> ambientes;

	public TipoAmbiente() {
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

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Ambiente> getAmbientes() {
		return this.ambientes;
	}

	public void setAmbientes(List<Ambiente> ambientes) {
		this.ambientes = ambientes;
	}

	public Ambiente addAmbiente(Ambiente ambiente) {
		getAmbientes().add(ambiente);
		ambiente.setTipoAmbiente(this);

		return ambiente;
	}

	public Ambiente removeAmbiente(Ambiente ambiente) {
		getAmbientes().remove(ambiente);
		ambiente.setTipoAmbiente(null);

		return ambiente;
	}

}