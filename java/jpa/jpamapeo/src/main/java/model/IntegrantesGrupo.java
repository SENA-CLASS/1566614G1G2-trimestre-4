package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the integrantes_grupo database table.
 * 
 */
@Entity
@Table(name="integrantes_grupo")
@NamedQuery(name="IntegrantesGrupo.findAll", query="SELECT i FROM IntegrantesGrupo i")
public class IntegrantesGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to Aprendiz
	@ManyToOne
	@JoinColumn(name="id_aprendiz", nullable=false)
	private Aprendiz aprendiz;

	//bi-directional many-to-one association to GrupoProyecto
	@ManyToOne
	@JoinColumn(name="id_grupo_proyecto", nullable=false)
	private GrupoProyecto grupoProyecto;

	public IntegrantesGrupo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Aprendiz getAprendiz() {
		return this.aprendiz;
	}

	public void setAprendiz(Aprendiz aprendiz) {
		this.aprendiz = aprendiz;
	}

	public GrupoProyecto getGrupoProyecto() {
		return this.grupoProyecto;
	}

	public void setGrupoProyecto(GrupoProyecto grupoProyecto) {
		this.grupoProyecto = grupoProyecto;
	}

}