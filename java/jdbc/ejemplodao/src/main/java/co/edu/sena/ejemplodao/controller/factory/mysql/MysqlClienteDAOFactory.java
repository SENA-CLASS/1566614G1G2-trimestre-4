package co.edu.sena.ejemplodao.controller.factory.mysql;

import co.edu.sena.ejemplodao.controller.dao.ClienteDAO;
import co.edu.sena.ejemplodao.controller.dao.mysql.MysqlClienteDAO;
import co.edu.sena.ejemplodao.controller.factory.ClienteDAOFactory;

public class MysqlClienteDAOFactory implements ClienteDAOFactory {

    public ClienteDAO create(){
        return new MysqlClienteDAO();
}

}
