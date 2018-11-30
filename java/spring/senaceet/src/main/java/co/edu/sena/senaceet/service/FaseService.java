package co.edu.sena.senaceet.service;

import co.edu.sena.senaceet.domain.Fase;
import co.edu.sena.senaceet.repository.FaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing Fase.
 */
@Service
@Transactional
public class FaseService {

    private final Logger log = LoggerFactory.getLogger(FaseService.class);

    private final FaseRepository faseRepository;

    public FaseService(FaseRepository faseRepository) {
        this.faseRepository = faseRepository;
    }

    /**
     * Save a fase.
     *
     * @param fase the entity to save
     * @return the persisted entity
     */
    public Fase save(Fase fase) {
        log.debug("Request to save Fase : {}", fase);
        return faseRepository.save(fase);
    }

    /**
     * Get all the fases.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<Fase> findAll(Pageable pageable) {
        log.debug("Request to get all Fases");
        return faseRepository.findAll(pageable);
    }


    /**
     * Get one fase by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<Fase> findOne(Long id) {
        log.debug("Request to get Fase : {}", id);
        return faseRepository.findById(id);
    }

    /**
     * Delete the fase by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Fase : {}", id);
        faseRepository.deleteById(id);
    }
}
