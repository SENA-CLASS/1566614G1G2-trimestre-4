/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.odp.model.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "item_checker")
@NamedQueries({
    @NamedQuery(name = "ItemChecker.findAll", query = "SELECT i FROM ItemChecker i")
    , @NamedQuery(name = "ItemChecker.findByListaChequeo", query = "SELECT i FROM ItemChecker i WHERE i.itemCheckerPK.listaChequeo = :listaChequeo")
    , @NamedQuery(name = "ItemChecker.findByIdItem", query = "SELECT i FROM ItemChecker i WHERE i.itemCheckerPK.idItem = :idItem")})
public class ItemChecker implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemCheckerPK itemCheckerPK;
    @Basic(optional = false)
    @Lob
    @Column(name = "pregunta", nullable = false, length = 16777215)
    private String pregunta;
    @JoinColumn(name = "lista_chequeo", referencedColumnName = "id_lista", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ListaChequeo listaChequeo1;
    @JoinColumns({
        @JoinColumn(name = "rae_codigo", referencedColumnName = "codigo", nullable = false)
        , @JoinColumn(name = "competencia_codigo", referencedColumnName = "competencia_codigo", nullable = false)
        , @JoinColumn(name = "programa_codigo_version", referencedColumnName = "programa_codigo_version", nullable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Rae rae;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemChecker", fetch = FetchType.LAZY)
    private Collection<RespuestaGrupo> respuestaGrupoCollection;

    public ItemChecker() {
    }

    public ItemChecker(ItemCheckerPK itemCheckerPK) {
        this.itemCheckerPK = itemCheckerPK;
    }

    public ItemChecker(ItemCheckerPK itemCheckerPK, String pregunta) {
        this.itemCheckerPK = itemCheckerPK;
        this.pregunta = pregunta;
    }

    public ItemChecker(String listaChequeo, int idItem) {
        this.itemCheckerPK = new ItemCheckerPK(listaChequeo, idItem);
    }

    public ItemCheckerPK getItemCheckerPK() {
        return itemCheckerPK;
    }

    public void setItemCheckerPK(ItemCheckerPK itemCheckerPK) {
        this.itemCheckerPK = itemCheckerPK;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public ListaChequeo getListaChequeo1() {
        return listaChequeo1;
    }

    public void setListaChequeo1(ListaChequeo listaChequeo1) {
        this.listaChequeo1 = listaChequeo1;
    }

    public Rae getRae() {
        return rae;
    }

    public void setRae(Rae rae) {
        this.rae = rae;
    }

    public Collection<RespuestaGrupo> getRespuestaGrupoCollection() {
        return respuestaGrupoCollection;
    }

    public void setRespuestaGrupoCollection(Collection<RespuestaGrupo> respuestaGrupoCollection) {
        this.respuestaGrupoCollection = respuestaGrupoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemCheckerPK != null ? itemCheckerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemChecker)) {
            return false;
        }
        ItemChecker other = (ItemChecker) object;
        if ((this.itemCheckerPK == null && other.itemCheckerPK != null) || (this.itemCheckerPK != null && !this.itemCheckerPK.equals(other.itemCheckerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.ItemChecker[ itemCheckerPK=" + itemCheckerPK + " ]";
    }
    
}
