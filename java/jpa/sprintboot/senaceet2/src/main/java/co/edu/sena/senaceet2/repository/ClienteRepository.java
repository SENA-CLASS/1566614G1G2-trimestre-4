package co.edu.sena.senaceet2.repository;

import co.edu.sena.senaceet2.domain.Cliente;
import co.edu.sena.senaceet2.domain.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByNumeroDocumentoAndIdTipoDocumento(String numeroDocumento, TipoDocumento idTipoDocumento);

}
