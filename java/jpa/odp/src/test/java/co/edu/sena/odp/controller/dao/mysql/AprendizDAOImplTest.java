package co.edu.sena.odp.controller.dao.mysql;

import co.edu.sena.odp.controller.dao.AprendizDAO;
import co.edu.sena.odp.controller.factory.DAOFactory;
import co.edu.sena.odp.model.entities.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AprendizDAOImplTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1Insert() {
        Aprendiz aprendiz = new Aprendiz();
        aprendiz.setAprendizPK(new AprendizPK("CC", "80013833", "1566614G1",1));
        aprendiz.setEstado(new EstadoFormacion("Desertado"));
        AprendizDAO aprendizDAO = DAOFactory.crearAprendizDAO();
        aprendizDAO.insert(aprendiz);
    }
}