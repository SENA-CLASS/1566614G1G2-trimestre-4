/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.odp.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Enrique
 */
@Embeddable
public class ItemCheckerPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "lista_chequeo", nullable = false, length = 45)
    private String listaChequeo;
    @Basic(optional = false)
    @Column(name = "id_item", nullable = false)
    private int idItem;

    public ItemCheckerPK() {
    }

    public ItemCheckerPK(String listaChequeo, int idItem) {
        this.listaChequeo = listaChequeo;
        this.idItem = idItem;
    }

    public String getListaChequeo() {
        return listaChequeo;
    }

    public void setListaChequeo(String listaChequeo) {
        this.listaChequeo = listaChequeo;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (listaChequeo != null ? listaChequeo.hashCode() : 0);
        hash += (int) idItem;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemCheckerPK)) {
            return false;
        }
        ItemCheckerPK other = (ItemCheckerPK) object;
        if ((this.listaChequeo == null && other.listaChequeo != null) || (this.listaChequeo != null && !this.listaChequeo.equals(other.listaChequeo))) {
            return false;
        }
        if (this.idItem != other.idItem) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.ItemCheckerPK[ listaChequeo=" + listaChequeo + ", idItem=" + idItem + " ]";
    }
    
}
