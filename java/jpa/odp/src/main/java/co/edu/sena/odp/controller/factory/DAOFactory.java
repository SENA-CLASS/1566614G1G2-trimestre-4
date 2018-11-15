package co.edu.sena.odp.controller.factory;

import co.edu.sena.odp.controller.dao.TipoDocumentoDAO;
import co.edu.sena.odp.controller.dao.mysql.TipoDocumentoDAOImpl;
import co.edu.sena.odp.model.entities.TipoDocumento;

public class DAOFactory {

    public static TipoDocumentoDAO crearTipoDocumentoDAO(){
         return new TipoDocumentoDAOImpl(TipoDocumento.class);
    }
}
