package co.edu.sena.programming.capitulo06.patronabstracfactory.dao;

import co.edu.sena.programming.capitulo06.patronabstracfactory.Castillo;

public interface CastilloDAO {
    void insert(Castillo castillo);
    void delete(Castillo castillo);
    void update(Castillo castilloViejo, Castillo castilloNuevo);
    void select();
}
