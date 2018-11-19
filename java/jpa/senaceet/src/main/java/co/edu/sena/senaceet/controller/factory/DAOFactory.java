package co.edu.sena.senaceet.controller.factory;


import co.edu.sena.senaceet.controller.dao.TipoDocumentoDAO;
import co.edu.sena.senaceet.controller.dao.mysql.TipoDocumentoDAOImpl;
import co.edu.sena.senaceet.model.entities.TipoDocumento;

public class DAOFactory {

    public static TipoDocumentoDAO crearTipoDocumentoDAO(){
         return new TipoDocumentoDAOImpl(TipoDocumento.class);
    }


}
