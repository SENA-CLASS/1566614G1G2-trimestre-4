package co.edu.sena.ejemplodao.controller.factory.mysql;

import co.edu.sena.ejemplodao.controller.dao.TipoDocumentoDAO;
import co.edu.sena.ejemplodao.controller.dao.mysql.MysqlTipoDocumentoDAO;
import co.edu.sena.ejemplodao.controller.factory.TipoDocumentoDAOFactory;

public class MysqlTipoDocumetoDAOFactory implements TipoDocumentoDAOFactory{
    @Override
    public TipoDocumentoDAO create() {
        return new MysqlTipoDocumentoDAO();
    }
}
