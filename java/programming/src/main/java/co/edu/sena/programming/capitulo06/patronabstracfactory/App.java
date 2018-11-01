package co.edu.sena.programming.capitulo06.patronabstracfactory;

import co.edu.sena.programming.capitulo06.patronabstracfactory.dao.*;

public class App {
    public static void main(String[] args) {
        ReinoFactory fabrica = new ReinoOrcoFactory();
        Rey rey= fabrica.crearRey();
        Castillo castillo = fabrica.crearCastillo();
        Ejercito ejercito = fabrica.crearEjercito();

        rey.gobernar();
        castillo.defender();
        ejercito.combatir();

        DAOFactoy fabricaConexiones = new OracleDAOFactory();

        ReyDAO daoRey = fabricaConexiones.crearDAORey();
        daoRey.insert(rey);
        daoRey.select();
        daoRey.delete(rey);
        daoRey.update(rey, new ReyOrco());

        CastilloDAO daoCastillo = fabricaConexiones.crearDAOCastillo();
        daoCastillo.insert(castillo);
        daoCastillo.delete(castillo);
        daoCastillo.update(castillo, new CastilloOrco());
        daoCastillo.select();

        EjercitoDAO daoEjercito = fabricaConexiones.crearDAOEjercito();
        daoEjercito.insert(ejercito);
        daoEjercito.delete(ejercito);
        daoEjercito.select();
        daoEjercito.update(ejercito, new EjercitoOrco());



    }
}
