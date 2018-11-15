package co.edu.sena.odp.controller.dao.mysql;

import co.edu.sena.odp.controller.dao.TipoDocumentoDAO;
import co.edu.sena.odp.model.entities.TipoDocumento;

public class TipoDocumentoDAOImpl extends AbstractDao<TipoDocumento> implements TipoDocumentoDAO<TipoDocumento> {
    public TipoDocumentoDAOImpl(Class<TipoDocumento> entityClass) {
        super(entityClass);
    }


}
