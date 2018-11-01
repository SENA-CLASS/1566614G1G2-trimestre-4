package co.edu.sena.programming.capitulo06.patronabstracfactory;

import co.edu.sena.programming.capitulo06.patronabstracfactory.dao.ReyDAO;
import co.edu.sena.programming.capitulo06.patronabstracfactory.dao.ReyDAOOracleImpl;
import co.edu.sena.programming.capitulo06.patronabstracfactory.dao.ReyDaoMysqlImpl;

public class App {
    public static void main(String[] args) {
        ReinoFactory fabrica = new ReinoOrcoFactory();
        Rey rey= fabrica.crearRey();
        Castillo castillo = fabrica.crearCastillo();
        Ejercito ejercito = fabrica.crearEjercito();

        rey.gobernar();
        castillo.defender();
        ejercito.combatir();

        ReyDAO dao = new ReyDAOOracleImpl();
        dao.insert(rey);
        dao.select();
        dao.delete(rey);
        dao.update(rey, new ReyOrco());


    }
}
