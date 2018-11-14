package co.edu.sena.jpamapeo.semantica.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    private static final Logger LOGGER = Logger.getLogger(ClienteTest.class.getName());
    private EntityManagerFactory emf;
    private EntityManager em;

    @BeforeEach
    void setUp() {
        emf = Persistence.createEntityManagerFactory("UPSemantica");
        em = emf.createEntityManager();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test01Insert() {

    }
}