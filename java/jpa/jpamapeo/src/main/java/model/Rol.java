package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@Table(name="rol")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=40)
	private String descripcion;

	@Column(nullable=false, length=40)
	private String estado;

	@Column(name="nombre_rol", nullable=false, length=40)
	private String nombreRol;

	//bi-directional many-to-one association to ClienteHasRol
	@OneToMany(mappedBy="rol")
	private List<ClienteHasRol> clienteHasRols;

	public Rol() {
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

	public String getNombreRol() {
		return this.nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public List<ClienteHasRol> getClienteHasRols() {
		return this.clienteHasRols;
	}

	public void setClienteHasRols(List<ClienteHasRol> clienteHasRols) {
		this.clienteHasRols = clienteHasRols;
	}

	public ClienteHasRol addClienteHasRol(ClienteHasRol clienteHasRol) {
		getClienteHasRols().add(clienteHasRol);
		clienteHasRol.setRol(this);

		return clienteHasRol;
	}

	public ClienteHasRol removeClienteHasRol(ClienteHasRol clienteHasRol) {
		getClienteHasRols().remove(clienteHasRol);
		clienteHasRol.setRol(null);

		return clienteHasRol;
	}

}