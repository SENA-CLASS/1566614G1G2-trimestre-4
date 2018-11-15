package co.edu.sena.odp.controller.dao.mysql;

import co.edu.sena.odp.controller.dao.ClienteDAO;
import co.edu.sena.odp.controller.factory.DAOFactory;
import co.edu.sena.odp.model.entities.Cliente;
import co.edu.sena.odp.model.entities.ClientePK;
import co.edu.sena.odp.model.entities.TipoDocumento;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



class ClienteDAOImplTest {

    private ClienteDAO clienteDAO;

    @BeforeEach
    void setUp() {
        clienteDAO= DAOFactory.crearClienteDAO();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test1Insert() {
        Cliente cliente = new Cliente();
        cliente.setClientePK(new ClientePK("CC", "80013833"));
        cliente.setPrimerNombre("Hernando");
        cliente.setSegundoNombre("Enrique");
        cliente.setPrimerApellido("moreno");
        clienteDAO.insert(cliente);
        assertEquals(cliente, clienteDAO.find(new ClientePK("CC", "80013833")));
    }

    @Test
    void test2Update() {
        Cliente cliente = new Cliente();
        cliente.setClientePK(new ClientePK("CC", "80013833"));
        cliente.setPrimerNombre("Hernando");
        cliente.setSegundoNombre("Enrique");
        cliente.setPrimerApellido("Moreno");
        cliente.setSegundoApellido("Moreno");
        clienteDAO.update(cliente);
        assertEquals(cliente, clienteDAO.find(new ClientePK("CC", "80013833")));
    }

    @Test
    void test3FindAll() {
        List<Cliente> lista = (List<Cliente>) clienteDAO.findAll();
        assertFalse(lista.isEmpty());
    }

    @Test
    void test4FindPrimaryKey() {
        Cliente cliente = (Cliente) clienteDAO.find(new ClientePK("CC", "80013833"));
        assertNotNull(cliente);
    }

    @Test
    void test5Delete() {
        clienteDAO.remove(clienteDAO.find(new ClientePK("CC", "80013833")));
        assertNull( clienteDAO.find(new ClientePK("CC", "80013833")));
    }
}