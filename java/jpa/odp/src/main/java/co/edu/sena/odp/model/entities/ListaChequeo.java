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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "lista_chequeo")
@NamedQueries({
    @NamedQuery(name = "ListaChequeo.findAll", query = "SELECT l FROM ListaChequeo l")
    , @NamedQuery(name = "ListaChequeo.findByIdLista", query = "SELECT l FROM ListaChequeo l WHERE l.idLista = :idLista")
    , @NamedQuery(name = "ListaChequeo.findByEstado", query = "SELECT l FROM ListaChequeo l WHERE l.estado = :estado")})
public class ListaChequeo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_lista", nullable = false, length = 45)
    private String idLista;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false)
    private boolean estado;
    @JoinColumn(name = "programa_codigo_version", referencedColumnName = "codigo_version", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Programa programaCodigoVersion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listaChequeo1", fetch = FetchType.LAZY)
    private Collection<ItemChecker> itemCheckerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listaChequeo", fetch = FetchType.LAZY)
    private Collection<FichaHasLista> fichaHasListaCollection;

    public ListaChequeo() {
    }

    public ListaChequeo(String idLista) {
        this.idLista = idLista;
    }

    public ListaChequeo(String idLista, boolean estado) {
        this.idLista = idLista;
        this.estado = estado;
    }

    public String getIdLista() {
        return idLista;
    }

    public void setIdLista(String idLista) {
        this.idLista = idLista;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Programa getProgramaCodigoVersion() {
        return programaCodigoVersion;
    }

    public void setProgramaCodigoVersion(Programa programaCodigoVersion) {
        this.programaCodigoVersion = programaCodigoVersion;
    }

    public Collection<ItemChecker> getItemCheckerCollection() {
        return itemCheckerCollection;
    }

    public void setItemCheckerCollection(Collection<ItemChecker> itemCheckerCollection) {
        this.itemCheckerCollection = itemCheckerCollection;
    }

    public Collection<FichaHasLista> getFichaHasListaCollection() {
        return fichaHasListaCollection;
    }

    public void setFichaHasListaCollection(Collection<FichaHasLista> fichaHasListaCollection) {
        this.fichaHasListaCollection = fichaHasListaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLista != null ? idLista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaChequeo)) {
            return false;
        }
        ListaChequeo other = (ListaChequeo) object;
        if ((this.idLista == null && other.idLista != null) || (this.idLista != null && !this.idLista.equals(other.idLista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.ListaChequeo[ idLista=" + idLista + " ]";
    }
    
}
