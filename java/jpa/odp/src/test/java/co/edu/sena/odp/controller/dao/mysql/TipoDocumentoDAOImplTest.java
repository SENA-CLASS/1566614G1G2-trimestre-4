package co.edu.sena.odp.controller.dao.mysql;

import co.edu.sena.odp.controller.dao.TipoDocumentoDAO;
import co.edu.sena.odp.controller.factory.DAOFactory;
import co.edu.sena.odp.model.entities.TipoDocumento;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.logging.Logger;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TipoDocumentoDAOImplTest {

    private static final Logger LOGGER = Logger.getLogger(AbstractDao.class.getName());

    private TipoDocumentoDAO daoTipoDocumento;

    @Before
    public void setUp() {
        daoTipoDocumento = DAOFactory.crearTipoDocumentoDAO();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01Insert() {
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setDocumento("CC2");
        tipoDocumento.setDescripcion("Cedula de Ciudadania");
        tipoDocumento.setEstado(true);
        daoTipoDocumento.insert(tipoDocumento);
        assertEquals(tipoDocumento, daoTipoDocumento.find("CC2"));
    }



    @Test
    public void test02Update() {
        TipoDocumento tipoDocumento = (TipoDocumento) daoTipoDocumento.find("CC2");
        tipoDocumento.setDescripcion("Cedula de Ciudadania 2");
        tipoDocumento.setEstado(false);
        daoTipoDocumento.update(tipoDocumento);
        assertEquals(tipoDocumento, daoTipoDocumento.find("CC2"));
    }

    @Test
    public void test02UpdatePrimary() {
        int cantidadModificados = daoTipoDocumento.updatePrimaryKey("CC3", "CC2");
        assertEquals(cantidadModificados, 1);
    }



    @Test
    public void test03FindAll() {
        List<TipoDocumento> lista =(List<TipoDocumento>) daoTipoDocumento.findAll();
        assertFalse(lista.isEmpty());
    }

    @Test
    public void test04FindByPrimaryKey() {
        TipoDocumento tipoDocumento = (TipoDocumento) daoTipoDocumento.find("CC3");
        assertNotNull(tipoDocumento);
    }

    @Test
    public void test05findDescripcion() {
        List<TipoDocumento> lista = daoTipoDocumento.findByDescripcion("Cédula de Ciudadanía");
        assertFalse(lista.isEmpty());
    }

    @Test
    public void test06findEstado() {
        List<TipoDocumento> lista = daoTipoDocumento.findByEstado(true);
        assertFalse(lista.isEmpty());
    }

    @Test
    public void test07findByLikeDescripcion() {
        List<TipoDocumento> lista = daoTipoDocumento.findByLikeDescripcion("%tidad%");
        assertFalse(lista.isEmpty());
    }

    @Test
    public void test08findByLikeDocumento() {
        List<TipoDocumento> lista = daoTipoDocumento.findByLikeDocumento("C%");
        assertFalse(lista.isEmpty());
    }

    @Test
    public void test09findByLikeDescripcionNative() {
        List<TipoDocumento> lista=null;
        try {
            lista = daoTipoDocumento.findByLikeDescripcionNative("C%a");
        }catch (PersistenceException e){
            LOGGER.severe(e.getMessage());
            assertNull(e);
        }
        assertFalse(lista.isEmpty());
    }

    @Test
    public void test10findByLikeDocumentoJPQL() {
        List<TipoDocumento> lista=null;
        try {
            lista = daoTipoDocumento.findByLikeDocumentoJPQL("%C");
        }catch (PersistenceException e){
            LOGGER.severe(e.getMessage());
            assertNull(e);
        }
        assertFalse(lista.isEmpty());
    }

    @Test
    public void test11Delete() {
        daoTipoDocumento.remove(daoTipoDocumento.find("CC3"));
        assertNull(daoTipoDocumento.find("CC3"));
    }
}