package co.edu.sena.programming.capitulo06.patronabstracfactory;

public class ReinoOrcoFactory implements ReinoFactory {
    @Override
    public Ejercito crearEjercito() {
        return new EjercitoOrco();
    }

    @Override
    public Rey crearRey() {
        return new ReyOrco();
    }

    @Override
    public Castillo crearCastillo() {
        return new CastilloOrco();
    }
}
