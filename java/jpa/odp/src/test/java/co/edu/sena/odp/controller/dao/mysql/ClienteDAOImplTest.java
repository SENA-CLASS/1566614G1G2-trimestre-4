package co.edu.sena.odp.controller.dao.mysql;

import co.edu.sena.odp.controller.dao.ClienteDAO;
import co.edu.sena.odp.controller.factory.DAOFactory;
import co.edu.sena.odp.model.entities.Cliente;
import co.edu.sena.odp.model.entities.ClientePK;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteDAOImplTest {


    private ClienteDAO clienteDAO;

    @Before
    public void setUp() {
        clienteDAO= DAOFactory.crearClienteDAO();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        Cliente cliente = new Cliente();
        cliente.setClientePK(new ClientePK("CC", "31341234123"));
        cliente.setPrimerNombre("Hernando");
        cliente.setSegundoNombre("Enrique");
        cliente.setPrimerApellido("moreno");
        clienteDAO.insert(cliente);
        assertEquals(cliente, clienteDAO.find(new ClientePK("CC", "31341234123")));
    }

    @Test
    public void test2Update() {
        Cliente cliente = new Cliente();
        cliente.setClientePK(new ClientePK("CC", "31341234123"));
        cliente.setPrimerNombre("Hernando");
        cliente.setSegundoNombre("Enrique");
        cliente.setPrimerApellido("Moreno");
        cliente.setSegundoApellido("Moreno");
        clienteDAO.update(cliente);
        assertEquals(cliente, clienteDAO.find(new ClientePK("CC", "31341234123")));
    }

    @Test
    public void test3FindAll() {
        List<Cliente> lista = (List<Cliente>) clienteDAO.findAll();
        assertFalse(lista.isEmpty());
    }

    @Test
    public void test4FindPrimaryKey() {
        Cliente cliente = (Cliente) clienteDAO.find(new ClientePK("CC", "31341234123"));
        assertNotNull(cliente);
    }

    @Test
    public void test5Delete() {
        clienteDAO.remove(clienteDAO.find(new ClientePK("CC", "31341234123")));
        assertNull( clienteDAO.find(new ClientePK("CC", "31341234123")));
    }
}