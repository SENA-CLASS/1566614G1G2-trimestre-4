package co.edu.sena.senaceet.controller.dao.mysql;

import co.edu.sena.senaceet.controller.dao.ClienteDAO;
import co.edu.sena.senaceet.controller.dao.TipoDocumentoDAO;
import co.edu.sena.senaceet.controller.factory.DAOFactory;
import co.edu.sena.senaceet.model.entities.Cliente;
import co.edu.sena.senaceet.model.entities.TipoDocumento;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class ClienteDAOImplTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1Insert() {
        Cliente cliente = new Cliente();
        TipoDocumentoDAO tipoDocumentoDAO = DAOFactory.crearTipoDocumentoDAO();
        TipoDocumento tipoDocumento =tipoDocumentoDAO.findBySigla("CC");
        if(tipoDocumento!=null) {
            cliente.setIdTipoDocumento(tipoDocumento);
            cliente.setNumeroDocumento("80013833");
            cliente.setPrimerNombre("hernando");
            cliente.setSegundoNombre("Enrique");
            cliente.setPrimerApellido("moreno");
            cliente.setSegundoApellido("morneo");

            ClienteDAO clienteDAO = DAOFactory.crearClienteDAO();
            clienteDAO.insert(cliente);

        }else{
            assertTrue(false);
        }
    }
}