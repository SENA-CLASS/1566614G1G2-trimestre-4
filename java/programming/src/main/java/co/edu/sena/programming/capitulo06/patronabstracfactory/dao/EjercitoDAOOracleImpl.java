package co.edu.sena.programming.capitulo06.patronabstracfactory.dao;

import co.edu.sena.programming.capitulo06.patronabstracfactory.Ejercito;

public class EjercitoDAOOracleImpl implements EjercitoDAO {
    @Override
    public void insert(Ejercito ejercito) {
        System.out.println("se inserto ejercito en oracle");
    }

    @Override
    public void delete(Ejercito ejercito) {
        System.out.println("se borro ejercito en oracle");
    }

    @Override
    public void update(Ejercito ejercitoViejo, Ejercito ejercitoNuevo) {
        System.out.println("se actualizo ejercito en oracle");
    }

    @Override
    public void select() {
        System.out.println("se consulto ejercito en oracle");
    }
}
