/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.senaceet2.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "respuesta_grupo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_item_lista", "id_grupo_proyecto"})})
@NamedQueries({
    @NamedQuery(name = "RespuestaGrupo.findAll", query = "SELECT r FROM RespuestaGrupo r")})
public class RespuestaGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    private int fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRespuestaGrupo", fetch = FetchType.LAZY)
    private Collection<ObservacionRespuesta> observacionRespuestaCollection;
    @JoinColumn(name = "id_grupo_proyecto", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GrupoProyecto idGrupoProyecto;
    @JoinColumn(name = "id_item_lista", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ItemLista idItemLista;
    @JoinColumn(name = "id_valoracion", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Valoracion idValoracion;

    public RespuestaGrupo() {
    }

    public RespuestaGrupo(Integer id) {
        this.id = id;
    }

    public RespuestaGrupo(Integer id, int fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public Collection<ObservacionRespuesta> getObservacionRespuestaCollection() {
        return observacionRespuestaCollection;
    }

    public void setObservacionRespuestaCollection(Collection<ObservacionRespuesta> observacionRespuestaCollection) {
        this.observacionRespuestaCollection = observacionRespuestaCollection;
    }

    public GrupoProyecto getIdGrupoProyecto() {
        return idGrupoProyecto;
    }

    public void setIdGrupoProyecto(GrupoProyecto idGrupoProyecto) {
        this.idGrupoProyecto = idGrupoProyecto;
    }

    public ItemLista getIdItemLista() {
        return idItemLista;
    }

    public void setIdItemLista(ItemLista idItemLista) {
        this.idItemLista = idItemLista;
    }

    public Valoracion getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(Valoracion idValoracion) {
        this.idValoracion = idValoracion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RespuestaGrupo)) {
            return false;
        }
        RespuestaGrupo other = (RespuestaGrupo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.RespuestaGrupo[ id=" + id + " ]";
    }
    
}
