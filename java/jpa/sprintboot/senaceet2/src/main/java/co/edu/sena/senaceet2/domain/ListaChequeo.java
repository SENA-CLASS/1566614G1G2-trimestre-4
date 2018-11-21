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
@Table(name = "lista_chequeo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_programa", "lista_chequeo"})})
@NamedQueries({
    @NamedQuery(name = "ListaChequeo.findAll", query = "SELECT l FROM ListaChequeo l")})
public class ListaChequeo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "lista_chequeo", nullable = false, length = 50)
    private String listaChequeo;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false)
    private int estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idListaChequeo", fetch = FetchType.LAZY)
    private Collection<ListaFicha> listaFichaCollection;
    @JoinColumn(name = "id_programa", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Programa idPrograma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idListaChequeo", fetch = FetchType.LAZY)
    private Collection<ItemLista> itemListaCollection;

    public ListaChequeo() {
    }

    public ListaChequeo(Integer id) {
        this.id = id;
    }

    public ListaChequeo(Integer id, String listaChequeo, int estado) {
        this.id = id;
        this.listaChequeo = listaChequeo;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getListaChequeo() {
        return listaChequeo;
    }

    public void setListaChequeo(String listaChequeo) {
        this.listaChequeo = listaChequeo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Collection<ListaFicha> getListaFichaCollection() {
        return listaFichaCollection;
    }

    public void setListaFichaCollection(Collection<ListaFicha> listaFichaCollection) {
        this.listaFichaCollection = listaFichaCollection;
    }

    public Programa getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Programa idPrograma) {
        this.idPrograma = idPrograma;
    }

    public Collection<ItemLista> getItemListaCollection() {
        return itemListaCollection;
    }

    public void setItemListaCollection(Collection<ItemLista> itemListaCollection) {
        this.itemListaCollection = itemListaCollection;
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
        if (!(object instanceof ListaChequeo)) {
            return false;
        }
        ListaChequeo other = (ListaChequeo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.ListaChequeo[ id=" + id + " ]";
    }
    
}
