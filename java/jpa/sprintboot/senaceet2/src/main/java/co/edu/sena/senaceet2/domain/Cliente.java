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
@Table(name = "cliente", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"numero_documento", "id_tipo_documento"})})
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numero_documento", nullable = false, length = 50)
    private String numeroDocumento;
    @Basic(optional = false)
    @Column(name = "primer_nombre", nullable = false, length = 50)
    private String primerNombre;
    @Column(name = "segundo_nombre", length = 50)
    private String segundoNombre;
    @Basic(optional = false)
    @Column(name = "primer_apellido", nullable = false, length = 50)
    private String primerApellido;
    @Column(name = "segundo_apellido", length = 50)
    private String segundoApellido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente", fetch = FetchType.LAZY)
    private Collection<ClienteHasRol> clienteHasRolCollection;
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoDocumento idTipoDocumento;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idCliente", fetch = FetchType.LAZY)
    private Instructor instructor;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idCliente", fetch = FetchType.LAZY)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente", fetch = FetchType.LAZY)
    private Collection<Aprendiz> aprendizCollection;

    public Cliente() {
    }

    public Cliente(Integer id) {
        this.id = id;
    }

    public Cliente(Integer id, String numeroDocumento, String primerNombre, String primerApellido) {
        this.id = id;
        this.numeroDocumento = numeroDocumento;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Collection<ClienteHasRol> getClienteHasRolCollection() {
        return clienteHasRolCollection;
    }

    public void setClienteHasRolCollection(Collection<ClienteHasRol> clienteHasRolCollection) {
        this.clienteHasRolCollection = clienteHasRolCollection;
    }

    public TipoDocumento getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(TipoDocumento idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Collection<Aprendiz> getAprendizCollection() {
        return aprendizCollection;
    }

    public void setAprendizCollection(Collection<Aprendiz> aprendizCollection) {
        this.aprendizCollection = aprendizCollection;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.Cliente[ id=" + id + " ]";
    }
    
}
