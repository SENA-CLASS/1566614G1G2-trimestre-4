/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.odp.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "observacion_item")
@NamedQueries({
    @NamedQuery(name = "ObservacionItem.findAll", query = "SELECT o FROM ObservacionItem o")
    , @NamedQuery(name = "ObservacionItem.findByIdObservacion", query = "SELECT o FROM ObservacionItem o WHERE o.observacionItemPK.idObservacion = :idObservacion")
    , @NamedQuery(name = "ObservacionItem.findByNumeroFicha", query = "SELECT o FROM ObservacionItem o WHERE o.observacionItemPK.numeroFicha = :numeroFicha")
    , @NamedQuery(name = "ObservacionItem.findByGrupoCodigo", query = "SELECT o FROM ObservacionItem o WHERE o.observacionItemPK.grupoCodigo = :grupoCodigo")
    , @NamedQuery(name = "ObservacionItem.findByListaChequeo", query = "SELECT o FROM ObservacionItem o WHERE o.observacionItemPK.listaChequeo = :listaChequeo")
    , @NamedQuery(name = "ObservacionItem.findByIdItem", query = "SELECT o FROM ObservacionItem o WHERE o.observacionItemPK.idItem = :idItem")
    , @NamedQuery(name = "ObservacionItem.findByFecha", query = "SELECT o FROM ObservacionItem o WHERE o.fecha = :fecha")
    , @NamedQuery(name = "ObservacionItem.findByUsuario", query = "SELECT o FROM ObservacionItem o WHERE o.usuario = :usuario")})
public class ObservacionItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ObservacionItemPK observacionItemPK;
    @Basic(optional = false)
    @Lob
    @Column(name = "observacion", nullable = false, length = 65535)
    private String observacion;
    @Lob
    @Column(name = "jurados", length = 65535)
    private String jurados;
    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "usuario", nullable = false, length = 150)
    private String usuario;
    @JoinColumns({
        @JoinColumn(name = "numero_ficha", referencedColumnName = "ficha", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "grupo_codigo", referencedColumnName = "grupo_codigo", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "lista_chequeo", referencedColumnName = "lista_chequeo", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "id_item", referencedColumnName = "id_item", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RespuestaGrupo respuestaGrupo;

    public ObservacionItem() {
    }

    public ObservacionItem(ObservacionItemPK observacionItemPK) {
        this.observacionItemPK = observacionItemPK;
    }

    public ObservacionItem(ObservacionItemPK observacionItemPK, String observacion, Date fecha, String usuario) {
        this.observacionItemPK = observacionItemPK;
        this.observacion = observacion;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public ObservacionItem(int idObservacion, String numeroFicha, int grupoCodigo, String listaChequeo, int idItem) {
        this.observacionItemPK = new ObservacionItemPK(idObservacion, numeroFicha, grupoCodigo, listaChequeo, idItem);
    }

    public ObservacionItemPK getObservacionItemPK() {
        return observacionItemPK;
    }

    public void setObservacionItemPK(ObservacionItemPK observacionItemPK) {
        this.observacionItemPK = observacionItemPK;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getJurados() {
        return jurados;
    }

    public void setJurados(String jurados) {
        this.jurados = jurados;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public RespuestaGrupo getRespuestaGrupo() {
        return respuestaGrupo;
    }

    public void setRespuestaGrupo(RespuestaGrupo respuestaGrupo) {
        this.respuestaGrupo = respuestaGrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (observacionItemPK != null ? observacionItemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObservacionItem)) {
            return false;
        }
        ObservacionItem other = (ObservacionItem) object;
        if ((this.observacionItemPK == null && other.observacionItemPK != null) || (this.observacionItemPK != null && !this.observacionItemPK.equals(other.observacionItemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.ObservacionItem[ observacionItemPK=" + observacionItemPK + " ]";
    }
    
}
