/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.odp.model.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "aprendiz")
@NamedQueries({
    @NamedQuery(name = "Aprendiz.findAll", query = "SELECT a FROM Aprendiz a")
    , @NamedQuery(name = "Aprendiz.findByTipoDocumento", query = "SELECT a FROM Aprendiz a WHERE a.aprendizPK.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "Aprendiz.findByNumeroDocumento", query = "SELECT a FROM Aprendiz a WHERE a.aprendizPK.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "Aprendiz.findByFicha", query = "SELECT a FROM Aprendiz a WHERE a.aprendizPK.ficha = :ficha")
    , @NamedQuery(name = "Aprendiz.findByGrupoCodigo", query = "SELECT a FROM Aprendiz a WHERE a.aprendizPK.grupoCodigo = :grupoCodigo")})
public class Aprendiz implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AprendizPK aprendizPK;
    @JoinColumn(name = "estado", referencedColumnName = "id_estado", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoFormacion estado;
    @JoinColumns({
        @JoinColumn(name = "ficha", referencedColumnName = "numero_ficha", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "grupo_codigo", referencedColumnName = "codigo", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GrupoProyecto grupoProyecto;
    @JoinColumns({
        @JoinColumn(name = "tipo_documento", referencedColumnName = "tipo_documento", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "numero_documento", referencedColumnName = "numero_documento", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente cliente;

    public Aprendiz() {
    }

    public Aprendiz(AprendizPK aprendizPK) {
        this.aprendizPK = aprendizPK;
    }

    public Aprendiz(String tipoDocumento, String numeroDocumento, String ficha, int grupoCodigo) {
        this.aprendizPK = new AprendizPK(tipoDocumento, numeroDocumento, ficha, grupoCodigo);
    }

    public AprendizPK getAprendizPK() {
        return aprendizPK;
    }

    public void setAprendizPK(AprendizPK aprendizPK) {
        this.aprendizPK = aprendizPK;
    }

    public EstadoFormacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoFormacion estado) {
        this.estado = estado;
    }

    public GrupoProyecto getGrupoProyecto() {
        return grupoProyecto;
    }

    public void setGrupoProyecto(GrupoProyecto grupoProyecto) {
        this.grupoProyecto = grupoProyecto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aprendizPK != null ? aprendizPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aprendiz)) {
            return false;
        }
        Aprendiz other = (Aprendiz) object;
        if ((this.aprendizPK == null && other.aprendizPK != null) || (this.aprendizPK != null && !this.aprendizPK.equals(other.aprendizPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.Aprendiz[ aprendizPK=" + aprendizPK + " ]";
    }
    
}
