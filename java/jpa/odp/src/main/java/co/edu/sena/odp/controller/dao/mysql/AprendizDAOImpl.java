package co.edu.sena.odp.controller.dao.mysql;

import co.edu.sena.odp.controller.dao.AprendizDAO;
import co.edu.sena.odp.model.entities.Aprendiz;
import co.edu.sena.odp.model.entities.AprendizPK;

import javax.persistence.Query;
import java.util.Optional;

public class AprendizDAOImpl extends AbstractDao<Aprendiz> implements AprendizDAO {
    public AprendizDAOImpl(Class<Aprendiz> entityClass) {
        super(entityClass);
    }

    public int updatePrimaryKey(AprendizPK llaveVieja, AprendizPK llaveNueva){
        this.getEntityManager();
        Optional<Aprendiz> aprendizOptional = Optional.of(this.find(llaveVieja));
        if(aprendizOptional.isPresent()){
            Query query = this.em.createQuery("UPDATE Aprendiz a SET a.aprendizPK.tipoDocumento = :tipoDocumentoNuevo," +
                    "a.aprendizPK.numeroDocumento =:numeroDocumentoNuevo, " +
                    "a.aprendizPK.ficha = :numeroFichaNuevo, " +
                    "a.aprendizPK.grupoCodigo = :grupoCodigoNuevo " +
                    "WHERE a.aprendizPK.tipoDocumento= :tipoDocumentoViejo AND " +
                    "a.aprendizPK.numeroDocumento= :numeroDocumentoViejo AND " +
                    "a.aprendizPK.ficha= :fichaVieja AND " +
                    "a.aprendizPK.grupoCodigo = :grupoCodigoViejo"); //JPQL
            query.setParameter("tipoDocumentoNuevo", llaveNueva.getTipoDocumento());
            query.setParameter("numeroDocumentoNuevo", llaveNueva.getTipoDocumento());
            query.setParameter("numeroFichaNuevo", llaveNueva.getFicha());
            query.setParameter("grupoCodigoNuevo", llaveNueva.getGrupoCodigo());
            query.setParameter("tipoDocumentoViejo", llaveVieja.getTipoDocumento());
            query.setParameter("numeroDocumentoViejo", llaveVieja.getNumeroDocumento() );
            query.setParameter("grupoCodigoViejo", llaveVieja.getGrupoCodigo());
            query.setParameter("fichaVieja", llaveVieja.getFicha());

            this.em.getTransaction().begin();
            int res =query.executeUpdate();
            this.em.getTransaction().commit();
            return res;
        }else{
            return 0;
        }
    }
}
