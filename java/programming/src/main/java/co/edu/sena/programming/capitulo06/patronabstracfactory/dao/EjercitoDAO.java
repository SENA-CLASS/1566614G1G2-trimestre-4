package co.edu.sena.programming.capitulo06.patronabstracfactory.dao;

import co.edu.sena.programming.capitulo06.patronabstracfactory.Ejercito;

public interface EjercitoDAO {
    public void insert(Ejercito ejercito);
    public void delete(Ejercito ejercito);
    public void update(Ejercito ejercitoViejo, Ejercito ejercitoNuevo);
    public void select();
}
