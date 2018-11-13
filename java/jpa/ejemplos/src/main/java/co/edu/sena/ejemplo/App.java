package co.edu.sena.ejemplo;

import co.edu.sena.ejemplo.domains.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class App {
    public static void main(String[] args) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit2");
            EntityManager em = emf.createEntityManager();

            Cliente cliente = new Cliente();
            cliente.setId(1);
            cliente.setNombre("pedro");

            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();

        }catch (PersistenceException e){
            System.out.println(e.getMessage());
        }





    }


}
