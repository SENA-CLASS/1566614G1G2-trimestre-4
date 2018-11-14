package co.edu.sena.jpamapeo.semantica.domain;

import org.junit.jupiter.api.*;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class TipoDocumentoTest {
  /*  private static final Logger LOGGER = Logger.getLogger(TipoDocumento.class.getName());
    private EntityManagerFactory emf;
    private EntityManager em;
    private TipoDocumento tipoDocumento;

    @BeforeEach
    void setUp() {
        emf = Persistence.createEntityManagerFactory("UPSemantica");
        em = emf.createEntityManager();
        tipoDocumento = new TipoDocumento();
        tipoDocumento.setDocumento("CC");
        tipoDocumento.setDescripcion("Cedula de ciudadania");
        tipoDocumento.setEstado((byte)1);
    }



    @AfterEach
    void tearDown() {


    }

    @Test
    void test01Insert() {
        em.getTransaction().begin();
        em.persist(tipoDocumento);
        em.getTransaction().commit();
        assertEquals(tipoDocumento, em.find(TipoDocumento.class,"CC"));

    }

    @Test
    void test01Update() {
        TipoDocumento tipoDocumentoTemporal = em.find(TipoDocumento.class, "CC");
        //tipoDocumentoTemporal.setDocumento("CCC");
        tipoDocumentoTemporal.setDescripcion("Cedula civil colombiana");
        tipoDocumentoTemporal.setEstado(false);
        em.getTransaction().begin();
        em.merge(tipoDocumentoTemporal);
        em.getTransaction().commit();
        assertEquals(tipoDocumentoTemporal, em.find(TipoDocumento.class, "CC"));
    }
*/
}