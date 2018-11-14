package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the valoracion database table.
 * 
 */
@Entity
@Table(name="valoracion")
@NamedQuery(name="Valoracion.findAll", query="SELECT v FROM Valoracion v")
public class Valoracion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=40)
	private String estado;

	@Column(name="tipo_valoracion", nullable=false, length=50)
	private String tipoValoracion;

	//bi-directional many-to-one association to RespuestaGrupo
	@OneToMany(mappedBy="valoracion")
	private List<RespuestaGrupo> respuestaGrupos;

	public Valoracion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipoValoracion() {
		return this.tipoValoracion;
	}

	public void setTipoValoracion(String tipoValoracion) {
		this.tipoValoracion = tipoValoracion;
	}

	public List<RespuestaGrupo> getRespuestaGrupos() {
		return this.respuestaGrupos;
	}

	public void setRespuestaGrupos(List<RespuestaGrupo> respuestaGrupos) {
		this.respuestaGrupos = respuestaGrupos;
	}

	public RespuestaGrupo addRespuestaGrupo(RespuestaGrupo respuestaGrupo) {
		getRespuestaGrupos().add(respuestaGrupo);
		respuestaGrupo.setValoracion(this);

		return respuestaGrupo;
	}

	public RespuestaGrupo removeRespuestaGrupo(RespuestaGrupo respuestaGrupo) {
		getRespuestaGrupos().remove(respuestaGrupo);
		respuestaGrupo.setValoracion(null);

		return respuestaGrupo;
	}

}