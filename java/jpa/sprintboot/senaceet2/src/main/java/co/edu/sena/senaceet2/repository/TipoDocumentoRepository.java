package co.edu.sena.senaceet2.repository;

import co.edu.sena.senaceet2.domain.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
    TipoDocumento findBySigla(String sigla);
    TipoDocumento findByNombreDocumento(String nombreDocumento);
    List<TipoDocumento> findBySiglaLike(String sigla);


}
