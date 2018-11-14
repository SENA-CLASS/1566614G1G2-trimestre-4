package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the planeacion database table.
 * 
 */
@Entity
@Table(name="planeacion")
@NamedQuery(name="Planeacion.findAll", query="SELECT p FROM Planeacion p")
public class Planeacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="codigo_planeacion", nullable=false, length=50)
	private String codigoPlaneacion;

	@Column(nullable=false, length=40)
	private String estado;

	//bi-directional many-to-one association to PlaneacionTrimestre
	@OneToMany(mappedBy="planeacion")
	private List<PlaneacionTrimestre> planeacionTrimestres;

	public Planeacion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigoPlaneacion() {
		return this.codigoPlaneacion;
	}

	public void setCodigoPlaneacion(String codigoPlaneacion) {
		this.codigoPlaneacion = codigoPlaneacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<PlaneacionTrimestre> getPlaneacionTrimestres() {
		return this.planeacionTrimestres;
	}

	public void setPlaneacionTrimestres(List<PlaneacionTrimestre> planeacionTrimestres) {
		this.planeacionTrimestres = planeacionTrimestres;
	}

	public PlaneacionTrimestre addPlaneacionTrimestre(PlaneacionTrimestre planeacionTrimestre) {
		getPlaneacionTrimestres().add(planeacionTrimestre);
		planeacionTrimestre.setPlaneacion(this);

		return planeacionTrimestre;
	}

	public PlaneacionTrimestre removePlaneacionTrimestre(PlaneacionTrimestre planeacionTrimestre) {
		getPlaneacionTrimestres().remove(planeacionTrimestre);
		planeacionTrimestre.setPlaneacion(null);

		return planeacionTrimestre;
	}

}