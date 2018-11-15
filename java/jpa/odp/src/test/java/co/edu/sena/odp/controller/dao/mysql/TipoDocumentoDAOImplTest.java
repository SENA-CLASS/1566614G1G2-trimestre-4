package co.edu.sena.odp.controller.dao.mysql;

import co.edu.sena.odp.controller.dao.TipoDocumentoDAO;
import co.edu.sena.odp.controller.factory.DAOFactory;
import co.edu.sena.odp.model.entities.TipoDocumento;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TipoDocumentoDAOImplTest {

    private TipoDocumentoDAO daoTipoDocumento;

    @Before
    public void setUp() {
        daoTipoDocumento = DAOFactory.crearTipoDocumentoDAO();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setDocumento("CC");
        tipoDocumento.setDescripcion("Cedula de Ciudadania");
        tipoDocumento.setEstado(true);
        daoTipoDocumento.insert(tipoDocumento);
        assertEquals(tipoDocumento, daoTipoDocumento.find("CC"));
    }

    @Test
    public void test2UPdate() {
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setDocumento("CC");
        tipoDocumento.setDescripcion("Cedula de Ciudadania 2");
        tipoDocumento.setEstado(false);
        daoTipoDocumento.update(tipoDocumento);
        assertEquals(tipoDocumento, daoTipoDocumento.find("CC"));
    }

    @Test
    public void test3FindAll() {
        List<TipoDocumento> lista =(List<TipoDocumento>) daoTipoDocumento.findAll();
        assertFalse(lista.isEmpty());
    }

    @Test
    public void test4FindByPrimaryKey() {
        TipoDocumento tipoDocumento = (TipoDocumento) daoTipoDocumento.find("CC");
        assertNotNull(tipoDocumento);
    }

    @Test
    public void test5Delete() {
        daoTipoDocumento.remove(daoTipoDocumento.find("CC"));
        assertNull(daoTipoDocumento.find("CC"));
    }
}