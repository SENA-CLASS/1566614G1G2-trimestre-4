package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the item_lista database table.
 * 
 */
@Entity
@Table(name="item_lista")
@NamedQuery(name="ItemLista.findAll", query="SELECT i FROM ItemLista i")
public class ItemLista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="numero_item", nullable=false)
	private int numeroItem;

	@Column(nullable=false, length=1000)
	private String pregunta;

	//bi-directional many-to-one association to ListaChequeo
	@ManyToOne
	@JoinColumn(name="id_lista_chequeo", nullable=false)
	private ListaChequeo listaChequeo;

	//bi-directional many-to-one association to ResultadoAprendizaje
	@ManyToOne
	@JoinColumn(name="id_resultado_aprendizaje", nullable=false)
	private ResultadoAprendizaje resultadoAprendizaje;

	//bi-directional many-to-one association to RespuestaGrupo
	@OneToMany(mappedBy="itemLista")
	private List<RespuestaGrupo> respuestaGrupos;

	public ItemLista() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroItem() {
		return this.numeroItem;
	}

	public void setNumeroItem(int numeroItem) {
		this.numeroItem = numeroItem;
	}

	public String getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public ListaChequeo getListaChequeo() {
		return this.listaChequeo;
	}

	public void setListaChequeo(ListaChequeo listaChequeo) {
		this.listaChequeo = listaChequeo;
	}

	public ResultadoAprendizaje getResultadoAprendizaje() {
		return this.resultadoAprendizaje;
	}

	public void setResultadoAprendizaje(ResultadoAprendizaje resultadoAprendizaje) {
		this.resultadoAprendizaje = resultadoAprendizaje;
	}

	public List<RespuestaGrupo> getRespuestaGrupos() {
		return this.respuestaGrupos;
	}

	public void setRespuestaGrupos(List<RespuestaGrupo> respuestaGrupos) {
		this.respuestaGrupos = respuestaGrupos;
	}

	public RespuestaGrupo addRespuestaGrupo(RespuestaGrupo respuestaGrupo) {
		getRespuestaGrupos().add(respuestaGrupo);
		respuestaGrupo.setItemLista(this);

		return respuestaGrupo;
	}

	public RespuestaGrupo removeRespuestaGrupo(RespuestaGrupo respuestaGrupo) {
		getRespuestaGrupos().remove(respuestaGrupo);
		respuestaGrupo.setItemLista(null);

		return respuestaGrupo;
	}

}