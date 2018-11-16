package co.edu.sena.odp.controller.dao.mysql;

import co.edu.sena.odp.controller.dao.TipoDocumentoDAO;
import co.edu.sena.odp.model.entities.TipoDocumento;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;

public class TipoDocumentoDAOImpl extends AbstractDao<TipoDocumento> implements TipoDocumentoDAO<TipoDocumento> {
    public TipoDocumentoDAOImpl(Class<TipoDocumento> entityClass) {
        super(entityClass);
    }

    @Override
    public List<TipoDocumento> findByDescripcion(String descripcionBuscar) throws PersistenceException {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TipoDocumento.findByDescripcion");
            query.setParameter("descripcion", descripcionBuscar);
            return query.getResultList();
    }

    @Override
    public List<TipoDocumento> findByEstado(boolean estado) throws PersistenceException{
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TipoDocumento.findByEstado");
            query.setParameter("estado", estado);
            return query.getResultList();
    }

    @Override
    public List<TipoDocumento> findByLikeDescripcion(String descripcion) throws PersistenceException {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TipoDocumento.findByLikeDescripcion");
            query.setParameter("descripcion", descripcion);
            return query.getResultList();
    }

    @Override
    public List<TipoDocumento> findByLikeDocumento(String documento) {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TipoDocumento.findByLikeDocumento");
            query.setParameter("documento", documento);
            return query.getResultList();
    }

    @Override
    public int updatePrimaryKey(String llaveNueva, String llaveVieja) throws PersistenceException{
            this.getEntityManager();
            if(this.find(llaveVieja)!=null){
                Query query = this.em.createNamedQuery("TipoDocumento.updatePimaryKey");
                query.setParameter("documentoNuevo", llaveNueva );
                query.setParameter("documentoViejo", llaveVieja );
                this.em.getTransaction().begin();
                int res =query.executeUpdate();
                this.em.getTransaction().commit();
                return res;
            }else{
                return 0;
            }
    }

    @Override
    public List<TipoDocumento> findByLikeEstado(String estado) throws PersistenceException {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM observador_de_proyectos.tipo_documento t where t.estado like ?");
            query.setParameter(1, estado);
            return query.getResultList();
    }

    @Override
    public List<TipoDocumento> findByLikeDocumentoJPQL(String documento) throws PersistenceException {
        this.getEntityManager();
        Query query = this.em.createQuery("SELECT t FROM TipoDocumento t WHERE t.documento LIKE :documento");
        query.setParameter("documento",documento);
        return query.getResultList();
    }

}
