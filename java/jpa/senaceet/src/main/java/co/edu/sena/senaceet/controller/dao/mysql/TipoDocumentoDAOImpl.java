package co.edu.sena.senaceet.controller.dao.mysql;

import co.edu.sena.senaceet.controller.dao.TipoDocumentoDAO;
import co.edu.sena.senaceet.model.entities.TipoDocumento;

public class TipoDocumentoDAOImpl extends AbstractDAO<TipoDocumento> implements TipoDocumentoDAO {
    public TipoDocumentoDAOImpl(Class<TipoDocumento> entityClass) {
        super(entityClass);
    }
}
