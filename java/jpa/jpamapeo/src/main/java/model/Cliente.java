package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="numero_documento", nullable=false, length=50)
	private String numeroDocumento;

	@Column(name="primer_apellido", nullable=false, length=50)
	private String primerApellido;

	@Column(name="primer_nombre", nullable=false, length=50)
	private String primerNombre;

	@Column(name="segundo_apellido", length=50)
	private String segundoApellido;

	@Column(name="segundo_nombre", length=50)
	private String segundoNombre;

	//bi-directional many-to-one association to Aprendiz
	@OneToMany(mappedBy="cliente")
	private List<Aprendiz> aprendizs;

	//bi-directional many-to-one association to TipoDocumento
	@ManyToOne
	@JoinColumn(name="id_tipo_documento", nullable=false)
	private TipoDocumento tipoDocumento;

	//bi-directional many-to-one association to ClienteHasRol
	@OneToMany(mappedBy="cliente")
	private List<ClienteHasRol> clienteHasRols;

	//bi-directional many-to-one association to Instructor
	@OneToMany(mappedBy="cliente")
	private List<Instructor> instructors;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="cliente")
	private List<Usuario> usuarios;

	public Cliente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public List<Aprendiz> getAprendizs() {
		return this.aprendizs;
	}

	public void setAprendizs(List<Aprendiz> aprendizs) {
		this.aprendizs = aprendizs;
	}

	public Aprendiz addAprendiz(Aprendiz aprendiz) {
		getAprendizs().add(aprendiz);
		aprendiz.setCliente(this);

		return aprendiz;
	}

	public Aprendiz removeAprendiz(Aprendiz aprendiz) {
		getAprendizs().remove(aprendiz);
		aprendiz.setCliente(null);

		return aprendiz;
	}

	public TipoDocumento getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public List<ClienteHasRol> getClienteHasRols() {
		return this.clienteHasRols;
	}

	public void setClienteHasRols(List<ClienteHasRol> clienteHasRols) {
		this.clienteHasRols = clienteHasRols;
	}

	public ClienteHasRol addClienteHasRol(ClienteHasRol clienteHasRol) {
		getClienteHasRols().add(clienteHasRol);
		clienteHasRol.setCliente(this);

		return clienteHasRol;
	}

	public ClienteHasRol removeClienteHasRol(ClienteHasRol clienteHasRol) {
		getClienteHasRols().remove(clienteHasRol);
		clienteHasRol.setCliente(null);

		return clienteHasRol;
	}

	public List<Instructor> getInstructors() {
		return this.instructors;
	}

	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}

	public Instructor addInstructor(Instructor instructor) {
		getInstructors().add(instructor);
		instructor.setCliente(this);

		return instructor;
	}

	public Instructor removeInstructor(Instructor instructor) {
		getInstructors().remove(instructor);
		instructor.setCliente(null);

		return instructor;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setCliente(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setCliente(null);

		return usuario;
	}

}