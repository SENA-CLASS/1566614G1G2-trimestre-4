package co.edu.sena.senaceet.controller.dao.mysql;

import co.edu.sena.senaceet.controller.dao.ClienteDAO;
import co.edu.sena.senaceet.model.entities.Cliente;

public class ClienteDAOImpl extends AbstractDAO<Cliente> implements ClienteDAO {
    public ClienteDAOImpl(Class<Cliente> entityClass) {
        super(entityClass);
    }
}
