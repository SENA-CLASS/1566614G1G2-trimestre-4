package co.edu.sena.odp.controller.dao.mysql;

import co.edu.sena.odp.controller.dao.AprendizDAO;
import co.edu.sena.odp.model.entities.Aprendiz;

public class AprendizDAOImpl extends AbstractDao<Aprendiz> implements AprendizDAO {
    public AprendizDAOImpl(Class<Aprendiz> entityClass) {
        super(entityClass);
    }
}
