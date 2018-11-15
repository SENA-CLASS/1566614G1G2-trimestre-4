/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.odp.model.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "respuesta_grupo")
@NamedQueries({
    @NamedQuery(name = "RespuestaGrupo.findAll", query = "SELECT r FROM RespuestaGrupo r")
    , @NamedQuery(name = "RespuestaGrupo.findByFicha", query = "SELECT r FROM RespuestaGrupo r WHERE r.respuestaGrupoPK.ficha = :ficha")
    , @NamedQuery(name = "RespuestaGrupo.findByGrupoCodigo", query = "SELECT r FROM RespuestaGrupo r WHERE r.respuestaGrupoPK.grupoCodigo = :grupoCodigo")
    , @NamedQuery(name = "RespuestaGrupo.findByListaChequeo", query = "SELECT r FROM RespuestaGrupo r WHERE r.respuestaGrupoPK.listaChequeo = :listaChequeo")
    , @NamedQuery(name = "RespuestaGrupo.findByIdItem", query = "SELECT r FROM RespuestaGrupo r WHERE r.respuestaGrupoPK.idItem = :idItem")
    , @NamedQuery(name = "RespuestaGrupo.findByFecha", query = "SELECT r FROM RespuestaGrupo r WHERE r.fecha = :fecha")})
public class RespuestaGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RespuestaGrupoPK respuestaGrupoPK;
    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "respuestaGrupo", fetch = FetchType.LAZY)
    private Collection<ObservacionItem> observacionItemCollection;
    @JoinColumns({
        @JoinColumn(name = "ficha", referencedColumnName = "numero_ficha", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "grupo_codigo", referencedColumnName = "codigo", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GrupoProyecto grupoProyecto;
    @JoinColumns({
        @JoinColumn(name = "lista_chequeo", referencedColumnName = "lista_chequeo", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "id_item", referencedColumnName = "id_item", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ItemChecker itemChecker;
    @JoinColumn(name = "valoracion_valor", referencedColumnName = "valor", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Valoracion valoracionValor;

    public RespuestaGrupo() {
    }

    public RespuestaGrupo(RespuestaGrupoPK respuestaGrupoPK) {
        this.respuestaGrupoPK = respuestaGrupoPK;
    }

    public RespuestaGrupo(RespuestaGrupoPK respuestaGrupoPK, Date fecha) {
        this.respuestaGrupoPK = respuestaGrupoPK;
        this.fecha = fecha;
    }

    public RespuestaGrupo(String ficha, int grupoCodigo, String listaChequeo, int idItem) {
        this.respuestaGrupoPK = new RespuestaGrupoPK(ficha, grupoCodigo, listaChequeo, idItem);
    }

    public RespuestaGrupoPK getRespuestaGrupoPK() {
        return respuestaGrupoPK;
    }

    public void setRespuestaGrupoPK(RespuestaGrupoPK respuestaGrupoPK) {
        this.respuestaGrupoPK = respuestaGrupoPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Collection<ObservacionItem> getObservacionItemCollection() {
        return observacionItemCollection;
    }

    public void setObservacionItemCollection(Collection<ObservacionItem> observacionItemCollection) {
        this.observacionItemCollection = observacionItemCollection;
    }

    public GrupoProyecto getGrupoProyecto() {
        return grupoProyecto;
    }

    public void setGrupoProyecto(GrupoProyecto grupoProyecto) {
        this.grupoProyecto = grupoProyecto;
    }

    public ItemChecker getItemChecker() {
        return itemChecker;
    }

    public void setItemChecker(ItemChecker itemChecker) {
        this.itemChecker = itemChecker;
    }

    public Valoracion getValoracionValor() {
        return valoracionValor;
    }

    public void setValoracionValor(Valoracion valoracionValor) {
        this.valoracionValor = valoracionValor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (respuestaGrupoPK != null ? respuestaGrupoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RespuestaGrupo)) {
            return false;
        }
        RespuestaGrupo other = (RespuestaGrupo) object;
        if ((this.respuestaGrupoPK == null && other.respuestaGrupoPK != null) || (this.respuestaGrupoPK != null && !this.respuestaGrupoPK.equals(other.respuestaGrupoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.RespuestaGrupo[ respuestaGrupoPK=" + respuestaGrupoPK + " ]";
    }
    
}
