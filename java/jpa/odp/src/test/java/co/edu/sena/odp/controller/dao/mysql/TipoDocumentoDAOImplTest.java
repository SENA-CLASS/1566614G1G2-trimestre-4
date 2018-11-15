package co.edu.sena.odp.controller.dao.mysql;

import co.edu.sena.odp.controller.dao.TipoDocumentoDAO;
import co.edu.sena.odp.controller.factory.DAOFactory;
import co.edu.sena.odp.model.entities.TipoDocumento;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TipoDocumentoDAOImplTest {
    private TipoDocumentoDAO daoTipoDocumento;

    @BeforeEach
    void setUp() {
        daoTipoDocumento = DAOFactory.crearTipoDocumentoDAO();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test1Insert() {
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setDocumento("CC");
        tipoDocumento.setDescripcion("Cedula de Ciudadania");
        tipoDocumento.setEstado(true);
        daoTipoDocumento.insert(tipoDocumento);
        assertEquals(tipoDocumento, daoTipoDocumento.find("CC"));
    }

    @Test
    void test2UPdate() {
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setDocumento("CC");
        tipoDocumento.setDescripcion("Cedula de Ciudadania 2");
        tipoDocumento.setEstado(false);
        daoTipoDocumento.update(tipoDocumento);
        assertEquals(tipoDocumento, daoTipoDocumento.find("CC"));
    }

    @Test
    void test3UpdatePrimeyKey() {
        // TODO: falta implementar

    }

    @Test
    void test4FindAll() {
        List<TipoDocumento> lista =(List<TipoDocumento>) daoTipoDocumento.findAll();
        assertFalse(lista.isEmpty());
    }

    @Test
    void test4FindByPrimaryKey() {
        TipoDocumento tipoDocumento = (TipoDocumento) daoTipoDocumento.find("CC");
        assertNotNull(tipoDocumento);
    }
}