package co.edu.sena.programming.capitulo06.patronabstracfactory.dao;

import co.edu.sena.programming.capitulo06.patronabstracfactory.Rey;

public interface ReyDAO {
    public void insert(Rey rey);
    public void select();
    public void delete(Rey rey);
    public void update(Rey reyViejo, Rey reyNuevo);
}
