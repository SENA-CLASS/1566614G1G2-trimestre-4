package co.edu.sena.programming.capitulo06.patronabstracfactory.dao;

import co.edu.sena.programming.capitulo06.patronabstracfactory.Castillo;

public class CastilloDAOMysqlImpl implements CastilloDAO {
    @Override
    public void insert(Castillo castillo) {
        System.out.println("castillo inserto en mysql");
    }

    @Override
    public void delete(Castillo castillo) {
        System.out.println("castillo borro en mysql");
    }

    @Override
    public void update(Castillo castilloViejo, Castillo castilloNuevo) {
        System.out.println("castillo actulizo en mysql");
    }

    @Override
    public void select() {
        System.out.println("cosulto castllo en mysql");
    }
}
