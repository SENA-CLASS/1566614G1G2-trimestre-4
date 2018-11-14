package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado_ficha database table.
 * 
 */
@Entity
@Table(name="estado_ficha")
@NamedQuery(name="EstadoFicha.findAll", query="SELECT e FROM EstadoFicha e")
public class EstadoFicha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private byte estado;

	@Column(name="nombre_estado", nullable=false)
	private int nombreEstado;

	//bi-directional many-to-one association to Ficha
	@OneToMany(mappedBy="estadoFicha")
	private List<Ficha> fichas;

	public EstadoFicha() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public int getNombreEstado() {
		return this.nombreEstado;
	}

	public void setNombreEstado(int nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public List<Ficha> getFichas() {
		return this.fichas;
	}

	public void setFichas(List<Ficha> fichas) {
		this.fichas = fichas;
	}

	public Ficha addFicha(Ficha ficha) {
		getFichas().add(ficha);
		ficha.setEstadoFicha(this);

		return ficha;
	}

	public Ficha removeFicha(Ficha ficha) {
		getFichas().remove(ficha);
		ficha.setEstadoFicha(null);

		return ficha;
	}

}