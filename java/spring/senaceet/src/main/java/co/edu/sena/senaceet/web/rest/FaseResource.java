package co.edu.sena.senaceet.web.rest;

import com.codahale.metrics.annotation.Timed;
import co.edu.sena.senaceet.domain.Fase;
import co.edu.sena.senaceet.service.FaseService;
import co.edu.sena.senaceet.web.rest.errors.BadRequestAlertException;
import co.edu.sena.senaceet.web.rest.util.HeaderUtil;
import co.edu.sena.senaceet.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Fase.
 */
@RestController
@RequestMapping("/api")
public class FaseResource {

    private final Logger log = LoggerFactory.getLogger(FaseResource.class);

    private static final String ENTITY_NAME = "fase";

    private final FaseService faseService;

    public FaseResource(FaseService faseService) {
        this.faseService = faseService;
    }

    /**
     * POST  /fases : Create a new fase.
     *
     * @param fase the fase to create
     * @return the ResponseEntity with status 201 (Created) and with body the new fase, or with status 400 (Bad Request) if the fase has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/fases")
    @Timed
    public ResponseEntity<Fase> createFase(@Valid @RequestBody Fase fase) throws URISyntaxException {
        log.debug("REST request to save Fase : {}", fase);
        if (fase.getId() != null) {
            throw new BadRequestAlertException("A new fase cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Fase result = faseService.save(fase);
        return ResponseEntity.created(new URI("/api/fases/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /fases : Updates an existing fase.
     *
     * @param fase the fase to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated fase,
     * or with status 400 (Bad Request) if the fase is not valid,
     * or with status 500 (Internal Server Error) if the fase couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/fases")
    @Timed
    public ResponseEntity<Fase> updateFase(@Valid @RequestBody Fase fase) throws URISyntaxException {
        log.debug("REST request to update Fase : {}", fase);
        if (fase.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Fase result = faseService.save(fase);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, fase.getId().toString()))
            .body(result);
    }

    /**
     * GET  /fases : get all the fases.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of fases in body
     */
    @GetMapping("/fases")
    @Timed
    public ResponseEntity<List<Fase>> getAllFases(Pageable pageable) {
        log.debug("REST request to get a page of Fases");
        Page<Fase> page = faseService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/fases");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /fases/:id : get the "id" fase.
     *
     * @param id the id of the fase to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the fase, or with status 404 (Not Found)
     */
    @GetMapping("/fases/{id}")
    @Timed
    public ResponseEntity<Fase> getFase(@PathVariable Long id) {
        log.debug("REST request to get Fase : {}", id);
        Optional<Fase> fase = faseService.findOne(id);
        return ResponseUtil.wrapOrNotFound(fase);
    }

    /**
     * DELETE  /fases/:id : delete the "id" fase.
     *
     * @param id the id of the fase to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/fases/{id}")
    @Timed
    public ResponseEntity<Void> deleteFase(@PathVariable Long id) {
        log.debug("REST request to delete Fase : {}", id);
        faseService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
