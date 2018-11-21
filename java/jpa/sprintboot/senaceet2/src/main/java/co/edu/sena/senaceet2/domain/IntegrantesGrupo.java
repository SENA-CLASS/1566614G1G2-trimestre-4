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
@Table(name = "integrantes_grupo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_aprendiz", "id_grupo_proyecto"})})
@NamedQueries({
    @NamedQuery(name = "IntegrantesGrupo.findAll", query = "SELECT i FROM IntegrantesGrupo i")})
public class IntegrantesGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "id_aprendiz", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Aprendiz idAprendiz;
    @JoinColumn(name = "id_grupo_proyecto", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GrupoProyecto idGrupoProyecto;

    public IntegrantesGrupo() {
    }

    public IntegrantesGrupo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Aprendiz getIdAprendiz() {
        return idAprendiz;
    }

    public void setIdAprendiz(Aprendiz idAprendiz) {
        this.idAprendiz = idAprendiz;
    }

    public GrupoProyecto getIdGrupoProyecto() {
        return idGrupoProyecto;
    }

    public void setIdGrupoProyecto(GrupoProyecto idGrupoProyecto) {
        this.idGrupoProyecto = idGrupoProyecto;
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
        if (!(object instanceof IntegrantesGrupo)) {
            return false;
        }
        IntegrantesGrupo other = (IntegrantesGrupo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.IntegrantesGrupo[ id=" + id + " ]";
    }
    
}
