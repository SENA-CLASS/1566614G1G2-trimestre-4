package co.edu.sena.ejemplodao.controller.dao.mysql;

import co.edu.sena.ejemplodao.controller.dao.TipoDocumentoDAO;
import co.edu.sena.ejemplodao.controller.factory.TipoDocumentoDAOFactory;
import co.edu.sena.ejemplodao.controller.factory.mysql.MysqlTipoDocumetoDAOFactory;
import co.edu.sena.ejemplodao.modelo.dto.TipoDocumentoDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MysqlTipoDocumentoDAOTest {

    private TipoDocumentoDTO tipoDocumentoDTO;
    private TipoDocumentoDTO tipoDocumentoDTO2;

    @Before
    public void setUp() throws Exception {
        tipoDocumentoDTO = new TipoDocumentoDTO();
        tipoDocumentoDTO.setDocumento("NIT");
        tipoDocumentoDTO.setDescripcion("Numero de identificación tributaria");
        tipoDocumentoDTO.setEstado(Boolean.TRUE);

        tipoDocumentoDTO2 = new TipoDocumentoDTO();
        tipoDocumentoDTO2.setDocumento("NOT");
        tipoDocumentoDTO2.setDescripcion("Numero de identificación tributaria");
        tipoDocumentoDTO2.setEstado(Boolean.TRUE);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1Insert() {
        TipoDocumentoDAOFactory factory = new MysqlTipoDocumetoDAOFactory();
        TipoDocumentoDAO dao = factory.create();
        assertEquals(dao.insert(tipoDocumentoDTO), 1);
    }

    @Test
    public void test2FindPk() {
        TipoDocumentoDAOFactory factory = new MysqlTipoDocumetoDAOFactory();
        TipoDocumentoDAO dao = factory.create();
        TipoDocumentoDTO respuesta =dao.findPk("NIT");
        assertEquals(respuesta,tipoDocumentoDTO);
    }

    @Test
    public void test3Update() {
        TipoDocumentoDAOFactory factory = new MysqlTipoDocumetoDAOFactory();
        TipoDocumentoDAO dao = factory.create();
        assertEquals(dao.update(tipoDocumentoDTO2,"NIT"),1);

    }

    @Test
    public void test4Delete() {
        TipoDocumentoDAOFactory factory = new MysqlTipoDocumetoDAOFactory();
        TipoDocumentoDAO dao = factory.create();
        assertEquals(dao.delete("NOT"),1);
    }

    @Test
    public void test5FindAll() {
        TipoDocumentoDAOFactory factory = new MysqlTipoDocumetoDAOFactory();
        TipoDocumentoDAO dao = factory.create();
        List<TipoDocumentoDTO> lista = (List<TipoDocumentoDTO>)dao.findAll();
        System.out.println(lista);
        assertTrue(!lista.isEmpty());
    }

}