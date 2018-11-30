package co.edu.sena.senaceet.service;

import co.edu.sena.senaceet.domain.TipoDocumento;
import co.edu.sena.senaceet.repository.TipoDocumentoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing TipoDocumento.
 */
@Service
@Transactional
public class TipoDocumentoService {

    private final Logger log = LoggerFactory.getLogger(TipoDocumentoService.class);

    private final TipoDocumentoRepository tipoDocumentoRepository;

    public TipoDocumentoService(TipoDocumentoRepository tipoDocumentoRepository) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }

    /**
     * Save a tipoDocumento.
     *
     * @param tipoDocumento the entity to save
     * @return the persisted entity
     */
    public TipoDocumento save(TipoDocumento tipoDocumento) {
        log.debug("Request to save TipoDocumento : {}", tipoDocumento);
        return tipoDocumentoRepository.save(tipoDocumento);
    }

    /**
     * Get all the tipoDocumentos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<TipoDocumento> findAll(Pageable pageable) {
        log.debug("Request to get all TipoDocumentos");
        return tipoDocumentoRepository.findAll(pageable);
    }


    /**
     * Get one tipoDocumento by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<TipoDocumento> findOne(Long id) {
        log.debug("Request to get TipoDocumento : {}", id);
        return tipoDocumentoRepository.findById(id);
    }

    /**
     * Delete the tipoDocumento by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete TipoDocumento : {}", id);
        tipoDocumentoRepository.deleteById(id);
    }
}
