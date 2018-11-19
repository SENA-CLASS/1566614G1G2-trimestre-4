package co.edu.sena.senaceet.controller.dao.mysql;

import co.edu.sena.senaceet.controller.dao.TipoDocumentoDAO;
import co.edu.sena.senaceet.model.entities.TipoDocumento;

import javax.persistence.Query;


public class TipoDocumentoDAOImpl extends AbstractDAO<TipoDocumento> implements TipoDocumentoDAO {
    public TipoDocumentoDAOImpl(Class<TipoDocumento> entityClass) {
        super(entityClass);
    }

    public TipoDocumento findBySigla(String sigla){
        this.getEntityManager();
        Query query = this.em.createNamedQuery("TipoDocumento.findBySigla");
        query.setParameter("sigla", sigla);
        return (TipoDocumento) query.getSingleResult();
    }

}
