package co.edu.sena.odp.controller.dao.mysql;

import co.edu.sena.odp.controller.dao.AprendizDAO;
import co.edu.sena.odp.controller.factory.DAOFactory;
import co.edu.sena.odp.model.entities.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AprendizDAOImplTest {

    private AprendizDAO aprendizDAO;

    @Before
    public void setUp() throws Exception {
        aprendizDAO = DAOFactory.crearAprendizDAO();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1Insert() {
        Aprendiz aprendiz = new Aprendiz();
        aprendiz.setAprendizPK(new AprendizPK("CC", "80013833", "1566614G1",1));
        aprendiz.setEstado(new EstadoFormacion("Desertado"));

        aprendizDAO.insert(aprendiz);
        assertEquals(aprendiz, aprendizDAO.find(new AprendizPK("CC", "80013833", "1566614G1",1)));
    }

    @Test
    public void test2Update() {
        Aprendiz aprendiz = aprendizDAO.find(new AprendizPK("CC", "80013833", "1566614G1",1));
        aprendiz.setEstado(new EstadoFormacion("En etapa productiva"));
        aprendizDAO.update(aprendiz);
        assertEquals(aprendiz, aprendizDAO.find(new AprendizPK("CC", "80013833", "1566614G1",1)));
    }

    @Test
    public void test3UpdatePrimaryKey() {
        Aprendiz aprendiz = aprendizDAO.find(new AprendizPK("CC", "80013833", "1566614G1",1));
        AprendizPK llaveNueva =new AprendizPK("CC","80013833","1566614G1",2);
        aprendizDAO.updatePrimaryKey(aprendiz.getAprendizPK(),llaveNueva);
        assertEquals(aprendizDAO.find(llaveNueva).getAprendizPK(),llaveNueva);
    }
}