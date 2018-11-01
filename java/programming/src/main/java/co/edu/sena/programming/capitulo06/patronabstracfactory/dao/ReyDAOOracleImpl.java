package co.edu.sena.programming.capitulo06.patronabstracfactory.dao;

import co.edu.sena.programming.capitulo06.patronabstracfactory.Rey;

public class ReyDAOOracleImpl implements ReyDAO {
    @Override
    public void insert(Rey rey) {
        System.out.println("inserto el rey en oracle");
    }

    @Override
    public void select() {
        System.out.println("consulto el rey en oracle");
    }

    @Override
    public void delete(Rey rey) {
        System.out.println("borro el rey en oracle");
    }

    @Override
    public void update(Rey reyViejo, Rey reyNuevo) {
        System.out.println("actualizo el rey en oracle");
    }
}
