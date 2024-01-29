package Habilidad.model.classes.builder;

import Habilidad.model.classes.Habilidad;


public interface HabilidadBuilder {


    HabilidadBuilder idNinja(long idNinja);

    HabilidadBuilder nombreHabilidad(String nombreHabilidad);


    HabilidadBuilder descripcionHabilidad(String descripcionHabilidad);


    Habilidad build();
}
