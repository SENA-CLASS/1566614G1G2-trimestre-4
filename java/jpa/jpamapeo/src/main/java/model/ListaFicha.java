package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lista_ficha database table.
 * 
 */
@Entity
@Table(name="lista_ficha")
@NamedQuery(name="ListaFicha.findAll", query="SELECT l FROM ListaFicha l")
public class ListaFicha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to Ficha
	@ManyToOne
	@JoinColumn(name="id_ficha", nullable=false)
	private Ficha ficha;

	//bi-directional many-to-one association to ListaChequeo
	@ManyToOne
	@JoinColumn(name="id_lista_chequeo", nullable=false)
	private ListaChequeo listaChequeo;

	public ListaFicha() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ficha getFicha() {
		return this.ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

	public ListaChequeo getListaChequeo() {
		return this.listaChequeo;
	}

	public void setListaChequeo(ListaChequeo listaChequeo) {
		this.listaChequeo = listaChequeo;
	}

}