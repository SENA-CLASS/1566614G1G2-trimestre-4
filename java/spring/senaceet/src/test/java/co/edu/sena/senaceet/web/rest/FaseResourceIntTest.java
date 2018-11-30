package co.edu.sena.senaceet.web.rest;

import co.edu.sena.senaceet.SenaceetApp;

import co.edu.sena.senaceet.domain.Fase;
import co.edu.sena.senaceet.domain.Proyecto;
import co.edu.sena.senaceet.repository.FaseRepository;
import co.edu.sena.senaceet.service.FaseService;
import co.edu.sena.senaceet.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.ZoneId;
import java.util.List;


import static co.edu.sena.senaceet.web.rest.TestUtil.sameInstant;
import static co.edu.sena.senaceet.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import co.edu.sena.senaceet.domain.enumeration.Estado;
/**
 * Test class for the FaseResource REST controller.
 *
 * @see FaseResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SenaceetApp.class)
public class FaseResourceIntTest {

    private static final String DEFAULT_NOMBRE = "AAAAAAAAAA";
    private static final String UPDATED_NOMBRE = "BBBBBBBBBB";

    private static final Estado DEFAULT_ESTADO = Estado.ACTIVO;
    private static final Estado UPDATED_ESTADO = Estado.INACTIVO;

    private static final ZonedDateTime DEFAULT_HORA = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_HORA = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    @Autowired
    private FaseRepository faseRepository;

    @Autowired
    private FaseService faseService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restFaseMockMvc;

    private Fase fase;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final FaseResource faseResource = new FaseResource(faseService);
        this.restFaseMockMvc = MockMvcBuilders.standaloneSetup(faseResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Fase createEntity(EntityManager em) {
        Fase fase = new Fase()
            .nombre(DEFAULT_NOMBRE)
            .estado(DEFAULT_ESTADO)
            .hora(DEFAULT_HORA);
        // Add required entity
        Proyecto proyecto = ProyectoResourceIntTest.createEntity(em);
        em.persist(proyecto);
        em.flush();
        fase.setProyecto(proyecto);
        return fase;
    }

    @Before
    public void initTest() {
        fase = createEntity(em);
    }

    @Test
    @Transactional
    public void createFase() throws Exception {
        int databaseSizeBeforeCreate = faseRepository.findAll().size();

        // Create the Fase
        restFaseMockMvc.perform(post("/api/fases")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(fase)))
            .andExpect(status().isCreated());

        // Validate the Fase in the database
        List<Fase> faseList = faseRepository.findAll();
        assertThat(faseList).hasSize(databaseSizeBeforeCreate + 1);
        Fase testFase = faseList.get(faseList.size() - 1);
        assertThat(testFase.getNombre()).isEqualTo(DEFAULT_NOMBRE);
        assertThat(testFase.getEstado()).isEqualTo(DEFAULT_ESTADO);
        assertThat(testFase.getHora()).isEqualTo(DEFAULT_HORA);
    }

    @Test
    @Transactional
    public void createFaseWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = faseRepository.findAll().size();

        // Create the Fase with an existing ID
        fase.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restFaseMockMvc.perform(post("/api/fases")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(fase)))
            .andExpect(status().isBadRequest());

        // Validate the Fase in the database
        List<Fase> faseList = faseRepository.findAll();
        assertThat(faseList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkNombreIsRequired() throws Exception {
        int databaseSizeBeforeTest = faseRepository.findAll().size();
        // set the field null
        fase.setNombre(null);

        // Create the Fase, which fails.

        restFaseMockMvc.perform(post("/api/fases")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(fase)))
            .andExpect(status().isBadRequest());

        List<Fase> faseList = faseRepository.findAll();
        assertThat(faseList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkEstadoIsRequired() throws Exception {
        int databaseSizeBeforeTest = faseRepository.findAll().size();
        // set the field null
        fase.setEstado(null);

        // Create the Fase, which fails.

        restFaseMockMvc.perform(post("/api/fases")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(fase)))
            .andExpect(status().isBadRequest());

        List<Fase> faseList = faseRepository.findAll();
        assertThat(faseList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkHoraIsRequired() throws Exception {
        int databaseSizeBeforeTest = faseRepository.findAll().size();
        // set the field null
        fase.setHora(null);

        // Create the Fase, which fails.

        restFaseMockMvc.perform(post("/api/fases")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(fase)))
            .andExpect(status().isBadRequest());

        List<Fase> faseList = faseRepository.findAll();
        assertThat(faseList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllFases() throws Exception {
        // Initialize the database
        faseRepository.saveAndFlush(fase);

        // Get all the faseList
        restFaseMockMvc.perform(get("/api/fases?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(fase.getId().intValue())))
            .andExpect(jsonPath("$.[*].nombre").value(hasItem(DEFAULT_NOMBRE.toString())))
            .andExpect(jsonPath("$.[*].estado").value(hasItem(DEFAULT_ESTADO.toString())))
            .andExpect(jsonPath("$.[*].hora").value(hasItem(sameInstant(DEFAULT_HORA))));
    }
    
    @Test
    @Transactional
    public void getFase() throws Exception {
        // Initialize the database
        faseRepository.saveAndFlush(fase);

        // Get the fase
        restFaseMockMvc.perform(get("/api/fases/{id}", fase.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(fase.getId().intValue()))
            .andExpect(jsonPath("$.nombre").value(DEFAULT_NOMBRE.toString()))
            .andExpect(jsonPath("$.estado").value(DEFAULT_ESTADO.toString()))
            .andExpect(jsonPath("$.hora").value(sameInstant(DEFAULT_HORA)));
    }

    @Test
    @Transactional
    public void getNonExistingFase() throws Exception {
        // Get the fase
        restFaseMockMvc.perform(get("/api/fases/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateFase() throws Exception {
        // Initialize the database
        faseService.save(fase);

        int databaseSizeBeforeUpdate = faseRepository.findAll().size();

        // Update the fase
        Fase updatedFase = faseRepository.findById(fase.getId()).get();
        // Disconnect from session so that the updates on updatedFase are not directly saved in db
        em.detach(updatedFase);
        updatedFase
            .nombre(UPDATED_NOMBRE)
            .estado(UPDATED_ESTADO)
            .hora(UPDATED_HORA);

        restFaseMockMvc.perform(put("/api/fases")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedFase)))
            .andExpect(status().isOk());

        // Validate the Fase in the database
        List<Fase> faseList = faseRepository.findAll();
        assertThat(faseList).hasSize(databaseSizeBeforeUpdate);
        Fase testFase = faseList.get(faseList.size() - 1);
        assertThat(testFase.getNombre()).isEqualTo(UPDATED_NOMBRE);
        assertThat(testFase.getEstado()).isEqualTo(UPDATED_ESTADO);
        assertThat(testFase.getHora()).isEqualTo(UPDATED_HORA);
    }

    @Test
    @Transactional
    public void updateNonExistingFase() throws Exception {
        int databaseSizeBeforeUpdate = faseRepository.findAll().size();

        // Create the Fase

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFaseMockMvc.perform(put("/api/fases")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(fase)))
            .andExpect(status().isBadRequest());

        // Validate the Fase in the database
        List<Fase> faseList = faseRepository.findAll();
        assertThat(faseList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteFase() throws Exception {
        // Initialize the database
        faseService.save(fase);

        int databaseSizeBeforeDelete = faseRepository.findAll().size();

        // Get the fase
        restFaseMockMvc.perform(delete("/api/fases/{id}", fase.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Fase> faseList = faseRepository.findAll();
        assertThat(faseList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Fase.class);
        Fase fase1 = new Fase();
        fase1.setId(1L);
        Fase fase2 = new Fase();
        fase2.setId(fase1.getId());
        assertThat(fase1).isEqualTo(fase2);
        fase2.setId(2L);
        assertThat(fase1).isNotEqualTo(fase2);
        fase1.setId(null);
        assertThat(fase1).isNotEqualTo(fase2);
    }
}
