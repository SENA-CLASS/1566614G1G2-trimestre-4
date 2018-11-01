package co.edu.sena.programming.capitulo06.patronabstracfactory;

public class ReinoElfoFactory implements ReinoFactory {
    @Override
    public Ejercito crearEjercito() {
        return new EjercitoElfo();
    }

    @Override
    public Rey crearRey() {
        return new ReyElfo();
    }

    @Override
    public Castillo crearCastillo() {
        return new CastilloElfo();
    }
}
