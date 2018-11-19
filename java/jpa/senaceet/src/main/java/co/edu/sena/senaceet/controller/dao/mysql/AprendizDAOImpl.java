package co.edu.sena.senaceet.controller.dao.mysql;

import co.edu.sena.senaceet.controller.dao.AprendizDAO;
import co.edu.sena.senaceet.model.entities.Aprendiz;

public class AprendizDAOImpl extends AbstractDAO<Aprendiz> implements AprendizDAO {

    public AprendizDAOImpl(Class<Aprendiz> entityClass) {
        super(entityClass);
    }
}
