package co.edu.sena.jpamapeo.semantica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TipoDocumento;



public class App {

	public static void main(String[] args) {
		EntityManagerFactory emf;
	    EntityManager em;
	    emf = Persistence.createEntityManagerFactory("UPSemantica");
        em = emf.createEntityManager();
	    TipoDocumento tipoDocumento;
	    tipoDocumento = new TipoDocumento();
        tipoDocumento.setNombreDocumento("cedual de ciudadania");
        tipoDocumento.setEstado("activo");;
        tipoDocumento.setSigla("CC");
        
        em.getTransaction().begin();
        em.persist(tipoDocumento);
        em.getTransaction().commit();
	    

	}

}
