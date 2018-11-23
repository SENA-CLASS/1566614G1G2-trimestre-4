package co.edu.sena.senaceet2.repository;

import co.edu.sena.senaceet2.domain.Cliente;
import co.edu.sena.senaceet2.domain.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByNumeroDocumentoAndIdTipoDocumento(String numeroDocumento, TipoDocumento idTipoDocumento);

}
