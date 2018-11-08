package co.edu.sena.ejemplodao.controller.factory;

import co.edu.sena.ejemplodao.controller.dao.ClienteDAO;

public interface ClienteDAOFactory {
    public ClienteDAO create();
}
