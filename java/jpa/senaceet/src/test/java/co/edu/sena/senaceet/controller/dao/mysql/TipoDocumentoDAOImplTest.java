package co.edu.sena.senaceet.controller.dao.mysql;

import co.edu.sena.senaceet.controller.dao.TipoDocumentoDAO;
import co.edu.sena.senaceet.controller.factory.DAOFactory;
import co.edu.sena.senaceet.model.entities.TipoDocumento;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TipoDocumentoDAOImplTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void test1Insert() {
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setSigla("CC");
        tipoDocumento.setEstado("Activo");
        tipoDocumento.setNombreDocumento("Cedula de ciudadania");

        TipoDocumentoDAO dao = DAOFactory.crearTipoDocumentoDAO();
        dao.insert(tipoDocumento);


    }
}