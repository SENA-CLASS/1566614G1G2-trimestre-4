package co.edu.sena.programming.capitulo06.patronabstracfactory.dao;

import co.edu.sena.programming.capitulo06.patronabstracfactory.Castillo;

public class CastilloDAOOracleImpl implements CastilloDAO {
    @Override
    public void insert(Castillo castillo) {
        System.out.println("inserto el castillo en oracle");
    }

    @Override
    public void delete(Castillo castillo) {
        System.out.println("borro el castillo en oracle");
    }

    @Override
    public void update(Castillo castilloViejo, Castillo castilloNuevo) {
        System.out.println("actualizo el castillo en oracle");
    }

    @Override
    public void select() {
        System.out.println("consulto el castillo en oracle");
    }
}
