package co.edu.sena.proyecto.domain;

import java.util.Collection;

public class Fase extends GenericEntity {
    private String nombre;
    private String estado;
    private Proyecto proyecto;
    private Collection<Actividad> actividadCollection;

}
