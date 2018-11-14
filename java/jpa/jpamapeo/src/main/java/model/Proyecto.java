package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proyecto database table.
 * 
 */
@Entity
@Table(name="proyecto")
@NamedQuery(name="Proyecto.findAll", query="SELECT p FROM Proyecto p")
public class Proyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=40)
	private String codigo;

	@Column(nullable=false, length=40)
	private String estado;

	@Column(nullable=false, length=500)
	private String nombre;

	//bi-directional many-to-one association to Fase
	@OneToMany(mappedBy="proyecto")
	private List<Fase> fases;

	public Proyecto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Fase> getFases() {
		return this.fases;
	}

	public void setFases(List<Fase> fases) {
		this.fases = fases;
	}

	public Fase addFas(Fase fas) {
		getFases().add(fas);
		fas.setProyecto(this);

		return fas;
	}

	public Fase removeFas(Fase fas) {
		getFases().remove(fas);
		fas.setProyecto(null);

		return fas;
	}

}