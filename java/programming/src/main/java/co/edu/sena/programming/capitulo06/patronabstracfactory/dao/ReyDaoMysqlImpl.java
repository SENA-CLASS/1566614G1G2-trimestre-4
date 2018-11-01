package co.edu.sena.programming.capitulo06.patronabstracfactory.dao;

import co.edu.sena.programming.capitulo06.patronabstracfactory.Rey;

public class ReyDaoMysqlImpl implements ReyDAO {
    @Override
    public void insert(Rey rey) {
        System.out.println("inserto un rey en mysql "+rey);
    }

    @Override
    public void select() {
        System.out.println("mostro rey en mysql");
    }

    @Override
    public void delete(Rey rey) {
        System.out.println("se borro un rey en mysql "+ rey);
    }

    @Override
    public void update(Rey reyViejo, Rey reyNuevo) {
        System.out.println("actualizo el rey en mysql");
    }
}
