package co.edu.sena.odp.controller.dao.mysql;

import co.edu.sena.odp.controller.dao.ClienteDAO;
import co.edu.sena.odp.model.entities.Cliente;

public class ClienteDAOImpl extends AbstractDao<Cliente> implements ClienteDAO<Cliente> {
    public ClienteDAOImpl(Class<Cliente> entityClass) {
        super(entityClass);
    }
}
