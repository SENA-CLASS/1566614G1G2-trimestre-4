/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.senaceet.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "resultados_vistos", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_resultado_aprendizaje", "id_ficha_has_trimestre"})})
@NamedQueries({
    @NamedQuery(name = "ResultadosVistos.findAll", query = "SELECT r FROM ResultadosVistos r"),
    @NamedQuery(name = "ResultadosVistos.findById", query = "SELECT r FROM ResultadosVistos r WHERE r.id = :id")})
public class ResultadosVistos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "id_ficha_has_trimestre", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private FichaHasTrimestre idFichaHasTrimestre;
    @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ResultadoAprendizaje idResultadoAprendizaje;

    public ResultadosVistos() {
    }

    public ResultadosVistos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FichaHasTrimestre getIdFichaHasTrimestre() {
        return idFichaHasTrimestre;
    }

    public void setIdFichaHasTrimestre(FichaHasTrimestre idFichaHasTrimestre) {
        this.idFichaHasTrimestre = idFichaHasTrimestre;
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
        if (!(object instanceof ResultadosVistos)) {
            return false;
        }
        ResultadosVistos other = (ResultadosVistos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.ResultadosVistos[ id=" + id + " ]";
    }
    
}
