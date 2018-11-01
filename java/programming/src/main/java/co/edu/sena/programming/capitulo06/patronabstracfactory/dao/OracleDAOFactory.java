package co.edu.sena.programming.capitulo06.patronabstracfactory.dao;

public class OracleDAOFactory implements DAOFactoy {
    @Override
    public CastilloDAO crearDAOCastillo() {
        return new CastilloDAOOracleImpl();
    }

    @Override
    public EjercitoDAO crearDAOEjercito() {
        return new EjercitoDAOOracleImpl();
    }

    @Override
    public ReyDAO crearDAORey() {
        return new ReyDAOOracleImpl();
    }
}
