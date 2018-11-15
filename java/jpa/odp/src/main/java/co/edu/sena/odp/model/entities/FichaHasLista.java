/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.odp.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "ficha_has_lista")
@NamedQueries({
    @NamedQuery(name = "FichaHasLista.findAll", query = "SELECT f FROM FichaHasLista f")
    , @NamedQuery(name = "FichaHasLista.findByFicha", query = "SELECT f FROM FichaHasLista f WHERE f.ficha = :ficha")})
public class FichaHasLista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ficha", nullable = false, length = 50)
    private String ficha;
    @JoinColumn(name = "ficha", referencedColumnName = "numero_ficha", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Ficha ficha1;
    @JoinColumn(name = "lista_chequeo", referencedColumnName = "id_lista", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ListaChequeo listaChequeo;

    public FichaHasLista() {
    }

    public FichaHasLista(String ficha) {
        this.ficha = ficha;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public Ficha getFicha1() {
        return ficha1;
    }

    public void setFicha1(Ficha ficha1) {
        this.ficha1 = ficha1;
    }

    public ListaChequeo getListaChequeo() {
        return listaChequeo;
    }

    public void setListaChequeo(ListaChequeo listaChequeo) {
        this.listaChequeo = listaChequeo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ficha != null ? ficha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FichaHasLista)) {
            return false;
        }
        FichaHasLista other = (FichaHasLista) object;
        if ((this.ficha == null && other.ficha != null) || (this.ficha != null && !this.ficha.equals(other.ficha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.FichaHasLista[ ficha=" + ficha + " ]";
    }
    
}
