package co.edu.sena.odp.controller.dao;

import co.edu.sena.odp.controller.dao.mysql.AbstractDao;
import co.edu.sena.odp.model.entities.Aprendiz;
import co.edu.sena.odp.model.entities.AprendizPK;

public interface AprendizDAO extends InterfaceDao<Aprendiz> {
    public int updatePrimaryKey(AprendizPK llaveVieja, AprendizPK llaveNueva);

}
