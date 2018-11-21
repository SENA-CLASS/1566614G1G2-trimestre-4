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
@Table(name = "item_lista", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_lista_chequeo", "numero_item", "pregunta"})})
@NamedQueries({
    @NamedQuery(name = "ItemLista.findAll", query = "SELECT i FROM ItemLista i")})
public class ItemLista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numero_item", nullable = false)
    private int numeroItem;
    @Basic(optional = false)
    @Column(name = "pregunta", nullable = false, length = 1000)
    private String pregunta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idItemLista", fetch = FetchType.LAZY)
    private Collection<RespuestaGrupo> respuestaGrupoCollection;
    @JoinColumn(name = "id_lista_chequeo", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ListaChequeo idListaChequeo;
    @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ResultadoAprendizaje idResultadoAprendizaje;

    public ItemLista() {
    }

    public ItemLista(Integer id) {
        this.id = id;
    }

    public ItemLista(Integer id, int numeroItem, String pregunta) {
        this.id = id;
        this.numeroItem = numeroItem;
        this.pregunta = pregunta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumeroItem() {
        return numeroItem;
    }

    public void setNumeroItem(int numeroItem) {
        this.numeroItem = numeroItem;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Collection<RespuestaGrupo> getRespuestaGrupoCollection() {
        return respuestaGrupoCollection;
    }

    public void setRespuestaGrupoCollection(Collection<RespuestaGrupo> respuestaGrupoCollection) {
        this.respuestaGrupoCollection = respuestaGrupoCollection;
    }

    public ListaChequeo getIdListaChequeo() {
        return idListaChequeo;
    }

    public void setIdListaChequeo(ListaChequeo idListaChequeo) {
        this.idListaChequeo = idListaChequeo;
    }

    public ResultadoAprendizaje getIdResultadoAprendizaje() {
        return idResultadoAprendizaje;
    }

    public void setIdResultadoAprendizaje(ResultadoAprendizaje idResultadoAprendizaje) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
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
        if (!(object instanceof ItemLista)) {
            return false;
        }
        ItemLista other = (ItemLista) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.ItemLista[ id=" + id + " ]";
    }
    
}
