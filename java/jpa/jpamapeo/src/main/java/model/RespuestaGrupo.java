package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the respuesta_grupo database table.
 * 
 */
@Entity
@Table(name="respuesta_grupo")
@NamedQuery(name="RespuestaGrupo.findAll", query="SELECT r FROM RespuestaGrupo r")
public class RespuestaGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private int fecha;

	//bi-directional many-to-one association to ObservacionRespuesta
	@OneToMany(mappedBy="respuestaGrupo")
	private List<ObservacionRespuesta> observacionRespuestas;

	//bi-directional many-to-one association to GrupoProyecto
	@ManyToOne
	@JoinColumn(name="id_grupo_proyecto", nullable=false)
	private GrupoProyecto grupoProyecto;

	//bi-directional many-to-one association to ItemLista
	@ManyToOne
	@JoinColumn(name="id_item_lista", nullable=false)
	private ItemLista itemLista;

	//bi-directional many-to-one association to Valoracion
	@ManyToOne
	@JoinColumn(name="id_valoracion", nullable=false)
	private Valoracion valoracion;

	public RespuestaGrupo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFecha() {
		return this.fecha;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	public List<ObservacionRespuesta> getObservacionRespuestas() {
		return this.observacionRespuestas;
	}

	public void setObservacionRespuestas(List<ObservacionRespuesta> observacionRespuestas) {
		this.observacionRespuestas = observacionRespuestas;
	}

	public ObservacionRespuesta addObservacionRespuesta(ObservacionRespuesta observacionRespuesta) {
		getObservacionRespuestas().add(observacionRespuesta);
		observacionRespuesta.setRespuestaGrupo(this);

		return observacionRespuesta;
	}

	public ObservacionRespuesta removeObservacionRespuesta(ObservacionRespuesta observacionRespuesta) {
		getObservacionRespuestas().remove(observacionRespuesta);
		observacionRespuesta.setRespuestaGrupo(null);

		return observacionRespuesta;
	}

	public GrupoProyecto getGrupoProyecto() {
		return this.grupoProyecto;
	}

	public void setGrupoProyecto(GrupoProyecto grupoProyecto) {
		this.grupoProyecto = grupoProyecto;
	}

	public ItemLista getItemLista() {
		return this.itemLista;
	}

	public void setItemLista(ItemLista itemLista) {
		this.itemLista = itemLista;
	}

	public Valoracion getValoracion() {
		return this.valoracion;
	}

	public void setValoracion(Valoracion valoracion) {
		this.valoracion = valoracion;
	}

}