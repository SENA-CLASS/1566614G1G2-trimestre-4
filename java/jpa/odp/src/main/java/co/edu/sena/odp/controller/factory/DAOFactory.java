package co.edu.sena.odp.controller.factory;

import co.edu.sena.odp.controller.dao.AprendizDAO;
import co.edu.sena.odp.controller.dao.ClienteDAO;
import co.edu.sena.odp.controller.dao.TipoDocumentoDAO;
import co.edu.sena.odp.controller.dao.mysql.AprendizDAOImpl;
import co.edu.sena.odp.controller.dao.mysql.ClienteDAOImpl;
import co.edu.sena.odp.controller.dao.mysql.TipoDocumentoDAOImpl;
import co.edu.sena.odp.model.entities.Aprendiz;
import co.edu.sena.odp.model.entities.Cliente;
import co.edu.sena.odp.model.entities.TipoDocumento;

public class DAOFactory {

    public static TipoDocumentoDAO crearTipoDocumentoDAO(){
         return new TipoDocumentoDAOImpl(TipoDocumento.class);
    }

    public static ClienteDAO crearClienteDAO(){
        return new ClienteDAOImpl(Cliente.class);
    }

    public static AprendizDAO crearAprendizDAO(){
        return new AprendizDAOImpl(Aprendiz.class);
    }
}
