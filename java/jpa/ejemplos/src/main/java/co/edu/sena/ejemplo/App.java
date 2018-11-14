package co.edu.sena.ejemplo;

import co.edu.sena.ejemplo.domains.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class App {
    public static void main(String[] args) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidadPersistenciaEjemploJPA");
            EntityManager em = emf.createEntityManager();

            Cliente cliente = new Cliente();
            cliente.setId(1);
            cliente.setNombre("pedro");

            em.getTransaction().begin();
            em.merge(cliente);
            cliente.setId(2);
            cliente.setNombre("juan");
            em.merge(cliente);

            em.getTransaction().commit();

            System.out.println(cliente.toString());






        }catch (PersistenceException e){
            System.out.println(e.getMessage());
        }





    }


}
