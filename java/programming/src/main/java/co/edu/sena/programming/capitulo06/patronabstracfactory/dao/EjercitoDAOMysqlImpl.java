package co.edu.sena.programming.capitulo06.patronabstracfactory.dao;

import co.edu.sena.programming.capitulo06.patronabstracfactory.Ejercito;

public class EjercitoDAOMysqlImpl implements EjercitoDAO {
    @Override
    public void insert(Ejercito ejercito) {
        System.out.printf("se inserto un ejercito en mysql");
    }

    @Override
    public void delete(Ejercito ejercito) {
        System.out.println("se borro un ejercio en mysql");
    }

    @Override
    public void update(Ejercito ejercitoViejo, Ejercito ejercitoNuevo) {
        System.out.println("se actulizo un jercito en mysql");
    }

    @Override
    public void select() {
        System.out.println("se consulto un ejercito en mysql");
    }
}
