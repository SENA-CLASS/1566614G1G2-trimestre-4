package co.edu.sena.senaceet2;

import co.edu.sena.senaceet2.domain.Cliente;
import co.edu.sena.senaceet2.repository.ClienteRepository;
import co.edu.sena.senaceet2.repository.TipoDocumentoRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
// la siguiente es la anotacion para el manejo del orden en junit 4
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteCRUDTest {

    private static final Logger LOGGER = Logger.getLogger(ClienteCRUDTest.class.getName());

    @Autowired
    TipoDocumentoRepository tipoDocumentoRepository;
    @Autowired
    ClienteRepository clienteRepository;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void test01Insert() {
        Cliente cliente = new Cliente();
        cliente.setIdTipoDocumento(tipoDocumentoRepository.findBySigla("TI"));
        cliente.setNumeroDocumento("1341234134");
        cliente.setPrimerNombre("pedro");
        cliente.setPrimerApellido("gonzales");

        clienteRepository.save(cliente);
        Assert.assertEquals(cliente, clienteRepository.findByNumeroDocumentoAndIdTipoDocumento(
                "1341234134",tipoDocumentoRepository.findBySigla("TI")
        ));
    }


    @Test
    public void test10Update() {
        Cliente cliente = clienteRepository.findByNumeroDocumentoAndIdTipoDocumento(
                "1341234134",tipoDocumentoRepository.findBySigla("TI"));
        cliente.setNumeroDocumento("123456");
        cliente.setSegundoNombre("martinez");
        clienteRepository.save(cliente);
        Assert.assertEquals(cliente,clienteRepository.findByNumeroDocumentoAndIdTipoDocumento(
                "123456",tipoDocumentoRepository.findBySigla("TI")));
    }

    @Test
    public void test20FindAll() {
        List<Cliente> lista = clienteRepository.findAll();
        Assert.assertFalse(lista.isEmpty());
    }

    @Test
    public void test90Delete() {
        Cliente cliente= clienteRepository.findByNumeroDocumentoAndIdTipoDocumento(
                "123456",tipoDocumentoRepository.findBySigla("TI"));
        clienteRepository.delete(cliente);
        Assert.assertNull(clienteRepository.findByNumeroDocumentoAndIdTipoDocumento(
                "123456",tipoDocumentoRepository.findBySigla("TI")));


    }
}
