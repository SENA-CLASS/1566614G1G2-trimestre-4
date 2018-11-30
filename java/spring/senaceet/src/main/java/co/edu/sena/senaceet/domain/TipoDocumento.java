package co.edu.sena.senaceet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import co.edu.sena.senaceet.domain.enumeration.Estado;

/**
 * A TipoDocumento.
 */
@Entity
@Table(name = "tipo_documento")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 10)
    @Column(name = "sigla", length = 10, nullable = false, unique = true)
    private String sigla;

    @NotNull
    @Size(max = 50)
    @Column(name = "nombre_documento", length = 50, nullable = false)
    private String nombreDocumento;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private Estado estado;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoDocumento")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Cliente> clientes = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public TipoDocumento sigla(String sigla) {
        this.sigla = sigla;
        return this;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public TipoDocumento nombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
        return this;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public Estado getEstado() {
        return estado;
    }

    public TipoDocumento estado(Estado estado) {
        this.estado = estado;
        return this;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public TipoDocumento clientes(Set<Cliente> clientes) {
        this.clientes = clientes;
        return this;
    }

    public TipoDocumento addCliente(Cliente cliente) {
        this.clientes.add(cliente);
        cliente.setTipoDocumento(this);
        return this;
    }

    public TipoDocumento removeCliente(Cliente cliente) {
        this.clientes.remove(cliente);
        cliente.setTipoDocumento(null);
        return this;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TipoDocumento tipoDocumento = (TipoDocumento) o;
        if (tipoDocumento.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tipoDocumento.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TipoDocumento{" +
            "id=" + getId() +
            ", sigla='" + getSigla() + "'" +
            ", nombreDocumento='" + getNombreDocumento() + "'" +
            ", estado='" + getEstado() + "'" +
            "}";
    }
}
