package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lista_chequeo database table.
 * 
 */
@Entity
@Table(name="lista_chequeo")
@NamedQuery(name="ListaChequeo.findAll", query="SELECT l FROM ListaChequeo l")
public class ListaChequeo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private int estado;

	@Column(name="lista_chequeo", nullable=false, length=50)
	private String listaChequeo;

	//bi-directional many-to-one association to ItemLista
	@OneToMany(mappedBy="listaChequeo")
	private List<ItemLista> itemListas;

	//bi-directional many-to-one association to Programa
	@ManyToOne
	@JoinColumn(name="id_programa", nullable=false)
	private Programa programa;

	//bi-directional many-to-one association to ListaFicha
	@OneToMany(mappedBy="listaChequeo")
	private List<ListaFicha> listaFichas;

	public ListaChequeo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getListaChequeo() {
		return this.listaChequeo;
	}

	public void setListaChequeo(String listaChequeo) {
		this.listaChequeo = listaChequeo;
	}

	public List<ItemLista> getItemListas() {
		return this.itemListas;
	}

	public void setItemListas(List<ItemLista> itemListas) {
		this.itemListas = itemListas;
	}

	public ItemLista addItemLista(ItemLista itemLista) {
		getItemListas().add(itemLista);
		itemLista.setListaChequeo(this);

		return itemLista;
	}

	public ItemLista removeItemLista(ItemLista itemLista) {
		getItemListas().remove(itemLista);
		itemLista.setListaChequeo(null);

		return itemLista;
	}

	public Programa getPrograma() {
		return this.programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public List<ListaFicha> getListaFichas() {
		return this.listaFichas;
	}

	public void setListaFichas(List<ListaFicha> listaFichas) {
		this.listaFichas = listaFichas;
	}

	public ListaFicha addListaFicha(ListaFicha listaFicha) {
		getListaFichas().add(listaFicha);
		listaFicha.setListaChequeo(this);

		return listaFicha;
	}

	public ListaFicha removeListaFicha(ListaFicha listaFicha) {
		getListaFichas().remove(listaFicha);
		listaFicha.setListaChequeo(null);

		return listaFicha;
	}

}