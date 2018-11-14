package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sede database table.
 * 
 */
@Entity
@Table(name="sede")
@NamedQuery(name="Sede.findAll", query="SELECT s FROM Sede s")
public class Sede implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=400)
	private String direccion;

	@Column(nullable=false, length=40)
	private String estado;

	@Column(name="nombre_sede", nullable=false, length=50)
	private String nombreSede;

	//bi-directional many-to-one association to Ambiente
	@OneToMany(mappedBy="sede")
	private List<Ambiente> ambientes;

	public Sede() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombreSede() {
		return this.nombreSede;
	}

	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}

	public List<Ambiente> getAmbientes() {
		return this.ambientes;
	}

	public void setAmbientes(List<Ambiente> ambientes) {
		this.ambientes = ambientes;
	}

	public Ambiente addAmbiente(Ambiente ambiente) {
		getAmbientes().add(ambiente);
		ambiente.setSede(this);

		return ambiente;
	}

	public Ambiente removeAmbiente(Ambiente ambiente) {
		getAmbientes().remove(ambiente);
		ambiente.setSede(null);

		return ambiente;
	}

}