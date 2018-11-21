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
@Table(name = "trimestre", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre_trimestre", "id_jornada", "id_nivel_formacion"})})
@NamedQueries({
    @NamedQuery(name = "Trimestre.findAll", query = "SELECT t FROM Trimestre t")})
public class Trimestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre_trimestre", nullable = false, length = 40)
    private String nombreTrimestre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrimestre", fetch = FetchType.LAZY)
    private Collection<FichaHasTrimestre> fichaHasTrimestreCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrimestre", fetch = FetchType.LAZY)
    private Collection<PlaneacionTrimestre> planeacionTrimestreCollection;
    @JoinColumn(name = "id_jornada", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Jornada idJornada;
    @JoinColumn(name = "id_nivel_formacion", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private NivelFormacion idNivelFormacion;

    public Trimestre() {
    }

    public Trimestre(Integer id) {
        this.id = id;
    }

    public Trimestre(Integer id, String nombreTrimestre) {
        this.id = id;
        this.nombreTrimestre = nombreTrimestre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreTrimestre() {
        return nombreTrimestre;
    }

    public void setNombreTrimestre(String nombreTrimestre) {
        this.nombreTrimestre = nombreTrimestre;
    }

    public Collection<FichaHasTrimestre> getFichaHasTrimestreCollection() {
        return fichaHasTrimestreCollection;
    }

    public void setFichaHasTrimestreCollection(Collection<FichaHasTrimestre> fichaHasTrimestreCollection) {
        this.fichaHasTrimestreCollection = fichaHasTrimestreCollection;
    }

    public Collection<PlaneacionTrimestre> getPlaneacionTrimestreCollection() {
        return planeacionTrimestreCollection;
    }

    public void setPlaneacionTrimestreCollection(Collection<PlaneacionTrimestre> planeacionTrimestreCollection) {
        this.planeacionTrimestreCollection = planeacionTrimestreCollection;
    }

    public Jornada getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(Jornada idJornada) {
        this.idJornada = idJornada;
    }

    public NivelFormacion getIdNivelFormacion() {
        return idNivelFormacion;
    }

    public void setIdNivelFormacion(NivelFormacion idNivelFormacion) {
        this.idNivelFormacion = idNivelFormacion;
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
        if (!(object instanceof Trimestre)) {
            return false;
        }
        Trimestre other = (Trimestre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.Trimestre[ id=" + id + " ]";
    }
    
}
