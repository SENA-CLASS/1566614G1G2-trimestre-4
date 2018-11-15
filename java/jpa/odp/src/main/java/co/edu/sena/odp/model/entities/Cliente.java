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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByTipoDocumento", query = "SELECT c FROM Cliente c WHERE c.clientePK.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "Cliente.findByNumeroDocumento", query = "SELECT c FROM Cliente c WHERE c.clientePK.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "Cliente.findByPrimerNombre", query = "SELECT c FROM Cliente c WHERE c.primerNombre = :primerNombre")
    , @NamedQuery(name = "Cliente.findBySegundoNombre", query = "SELECT c FROM Cliente c WHERE c.segundoNombre = :segundoNombre")
    , @NamedQuery(name = "Cliente.findByPrimerApellido", query = "SELECT c FROM Cliente c WHERE c.primerApellido = :primerApellido")
    , @NamedQuery(name = "Cliente.findBySegundoApellido", query = "SELECT c FROM Cliente c WHERE c.segundoApellido = :segundoApellido")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClientePK clientePK;
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
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
    private Collection<ClienteHasRol> clienteHasRolCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
    private Collection<Aprendiz> aprendizCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
    private Collection<InstructorFicha> instructorFichaCollection;
    @JoinColumn(name = "tipo_documento", referencedColumnName = "documento", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoDocumento tipoDocumento1;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
    private Usuario usuario;

    public Cliente() {
    }

    public Cliente(ClientePK clientePK) {
        this.clientePK = clientePK;
    }

    public Cliente(ClientePK clientePK, String primerNombre, String primerApellido) {
        this.clientePK = clientePK;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
    }

    public Cliente(String tipoDocumento, String numeroDocumento) {
        this.clientePK = new ClientePK(tipoDocumento, numeroDocumento);
    }

    public ClientePK getClientePK() {
        return clientePK;
    }

    public void setClientePK(ClientePK clientePK) {
        this.clientePK = clientePK;
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

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Collection<ClienteHasRol> getClienteHasRolCollection() {
        return clienteHasRolCollection;
    }

    public void setClienteHasRolCollection(Collection<ClienteHasRol> clienteHasRolCollection) {
        this.clienteHasRolCollection = clienteHasRolCollection;
    }

    public Collection<Aprendiz> getAprendizCollection() {
        return aprendizCollection;
    }

    public void setAprendizCollection(Collection<Aprendiz> aprendizCollection) {
        this.aprendizCollection = aprendizCollection;
    }

    public Collection<InstructorFicha> getInstructorFichaCollection() {
        return instructorFichaCollection;
    }

    public void setInstructorFichaCollection(Collection<InstructorFicha> instructorFichaCollection) {
        this.instructorFichaCollection = instructorFichaCollection;
    }

    public TipoDocumento getTipoDocumento1() {
        return tipoDocumento1;
    }

    public void setTipoDocumento1(TipoDocumento tipoDocumento1) {
        this.tipoDocumento1 = tipoDocumento1;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientePK != null ? clientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.clientePK == null && other.clientePK != null) || (this.clientePK != null && !this.clientePK.equals(other.clientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.odp.model.entities.Cliente[ clientePK=" + clientePK + " ]";
    }
    
}
