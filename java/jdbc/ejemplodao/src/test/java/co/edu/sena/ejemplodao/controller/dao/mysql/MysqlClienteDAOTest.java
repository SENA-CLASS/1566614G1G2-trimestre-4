package co.edu.sena.ejemplodao.controller.dao.mysql;

import co.edu.sena.ejemplodao.controller.dao.ClienteDAO;
import co.edu.sena.ejemplodao.controller.factory.ClienteDAOFactory;
import co.edu.sena.ejemplodao.controller.factory.mysql.MysqlClienteDAOFactory;
import co.edu.sena.ejemplodao.modelo.dto.ClienteDTO;
import co.edu.sena.ejemplodao.modelo.dto.ClientePkDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MysqlClienteDAOTest {

    private ClienteDTO cliente;
    private ClienteDTO cliente2;
    private ClientePkDTO llave;
    private ClientePkDTO llave2;

    @Before
    public void setUp() throws Exception {
        cliente = new ClienteDTO();
        cliente.setTipoDocumento("CC");
        cliente.setNumeroDocumento("555555");
        cliente.setPrimerNombre("hernando");
        cliente.setSegundoNombre("enrique");
        cliente.setPrimerApellido("Moreno");
        cliente.setSegundoApellido("Moreno");


        cliente2 = new ClienteDTO();
        cliente2.setTipoDocumento("CC");
        cliente2.setNumeroDocumento("1234555");
        cliente2.setPrimerNombre("pedrito");
        cliente2.setSegundoNombre(null);
        cliente2.setPrimerApellido("Moreno");
        cliente2.setSegundoApellido("Moreno");

        llave = new ClientePkDTO();
        llave.setTipoDocumento("CC");
        llave.setNumeroDocumento("555555");

        llave2 = new ClientePkDTO();
        llave2.setTipoDocumento("CC");
        llave2.setNumeroDocumento("1234555");

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1Insert() {
        System.out.println("prueba del insert de clienteDAO");
        ClienteDAOFactory factory = new MysqlClienteDAOFactory();
        ClienteDAO dao = factory.create();
        assertEquals(dao.insert(cliente),1);

    }

    @Test
    public void test2FindPk() {
        System.out.println("prueba del búsqueda llave primaria de clienteDAo");
        ClienteDAOFactory factory = new MysqlClienteDAOFactory();
        ClienteDAO dao = factory.create();
        ClienteDTO consulta = dao.findPk(llave);
        assertEquals(consulta, cliente);
    }

    @Test
    public void test3Update() {
        System.out.println("prueba del update de clienteDAo");
        ClienteDAOFactory factory = new MysqlClienteDAOFactory();
        ClienteDAO dao = factory.create();
        assertEquals(dao.update(cliente2, llave),1);
    }

    @Test
    public void test4Delete() {
        System.out.println("prueba del delete de clienteDAo");
        ClienteDAOFactory factory = new MysqlClienteDAOFactory();
        ClienteDAO dao = factory.create();
        assertEquals(dao.delete(llave2),1);
    }

    @Test
    public void test5FindAll() {
        System.out.println("prueba del select * de clienteDAo");
        ClienteDAOFactory factory = new MysqlClienteDAOFactory();
        ClienteDAO dao = factory.create();
        List<ClienteDTO> consulta = (List<ClienteDTO>) dao.findAll();
        assertTrue(!consulta.isEmpty());
    }


}