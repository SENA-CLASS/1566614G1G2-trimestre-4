package co.edu.sena.programming.capitulo06.patronabstracfactory.dao;

public class MysqlDAOFactory implements DAOFactoy {
    @Override
    public CastilloDAO crearDAOCastillo() {
        return new CastilloDAOMysqlImpl();
    }

    @Override
    public EjercitoDAO crearDAOEjercito() {
        return new EjercitoDAOMysqlImpl();
    }

    @Override
    public ReyDAO crearDAORey() {
        return new ReyDaoMysqlImpl();
    }
}
