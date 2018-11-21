/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.senaceet2.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "lista_ficha", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_ficha", "id_lista_chequeo"})})
@NamedQueries({
    @NamedQuery(name = "ListaFicha.findAll", query = "SELECT l FROM ListaFicha l")})
public class ListaFicha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "id_ficha", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ficha idFicha;
    @JoinColumn(name = "id_lista_chequeo", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ListaChequeo idListaChequeo;

    public ListaFicha() {
    }

    public ListaFicha(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ficha getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(Ficha idFicha) {
        this.idFicha = idFicha;
    }

    public ListaChequeo getIdListaChequeo() {
        return idListaChequeo;
    }

    public void setIdListaChequeo(ListaChequeo idListaChequeo) {
        this.idListaChequeo = idListaChequeo;
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
        if (!(object instanceof ListaFicha)) {
            return false;
        }
        ListaFicha other = (ListaFicha) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.ListaFicha[ id=" + id + " ]";
    }
    
}
