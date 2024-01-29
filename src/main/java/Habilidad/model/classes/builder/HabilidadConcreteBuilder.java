
package Habilidad.model.classes.builder;

import Habilidad.model.classes.Habilidad;



public class HabilidadConcreteBuilder implements HabilidadBuilder {

    private Habilidad habilidad = new Habilidad();


    @Override
    public HabilidadBuilder idNinja(long idNinja) {
        habilidad.setIdNinja(idNinja);
        return this;
    }

    @Override
    public HabilidadBuilder nombreHabilidad(String nombreHabilidad) {
        habilidad.setNombreHabilidad(nombreHabilidad);
        return this;
    }

    @Override
    public HabilidadBuilder descripcionHabilidad(String descripcionHabilidad) {
        habilidad.setDescripcionHabilidad(descripcionHabilidad);
        return this;
    }

    @Override
    public Habilidad build() {
        return habilidad;
    }
}
